package org.voovan.docker.message.Swarm;

import org.voovan.tools.json.JSON;
import org.voovan.tools.log.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         DockerFly Framework.
 *         WebSite: https://github.com/helyho/DockerFly
 *         Licence: Apache v2 License
 */
public class SwarmJoin {
    private String listenAddr;
    private String advertiseAddr;
    private List<String> remoteAddrs;
    private String joinToken;

    public SwarmJoin() {
        listenAddr = "0.0.0.0:2377";
        remoteAddrs = new ArrayList<String>();
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

    public List<String> getRemoteAddrs() {
        return remoteAddrs;
    }

    public void setRemoteAddrs(List<String> remoteAddrs) {
        this.remoteAddrs = remoteAddrs;
    }

    public String getJoinToken() {
        return joinToken;
    }

    public void setJoinToken(String joinToken) {
        this.joinToken = joinToken;
    }

    public static void main(String[] args) {
        SwarmJoin swarmJoin = new SwarmJoin();

        swarmJoin.getRemoteAddrs().add("103.214.142.16:2377");
        swarmJoin.setJoinToken("SWMTKN-1-3foky7n2vsqtitqy7lx0e95ypre8xrlwz0w972d24slmdf0xt0-6rtarw25ao45xv0o1g3lk3nkm");

        Logger.simple(JSON.formatJson(JSON.toJSON(swarmJoin)));
    }
}
