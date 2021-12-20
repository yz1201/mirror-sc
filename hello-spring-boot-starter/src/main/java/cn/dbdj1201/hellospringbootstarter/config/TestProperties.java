package cn.dbdj1201.hellospringbootstarter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: yz1201
 * @Date: 2021/12/20 8:57
 */
@ConfigurationProperties(prefix = "test")
public class TestProperties {

    public String nickName;
    public Integer age;
    public String info;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
