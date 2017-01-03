package org.voovan.docker.message.info;

import org.voovan.docker.message.info.atom.Plugins;
import org.voovan.docker.message.info.atom.Swarm;
import org.voovan.docker.message.swarm.SwarmInfo;
import org.voovan.tools.json.JSON;
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
    private List<String> securityOptions;

    private Plugins plugins;
    private Swarm swarm;

    public Info(){
        securityOptions = new ArrayList<String>();
        plugins = new Plugins();
        swarm = new Swarm();
    }

    public static Info load(String jsonStr) throws ParseException, ReflectiveOperationException {
        JSONPath jsonPath = JSONPath.newInstance(jsonStr);

        Info info = JSON.toObject(jsonStr, Info.class, true);
        return info;
    }
}
