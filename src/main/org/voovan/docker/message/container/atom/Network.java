package org.voovan.docker.message.container.atom;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class Network {
    private String name;
    private String ipamConfig;
    private String links;
    private String aliases;
    private String networkID;
    private String endpointID;
    private String gateway;
    private String ipAddress;
    private int ipPrefixLen;
    private String ipv6Gateway;
    private String globalIPv6Address;
    private int globalIPv6PrefixLen;
    private String macAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
