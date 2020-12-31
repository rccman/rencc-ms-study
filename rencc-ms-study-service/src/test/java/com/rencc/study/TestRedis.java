package com.rencc.study;

import com.alibaba.fastjson.JSON;
import com.rencc.common.cache.redis.RedisService;
import com.rencc.study.redis.IDGenerator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: renchaochao
 * @Date: 2020/12/30 17:38
 **/
@Slf4j
//@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

    private static final String TEST_STRING_KEY = "test:String";
    private static final String TEST_LIST_KEY = "test:List";
    private static final String TEST_SET_KEY = "test:Set";
    private static final String TEST_SORTED_SET_KEY = "test:sorted set";
    private static final String TEST_HASH_KEY = "test:hash";

    @Autowired
    private RedisService redisService;

    @Autowired
    private IDGenerator idGenerator;


    @Test
    public void testRedisSetString() {
        redisService.set(TEST_STRING_KEY, "2020-12-30 17:11:46");
    }


    @Test
    public void testRedisGetString() {
        Object value = redisService.get(TEST_STRING_KEY);
        log.info("Redis value={}", value);
    }

    @Test
    public void testRedisSetList() {

    }

    @Test
    public void testRedisGetList() {

    }

    @Test
    public void testRedisSetSet() {
        redisService.setSet(TEST_SET_KEY, "aaa", 1000L, TimeUnit.SECONDS);
        redisService.setSet(TEST_SET_KEY, "bbb", 1000L, TimeUnit.SECONDS);
        redisService.setSet(TEST_SET_KEY, "ccc", 1000L, TimeUnit.SECONDS);
    }

    @Test
    public void testRedisGetSet() {
        Set<Object> setKeys = redisService.getSetKeys(TEST_SET_KEY);
        log.info("测试Redis Set读取", setKeys.toString());
    }

    @Test
    public void testRedisSetSortedSet() {
    }

    @Test
    public void testRedisGetSortedSet() {
    }

    @Test
    public void testRedisSetHash() {
        redisService.setHashCache(TEST_HASH_KEY, "hashKey1", "aaaa", 1000L);
        redisService.setHashCache(TEST_HASH_KEY, "hashKey2", "aaaa", 1000L);
        redisService.setHashCache(TEST_HASH_KEY, "hashKey3", "aaaa", 1000L);
    }

    @Test
    public void testRedisGetHash() {
        Object hashKey = redisService.getHashCacheAll(TEST_HASH_KEY);
        log.info("测试Redis Hash读取value={}", JSON.toJSONString(hashKey));
    }

    @Test
    public void testRedisID() {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            String id = idGenerator.nextID();
            log.info(id);
        }

    }

    @Test
    public void testRedisLuaID() {
        String id = idGenerator.nextIDLua();
        log.info(id);
    }

}
