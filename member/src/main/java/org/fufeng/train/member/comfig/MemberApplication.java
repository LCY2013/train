package org.fufeng.train.member.comfig;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@ComponentScan(basePackages = {"org.fufeng.train"})
@MapperScan(basePackages = {"org.fufeng.train.member.mapper"})
public class MemberApplication {

    private static final Logger LOG = LoggerFactory.getLogger(MemberApplication.class);

    public static void main(String[] args) {
        final SpringApplication app = new SpringApplication(MemberApplication.class);
        ConfigurableEnvironment environment = app.run(args).getEnvironment();
        LOG.info("启动成功!");
        LOG.info("测试地址：\thttp://127.0.0.1:{}", environment.getProperty("server.port"));
    }
}
