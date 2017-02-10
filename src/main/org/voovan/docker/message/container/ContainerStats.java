package org.voovan.docker.message.container;

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
public class ContainerStats {
    private Long cpuTotal;
    private Long cpuUsage;
    private List<Long> perCpuUsage;
    private Long memoryUsage;
    private Long memoryMaxUsage;
    private Long memoryMaxLimit;
    private Integer memoryFailCnt;
    private Long ioRead;
    private Long ioWrite;
    private Long ioSync;
    private Long ioAsync;
    private Long ioTotal;
    private Long netRxBytes;
    private Long netRxPackets;
    private Long netRxErros;
    private Long netRxDrops;
    private Long netTxBytes;
    private Long netTxPackets;
    private Long netTxErros;
    private Long netTxDrops;

    public ContainerStats() {
        perCpuUsage = new ArrayList<Long>();
    }

    public Long getCpuTotal() {
        return cpuTotal;
    }

    public void setCpuTotal(Long cpuTotal) {
        this.cpuTotal = cpuTotal;
    }

    public Long getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(Long cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public List<Long> getPerCpuUsage() {
        return perCpuUsage;
    }

    public void setPerCpuUsage(List<Long> perCpuUsage) {
        this.perCpuUsage = perCpuUsage;
    }

    public Long getMemoryUsage() {
        return memoryUsage;
    }

    public void setMemoryUsage(Long memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    public Long getMemoryMaxUsage() {
        return memoryMaxUsage;
    }

    public void setMemoryMaxUsage(Long memoryMaxUsage) {
        this.memoryMaxUsage = memoryMaxUsage;
    }

    public Long getMemoryMaxLimit() {
        return memoryMaxLimit;
    }

    public void setMemoryMaxLimit(Long memoryMaxLimit) {
        this.memoryMaxLimit = memoryMaxLimit;
    }

    public Integer getMemoryFailCnt() {
        return memoryFailCnt;
    }

    public void setMemoryFailCnt(Integer memoryFailCnt) {
        this.memoryFailCnt = memoryFailCnt;
    }

    public Long getIoRead() {
        return ioRead;
    }

    public void setIoRead(Long ioRead) {
        this.ioRead = ioRead;
    }

    public Long getIoWrite() {
        return ioWrite;
    }

    public void setIoWrite(Long ioWrite) {
        this.ioWrite = ioWrite;
    }

    public Long getIoSync() {
        return ioSync;
    }

    public void setIoSync(Long ioSync) {
        this.ioSync = ioSync;
    }

    public Long getIoAsync() {
        return ioAsync;
    }

    public void setIoAsync(Long ioAsync) {
        this.ioAsync = ioAsync;
    }

    public Long getIoTotal() {
        return ioTotal;
    }

    public void setIoTotal(Long ioTotal) {
        this.ioTotal = ioTotal;
    }

    public Long getNetRxBytes() {
        return netRxBytes;
    }

    public void setNetRxBytes(Long netRxBytes) {
        this.netRxBytes = netRxBytes;
    }

    public Long getNetRxPackets() {
        return netRxPackets;
    }

    public void setNetRxPackets(Long netRxPackets) {
        this.netRxPackets = netRxPackets;
    }

    public Long getNetRxErros() {
        return netRxErros;
    }

    public void setNetRxErros(Long netRxErros) {
        this.netRxErros = netRxErros;
    }

    public Long getNetRxDrops() {
        return netRxDrops;
    }

    public void setNetRxDrops(Long netRxDrops) {
        this.netRxDrops = netRxDrops;
    }

    public Long getNetTxBytes() {
        return netTxBytes;
    }

    public void setNetTxBytes(Long netTxBytes) {
        this.netTxBytes = netTxBytes;
    }

    public Long getNetTxPackets() {
        return netTxPackets;
    }

    public void setNetTxPackets(Long netTxPackets) {
        this.netTxPackets = netTxPackets;
    }

    public Long getNetTxErros() {
        return netTxErros;
    }

    public void setNetTxErros(Long netTxErros) {
        this.netTxErros = netTxErros;
    }

    public Long getNetTxDrops() {
        return netTxDrops;
    }

    public void setNetTxDrops(Long netTxDrops) {
        this.netTxDrops = netTxDrops;
    }

    public static ContainerStats load(String jsonStr) throws ParseException, ReflectiveOperationException {
        ContainerStats containerStats = new ContainerStats();
        JSONPath jsonPath = JSONPath.newInstance(jsonStr);
        containerStats.setCpuTotal(new Long(jsonPath.value("/cpu_stats/system_cpu_usage", "-1").toString()));
        containerStats.setCpuUsage(new Long(jsonPath.value("/cpu_stats/cpu_usage/total_usage", "-1").toString()));

        List<Object> perCpuInfos = jsonPath.value("/cpu_stats/cpu_usage/percpu_usage", List.class,new ArrayList<Object>());
        for (Object perCpuInfo : perCpuInfos) {
            containerStats.perCpuUsage.add(new Long(perCpuInfo.toString()));
        }

        containerStats.setMemoryUsage(new Long(jsonPath.value("/memory_stats/usage", "-1").toString()));
        containerStats.setMemoryMaxUsage(new Long(jsonPath.value("/memory_stats/max_usage", "-1").toString()));
        containerStats.setMemoryMaxLimit(new Long(jsonPath.value("/memory_stats/limit", "-1").toString()));
        containerStats.setMemoryFailCnt(jsonPath.value("/memory_stats/failcnt", int.class,-1));


        containerStats.setNetRxBytes(new Long(jsonPath.value("/networks/eth0/rx_bytes", "-1").toString()));
        containerStats.setNetRxPackets(new Long(jsonPath.value("/networks/eth0/rx_packets", "-1").toString()));
        containerStats.setNetRxErros(new Long(jsonPath.value("/networks/eth0/rx_errors", "-1").toString()));
        containerStats.setNetRxDrops(new Long(jsonPath.value("/networks/eth0/rx_dropped", "-1").toString()));

        containerStats.setNetTxBytes(new Long(jsonPath.value("/networks/eth0/tx_bytes", "-1").toString()));
        containerStats.setNetTxPackets(new Long(jsonPath.value("/networks/eth0/tx_packets", "-1").toString()));
        containerStats.setNetTxErros(new Long(jsonPath.value("/networks/eth0/tx_errors", "-1").toString()));
        containerStats.setNetTxDrops(new Long(jsonPath.value("/networks/eth0/tx_dropped", "-1").toString()));

        List<Map<String, Object>> ioInfos = jsonPath.value("/blkio_stats/io_service_bytes_recursive", List.class);
        for (Map<String, Object> ioInfo : ioInfos) {
            if (ioInfo.get("op").equals("Read")) {
                containerStats.setIoRead(new Long(ioInfo.get("value").toString()));
            }

            if (ioInfo.get("op").equals("Write")) {

                containerStats.setIoWrite(new Long(ioInfo.get("value").toString()));
            }
            if (ioInfo.get("op").equals("Sync")) {

                containerStats.setIoSync(new Long(ioInfo.get("value").toString()));
            }
            if (ioInfo.get("op").equals("Async")) {

                containerStats.setIoAsync(new Long(ioInfo.get("value").toString()));
            }
            if (ioInfo.get("op").equals("Total")) {

                containerStats.setIoTotal(new Long(ioInfo.get("value").toString()));
            }
        }
        return containerStats;
    }
}
