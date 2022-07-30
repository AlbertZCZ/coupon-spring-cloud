package org.study.template.sentinel;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@Slf4j
public class SentinelOriginParser implements RequestOriginParser {
    /**
     * 从服务请求的Header中获取SentinelSource变量的值，作为调用源的name
     * @param httpServletRequest
     * @return
     */
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        log.info("header={},name:{}", httpServletRequest.getHeaderNames().toString(),httpServletRequest.getHeader("SentinelSource"));
        return httpServletRequest.getHeader("SentinelSource");
    }
}
