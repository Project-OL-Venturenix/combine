package com.vtxlab.projectol.server_test_cases.config;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RedisHashOperations {

  final String USER_ID = "USER_ID_";
  private final RedisTemplate<String, Object> redisTemplate;
  private final HashOperations<String, String, Object> hashOperations;
  private final ObjectMapper objectMapper;

  
  public RedisHashOperations(RedisTemplate<String, Object> redisTemplate,
      ObjectMapper objectMapper) {
    this.redisTemplate = redisTemplate;
    this.hashOperations = redisTemplate.opsForHash();
    this.objectMapper = objectMapper;
  }

  public boolean put(String key, String hashKey, Object value) {
    try {
      String serializedValue = objectMapper.writeValueAsString(value);
      hashOperations.put(USER_ID + key, hashKey, serializedValue);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public Object get(String key, String hashKey) {
    try {
      return redisTemplate.opsForHash().get(USER_ID + key, hashKey);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public boolean delete(String key, String hashKey) {
    try {
      Long deletedCount =
          redisTemplate.opsForHash().delete(USER_ID + key, hashKey);
      return deletedCount > 0;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public boolean deleteAll(String userID) {
    try {
      Set<String> keys = redisTemplate.keys(USER_ID + userID + "*");
      redisTemplate.delete(keys);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }


  public boolean expire(String key, long time) {
    try {
      if (time > 0) {
        redisTemplate.expire(USER_ID + key, time, TimeUnit.MILLISECONDS);
        return true;
      }
      return false;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }



  public Map<Object, Object> entries(String key) {
    try {
      return redisTemplate.opsForHash().entries(USER_ID + key);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }


  public boolean hasKey(String key, String hashKey) {
    try {
      return redisTemplate.opsForHash().hasKey(USER_ID + key, hashKey);
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public static String formatKey(String head, String source) {
    return new StringBuilder(head).append(":").append(source).toString();
  }
}
