package org.fufeng.train.gateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 网关项目
 * 开启日志：-Dreactor.netty.http.server.accessLogEnabled=true
 *
 * @author fufeng
 * @Date 2024-03-13 21:07
 */
@SpringBootApplication
public class GatewayApplication {
    private static final Logger LOG = LoggerFactory.getLogger(GatewayApplication.class);

    public static void main(String[] args) {
        final SpringApplication app = new SpringApplication(GatewayApplication.class);
        ConfigurableEnvironment environment = app.run(args).getEnvironment();
        LOG.info("启动成功!");
        LOG.info("网关：\thttp://127.0.0.1:{}", environment.getProperty("server.port"));
    }
}
