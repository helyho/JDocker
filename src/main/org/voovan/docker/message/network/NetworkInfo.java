package org.voovan.docker.message.network;

import org.voovan.docker.message.network.atom.Container;
import org.voovan.docker.message.network.atom.IPAMConfig;
import org.voovan.tools.json.JSONPath;

import java.text.ParseException;
import java.util.ArrayList;
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
    private boolean internal;
    private List<Container> containers;

    public NetworkInfo() {
        super();
        containers = new ArrayList<Container>();
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

    public boolean getInternal() {
        return internal;
    }

    public void setInternal(boolean internal) {
        this.internal = internal;
    }

    public List<Container> getContainers() {
        return containers;
    }

    public void setContainers(List<Container> containers) {
        this.containers = containers;
    }

    public static List<NetworkInfo> load(String jsonStr) throws ParseException, ReflectiveOperationException {
        JSONPath jsonPath = JSONPath.newInstance(jsonStr);
        List<NetworkInfo> networkInfos = new ArrayList<NetworkInfo>();
        for (int i = 0; i < jsonPath.value("/", List.class).size(); i++) {
            NetworkInfo networkInfo = new NetworkInfo();
            networkInfo.setId(jsonPath.value("/[" + i + "]/Id", String.class));
            networkInfo.setName(jsonPath.value("/[" + i + "]/Name", String.class));
            networkInfo.setScope(jsonPath.value("/[" + i + "]/Scope", String.class));
            networkInfo.setDriver(jsonPath.value("/[" + i + "]/Driver", String.class));
            networkInfo.setEnableIPv6(jsonPath.value("/[" + i + "]/EnableIPv6", boolean.class));
            networkInfo.setInternal(jsonPath.value("/[" + i + "]/Internal", boolean.class));

            networkInfo.getIpam().setDriver(jsonPath.value("/[" + i + "]/IPAM/Driver", String.class));
            Map optionsNode = jsonPath.value("/[" + i + "]/IPAM/Options", Map.class);
            if (optionsNode != null) {
                networkInfo.getIpam().getOptions().putAll(optionsNode);
            }
            networkInfo.getIpam().getConfig().addAll(jsonPath.listObject("/[" + i + "]/IPAM/Config", IPAMConfig.class));
            List<Container> containersNode = jsonPath.mapToListObject("/[" + i + "]/Containers", "containerId", Container.class);
            if (containersNode != null) {
                networkInfo.getContainers().addAll(containersNode);
            }
            networkInfos.add(networkInfo);
        }

        return networkInfos;
    }
}
