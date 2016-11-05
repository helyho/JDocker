package org.voovan.docker.message.container;

import org.voovan.docker.message.container.atom.*;
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
    private Long sizeRootFs;

    private String imageID;
    private String command;
    private Long created;
    private List<Port> ports;
    private String state;
    private String status;
    private HostConfig hostConfig;
    private NetworkSettings networkSettings;
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

    public Long getSizeRootFs() {
        return sizeRootFs;
    }

    public void setSizeRootFs(Long sizeRootFs) {
        this.sizeRootFs = sizeRootFs;
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

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
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

    public HostConfig getHostConfig() {
        return hostConfig;
    }

    public void setHostConfig(HostConfig hostConfig) {
        this.hostConfig = hostConfig;
    }

    public NetworkSettings getNetworkSettings() {
        return networkSettings;
    }

    public void setNetworkSettings(NetworkSettings networkSettings) {
        this.networkSettings = networkSettings;
    }

    public List<Mount> getMounts() {
        return mounts;
    }

    public void setMounts(List<Mount> mounts) {
        this.mounts = mounts;
    }

    public static List<ContainerInfo> load(String jsonStr) throws ParseException, ReflectiveOperationException {

        if(!jsonStr.trim().startsWith("[")){
            jsonStr = "["+jsonStr+"]";
        }

        JSONPath jsonPath = JSONPath.newInstance(jsonStr);

        List<ContainerInfo> containerInfos = jsonPath.listObject("/",ContainerInfo.class,new ArrayList<ContainerInfo>());
        return containerInfos;
    }
}
