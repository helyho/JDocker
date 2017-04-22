package org.voovan.docker.message.network;

import org.voovan.docker.message.network.atom.Container;
import org.voovan.docker.message.network.atom.IPAM;
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
public class NetworkInfo extends NetworkCreate {
    private String id;
    private String scope;
    private String driver;
    private Boolean internal;
    private Boolean enableIPv6;
    private Boolean attachable;
    private IPAM ipam;

    private HashMap<String,Container> containers;

    private HashMap<String,Container> options;

    //v1.25
    private String created;

    public NetworkInfo() {
        super();
        containers = new HashMap<String,Container>();
        options = new HashMap<String,Container>();
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

    @Override
    public String getDriver() {
        return driver;
    }

    @Override
    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Boolean isInternal() {
        return internal;
    }

    public void setInternal(Boolean internal) {
        this.internal = internal;
    }

    @Override
    public Boolean isEnableIPv6() {
        return enableIPv6;
    }

    @Override
    public void setEnableIPv6(Boolean enableIPv6) {
        this.enableIPv6 = enableIPv6;
    }

    public Boolean isAttachable() {
        return attachable;
    }

    public void setAttachable(Boolean attachable) {
        this.attachable = attachable;
    }

    @Override
    public IPAM getIpam() {
        return ipam;
    }

    @Override
    public void setIpam(IPAM ipam) {
        this.ipam = ipam;
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

    public static List<NetworkInfo> load(String jsonStr) throws ParseException, ReflectiveOperationException {

        if(!jsonStr.trim().startsWith("[")){
            jsonStr = "["+jsonStr+"]";
        }

        JSONPath jsonPath = JSONPath.newInstance(jsonStr);
        List<NetworkInfo> networkInfos =jsonPath.listObject("/",NetworkInfo.class, new ArrayList<NetworkInfo>());
        return networkInfos;
    }
}
