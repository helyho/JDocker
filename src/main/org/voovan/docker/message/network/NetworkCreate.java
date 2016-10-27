package org.voovan.docker.message.network;

import org.voovan.docker.message.network.atom.IPAM;
import org.voovan.tools.json.JSON;
import org.voovan.tools.log.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class NetworkCreate {
    private String name;
    private String driver;
    private boolean enableIPv6;
    private IPAM ipam;
    private Map<String, Object> labels;

    public NetworkCreate() {
        labels = new HashMap<String, Object>();
        ipam = new IPAM();
        enableIPv6 = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        driver = driver;
    }

    public boolean isEnableIPv6() {
        return enableIPv6;
    }

    public void setEnableIPv6(boolean enableIPv6) {
        enableIPv6 = enableIPv6;
    }

    public IPAM getIpam() {
        return ipam;
    }

    public void setIpam(IPAM ipam) {
        this.ipam = ipam;
    }

    public Map<String, Object> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, Object> labels) {
        this.labels = labels;
    }

    public static void main(String[] args) {
        NetworkCreate networkCreate = new NetworkCreate();
        networkCreate.setName("prog_test");
        networkCreate.setDriver("bridge");
        networkCreate.getLabels().put("test", "dafdasdf");

        Logger.simple(JSON.formatJson(JSON.toJSON(networkCreate)));
    }
}
