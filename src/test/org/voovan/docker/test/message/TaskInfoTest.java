package org.voovan.docker.test.message;

import org.voovan.docker.message.Task.TaskInfo;
import org.voovan.tools.log.Logger;

import java.text.ParseException;
import java.util.List;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class TaskInfoTest {

    public static String tmp = "[\n" +
            "  {\n" +
            "    \"ID\": \"4iuz6bsidcx70f0btosiz0wlp\",\n" +
            "    \"Version\": {\n" +
            "      \"Index\": 108675\n" +
            "    },\n" +
            "    \"CreatedAt\": \"2016-10-25T07:29:26.408020891Z\",\n" +
            "    \"UpdatedAt\": \"2016-10-25T07:29:30.396907373Z\",\n" +
            "    \"Spec\": {\n" +
            "      \"ContainerSpec\": {\n" +
            "        \"Image\": \"alpine\",\n" +
            "        \"Args\": [\n" +
            "          \"ping\",\n" +
            "          \"127.0.0.1\"\n" +
            "        ],\n" +
            "        \"Mounts\": [\n" +
            "          {\n" +
            "            \"Type\": \"volume\",\n" +
            "            \"Source\": \"v_t1\",\n" +
            "            \"Target\": \"/v_t1\",\n" +
            "            \"ReadOnly\": true\n" +
            "          }\n" +
            "        ],\n" +
            "        \"StopGracePeriod\": 0\n" +
            "      },\n" +
            "      \"Resources\": {\n" +
            "        \"Limits\": {},\n" +
            "        \"Reservations\": {}\n" +
            "      },\n" +
            "      \"RestartPolicy\": {\n" +
            "        \"Condition\": \"on_failure\",\n" +
            "        \"Delay\": 0,\n" +
            "        \"MaxAttempts\": 0\n" +
            "      }\n" +
            "    },\n" +
            "    \"ServiceID\": \"2ssuzbg6tzfn96dxtes3lj4yw\",\n" +
            "    \"Slot\": 2,\n" +
            "    \"NodeID\": \"89hfls6kcbg5qnv6jzi35o86m\",\n" +
            "    \"Status\": {\n" +
            "      \"Timestamp\": \"2016-10-25T07:29:30.377674345Z\",\n" +
            "      \"State\": \"running\",\n" +
            "      \"Message\": \"started\",\n" +
            "      \"ContainerStatus\": {\n" +
            "        \"ContainerID\": \"79c88545bafdfc38ed2f84a17b24a534eb94f2881006330db40ad1f83939bd71\",\n" +
            "        \"PID\": 8320\n" +
            "      }\n" +
            "    },\n" +
            "    \"DesiredState\": \"running\",\n" +
            "    \"NetworksAttachments\": [\n" +
            "      {\n" +
            "        \"Network\": {\n" +
            "          \"ID\": \"chhjg6kzl8v9bc7x300v6axfl\",\n" +
            "          \"Version\": {\n" +
            "            \"Index\": 108607\n" +
            "          },\n" +
            "          \"CreatedAt\": \"2016-10-19T19:00:40.250017428Z\",\n" +
            "          \"UpdatedAt\": \"2016-10-21T08:20:03.797429382Z\",\n" +
            "          \"Spec\": {\n" +
            "            \"Name\": \"ingress\",\n" +
            "            \"Labels\": {\n" +
            "              \"com.docker.swarm.internal\": \"true\"\n" +
            "            },\n" +
            "            \"DriverConfiguration\": {},\n" +
            "            \"IPAMOptions\": {\n" +
            "              \"Driver\": {},\n" +
            "              \"Configs\": [\n" +
            "                {\n" +
            "                  \"Subnet\": \"10.255.0.0/16\",\n" +
            "                  \"Gateway\": \"10.255.0.1\"\n" +
            "                }\n" +
            "              ]\n" +
            "            }\n" +
            "          },\n" +
            "          \"DriverState\": {\n" +
            "            \"Name\": \"overlay\",\n" +
            "            \"Options\": {\n" +
            "              \"com.docker.network.driver.overlay.vxlanid_list\": \"256\"\n" +
            "            }\n" +
            "          },\n" +
            "          \"IPAMOptions\": {\n" +
            "            \"Driver\": {\n" +
            "              \"Name\": \"default\"\n" +
            "            },\n" +
            "            \"Configs\": [\n" +
            "              {\n" +
            "                \"Subnet\": \"10.255.0.0/16\",\n" +
            "                \"Gateway\": \"10.255.0.1\"\n" +
            "              }\n" +
            "            ]\n" +
            "          }\n" +
            "        },\n" +
            "        \"Addresses\": [\n" +
            "          \"10.255.0.6/16\"\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"Network\": {\n" +
            "          \"ID\": \"89x15fcp9x08ncc885xwn0e9e\",\n" +
            "          \"Version\": {\n" +
            "            \"Index\": 108608\n" +
            "          },\n" +
            "          \"CreatedAt\": \"2016-10-20T13:25:37.163144635Z\",\n" +
            "          \"UpdatedAt\": \"2016-10-21T08:20:03.808611829Z\",\n" +
            "          \"Spec\": {\n" +
            "            \"Name\": \"voovan\",\n" +
            "            \"DriverConfiguration\": {\n" +
            "              \"Name\": \"overlay\"\n" +
            "            },\n" +
            "            \"IPAMOptions\": {\n" +
            "              \"Driver\": {\n" +
            "                \"Name\": \"default\"\n" +
            "              }\n" +
            "            }\n" +
            "          },\n" +
            "          \"DriverState\": {\n" +
            "            \"Name\": \"overlay\",\n" +
            "            \"Options\": {\n" +
            "              \"com.docker.network.driver.overlay.vxlanid_list\": \"257\"\n" +
            "            }\n" +
            "          },\n" +
            "          \"IPAMOptions\": {\n" +
            "            \"Driver\": {\n" +
            "              \"Name\": \"default\"\n" +
            "            },\n" +
            "            \"Configs\": [\n" +
            "              {\n" +
            "                \"Subnet\": \"10.0.0.0/24\",\n" +
            "                \"Gateway\": \"10.0.0.1\"\n" +
            "              }\n" +
            "            ]\n" +
            "          }\n" +
            "        },\n" +
            "        \"Addresses\": [\n" +
            "          \"10.0.0.5/24\"\n" +
            "        ]\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"ID\": \"9g9tntvitmspvg9r206n4jal9\",\n" +
            "    \"Version\": {\n" +
            "      \"Index\": 108665\n" +
            "    },\n" +
            "    \"CreatedAt\": \"2016-10-25T07:22:24.959650478Z\",\n" +
            "    \"UpdatedAt\": \"2016-10-25T07:22:29.419054007Z\",\n" +
            "    \"Spec\": {\n" +
            "      \"ContainerSpec\": {\n" +
            "        \"Image\": \"alpine\",\n" +
            "        \"Args\": [\n" +
            "          \"ping\",\n" +
            "          \"127.0.0.1\"\n" +
            "        ],\n" +
            "        \"Mounts\": [\n" +
            "          {\n" +
            "            \"Type\": \"volume\",\n" +
            "            \"Source\": \"v_t1\",\n" +
            "            \"Target\": \"/v_t1\",\n" +
            "            \"ReadOnly\": true\n" +
            "          }\n" +
            "        ],\n" +
            "        \"StopGracePeriod\": 0\n" +
            "      },\n" +
            "      \"Resources\": {\n" +
            "        \"Limits\": {},\n" +
            "        \"Reservations\": {}\n" +
            "      },\n" +
            "      \"RestartPolicy\": {\n" +
            "        \"Condition\": \"on_failure\",\n" +
            "        \"Delay\": 0,\n" +
            "        \"MaxAttempts\": 0\n" +
            "      }\n" +
            "    },\n" +
            "    \"ServiceID\": \"2ssuzbg6tzfn96dxtes3lj4yw\",\n" +
            "    \"Slot\": 1,\n" +
            "    \"NodeID\": \"89hfls6kcbg5qnv6jzi35o86m\",\n" +
            "    \"Status\": {\n" +
            "      \"Timestamp\": \"2016-10-25T07:22:29.407877044Z\",\n" +
            "      \"State\": \"running\",\n" +
            "      \"Message\": \"started\",\n" +
            "      \"ContainerStatus\": {\n" +
            "        \"ContainerID\": \"493c9d60badb07048b5fabe18078970cebf480ba80cca7326fef141e6f9d6111\",\n" +
            "        \"PID\": 8181\n" +
            "      }\n" +
            "    },\n" +
            "    \"DesiredState\": \"running\",\n" +
            "    \"NetworksAttachments\": [\n" +
            "      {\n" +
            "        \"Network\": {\n" +
            "          \"ID\": \"chhjg6kzl8v9bc7x300v6axfl\",\n" +
            "          \"Version\": {\n" +
            "            \"Index\": 108607\n" +
            "          },\n" +
            "          \"CreatedAt\": \"2016-10-19T19:00:40.250017428Z\",\n" +
            "          \"UpdatedAt\": \"2016-10-21T08:20:03.797429382Z\",\n" +
            "          \"Spec\": {\n" +
            "            \"Name\": \"ingress\",\n" +
            "            \"Labels\": {\n" +
            "              \"com.docker.swarm.internal\": \"true\"\n" +
            "            },\n" +
            "            \"DriverConfiguration\": {},\n" +
            "            \"IPAMOptions\": {\n" +
            "              \"Driver\": {},\n" +
            "              \"Configs\": [\n" +
            "                {\n" +
            "                  \"Subnet\": \"10.255.0.0/16\",\n" +
            "                  \"Gateway\": \"10.255.0.1\"\n" +
            "                }\n" +
            "              ]\n" +
            "            }\n" +
            "          },\n" +
            "          \"DriverState\": {\n" +
            "            \"Name\": \"overlay\",\n" +
            "            \"Options\": {\n" +
            "              \"com.docker.network.driver.overlay.vxlanid_list\": \"256\"\n" +
            "            }\n" +
            "          },\n" +
            "          \"IPAMOptions\": {\n" +
            "            \"Driver\": {\n" +
            "              \"Name\": \"default\"\n" +
            "            },\n" +
            "            \"Configs\": [\n" +
            "              {\n" +
            "                \"Subnet\": \"10.255.0.0/16\",\n" +
            "                \"Gateway\": \"10.255.0.1\"\n" +
            "              }\n" +
            "            ]\n" +
            "          }\n" +
            "        },\n" +
            "        \"Addresses\": [\n" +
            "          \"10.255.0.5/16\"\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"Network\": {\n" +
            "          \"ID\": \"89x15fcp9x08ncc885xwn0e9e\",\n" +
            "          \"Version\": {\n" +
            "            \"Index\": 108608\n" +
            "          },\n" +
            "          \"CreatedAt\": \"2016-10-20T13:25:37.163144635Z\",\n" +
            "          \"UpdatedAt\": \"2016-10-21T08:20:03.808611829Z\",\n" +
            "          \"Spec\": {\n" +
            "            \"Name\": \"voovan\",\n" +
            "            \"DriverConfiguration\": {\n" +
            "              \"Name\": \"overlay\"\n" +
            "            },\n" +
            "            \"IPAMOptions\": {\n" +
            "              \"Driver\": {\n" +
            "                \"Name\": \"default\"\n" +
            "              }\n" +
            "            }\n" +
            "          },\n" +
            "          \"DriverState\": {\n" +
            "            \"Name\": \"overlay\",\n" +
            "            \"Options\": {\n" +
            "              \"com.docker.network.driver.overlay.vxlanid_list\": \"257\"\n" +
            "            }\n" +
            "          },\n" +
            "          \"IPAMOptions\": {\n" +
            "            \"Driver\": {\n" +
            "              \"Name\": \"default\"\n" +
            "            },\n" +
            "            \"Configs\": [\n" +
            "              {\n" +
            "                \"Subnet\": \"10.0.0.0/24\",\n" +
            "                \"Gateway\": \"10.0.0.1\"\n" +
            "              }\n" +
            "            ]\n" +
            "          }\n" +
            "        },\n" +
            "        \"Addresses\": [\n" +
            "          \"10.0.0.4/24\"\n" +
            "        ]\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"ID\": \"cb3rbntlh3cap0dne4ll09y36\",\n" +
            "    \"Version\": {\n" +
            "      \"Index\": 108674\n" +
            "    },\n" +
            "    \"CreatedAt\": \"2016-10-25T07:29:26.408290988Z\",\n" +
            "    \"UpdatedAt\": \"2016-10-25T07:29:30.277608184Z\",\n" +
            "    \"Spec\": {\n" +
            "      \"ContainerSpec\": {\n" +
            "        \"Image\": \"alpine\",\n" +
            "        \"Args\": [\n" +
            "          \"ping\",\n" +
            "          \"127.0.0.1\"\n" +
            "        ],\n" +
            "        \"Mounts\": [\n" +
            "          {\n" +
            "            \"Type\": \"volume\",\n" +
            "            \"Source\": \"v_t1\",\n" +
            "            \"Target\": \"/v_t1\",\n" +
            "            \"ReadOnly\": true\n" +
            "          }\n" +
            "        ],\n" +
            "        \"StopGracePeriod\": 0\n" +
            "      },\n" +
            "      \"Resources\": {\n" +
            "        \"Limits\": {},\n" +
            "        \"Reservations\": {}\n" +
            "      },\n" +
            "      \"RestartPolicy\": {\n" +
            "        \"Condition\": \"on_failure\",\n" +
            "        \"Delay\": 0,\n" +
            "        \"MaxAttempts\": 0\n" +
            "      }\n" +
            "    },\n" +
            "    \"ServiceID\": \"2ssuzbg6tzfn96dxtes3lj4yw\",\n" +
            "    \"Slot\": 3,\n" +
            "    \"NodeID\": \"89hfls6kcbg5qnv6jzi35o86m\",\n" +
            "    \"Status\": {\n" +
            "      \"Timestamp\": \"2016-10-25T07:29:30.274743897Z\",\n" +
            "      \"State\": \"running\",\n" +
            "      \"Message\": \"started\",\n" +
            "      \"ContainerStatus\": {\n" +
            "        \"ContainerID\": \"b2889477c9a10e0978bc6746b5c6070a83ab032a1fd3b045709c0286b1613b74\",\n" +
            "        \"PID\": 8329\n" +
            "      }\n" +
            "    },\n" +
            "    \"DesiredState\": \"running\",\n" +
            "    \"NetworksAttachments\": [\n" +
            "      {\n" +
            "        \"Network\": {\n" +
            "          \"ID\": \"chhjg6kzl8v9bc7x300v6axfl\",\n" +
            "          \"Version\": {\n" +
            "            \"Index\": 108607\n" +
            "          },\n" +
            "          \"CreatedAt\": \"2016-10-19T19:00:40.250017428Z\",\n" +
            "          \"UpdatedAt\": \"2016-10-21T08:20:03.797429382Z\",\n" +
            "          \"Spec\": {\n" +
            "            \"Name\": \"ingress\",\n" +
            "            \"Labels\": {\n" +
            "              \"com.docker.swarm.internal\": \"true\"\n" +
            "            },\n" +
            "            \"DriverConfiguration\": {},\n" +
            "            \"IPAMOptions\": {\n" +
            "              \"Driver\": {},\n" +
            "              \"Configs\": [\n" +
            "                {\n" +
            "                  \"Subnet\": \"10.255.0.0/16\",\n" +
            "                  \"Gateway\": \"10.255.0.1\"\n" +
            "                }\n" +
            "              ]\n" +
            "            }\n" +
            "          },\n" +
            "          \"DriverState\": {\n" +
            "            \"Name\": \"overlay\",\n" +
            "            \"Options\": {\n" +
            "              \"com.docker.network.driver.overlay.vxlanid_list\": \"256\"\n" +
            "            }\n" +
            "          },\n" +
            "          \"IPAMOptions\": {\n" +
            "            \"Driver\": {\n" +
            "              \"Name\": \"default\"\n" +
            "            },\n" +
            "            \"Configs\": [\n" +
            "              {\n" +
            "                \"Subnet\": \"10.255.0.0/16\",\n" +
            "                \"Gateway\": \"10.255.0.1\"\n" +
            "              }\n" +
            "            ]\n" +
            "          }\n" +
            "        },\n" +
            "        \"Addresses\": [\n" +
            "          \"10.255.0.7/16\"\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"Network\": {\n" +
            "          \"ID\": \"89x15fcp9x08ncc885xwn0e9e\",\n" +
            "          \"Version\": {\n" +
            "            \"Index\": 108608\n" +
            "          },\n" +
            "          \"CreatedAt\": \"2016-10-20T13:25:37.163144635Z\",\n" +
            "          \"UpdatedAt\": \"2016-10-21T08:20:03.808611829Z\",\n" +
            "          \"Spec\": {\n" +
            "            \"Name\": \"voovan\",\n" +
            "            \"DriverConfiguration\": {\n" +
            "              \"Name\": \"overlay\"\n" +
            "            },\n" +
            "            \"IPAMOptions\": {\n" +
            "              \"Driver\": {\n" +
            "                \"Name\": \"default\"\n" +
            "              }\n" +
            "            }\n" +
            "          },\n" +
            "          \"DriverState\": {\n" +
            "            \"Name\": \"overlay\",\n" +
            "            \"Options\": {\n" +
            "              \"com.docker.network.driver.overlay.vxlanid_list\": \"257\"\n" +
            "            }\n" +
            "          },\n" +
            "          \"IPAMOptions\": {\n" +
            "            \"Driver\": {\n" +
            "              \"Name\": \"default\"\n" +
            "            },\n" +
            "            \"Configs\": [\n" +
            "              {\n" +
            "                \"Subnet\": \"10.0.0.0/24\",\n" +
            "                \"Gateway\": \"10.0.0.1\"\n" +
            "              }\n" +
            "            ]\n" +
            "          }\n" +
            "        },\n" +
            "        \"Addresses\": [\n" +
            "          \"10.0.0.6/24\"\n" +
            "        ]\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "]";

    public static void main(String[] args) throws ParseException, ReflectiveOperationException {
        List<TaskInfo> taskInfos = TaskInfo.load(tmp);

        Logger.simple("----");

    }
}
