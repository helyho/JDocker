package org.voovan.docker.message.network;

import org.voovan.docker.message.network.atom.Container;
import org.voovan.docker.message.network.atom.IPAM;
import org.voovan.docker.message.network.atom.Peers;
import org.voovan.tools.json.JSONPath;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class NetworkDetail extends NetworkCreate {
    private String id;
    private String scope;
    private Boolean attachable;

    private HashMap<String,Container> containers;

    private List<Peers> peers;

    //v1.25
    private String created;

    public NetworkDetail() {
        super();
        containers = new HashMap<String,Container>();
        peers = new ArrayList<Peers>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Boolean isAttachable() {
        return attachable;
    }

    public void setAttachable(Boolean attachable) {
        this.attachable = attachable;
    }

    public HashMap<String,Container> getContainers() {
        return containers;
    }

    public void setContainers(HashMap<String,Container> containers) {
        this.containers = containers;
    }

    //v1.25
    public String getCreated() {
        return created;
    }

    //v1.25
    public void setCreated(String created) {
        this.created = created;
    }

    public List<Peers> getPeers() {
        return peers;
    }

    public void setPeers(List<Peers> peers) {
        this.peers = peers;
    }

    public static NetworkDetail load(String jsonStr) throws ParseException, ReflectiveOperationException {

        JSONPath jsonPath = JSONPath.newInstance(jsonStr);
        NetworkDetail networkDetail =jsonPath.value("/",NetworkDetail.class, new NetworkDetail());
        return networkDetail;
    }
}
