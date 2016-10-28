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
    private long cpuTotal;
    private long cpuUsage;
    private List<Long> perCpuUsage;
    private long memoryUsage;
    private long memoryMasUsage;
    private long memoryMasLimit;
    private int memoryFailCnt;
    private long ioRead;
    private long ioWrite;
    private long ioSync;
    private long ioAsync;
    private long ioTotal;
    private long netRxBytes;
    private long netRxPackets;
    private long netRxErros;
    private long netRxDrops;
    private long netTxBytes;
    private long netTxPackets;
    private long netTxErros;
    private long netTxDrops;

    public ContainerStats() {
        perCpuUsage = new ArrayList<Long>();
    }

    public long getCpuTotal() {
        return cpuTotal;
    }

    public void setCpuTotal(long cpuTotal) {
        this.cpuTotal = cpuTotal;
    }

    public long getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(long cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public List<Long> getPerCpuUsage() {
        return perCpuUsage;
    }

    public void setPerCpuUsage(List<Long> perCpuUsage) {
        this.perCpuUsage = perCpuUsage;
    }

    public long getMemoryUsage() {
        return memoryUsage;
    }

    public void setMemoryUsage(long memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    public long getMemoryMasUsage() {
        return memoryMasUsage;
    }

    public void setMemoryMasUsage(long memoryMasUsage) {
        this.memoryMasUsage = memoryMasUsage;
    }

    public long getMemoryMasLimit() {
        return memoryMasLimit;
    }

    public void setMemoryMasLimit(long memoryMasLimit) {
        this.memoryMasLimit = memoryMasLimit;
    }

    public int getMemoryFailCnt() {
        return memoryFailCnt;
    }

    public void setMemoryFailCnt(int memoryFailCnt) {
        this.memoryFailCnt = memoryFailCnt;
    }

    public long getIoRead() {
        return ioRead;
    }

    public void setIoRead(long ioRead) {
        this.ioRead = ioRead;
    }

    public long getIoWrite() {
        return ioWrite;
    }

    public void setIoWrite(long ioWrite) {
        this.ioWrite = ioWrite;
    }

    public long getIoSync() {
        return ioSync;
    }

    public void setIoSync(long ioSync) {
        this.ioSync = ioSync;
    }

    public long getIoAsync() {
        return ioAsync;
    }

    public void setIoAsync(long ioAsync) {
        this.ioAsync = ioAsync;
    }

    public long getIoTotal() {
        return ioTotal;
    }

    public void setIoTotal(long ioTotal) {
        this.ioTotal = ioTotal;
    }

    public long getNetRxBytes() {
        return netRxBytes;
    }

    public void setNetRxBytes(long netRxBytes) {
        this.netRxBytes = netRxBytes;
    }

    public long getNetRxPackets() {
        return netRxPackets;
    }

    public void setNetRxPackets(long netRxPackets) {
        this.netRxPackets = netRxPackets;
    }

    public long getNetRxErros() {
        return netRxErros;
    }

    public void setNetRxErros(long netRxErros) {
        this.netRxErros = netRxErros;
    }

    public long getNetRxDrops() {
        return netRxDrops;
    }

    public void setNetRxDrops(long netRxDrops) {
        this.netRxDrops = netRxDrops;
    }

    public long getNetTxBytes() {
        return netTxBytes;
    }

    public void setNetTxBytes(long netTxBytes) {
        this.netTxBytes = netTxBytes;
    }

    public long getNetTxPackets() {
        return netTxPackets;
    }

    public void setNetTxPackets(long netTxPackets) {
        this.netTxPackets = netTxPackets;
    }

    public long getNetTxErros() {
        return netTxErros;
    }

    public void setNetTxErros(long netTxErros) {
        this.netTxErros = netTxErros;
    }

    public long getNetTxDrops() {
        return netTxDrops;
    }

    public void setNetTxDrops(long netTxDrops) {
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
        containerStats.setMemoryMasUsage(new Long(jsonPath.value("/memory_stats/max_usage", "-1").toString()));
        containerStats.setMemoryMasLimit(new Long(jsonPath.value("/memory_stats/limit", "-1").toString()));
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
