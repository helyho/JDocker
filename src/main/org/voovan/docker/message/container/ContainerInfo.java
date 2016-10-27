package org.voovan.docker.message.container;

import org.voovan.docker.message.container.atom.Mount;
import org.voovan.docker.message.container.atom.Network;
import org.voovan.docker.message.container.atom.Port;
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
public class ContainerInfo {
    private String id;
    private List<String> names;
    private String image;

    private String imageID;
    private String command;
    private long created;
    private List<Port> ports;
    private String state;
    private String status;
    private Map<String, Object> hostConfig;
    private List<Network> networkSettings;
    private List<Mount> mounts;

    private Map<String, Object> labels;

    public ContainerInfo() {
        labels = new HashMap<String, Object>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public List<Port> getPorts() {
        return ports;
    }

    public void setPorts(List<Port> ports) {
        this.ports = ports;
    }

    public Map<String, Object> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, Object> labels) {
        this.labels = labels;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, Object> getHostConfig() {
        return hostConfig;
    }

    public void setHostConfig(Map<String, Object> hostConfig) {
        this.hostConfig = hostConfig;
    }

    public List<Network> getNetworkSettings() {
        return networkSettings;
    }

    public void setNetworkSettings(List<Network> networkSettings) {
        this.networkSettings = networkSettings;
    }

    public List<Mount> getMounts() {
        return mounts;
    }

    public void setMounts(List<Mount> mounts) {
        this.mounts = mounts;
    }

    public static List<ContainerInfo> load(String jsonStr) throws ParseException, ReflectiveOperationException {
        List<ContainerInfo> containerInfos = new ArrayList<ContainerInfo>();
        JSONPath jsonPath = JSONPath.newInstance(jsonStr);

        for (int i = 0; i < jsonPath.value("/", List.class).size(); i++) {
            ContainerInfo containerInfo = new ContainerInfo();
            containerInfo.setId(jsonPath.value("/[" + i + "]/Id", String.class));
            containerInfo.setNames(jsonPath.value("/[" + i + "]/Names", List.class));
            containerInfo.setImage(jsonPath.value("/[" + i + "]/Image", String.class));
            containerInfo.setImageID(jsonPath.value("/[" + i + "]/ImageID", String.class));
            containerInfo.setCommand(jsonPath.value("/[" + i + "]/Command", String.class));
            containerInfo.setCreated(jsonPath.value("/[" + i + "]/Created", int.class, -1));
            containerInfo.setPorts(jsonPath.listObject("/[" + i + "]/Ports", Port.class));
            containerInfo.setState(jsonPath.value("/[" + i + "]/State", String.class));
            containerInfo.setStatus(jsonPath.value("/[" + i + "]/Status", String.class));
            containerInfo.setHostConfig(jsonPath.value("/[" + i + "]/HostConfig", Map.class));
            containerInfo.setMounts(jsonPath.listObject("/[" + i + "]/Mounts", Mount.class));


            containerInfo.setNetworkSettings(jsonPath.mapToListObject("/[" + i + "]/NetworkSettings/Networks", "Name", Network.class));
            containerInfo.setLabels((Map<String, Object>) jsonPath.value("/[" + i + "]/Labels", Map.class));
            containerInfos.add(containerInfo);
        }
        return containerInfos;
    }
}
