package org.voovan.docker.message.container.atom;

import org.voovan.docker.message.service.atom.RestartPolicy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         DockerFly Framework.
 *         WebSite: https://github.com/helyho/DockerFly
 *         Licence: Apache v2 License
 */
public class HostConfig {
    private int blkioWeight;
    private int cpuShares;
    private int cpuPeriod;
    private int cpuQuota;
    private String cpusetCpus;
    private long memory;
    private int memorySwap;
    private int memoryReservation;
    private int kernelMemory;
    private RestartPolicy restartPolicy;
    private String networkMode;
    private List<String> dns;
    private List<String> binds;
    private List<String> links;
    private List<Device> devices;
    private Map<String,List<Map<String,String>>> portBindings;

    public HostConfig(){
        dns = new ArrayList<String>();
        binds = new ArrayList<String>();
        links = new ArrayList<String>();
        devices = new ArrayList<Device>();
        portBindings = new HashMap<String,List<Map<String,String>>>();
    }

    public int getBlkioWeight() {
        return blkioWeight;
    }

    public void setBlkioWeight(int blkioWeight) {
        this.blkioWeight = blkioWeight;
    }

    public int getCpuShares() {
        return cpuShares;
    }

    public void setCpuShares(int cpuShares) {
        this.cpuShares = cpuShares;
    }

    public int getCpuPeriod() {
        return cpuPeriod;
    }

    public void setCpuPeriod(int cpuPeriod) {
        this.cpuPeriod = cpuPeriod;
    }

    public int getCpuQuota() {
        return cpuQuota;
    }

    public void setCpuQuota(int cpuQuota) {
        this.cpuQuota = cpuQuota;
    }

    public String getCpusetCpus() {
        return cpusetCpus;
    }

    public void setCpusetCpus(String cpusetCpus) {
        this.cpusetCpus = cpusetCpus;
    }

    public long getMemory() {
        return memory;
    }

    public void setMemory(long memory) {
        this.memory = memory;
    }

    public int getMemorySwap() {
        return memorySwap;
    }

    public void setMemorySwap(int memorySwap) {
        this.memorySwap = memorySwap;
    }

    public int getMemoryReservation() {
        return memoryReservation;
    }

    public void setMemoryReservation(int memoryReservation) {
        this.memoryReservation = memoryReservation;
    }

    public int getKernelMemory() {
        return kernelMemory;
    }

    public void setKernelMemory(int kernelMemory) {
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

    public Map<String,List<Map<String,String>>>getPortBindings() {
        return portBindings;
    }

    public void setPortBindings(Map<String,List<Map<String,String>>> portBindings) {
        this.portBindings = portBindings;
    }
}
