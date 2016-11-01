package org.voovan.docker.message.swarm;

import org.voovan.docker.message.swarm.atom.Spec;
import org.voovan.tools.json.JSON;
import org.voovan.tools.log.Logger;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class SwarmInit {
    private String listenAddr;
    private String advertiseAddr;
    private Boolean forceNewCluster;
    private Spec spec;

    public SwarmInit() {
        listenAddr = "0.0.0.0:2737";
        forceNewCluster = false;
        spec = new Spec();
    }

    public String getListenAddr() {
        return listenAddr;
    }

    public void setListenAddr(String listenAddr) {
        this.listenAddr = listenAddr;
    }

    public String getAdvertiseAddr() {
        return advertiseAddr;
    }

    public void setAdvertiseAddr(String advertiseAddr) {
        this.advertiseAddr = advertiseAddr;
    }

    public Boolean isForceNewCluster() {
        return forceNewCluster;
    }

    public void setForceNewCluster(Boolean forceNewCluster) {
        this.forceNewCluster = forceNewCluster;
    }

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
        this.spec = spec;
    }

    public static void main(String[] args) {
        SwarmInit swarmInit = new SwarmInit();
        swarmInit.setAdvertiseAddr("192.168.65.2:2377");
        Logger.simple(JSON.formatJson(JSON.toJSON(swarmInit)));
    }
}
