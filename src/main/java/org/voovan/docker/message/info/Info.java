package org.voovan.docker.message.info;

import org.voovan.docker.message.info.atom.Plugins;
import org.voovan.docker.message.info.atom.RegistryConfig;
import org.voovan.docker.message.info.atom.Swarm;
import org.voovan.tools.json.JSONPath;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class Info {
    private String id;
    private Integer containers;
    private Integer containersRunning;
    private Integer containersPaused;
    private Integer containersStopped;
    private Integer images;
    private String driver;
    private boolean memoryLimit;
    private boolean swapLimit;
    private boolean kernelMemory;
    private boolean cpuCfsPeriod;
    private boolean cpuCfsQuota;
    private boolean cPUShares;
    private boolean cPUSet;
    private boolean iPv4Forwardin;
    private boolean bridgeNfIptables;
    private boolean bridgeNfIp6tables;
    private boolean debug;
    private Integer nfd;
    private boolean oomKillDisable;
    private Integer ngoroutines;
    private String systemTime;
    private String executionDriver;
    private String loggingDriver;
    private String cgroupDriver;
    private Integer nEventsListener;
    private String kernelVersion;
    private String operatingSystem;
    private String osType;
    private String architecture;
    private String indexServerAddress;
    private Integer nCPU;
    private Long memTotal;
    private String dockerRootDir;
    private String httpProxy;
    private String httpsProxy;
    private String noProxy;
    private String name;
    private Map<String, Object> labels;
    private boolean experimentalBuild;
    private String serverVersion;
    private String clusterStore;
    private String clusterAdvertise;
    private String defaultRuntime;
    private boolean liveRestoreEnabled;
    //v1.25
    private String isolation;
    private RegistryConfig registryConfig;
    private List<String> securityOptions;

    private Plugins plugins;
    private Swarm swarm;

    public Info(){
        securityOptions = new ArrayList<String>();
        plugins = new Plugins();
        swarm = new Swarm();
        registryConfig = new RegistryConfig();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getContainers() {
        return containers;
    }

    public void setContainers(Integer containers) {
        this.containers = containers;
    }

    public Integer getContainersRunning() {
        return containersRunning;
    }

    public void setContainersRunning(Integer containersRunning) {
        this.containersRunning = containersRunning;
    }

    public Integer getContainersPaused() {
        return containersPaused;
    }

    public void setContainersPaused(Integer containersPaused) {
        this.containersPaused = containersPaused;
    }

    public Integer getContainersStopped() {
        return containersStopped;
    }

    public void setContainersStopped(Integer containersStopped) {
        this.containersStopped = containersStopped;
    }

    public Integer getImages() {
        return images;
    }

    public void setImages(Integer images) {
        this.images = images;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public boolean isMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(boolean memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public boolean isSwapLimit() {
        return swapLimit;
    }

    public void setSwapLimit(boolean swapLimit) {
        this.swapLimit = swapLimit;
    }

    public boolean isKernelMemory() {
        return kernelMemory;
    }

    public void setKernelMemory(boolean kernelMemory) {
        this.kernelMemory = kernelMemory;
    }

    public boolean isCpuCfsPeriod() {
        return cpuCfsPeriod;
    }

    public void setCpuCfsPeriod(boolean cpuCfsPeriod) {
        this.cpuCfsPeriod = cpuCfsPeriod;
    }

    public boolean isCpuCfsQuota() {
        return cpuCfsQuota;
    }

    public void setCpuCfsQuota(boolean cpuCfsQuota) {
        this.cpuCfsQuota = cpuCfsQuota;
    }

    public boolean iscPUShares() {
        return cPUShares;
    }

    public void setcPUShares(boolean cPUShares) {
        this.cPUShares = cPUShares;
    }

    public boolean iscPUSet() {
        return cPUSet;
    }

    public void setcPUSet(boolean cPUSet) {
        this.cPUSet = cPUSet;
    }

    public boolean isiPv4Forwardin() {
        return iPv4Forwardin;
    }

    public void setiPv4Forwardin(boolean iPv4Forwardin) {
        this.iPv4Forwardin = iPv4Forwardin;
    }

    public boolean isBridgeNfIptables() {
        return bridgeNfIptables;
    }

    public void setBridgeNfIptables(boolean bridgeNfIptables) {
        this.bridgeNfIptables = bridgeNfIptables;
    }

    public boolean isBridgeNfIp6tables() {
        return bridgeNfIp6tables;
    }

    public void setBridgeNfIp6tables(boolean bridgeNfIp6tables) {
        this.bridgeNfIp6tables = bridgeNfIp6tables;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public Integer getNfd() {
        return nfd;
    }

    public void setNfd(Integer nfd) {
        this.nfd = nfd;
    }

    public boolean isOomKillDisable() {
        return oomKillDisable;
    }

    public void setOomKillDisable(boolean oomKillDisable) {
        this.oomKillDisable = oomKillDisable;
    }

    public Integer getNgoroutines() {
        return ngoroutines;
    }

    public void setNgoroutines(Integer ngoroutines) {
        this.ngoroutines = ngoroutines;
    }

    public String getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(String systemTime) {
        this.systemTime = systemTime;
    }

    public String getExecutionDriver() {
        return executionDriver;
    }

    public void setExecutionDriver(String executionDriver) {
        this.executionDriver = executionDriver;
    }

    public String getLoggingDriver() {
        return loggingDriver;
    }

    public void setLoggingDriver(String loggingDriver) {
        this.loggingDriver = loggingDriver;
    }

    public String getCgroupDriver() {
        return cgroupDriver;
    }

    public void setCgroupDriver(String cgroupDriver) {
        this.cgroupDriver = cgroupDriver;
    }

    public Integer getnEventsListener() {
        return nEventsListener;
    }

    public void setnEventsListener(Integer nEventsListener) {
        this.nEventsListener = nEventsListener;
    }

    public String getKernelVersion() {
        return kernelVersion;
    }

    public void setKernelVersion(String kernelVersion) {
        this.kernelVersion = kernelVersion;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public String getIndexServerAddress() {
        return indexServerAddress;
    }

    public void setIndexServerAddress(String indexServerAddress) {
        this.indexServerAddress = indexServerAddress;
    }

    public Integer getnCPU() {
        return nCPU;
    }

    public void setnCPU(Integer nCPU) {
        this.nCPU = nCPU;
    }

    public Long getMemTotal() {
        return memTotal;
    }

    public void setMemTotal(Long memTotal) {
        this.memTotal = memTotal;
    }

    public String getDockerRootDir() {
        return dockerRootDir;
    }

    public void setDockerRootDir(String dockerRootDir) {
        this.dockerRootDir = dockerRootDir;
    }

    public String getHttpProxy() {
        return httpProxy;
    }

    public void setHttpProxy(String httpProxy) {
        this.httpProxy = httpProxy;
    }

    public String getHttpsProxy() {
        return httpsProxy;
    }

    public void setHttpsProxy(String httpsProxy) {
        this.httpsProxy = httpsProxy;
    }

    public String getNoProxy() {
        return noProxy;
    }

    public void setNoProxy(String noProxy) {
        this.noProxy = noProxy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, Object> labels) {
        this.labels = labels;
    }

    public boolean isExperimentalBuild() {
        return experimentalBuild;
    }

    public void setExperimentalBuild(boolean experimentalBuild) {
        this.experimentalBuild = experimentalBuild;
    }

    public String getServerVersion() {
        return serverVersion;
    }

    public void setServerVersion(String serverVersion) {
        this.serverVersion = serverVersion;
    }

    public String getClusterStore() {
        return clusterStore;
    }

    public void setClusterStore(String clusterStore) {
        this.clusterStore = clusterStore;
    }

    public String getClusterAdvertise() {
        return clusterAdvertise;
    }

    public void setClusterAdvertise(String clusterAdvertise) {
        this.clusterAdvertise = clusterAdvertise;
    }

    public String getDefaultRuntime() {
        return defaultRuntime;
    }

    public void setDefaultRuntime(String defaultRuntime) {
        this.defaultRuntime = defaultRuntime;
    }

    public boolean isLiveRestoreEnabled() {
        return liveRestoreEnabled;
    }

    public void setLiveRestoreEnabled(boolean liveRestoreEnabled) {
        this.liveRestoreEnabled = liveRestoreEnabled;
    }

    public String getIsolation() {
        return isolation;
    }

    public void setIsolation(String isolation) {
        this.isolation = isolation;
    }

    public RegistryConfig getRegistryConfig() {
        return registryConfig;
    }

    public void setRegistryConfig(RegistryConfig registryConfig) {
        this.registryConfig = registryConfig;
    }

    public List<String> getSecurityOptions() {
        return securityOptions;
    }

    public void setSecurityOptions(List<String> securityOptions) {
        this.securityOptions = securityOptions;
    }

    public Plugins getPlugins() {
        return plugins;
    }

    public void setPlugins(Plugins plugins) {
        this.plugins = plugins;
    }

    public Swarm getSwarm() {
        return swarm;
    }

    public void setSwarm(Swarm swarm) {
        this.swarm = swarm;
    }

    public static Info load(String jsonStr) throws ParseException, ReflectiveOperationException {
        JSONPath jsonPath = JSONPath.newInstance(jsonStr);

        Info info = jsonPath.value("/", Info.class, new Info());
        return info;
    }
}
