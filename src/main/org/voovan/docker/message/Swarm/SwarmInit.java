package org.voovan.docker.message.Swarm;

import org.voovan.docker.message.Swarm.atom.Spec;
import org.voovan.tools.json.JSON;
import org.voovan.tools.log.Logger;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         DockerFly Framework.
 *         WebSite: https://github.com/helyho/DockerFly
 *         Licence: Apache v2 License
 */
public class SwarmInit {
    private String listenAddr;
    private String advertiseAddr;
    private boolean forceNewCluster;
    private Spec spec;

    public SwarmInit(){
        listenAddr = "0.0.0.0:2377";
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

    public boolean isForceNewCluster() {
        return forceNewCluster;
    }

    public void setForceNewCluster(boolean forceNewCluster) {
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
