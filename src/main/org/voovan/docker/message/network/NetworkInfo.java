package org.voovan.docker.message.network;

import org.voovan.docker.message.network.atom.Container;
import org.voovan.docker.message.network.atom.IPAMConfig;
import org.voovan.tools.json.JSONPath;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class NetworkInfo extends NetworkCreate {
    private String id;
    private String scope;
    private Boolean internal;
    private HashMap<String,Container> containers;

    public NetworkInfo() {
        super();
        containers = new HashMap<String,Container>();
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

    public Boolean getInternal() {
        return internal;
    }

    public void setInternal(Boolean internal) {
        this.internal = internal;
    }

    public HashMap<String,Container> getContainers() {
        return containers;
    }

    public void setContainers(HashMap<String,Container> containers) {
        this.containers = containers;
    }

    public static List<NetworkInfo> load(String jsonStr) throws ParseException, ReflectiveOperationException {

        if(!jsonStr.trim().startsWith("[")){
            jsonStr = "["+jsonStr+"]";
        }

        JSONPath jsonPath = JSONPath.newInstance(jsonStr);
        List<NetworkInfo> networkInfos =jsonPath.listObject("/",NetworkInfo.class, new ArrayList<NetworkInfo>());
        return networkInfos;
    }
}
