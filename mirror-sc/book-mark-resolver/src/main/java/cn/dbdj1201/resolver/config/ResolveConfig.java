package cn.dbdj1201.resolver.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-28 19:44
 */
@Configuration
public class ResolveConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
