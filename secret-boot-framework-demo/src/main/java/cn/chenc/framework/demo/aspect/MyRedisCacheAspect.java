package cn.chenc.framework.demo.aspect;

import cn.chenc.framework.cache.annotation.RedisCache;
import cn.chenc.framework.cache.util.RedisUtils;
import cn.chenc.framework.core.util.AspectUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Redis业务层数据缓存
 */
@Slf4j
@Aspect
@Component
public class MyRedisCacheAspect {

    private static final String BIZ_CACHE_PREFIX = "biz_cache_";

    @Autowired
    private RedisUtils redisUtils;

    @Pointcut(value = "@annotation(cn.chenc.framework.cache.annotation.RedisCache)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object handle(ProceedingJoinPoint point) throws Throwable {
        Method currentMethod = AspectUtil.INSTANCE.getMethod(point);
        //获取操作名称
        RedisCache cache = currentMethod.getAnnotation(RedisCache.class);
        boolean enable = cache.enable();
        if (!enable) {
            return point.proceed();
        }
        boolean flush = cache.flush();
        if (flush) {
            String classPrefix = AspectUtil.INSTANCE.getKey(point, BIZ_CACHE_PREFIX);
            log.info("清空缓存 - {}*", classPrefix);
            redisUtils.delBatch(classPrefix);
            return point.proceed();
        }
        String key = AspectUtil.INSTANCE.getKey(point, cache.key(), BIZ_CACHE_PREFIX);
        boolean hasKey = redisUtils.hasKey(key);
        if (hasKey) {
            try {
                log.info("{}从缓存中获取数据", key);
                return redisUtils.get(key);
            } catch (Exception e) {
                log.error("从缓存中获取数据失败！", e);
            }
        }
        //先执行业务
        Object result = point.proceed();
        redisUtils.set(key, result, cache.expire(), cache.unit());
        log.info("{}从数据库中获取数据", key);
        return result;
    }
}
