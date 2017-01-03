package org.voovan.docker.message.info.atom;

import org.voovan.docker.message.swarm.SwarmInfo;
import org.voovan.docker.message.swarm.atom.SwarmSpec;

import java.util.ArrayList;
import java.util.List;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class Swarm {

    private String nodeID;
    private String nodeAddr;
    private String nodeState;
    private boolean controlAvailable;
    private String error;
    private int nodes;
    private int managers;
    private List<RemoteManager> remoteManagers;
    private SwarmInfo cluster;

    public Swarm(){
        remoteManagers = new ArrayList<RemoteManager>();
        cluster = new SwarmInfo();
    }

    public String getNodeID() {
        return nodeID;
    }

    public void setNodeID(String nodeID) {
        this.nodeID = nodeID;
    }

    public String getNodeAddr() {
        return nodeAddr;
    }

    public void setNodeAddr(String nodeAddr) {
        this.nodeAddr = nodeAddr;
    }

    public String getNodeState() {
        return nodeState;
    }

    public void setNodeState(String nodeState) {
        this.nodeState = nodeState;
    }

    public boolean isControlAvailable() {
        return controlAvailable;
    }

    public void setControlAvailable(boolean controlAvailable) {
        this.controlAvailable = controlAvailable;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getNodes() {
        return nodes;
    }

    public void setNodes(int nodes) {
        this.nodes = nodes;
    }

    public int getManagers() {
        return managers;
    }

    public void setManagers(int managers) {
        this.managers = managers;
    }

    public List<RemoteManager> getRemoteManagers() {
        return remoteManagers;
    }

    public void setRemoteManagers(List<RemoteManager> remoteManagers) {
        this.remoteManagers = remoteManagers;
    }

    public SwarmInfo getCluster() {
        return cluster;
    }

    public void setCluster(SwarmInfo cluster) {
        this.cluster = cluster;
    }
}
