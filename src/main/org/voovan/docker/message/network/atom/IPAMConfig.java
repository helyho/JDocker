package org.voovan.docker.message.network.atom;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         DockerFly Framework.
 *         WebSite: https://github.com/helyho/DockerFly
 *         Licence: Apache v2 License
 */
public class IPAMConfig {
    private String subnet;
    private String ipRange;
    private String gateway;

    public IPAMConfig() {
        subnet = "172.20.0.0/16";
        ipRange = "172.20.10.0/24";
        gateway = "172.20.10.11";

    }

    public String getSubnet() {
        return subnet;
    }

    public void setSubnet(String subnet) {
        this.subnet = subnet;
    }

    public String getIpRange() {
        return ipRange;
    }

    public void setIpRange(String ipRange) {
        this.ipRange = ipRange;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }
}
