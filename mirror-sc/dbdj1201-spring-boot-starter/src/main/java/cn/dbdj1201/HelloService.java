package cn.dbdj1201;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-23 9:25
 */
public class HelloService {

    HelloProperties helloProperties;

    public HelloService() {
    }

    public HelloService(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sayHello(String name) {
        return helloProperties.getPrefix() + name + helloProperties.getSuffix();
    }
}
