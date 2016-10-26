package org.voovan.docker.message.service.atom;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         DockerFly Framework.
 *         WebSite: https://github.com/helyho/DockerFly
 *         Licence: Apache v2 License
 */
public class Port {
    private String protocol;
    private int targetPort;
    private int publishedPort;

    public Port(){
        protocol = "tcp";
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public int getTargetPort() {
        return targetPort;
    }

    public void setTargetPort(int targetPort) {
        this.targetPort = targetPort;
    }

    public int getPublishedPort() {
        return publishedPort;
    }

    public void setPublishedPort(int publishedPort) {
        this.publishedPort = publishedPort;
    }
}
