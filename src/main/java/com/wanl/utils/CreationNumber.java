package com.wanl.utils;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;

/**
 * 创建订单编号
 * 
 * @project sorder
 * @fileName MakeCode.java
 * @Description
 * @author light-zhang
 * @date 2018年3月11日下午12:19:25
 * @version 1.0.0
 */
public abstract class CreationNumber {
    /**
     * 订单号生成计数器
     */
    private static long numberCount = 0L;
    /**
     * 每毫秒生成订单号数量最大峰值
     */
    private static final int maxPerMSECSize = 20000;

    private static final FastDateFormat pattern = FastDateFormat.getInstance("yyyyMMddHHmmss");

    /**
     * 并发下面容易产生重复的订单号,给传入的PKID枷锁,保证资源安全的同时,性能也有所下降 订单生成策略为: 时间20180511
     * +机器编码(我这里临时填写的是00100),在本台机器上生成订单编号的标识,如果分开部署,则此处的机器码需要变更,防止出现意外重复 +二位随机数
     * +lock的hash-code编码,这里有个并发下的性能问题 +时间时分秒 +递增参数值
     * 
     * @param lock 生成的UUID32位参数
     * @return
     */
    public static String makeOrderCode(String lock) {
        ReferenceQueue<StringBuilder> queue = new ReferenceQueue<StringBuilder>();
        WeakReference<StringBuilder> weakRef = new WeakReference<StringBuilder>(new StringBuilder(25), queue);
        // 锁住传入的lock
        synchronized (lock) {
            if (null == weakRef.get()) {
                weakRef = new WeakReference<StringBuilder>(new StringBuilder(25), queue);
            }
            // 计数器到最大值归零,目前1毫秒处理峰值1个
            if (numberCount >= maxPerMSECSize) {
                numberCount = 0L;
            }
            // 取系统当前时间作为订单号变量前半部分
            weakRef.get().append(pattern.format(Instant.now().toEpochMilli()));
            // HASH-CODE
            weakRef.get().append(Math.abs(lock.hashCode()));
            // 计数器的值
            weakRef.get().append(numberCount++);
            return weakRef.get().toString();
        }
    }

    /**
     * 100000个线程并发测试
     * 
     * @param args
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Set<String> set = new HashSet<String>();
        FutureTask<String> task = null;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Callable<String> callable = new Callable<String>() {
                @Override
                public String call() throws Exception {
                    // System.out.println("当前线程:>>>>> ".concat(Thread.currentThread().getName()));
                    return makeOrderCode(StringUtils.replace(UUID.randomUUID().toString(), "-", ""));
                }
            };
            task = new FutureTask<String>(callable);
            new Thread(task).start();
            // System.out.println("订单号:>>>>> ".concat(task.get()));
            set.add(task.get());
        }
        System.out.println("总共耗时:" + ((System.currentTimeMillis() - startTime)) + "ms");
        System.out.println("*************** " + set.size());
    }
}