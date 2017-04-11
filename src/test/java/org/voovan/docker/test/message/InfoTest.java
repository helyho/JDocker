package org.voovan.docker.test.message;

import org.voovan.docker.message.info.Info;

import java.text.ParseException;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class InfoTest {
    public static String tmp = "{\n" +
            "  \"ID\": \"RACW:ALXL:IL5A:CX2T:USD4:24I3:EWJU:5ZAS:BSCY:7VKB:KO7A:ZLQN\",\n" +
            "  \"Containers\": 5,\n" +
            "  \"ContainersRunning\": 2,\n" +
            "  \"ContainersPaused\": 0,\n" +
            "  \"ContainersStopped\": 3,\n" +
            "  \"Images\": 8,\n" +
            "  \"Driver\": \"aufs\",\n" +
            "  \"DriverStatus\": [\n" +
            "    [\n" +
            "      \"Root Dir\",\n" +
            "      \"/var/lib/docker/aufs\"\n" +
            "    ],\n" +
            "    [\n" +
            "      \"Backing Filesystem\",\n" +
            "      \"extfs\"\n" +
            "    ],\n" +
            "    [\n" +
            "      \"Dirs\",\n" +
            "      \"15\"\n" +
            "    ],\n" +
            "    [\n" +
            "      \"Dirperm1 Supported\",\n" +
            "      \"true\"\n" +
            "    ]\n" +
            "  ],\n" +
            "  \"SystemStatus\": null,\n" +
            "  \"Plugins\": {\n" +
            "    \"Volume\": [\n" +
            "      \"local\"\n" +
            "    ],\n" +
            "    \"Network\": [\n" +
            "      \"host\",\n" +
            "      \"bridge\",\n" +
            "      \"null\",\n" +
            "      \"overlay\"\n" +
            "    ],\n" +
            "    \"Authorization\": null\n" +
            "  },\n" +
            "  \"MemoryLimit\": true,\n" +
            "  \"SwapLimit\": true,\n" +
            "  \"KernelMemory\": false,\n" +
            "  \"CpuCfsPeriod\": true,\n" +
            "  \"CpuCfsQuota\": true,\n" +
            "  \"CPUShares\": true,\n" +
            "  \"CPUSet\": true,\n" +
            "  \"IPv4Forwarding\": true,\n" +
            "  \"BridgeNfIptables\": true,\n" +
            "  \"BridgeNfIp6tables\": true,\n" +
            "  \"Debug\": true,\n" +
            "  \"NFd\": 52,\n" +
            "  \"OomKillDisable\": true,\n" +
            "  \"NGoroutines\": 142,\n" +
            "  \"SystemTime\": \"2017-01-03T08:42:14.634412787Z\",\n" +
            "  \"ExecutionDriver\": \"\",\n" +
            "  \"LoggingDriver\": \"json-file\",\n" +
            "  \"CgroupDriver\": \"cgroupfs\",\n" +
            "  \"NEventsListener\": 2,\n" +
            "  \"KernelVersion\": \"4.4.39-moby\",\n" +
            "  \"OperatingSystem\": \"Alpine Linux v3.4\",\n" +
            "  \"OSType\": \"linux\",\n" +
            "  \"Architecture\": \"x86_64\",\n" +
            "  \"IndexServerAddress\": \"https://index.docker.io/v1/\",\n" +
            "  \"RegistryConfig\": {\n" +
            "    \"InsecureRegistryCIDRs\": [\n" +
            "      \"127.0.0.0/8\"\n" +
            "    ],\n" +
            "    \"IndexConfigs\": {\n" +
            "      \"docker.io\": {\n" +
            "        \"Name\": \"docker.io\",\n" +
            "        \"Mirrors\": [\n" +
            "          \"https://d7msktio.mirror.aliyuncs.com\"\n" +
            "        ],\n" +
            "        \"Secure\": true,\n" +
            "        \"Official\": true\n" +
            "      }\n" +
            "    },\n" +
            "    \"Mirrors\": [\n" +
            "      \"https://d7msktio.mirror.aliyuncs.com\"\n" +
            "    ]\n" +
            "  },\n" +
            "  \"NCPU\": 2,\n" +
            "  \"MemTotal\": 2094940160,\n" +
            "  \"DockerRootDir\": \"/var/lib/docker\",\n" +
            "  \"HttpProxy\": \"\",\n" +
            "  \"HttpsProxy\": \"\",\n" +
            "  \"NoProxy\": \"\",\n" +
            "  \"Name\": \"moby\",\n" +
            "  \"Labels\": null,\n" +
            "  \"ExperimentalBuild\": false,\n" +
            "  \"ServerVersion\": \"1.12.5\",\n" +
            "  \"ClusterStore\": \"\",\n" +
            "  \"ClusterAdvertise\": \"\",\n" +
            "  \"SecurityOptions\": [\n" +
            "    \"seccomp\"\n" +
            "  ],\n" +
            "  \"Runtimes\": {\n" +
            "    \"runc\": {\n" +
            "      \"path\": \"docker-runc\"\n" +
            "    }\n" +
            "  },\n" +
            "  \"DefaultRuntime\": \"runc\",\n" +
            "  \"Swarm\": {\n" +
            "    \"NodeID\": \"3q37bk0p5wasmnqluugqfokow\",\n" +
            "    \"NodeAddr\": \"192.168.65.2\",\n" +
            "    \"LocalNodeState\": \"active\",\n" +
            "    \"ControlAvailable\": true,\n" +
            "    \"Error\": \"\",\n" +
            "    \"RemoteManagers\": [\n" +
            "      {\n" +
            "        \"NodeID\": \"3q37bk0p5wasmnqluugqfokow\",\n" +
            "        \"Addr\": \"192.168.65.2:2377\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"Nodes\": 1,\n" +
            "    \"Managers\": 1,\n" +
            "    \"Cluster\": {\n" +
            "      \"ID\": \"3n9m1065k4dybar6or5z4zkib\",\n" +
            "      \"Version\": {\n" +
            "        \"Index\": 151\n" +
            "      },\n" +
            "      \"CreatedAt\": \"2016-12-29T11:16:28.213689533Z\",\n" +
            "      \"UpdatedAt\": \"2017-01-03T08:28:48.075088967Z\",\n" +
            "      \"Spec\": {\n" +
            "        \"Name\": \"default\",\n" +
            "        \"Orchestration\": {\n" +
            "          \"TaskHistoryRetentionLimit\": 5\n" +
            "        },\n" +
            "        \"Raft\": {\n" +
            "          \"SnapshotInterval\": 10000,\n" +
            "          \"LogEntriesForSlowFollowers\": 500,\n" +
            "          \"HeartbeatTick\": 1,\n" +
            "          \"ElectionTick\": 3\n" +
            "        },\n" +
            "        \"Dispatcher\": {\n" +
            "          \"HeartbeatPeriod\": 5000000000\n" +
            "        },\n" +
            "        \"CAConfig\": {\n" +
            "          \"NodeCertExpiry\": 7776000000000000\n" +
            "        },\n" +
            "        \"TaskDefaults\": {}\n" +
            "      }\n" +
            "    }\n" +
            "  },\n" +
            "  \"LiveRestoreEnabled\": false\n" +
            "}";

    public static void main(String[] args) throws ParseException, ReflectiveOperationException {
        Info.load(tmp);
    }
}
