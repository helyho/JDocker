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
    private String PathOnHost;
    private String PathInContainer;
    private String CgroupPermissions;

    public String getPathOnHost() {
        return PathOnHost;
    }

    public void setPathOnHost(String pathOnHost) {
        PathOnHost = pathOnHost;
    }

    public String getPathInContainer() {
        return PathInContainer;
    }

    public void setPathInContainer(String pathInContainer) {
        PathInContainer = pathInContainer;
    }

    public String getCgroupPermissions() {
        return CgroupPermissions;
    }

    public void setCgroupPermissions(String cgroupPermissions) {
        CgroupPermissions = cgroupPermissions;
    }
}
