package org.study.gateway.dynamic;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.config.listener.Listener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * 类<code>Doc</code>用于：注册一个“监听器”来获取Nacos Config的配置变化通知
 * Listener是Nacos Config提供的标准监听器接口，当被监听的Nacos配置文件发生变化的时候，框架会自动调用receiveConfigInfo方法执行自定义逻辑。
 * @author zhang
 * @date 2022-08-13
 */
@Slf4j
@Component
public class DynamicRoutesListener implements Listener {
    @Autowired
    private GatewayService gatewayService;

    @Override
    public Executor getExecutor() {
        log.info("getExecutor");
        return null;
    }

    @Override
    public void receiveConfigInfo(String configInfo) {
        //需要按照RouteDefinition的JSON格式来编写Nacos Config中的配置项
        log.info("received routes changes {}", configInfo);
        List<RouteDefinition> definitionList = JSON.parseArray(configInfo, RouteDefinition.class);
        gatewayService.updateRoutes(definitionList);
    }
}
