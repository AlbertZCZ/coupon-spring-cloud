package org.study.gateway.dynamic;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.cloud.nacos.NacosConfigProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

/**
 * 类<code>Doc</code>用于：一个是项目首次启动的时候，从Nacos读取文件用来初始化路由表；当Nacos的配置项发生变化的时候，动态获取配置项。
 *
 * @author zhang
 * @date 2022-08-13
 */
@Slf4j
@Configuration
@AllArgsConstructor
public class DynamicRoutesLoader implements InitializingBean {

    private final NacosConfigManager configService;
    private final NacosConfigProperties configProps;
    private final DynamicRoutesListener dynamicRoutesListener;

    private static final String ROUTES_CONFIG = "routes-config.json";

    @Override
    public void afterPropertiesSet() throws Exception {
        //首次加载配置
        String routes = configService.getConfigService().getConfig(
                ROUTES_CONFIG, configProps.getGroup(), 10000);
        dynamicRoutesListener.receiveConfigInfo(routes);
        //监听配置变化
        configService.getConfigService().addListener(ROUTES_CONFIG,
                configProps.getGroup(), dynamicRoutesListener);
    }
}
