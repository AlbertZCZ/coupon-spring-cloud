package org.study.gateway.dynamic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 类<code>Doc</code>用于：将变化后的路由信息添加到网关上下文中
 *
 * @author zhang
 * @date 2022-08-13
 */
@Slf4j
@Service
public class GatewayService {
    @Autowired
    private RouteDefinitionWriter routeDefinitionWriter;

    @Autowired
    private ApplicationEventPublisher publisher;

    /**
     * RouteDefinition：封装路由规则的标准类
     *
     * @param routes
     */
    public void updateRoutes(List<RouteDefinition> routes) {
        if (CollectionUtils.isEmpty(routes)) {
            log.info("No routes found");
            return;
        }

        routes.forEach(r -> {
            try {
                //调用了Gateway内置的路由编辑类RouteDefinitionWriter，将路由规则写入上下文
                routeDefinitionWriter.save(Mono.just(r)).subscribe();
                //调用ApplicationEventPublisher类发布一个路由刷新事件
                publisher.publishEvent(new RefreshRoutesEvent(this));
            } catch (Exception e) {
                log.error("cannot update route, id={}", r.getId());
            }
        });
    }
}
