package org.voovan.docker.message.Node.atom;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class ManagerStatus {
    private String leader;
    private String reachability;
    private String addr;

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getReachability() {
        return reachability;
    }

    public void setReachability(String reachability) {
        this.reachability = reachability;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
