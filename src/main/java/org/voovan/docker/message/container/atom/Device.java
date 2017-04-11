package org.voovan.docker.message.container.atom;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class Device {
    private String pathOnHost;
    private String pathInContainer;
    private String cgroupPermissions;

    public Device(){

    }

    public Device(String pathOnHost, String pathInContainer, String cgroupPermissions) {
        this.pathOnHost = pathOnHost;
        this.pathInContainer = pathInContainer;
        this.cgroupPermissions = cgroupPermissions;
    }

    public String getPathOnHost() {
        return pathOnHost;
    }

    public void setPathOnHost(String pathOnHost) {
        this.pathOnHost = pathOnHost;
    }

    public String getPathInContainer() {
        return pathInContainer;
    }

    public void setPathInContainer(String pathInContainer) {
        this.pathInContainer = pathInContainer;
    }

    public String getCgroupPermissions() {
        return cgroupPermissions;
    }

    public void setCgroupPermissions(String cgroupPermissions) {
        this.cgroupPermissions = cgroupPermissions;
    }
}
