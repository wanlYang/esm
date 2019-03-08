package com.wanl.configuration;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * spring redis配置
 * @Title: SpringRedisConfig.java
 * @Package:com.wanl.configuration
 * @author:YangBin
 * @date:2019年2月20日
 * @version:V1.0
 */
@Configuration
@PropertySource(value = {"classpath:redis.properties"})
@EnableCaching
public class SpringRedisConfig {

    /**
     * 配置jedis
     * @author:YangBin
     * @date:2019年2月20日
     * @version:V1.0
     * @param maxIdle
     * @param maxWaitMillis
     * @param testOnBorrow
     * @return
     * @return:JedisPoolConfig
     */
    @Bean
    public JedisPoolConfig poolConfig(
            @Value("${redis.maxIdle}")Integer maxIdle,
            @Value("${redis.maxWait}")long maxWaitMillis,
            @Value("${redis.testOnBorrow}")boolean testOnBorrow) {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        return jedisPoolConfig;
    }
    
    /**
     * redis密码
     * @author:YangBin
     * @date:2019年2月20日
     * @version:V1.0
     * @return
     * @return:RedisPassword
     */
    @Bean
    public RedisPassword redisPassword(@Value("${redis.password}")String passwordAsChars) {
        return RedisPassword.of(passwordAsChars);
    }
    
    /**
     * redis服务中心 2.0
     * @author:YangBin
     * @date:2019年2月20日
     * @version:V1.0
     * @return
     * @return:JedisConnectionFactory
     */
    @Bean
    public RedisStandaloneConfiguration redisStandaloneConfiguration(
            JedisPoolConfig poolConfig,
            @Value("${redis.host}")String hostName,
            @Value("${redis.port}")Integer port,
            RedisPassword redisPassword,
            @Value("${redis.dbIndex}")Integer index
            ) {
        RedisStandaloneConfiguration standaloneConfiguration = new RedisStandaloneConfiguration();
        standaloneConfiguration.setHostName(hostName);
        standaloneConfiguration.setPort(port);
        standaloneConfiguration.setPassword(redisPassword);
        standaloneConfiguration.setDatabase(index);
        return standaloneConfiguration;
    }
    
    /**
     * 配置jedis链接工厂 2.0
     * @author:YangBin
     * @date:2019年2月20日
     * @version:V1.0
     * @param redisStandaloneConfiguration
     * @return
     * @return:JedisConnectionFactory
     */
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(RedisStandaloneConfiguration redisStandaloneConfiguration) {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration);
        return jedisConnectionFactory;
    }
    
    /**
     * 手动设置 key  与 value的序列化方式
     * @author:YangBin
     * @date:2019年2月20日
     * @version:V1.0
     * @return
     * @return:StringRedisSerializer
     */
    @Bean
    public StringRedisSerializer keySerializer() {
        return new StringRedisSerializer();
    }
    
    /**
     * 手动设置 key  与 value的序列化方式
     * @author:YangBin
     * @date:2019年1月22日
     * @version:V1.0
     * @return
     * @return:GenericJackson2JsonRedisSerializer
     */
    @Bean
    public GenericJackson2JsonRedisSerializer  valueSerializer() {
        return new GenericJackson2JsonRedisSerializer();
    }
    
    /**
     * 配置jedis模板 
     * @author:YangBin
     * @date:2019年2月20日
     * @version:V1.0
     * @param jedisConnectionFactory
     * @param keySerializer
     * @param valueSerializer
     * @return
     * @return:RedisTemplate<?,?>
     */
    @Bean
    public RedisTemplate<?, ?> redisTemplate(
            JedisConnectionFactory jedisConnectionFactory,
            StringRedisSerializer keySerializer,
            GenericJackson2JsonRedisSerializer valueSerializer) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        redisTemplate.setKeySerializer(keySerializer);
        redisTemplate.setValueSerializer(valueSerializer);
        redisTemplate.setHashKeySerializer(keySerializer);
        redisTemplate.setHashValueSerializer(valueSerializer);
        redisTemplate.setDefaultSerializer(valueSerializer);
        return redisTemplate;
    }
    
    /**
     * 也可以StringRedisTemplate  专注于String的操作
     * @author:YangBin
     * @date:2019年2月20日
     * @version:V1.0
     * @param jedisConnectionFactory
     * @param keySerializer
     * @param valueSerializer
     * @return
     * @return:StringRedisTemplate
     */
    @Bean
    public StringRedisTemplate stringRedisTemplate(
            JedisConnectionFactory jedisConnectionFactory,
            StringRedisSerializer keySerializer,
            GenericJackson2JsonRedisSerializer valueSerializer) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(jedisConnectionFactory);
        stringRedisTemplate.setKeySerializer(keySerializer);
        stringRedisTemplate.setValueSerializer(valueSerializer);
        return stringRedisTemplate;
    }
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(5));
        return RedisCacheManager
                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
                .cacheDefaults(redisCacheConfiguration).build();
    }
    
}
