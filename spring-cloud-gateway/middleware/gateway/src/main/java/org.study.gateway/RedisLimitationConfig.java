package org.study.gateway;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;

/**
 * 类<code>Doc</code>用于：专门用来定义限流参数
 *
 * @author zhang
 * @date 2022-08-12
 */
@Configuration
public class RedisLimitationConfig {
    /**
     * 限流的维度
     * @return
     */
    @Bean
    @Primary
    public KeyResolver remoteHostLimiterKey() {
        return exchange -> Mono.just(
                exchange.getRequest()
                        .getRemoteAddress()
                        .getAddress()
                        .getHostAddress()
        );
    }

    /**
     * template服务限流速率
     * @return
     */
    @Bean("tempalteRateLimiter")
    public RedisRateLimiter templateRateLimiter() {
        //第一个参数表示每秒发放的令牌数量，第二个参数表示令牌桶的容量
        return new RedisRateLimiter(10, 20);
    }

    /**
     * customer服务限流速率
     * @return
     */
    @Bean("customerRateLimiter")
    public RedisRateLimiter customerRateLimiter() {
        return new RedisRateLimiter(1, 1);
    }

    @Bean("defaultRateLimiter")
    @Primary
    public RedisRateLimiter defaultRateLimiter() {
        return new RedisRateLimiter(50, 100);
    }
}
