package org.voovan.docker.message.container.atom;

import org.voovan.docker.message.service.atom.RestartPolicy;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class ContainerUpdate {
    private Integer blkioWeight;
    private Integer cpuShares;
    private Integer cpuPeriod;
    private Integer cpuQuota;
    private Integer cpusetCpus;
    private Integer cpusetMems;
    private Long memory;
    private Long memorySwap;
    private Long memoryReservation;
    private Long kernelMemory;
    private RestartPolicy restartPolicy;

    public ContainerUpdate() {
        restartPolicy = new RestartPolicy();
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

    public Integer getCpusetCpus() {
        return cpusetCpus;
    }

    public void setCpusetCpus(Integer cpusetCpus) {
        this.cpusetCpus = cpusetCpus;
    }

    public Integer getCpusetMems() {
        return cpusetMems;
    }

    public void setCpusetMems(Integer cpusetMems) {
        this.cpusetMems = cpusetMems;
    }

    public Long getMemory() {
        return memory;
    }

    public void setMemory(Long memory) {
        this.memory = memory;
    }

    public Long getMemorySwap() {
        return memorySwap;
    }

    public void setMemorySwap(Long memorySwap) {
        this.memorySwap = memorySwap;
    }

    public Long getMemoryReservation() {
        return memoryReservation;
    }

    public void setMemoryReservation(Long memoryReservation) {
        this.memoryReservation = memoryReservation;
    }

    public Long getKernelMemory() {
        return kernelMemory;
    }

    public void setKernelMemory(Long kernelMemory) {
        this.kernelMemory = kernelMemory;
    }

    public RestartPolicy getRestartPolicy() {
        return restartPolicy;
    }

    public void setRestartPolicy(RestartPolicy restartPolicy) {
        this.restartPolicy = restartPolicy;
    }
}
