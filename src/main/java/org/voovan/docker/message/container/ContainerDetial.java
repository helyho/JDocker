package org.voovan.docker.message.container;

import org.voovan.docker.message.Image.atom.GraphDriver;
import org.voovan.docker.message.container.atom.*;
import org.voovan.tools.json.JSONPath;

import java.text.ParseException;
import java.util.List;

/**
 * 类文字命名
 *
 * @author: helyho
 * JDocker Framework.
 * WebSite: https://github.com/helyho/JDocker
 * Licence: Apache v2 License
 */
public class ContainerDetial {
    private String image;
    private String resolvConfPath;
    private String hostnamePath;
    private String hostsPath;
    private String logPath;
    private String name;
    private Integer restartCount;
    private String driver;
    private String mountLabel;
    private String processLabel;
    private String appArmorProfile;
    private String id;
    private String created;
    private String path;

    private List<String> args;
    private List<String> execIDs;

    private State state;

    private HostConfig hostConfig;
    private GraphDriver graphDriver;
    private List<Mount> mounts;
    private Config config;
    private NetworkSettings networkSettings;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getResolvConfPath() {
        return resolvConfPath;
    }

    public void setResolvConfPath(String resolvConfPath) {
        this.resolvConfPath = resolvConfPath;
    }

    public String getHostnamePath() {
        return hostnamePath;
    }

    public void setHostnamePath(String hostnamePath) {
        this.hostnamePath = hostnamePath;
    }

    public String getHostsPath() {
        return hostsPath;
    }

    public void setHostsPath(String hostsPath) {
        this.hostsPath = hostsPath;
    }

    public String getLogPath() {
        return logPath;
    }

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRestartCount() {
        return restartCount;
    }

    public void setRestartCount(Integer restartCount) {
        this.restartCount = restartCount;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getMountLabel() {
        return mountLabel;
    }

    public void setMountLabel(String mountLabel) {
        this.mountLabel = mountLabel;
    }

    public String getProcessLabel() {
        return processLabel;
    }

    public void setProcessLabel(String processLabel) {
        this.processLabel = processLabel;
    }

    public String getAppArmorProfile() {
        return appArmorProfile;
    }

    public void setAppArmorProfile(String appArmorProfile) {
        this.appArmorProfile = appArmorProfile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }

    public List<String> getExecIDs() {
        return execIDs;
    }

    public void setExecIDs(List<String> execIDs) {
        this.execIDs = execIDs;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public HostConfig getHostConfig() {
        return hostConfig;
    }

    public void setHostConfig(HostConfig hostConfig) {
        this.hostConfig = hostConfig;
    }

    public GraphDriver getGraphDriver() {
        return graphDriver;
    }

    public void setGraphDriver(GraphDriver graphDriver) {
        this.graphDriver = graphDriver;
    }

    public List<Mount> getMounts() {
        return mounts;
    }

    public void setMounts(List<Mount> mounts) {
        this.mounts = mounts;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public NetworkSettings getNetworkSettings() {
        return networkSettings;
    }

    public void setNetworkSettings(NetworkSettings networkSettings) {
        this.networkSettings = networkSettings;
    }

    public static ContainerDetial load(String jsonStr) throws ParseException, ReflectiveOperationException {

        JSONPath jsonPath = JSONPath.newInstance(jsonStr);

        ContainerDetial containerDetial = jsonPath.value("/",ContainerDetial.class,new ContainerDetial());
        return containerDetial;
    }
}
