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

    public Port(int targetPort, int publishedPort) {
        protocol = "tcp";
        this.targetPort = targetPort;
        this.publishedPort = publishedPort;
    }

    public Port(String protocol, int targetPort, int publishedPort) {
        protocol = protocol;
        this.targetPort = targetPort;
        this.publishedPort = publishedPort;
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
