package org.voovan.docker.message.service.atom;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class Port {
    private String protocol;
    private Integer targetPort;
    private Integer publishedPort;

    public Port() {
        protocol = "tcp";
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Integer getTargetPort() {
        return targetPort;
    }

    public void setTargetPort(Integer targetPort) {
        this.targetPort = targetPort;
    }

    public Integer getPublishedPort() {
        return publishedPort;
    }

    public void setPublishedPort(Integer publishedPort) {
        this.publishedPort = publishedPort;
    }
}
