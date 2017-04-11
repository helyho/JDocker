package org.voovan.docker.message.task.atom;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class ContainerStatus {
    private String containerId;
    private String pid;

    public String getContainerId() {
        return containerId;
    }

    public void setContainerId(String containerID) {
        this.containerId = containerID;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
