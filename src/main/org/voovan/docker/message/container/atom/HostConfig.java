package org.voovan.docker.message.container.atom;

import org.voovan.docker.message.service.atom.RestartPolicy;

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
public class HostConfig {
    private Integer blkioWeight;
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
    private List<String> dns;
    private List<String> binds;
    private List<String> volumesFrom;
    private List<String> links;
    private List<Device> devices;
    private Map<String, List<Map<String, String>>> portBindings;

    public HostConfig() {
        dns = new ArrayList<String>();
        binds = new ArrayList<String>();
        links = new ArrayList<String>();
        devices = new ArrayList<Device>();
        portBindings = new HashMap<String, List<Map<String, String>>>();
    }

    public Integer getBlkioWeight() {
        return blkioWeight;
    }

    public void setBlkioWeight(Integer blkioWeight) {
        this.blkioWeight = blkioWeight;
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
}
