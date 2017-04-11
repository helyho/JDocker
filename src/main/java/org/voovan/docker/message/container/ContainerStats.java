package org.voovan.docker.message.container;

import org.voovan.docker.message.container.atom.NetStats;
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
    private Map<String, NetStats> network;


    public ContainerStats() {
        perCpuUsage = new ArrayList<Long>();
        network = new HashMap<String,NetStats>();
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

    public Map<String, NetStats> getNetwork() {
        return network;
    }

    public void setNetwork(Map<String, NetStats> network) {
        this.network = network;
    }

    public static ContainerStats load(String jsonStr) throws ParseException, ReflectiveOperationException {
        ContainerStats containerStats = new ContainerStats();
        JSONPath jsonPath = JSONPath.newInstance(jsonStr);
        containerStats.setCpuTotal(new Long(jsonPath.value("/cpu_stats/system_cpu_usage").toString()));
        containerStats.setCpuUsage(new Long(jsonPath.value("/cpu_stats/cpu_usage/total_usage").toString()));

        List<Object> perCpuInfos = jsonPath.value("/cpu_stats/cpu_usage/percpu_usage", List.class,new ArrayList<Object>());
        for (Object perCpuInfo : perCpuInfos) {
            containerStats.perCpuUsage.add(new Long(perCpuInfo.toString()));
        }

        containerStats.setMemoryUsage(new Long(jsonPath.value("/memory_stats/usage").toString()));
        containerStats.setMemoryMaxUsage(new Long(jsonPath.value("/memory_stats/max_usage").toString()));
        containerStats.setMemoryMaxLimit(new Long(jsonPath.value("/memory_stats/limit").toString()));
        containerStats.setMemoryFailCnt(jsonPath.value("/memory_stats/failcnt", int.class,-1));

        Map<String, Map<String,Object>> networkInfoMap = jsonPath.value("/networks", Map.class,
                new HashMap<String, Map<String,Object>>());

        for(Map.Entry<String, Map<String,Object>> networkInfo : networkInfoMap.entrySet()){
            NetStats netStats = new NetStats();
            netStats.setNetRxBytes(Long.valueOf(networkInfo.getValue().get("rx_bytes").toString()));
            netStats.setNetRxPackets(Long.valueOf(networkInfo.getValue().get("rx_packets").toString()));
            netStats.setNetRxErros(Long.valueOf(networkInfo.getValue().get("rx_errors").toString()));
            netStats.setNetRxDrops(Long.valueOf(networkInfo.getValue().get("rx_dropped").toString()));

            netStats.setNetTxBytes(Long.valueOf(networkInfo.getValue().get("tx_bytes").toString()));
            netStats.setNetTxPackets(Long.valueOf(networkInfo.getValue().get("tx_packets").toString()));
            netStats.setNetTxErros(Long.valueOf(networkInfo.getValue().get("tx_errors").toString()));
            netStats.setNetTxDrops(Long.valueOf(networkInfo.getValue().get("tx_dropped").toString()));
            containerStats.getNetwork().put(networkInfo.getKey(), netStats);
        }
        networkInfoMap.clear();

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
