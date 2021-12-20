package cn.dbdj1201.hellospringbootstarter.service;

import cn.dbdj1201.hellospringbootstarter.config.TestProperties;

/**
 * @Author: yz1201
 * @Date: 2021/12/20 8:56
 */
public class TestService {

    TestProperties properties;

    public TestService() {
    }

    public TestService(TestProperties properties) {
        this.properties = properties;
    }

    public void setProperties(TestProperties properties) {
        this.properties = properties;
    }

    public String getWelcomeInfo(String content) {
        StringBuilder sb = new StringBuilder();
        sb.append(properties.getNickName()).append(content).append(properties.getInfo())
                .append(properties.getAge());
        return sb.toString();
    }

}
