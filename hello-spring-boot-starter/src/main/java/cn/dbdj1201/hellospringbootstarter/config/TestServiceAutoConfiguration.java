package cn.dbdj1201.hellospringbootstarter.config;

import cn.dbdj1201.hellospringbootstarter.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: yz1201
 * @Date: 2021/12/20 8:55
 */
@Configuration
@EnableConfigurationProperties(TestProperties.class)
public class TestServiceAutoConfiguration {

    @Autowired
    TestProperties testProperties;

    @Bean
    @ConditionalOnMissingBean
    public TestService testService() {
        TestService testService = new TestService();
        testService.setProperties(testProperties);
        return testService;
    }

}
