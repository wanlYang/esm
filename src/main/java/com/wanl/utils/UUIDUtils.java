package com.wanl.utils;

import com.wanl.constant.EsmConstant;

import java.util.Random;
import java.util.UUID;

public class UUIDUtils {
	public static String getUid() {
		return UUID.randomUUID().toString();
	}
	public static String getOrderid() {
		return UUID.randomUUID().toString();
	}
	public static String getOrderItemid() {
		return UUID.randomUUID().toString();
	}
	public static String getPid() {
		return UUID.randomUUID().toString();
	}
	public static String getCateGoryId() {
		return UUID.randomUUID().toString();
	}
	public static String getCode() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());
	}


	public static String generateNumberUUID(String type) {
		String no = "";
		int num[] = new int[10];
		int c = 0;
		for (int i = 0; i < 10; i++) {
			num[i] = new Random().nextInt(9) + 1;
			c = num[i];
			for (int j = 0; j < i; j++) {
				if (num[j] == c) {
					i--;
					break;
				}
			}
		}
		if (num.length > 0) {
			for (int i = 0; i < num.length; i++) {
				no += num[i];
			}
		}
		if (type.equals(EsmConstant.USER_ID)){
			String wanl = "wanl";
			return wanl += no;
		}
		String wanl = "ac";
		return wanl += no;

	}
}
