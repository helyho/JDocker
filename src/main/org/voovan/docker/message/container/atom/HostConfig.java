package org.voovan.docker.message.container.atom;

import org.voovan.docker.message.service.atom.RestartPolicy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.voovan.docker.message.service.atom.Mount;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class HostConfig {
    private Integer cpuShares;
    private Integer cpuPeriod;
    private Integer cpuQuota;
    private String cpusetCpus;
    private Long memory;
    private Integer memorySwap;
    private Integer memoryReservation;
    private Integer kernelMemory;
    private RestartPolicy restartPolicy;
    private String networkMode;
    private Boolean publishAllPorts;
    private Boolean privileged;
    private List<String> dns;
    private List<String> binds;
    private List<String> volumesFrom;
    private List<String> links;
    private List<Device> devices;
    private Map<String, List<Map<String, String>>> portBindings;
    private ArrayList<ULimit> ulimits;
    private Integer blkioWeight;
    private ArrayList<BlockIORate> blkioWeightDevice;
    private ArrayList<BlockIORate> blkioDeviceReadBps;
    private ArrayList<BlockIORate> blkioDeviceWriteBps;
    private ArrayList<BlockIORate> blkioDeviceReadIOps;
    private ArrayList<BlockIORate> blkioDeviceWiiteIOps;

    //v1.25
    private Long nanoCPUs;

    //v1.25
    private List<Mount> mounts;

    //1.25
    private Boolean autoRemove;

    public HostConfig() {
        cpuPeriod = 100000;
        blkioWeight = null;
        dns = new ArrayList<String>();
        binds = new ArrayList<String>();

        links = new ArrayList<String>();
        devices = new ArrayList<Device>();
        volumesFrom =  new ArrayList<String>();
        portBindings = new HashMap<String, List<Map<String, String>>>();
        ulimits = new ArrayList<ULimit>();
        blkioWeightDevice = new ArrayList<BlockIORate>();
        blkioDeviceReadBps = new ArrayList<BlockIORate>();
        blkioDeviceWriteBps = new ArrayList<BlockIORate>();
        blkioDeviceReadIOps = new ArrayList<BlockIORate>();
        blkioDeviceWiiteIOps = new ArrayList<BlockIORate>();

        //1.25
        mounts = new ArrayList<Mount>();
        //1.25
        autoRemove = false;
    }

    public Integer getCpuShares() {
        return cpuShares;
    }

    public void setCpuShares(Integer cpuShares) {
        this.cpuShares = cpuShares;
    }

    public Integer getCpuPeriod() {
        return cpuPeriod;
    }

    public void setCpuPeriod(Integer cpuPeriod) {
        this.cpuPeriod = cpuPeriod;
    }

    public Integer getCpuQuota() {
        return cpuQuota;
    }

    public void setCpuQuota(Integer cpuQuota) {
        this.cpuQuota = cpuQuota;
    }

    public String getCpusetCpus() {
        return cpusetCpus;
    }

    public void setCpusetCpus(String cpusetCpus) {
        this.cpusetCpus = cpusetCpus;
    }

    public Long getMemory() {
        return memory;
    }

    public void setMemory(Long memory) {
        this.memory = memory;
    }

    public Integer getMemorySwap() {
        return memorySwap;
    }

    public void setMemorySwap(Integer memorySwap) {
        this.memorySwap = memorySwap;
    }

    public Integer getMemoryReservation() {
        return memoryReservation;
    }

    public void setMemoryReservation(Integer memoryReservation) {
        this.memoryReservation = memoryReservation;
    }

    public Integer getKernelMemory() {
        return kernelMemory;
    }

    public void setKernelMemory(Integer kernelMemory) {
        this.kernelMemory = kernelMemory;
    }

    public RestartPolicy getRestartPolicy() {
        return restartPolicy;
    }

    public void setRestartPolicy(RestartPolicy restartPolicy) {
        this.restartPolicy = restartPolicy;
    }

    public String getNetworkMode() {
        return networkMode;
    }

    public void setNetworkMode(String networkMode) {
        this.networkMode = networkMode;
    }

    public Boolean isPublishAllPorts() {
        return publishAllPorts;
    }

    public void setPublishAllPorts(Boolean publishAllPorts) {
        this.publishAllPorts = publishAllPorts;
    }

    public Boolean isPrivileged() {
        return privileged;
    }

    public void setPrivileged(Boolean privileged) {
        this.privileged = privileged;
    }

    public List<String> getDns() {
        return dns;
    }

    public void setDns(List<String> dns) {
        this.dns = dns;
    }

    public List<String> getBinds() {
        return binds;
    }

    public void setBinds(List<String> binds) {
        this.binds = binds;
    }

    public List<String> getVolumesFrom() {
        return volumesFrom;
    }

    public void setVolumesFrom(List<String> volumesFrom) {
        this.volumesFrom = volumesFrom;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public Map<String, List<Map<String, String>>> getPortBindings() {
        return portBindings;
    }

    public void setPortBindings(Map<String, List<Map<String, String>>> portBindings) {
        this.portBindings = portBindings;
    }

    public ArrayList<ULimit> getUlimits() {
        return ulimits;
    }

    public void setUlimits(ArrayList<ULimit> ulimits) {
        this.ulimits = ulimits;
    }

    public Integer getBlkioWeight() {
        return blkioWeight;
    }

    public void setBlkioWeight(Integer blkioWeight) {
        this.blkioWeight = blkioWeight;
    }

    public ArrayList<BlockIORate> getBlkioWeightDevice() {
        return blkioWeightDevice;
    }

    public void setBlkioWeightDevice(ArrayList<BlockIORate> blkioWeightDevice) {
        this.blkioWeightDevice = blkioWeightDevice;
    }

    public ArrayList<BlockIORate> getBlkioDeviceReadBps() {
        return blkioDeviceReadBps;
    }

    public void setBlkioDeviceReadBps(ArrayList<BlockIORate> blkioDeviceReadBps) {
        this.blkioDeviceReadBps = blkioDeviceReadBps;
    }

    public ArrayList<BlockIORate> getBlkioDeviceWriteBps() {
        return blkioDeviceWriteBps;
    }

    public void setBlkioDeviceWriteBps(ArrayList<BlockIORate> blkioDeviceWriteBps) {
        this.blkioDeviceWriteBps = blkioDeviceWriteBps;
    }

    public ArrayList<BlockIORate> getBlkioDeviceReadIOps() {
        return blkioDeviceReadIOps;
    }

    public void setBlkioDeviceReadIOps(ArrayList<BlockIORate> blkioDeviceReadIOps) {
        this.blkioDeviceReadIOps = blkioDeviceReadIOps;
    }

    public ArrayList<BlockIORate> getBlkioDeviceWiiteIOps() {
        return blkioDeviceWiiteIOps;
    }

    public void setBlkioDeviceWiiteIOps(ArrayList<BlockIORate> blkioDeviceWiiteIOps) {
        this.blkioDeviceWiiteIOps = blkioDeviceWiiteIOps;
    }

    //v1.25
    public Long getNanoCPUs() {
        return nanoCPUs;
    }

    //v1.25
    public void setNanoCPUs(Long nanoCPUs) {
        this.nanoCPUs = nanoCPUs;
    }

    //1.25
    public List<Mount> getMounts() {
        return mounts;
    }

    //1.25
    public void setMounts(List<Mount> mounts) {
        this.mounts = mounts;
    }

    //v1.25
    public Boolean isAutoRemove() {
        return autoRemove;
    }

    //v1.25
    public void setAutoRemove(Boolean autoRemove) {
        this.autoRemove = autoRemove;
    }

    //v1.25
    public void setAutoRemove(boolean autoRemove) {
        this.autoRemove = autoRemove;
    }
}
