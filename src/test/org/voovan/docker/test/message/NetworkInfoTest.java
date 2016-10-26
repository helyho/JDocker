package org.voovan.docker.test.message;

import org.voovan.docker.message.container.ContainerChange;
import org.voovan.docker.message.container.atom.ChangeItem;
import org.voovan.docker.message.network.NetworkInfo;
import org.voovan.tools.log.Logger;

import java.text.ParseException;
import java.util.List;


/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         DockerFly Framework.
 *         WebSite: https://github.com/helyho/DockerFly
 *         Licence: Apache v2 License
 */
public class NetworkInfoTest {

    public static String tmp = "[\n" +
            "  {\n" +
            "    \"Name\": \"voovan\",\n" +
            "    \"Id\": \"29s05n4xjjacao9kespdzg7ri\",\n" +
            "    \"Scope\": \"swarm\",\n" +
            "    \"Driver\": \"overlay\",\n" +
            "    \"EnableIPv6\": false,\n" +
            "    \"IPAM\": {\n" +
            "      \"Driver\": \"default\",\n" +
            "      \"Options\": null,\n" +
            "      \"Config\": [\n" +
            "        {\n" +
            "          \"Subnet\": \"172.20.0.0/16\",\n" +
            "          \"IPRange\": \"172.20.10.0/24\",\n" +
            "          \"Gateway\": \"172.20.10.11\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    \"Internal\": false,\n" +
            "    \"Containers\": null,\n" +
            "    \"Options\": {\n" +
            "      \"com.docker.network.driver.overlay.vxlanid_list\": \"257\"\n" +
            "    },\n" +
            "    \"Labels\": {\n" +
            "      \"Author\": \"helyho\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"ingress\",\n" +
            "    \"Id\": \"chhjg6kzl8v9bc7x300v6axfl\",\n" +
            "    \"Scope\": \"swarm\",\n" +
            "    \"Driver\": \"overlay\",\n" +
            "    \"EnableIPv6\": false,\n" +
            "    \"IPAM\": {\n" +
            "      \"Driver\": \"\",\n" +
            "      \"Options\": null,\n" +
            "      \"Config\": [\n" +
            "        {\n" +
            "          \"Subnet\": \"10.255.0.0/16\",\n" +
            "          \"Gateway\": \"10.255.0.1\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    \"Internal\": false,\n" +
            "    \"Containers\": null,\n" +
            "    \"Options\": {\n" +
            "      \"com.docker.network.driver.overlay.vxlanid_list\": \"256\"\n" +
            "    },\n" +
            "    \"Labels\": {\n" +
            "      \"com.docker.swarm.internal\": \"true\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"bridge\",\n" +
            "    \"Id\": \"174672d6eb3157f937890cb7a80702cf2141a6935e9336e0e43cf53519fb560c\",\n" +
            "    \"Scope\": \"local\",\n" +
            "    \"Driver\": \"bridge\",\n" +
            "    \"EnableIPv6\": false,\n" +
            "    \"IPAM\": {\n" +
            "      \"Driver\": \"default\",\n" +
            "      \"Options\": null,\n" +
            "      \"Config\": [\n" +
            "        {\n" +
            "          \"Subnet\": \"172.17.0.0/16\",\n" +
            "          \"Gateway\": \"172.17.0.1\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    \"Internal\": false,\n" +
            "    \"Containers\": {\n" +
            "      \"10d02414dc9daa1053cd6cec347b5d0575e9cc3a15282835ac9e57e488074c13\": {\n" +
            "        \"Name\": \"reverent_mclean\",\n" +
            "        \"EndpointID\": \"f590a4929f6037b3c9e7b3c35772f293400c3451014a510a6a936ca4b2445d87\",\n" +
            "        \"MacAddress\": \"02:42:ac:11:00:03\",\n" +
            "        \"IPv4Address\": \"172.17.0.3/16\",\n" +
            "        \"IPv6Address\": \"\"\n" +
            "      },\n" +
            "      \"218a3df24831ee65786f402c1ae124624437664d7d4298579b280fdc43d98522\": {\n" +
            "        \"Name\": \"dockerfly\",\n" +
            "        \"EndpointID\": \"82f8f845859bf99860a62207201452c6c4fd62c525b3bdeaeae003922e2dde4e\",\n" +
            "        \"MacAddress\": \"02:42:ac:11:00:02\",\n" +
            "        \"IPv4Address\": \"172.17.0.2/16\",\n" +
            "        \"IPv6Address\": \"\"\n" +
            "      }\n" +
            "    },\n" +
            "    \"Options\": {\n" +
            "      \"com.docker.network.bridge.default_bridge\": \"true\",\n" +
            "      \"com.docker.network.bridge.enable_icc\": \"true\",\n" +
            "      \"com.docker.network.bridge.enable_ip_masquerade\": \"true\",\n" +
            "      \"com.docker.network.bridge.host_binding_ipv4\": \"0.0.0.0\",\n" +
            "      \"com.docker.network.bridge.name\": \"docker0\",\n" +
            "      \"com.docker.network.driver.mtu\": \"1500\"\n" +
            "    },\n" +
            "    \"Labels\": {}\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"host\",\n" +
            "    \"Id\": \"7bbe633054c647e10429872c8c597b9a7b75dd72ab142ed7555c9e6e72102d80\",\n" +
            "    \"Scope\": \"local\",\n" +
            "    \"Driver\": \"host\",\n" +
            "    \"EnableIPv6\": false,\n" +
            "    \"IPAM\": {\n" +
            "      \"Driver\": \"default\",\n" +
            "      \"Options\": null,\n" +
            "      \"Config\": []\n" +
            "    },\n" +
            "    \"Internal\": false,\n" +
            "    \"Containers\": {},\n" +
            "    \"Options\": {},\n" +
            "    \"Labels\": {}\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"none\",\n" +
            "    \"Id\": \"d363c43d758994896ecf791ad623d2ad5fffb513511bcd0a14767976aa6b22a7\",\n" +
            "    \"Scope\": \"local\",\n" +
            "    \"Driver\": \"null\",\n" +
            "    \"EnableIPv6\": false,\n" +
            "    \"IPAM\": {\n" +
            "      \"Driver\": \"default\",\n" +
            "      \"Options\": null,\n" +
            "      \"Config\": []\n" +
            "    },\n" +
            "    \"Internal\": false,\n" +
            "    \"Containers\": {},\n" +
            "    \"Options\": {},\n" +
            "    \"Labels\": {}\n" +
            "  },\n" +
            "{\n" +
            "    \"Name\": \"voovan_xxxx\",\n" +
            "    \"Id\": \"3gw3wvz2hskaott9gweixjwmr\",\n" +
            "    \"Scope\": \"swarm\",\n" +
            "    \"Driver\": \"overlay\",\n" +
            "    \"EnableIPv6\": false,\n" +
            "    \"IPAM\": {\n" +
            "      \"Driver\": \"default\",\n" +
            "      \"Options\": {\n" +
            "        \"adfasdf\": \"asdfadfaf\"\n" +
            "      },\n" +
            "      \"Config\": [\n" +
            "        {\n" +
            "          \"Subnet\": \"172.20.0.0/16\",\n" +
            "          \"IPRange\": \"172.20.10.0/24\",\n" +
            "          \"Gateway\": \"172.20.10.11\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    \"Internal\": false,\n" +
            "    \"Containers\": null,\n" +
            "    \"Options\": {\n" +
            "      \"com.docker.network.driver.overlay.vxlanid_list\": \"258\"\n" +
            "    },\n" +
            "    \"Labels\": {\n" +
            "      \"Author\": \"helyho\"\n" +
            "    }\n" +
            "  },"+
            "  {\n" +
            "    \"Name\": \"docker_gwbridge\",\n" +
            "    \"Id\": \"e96af0a01963ae331daefc419a40b85e44e0fb4def714fb4c48b81b662608bdd\",\n" +
            "    \"Scope\": \"local\",\n" +
            "    \"Driver\": \"bridge\",\n" +
            "    \"EnableIPv6\": false,\n" +
            "    \"IPAM\": {\n" +
            "      \"Driver\": \"default\",\n" +
            "      \"Options\": {\"adfasdfa\":\"adfasdfasdf\"},\n" +
            "      \"Config\": [\n" +
            "        {\n" +
            "          \"Subnet\": \"172.19.0.0/16\",\n" +
            "          \"Gateway\": \"172.19.0.1\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    \"Internal\": false,\n" +
            "    \"Containers\": {\n" +
            "      \"17607e5d1b27bb4e8cb69c706ab2ab2c3f9fd58db6b0f758c82305d8cd53882e\": {\n" +
            "        \"Name\": \"gateway_17607e5d1b27\",\n" +
            "        \"EndpointID\": \"22ef2760d68241baa879b0437f79d4c11f0563c72412ba169f9d23ce92ee424e\",\n" +
            "        \"MacAddress\": \"02:42:ac:13:00:03\",\n" +
            "        \"IPv4Address\": \"172.19.0.3/16\",\n" +
            "        \"IPv6Address\": \"\"\n" +
            "      },\n" +
            "      \"ingress-sbox\": {\n" +
            "        \"Name\": \"gateway_ingress-sbox\",\n" +
            "        \"EndpointID\": \"f0c10c0255c8c5ce338e491f4c772a750a53004223b75d7505207deb49e95a36\",\n" +
            "        \"MacAddress\": \"02:42:ac:13:00:02\",\n" +
            "        \"IPv4Address\": \"172.19.0.2/16\",\n" +
            "        \"IPv6Address\": \"\"\n" +
            "      }\n" +
            "    },\n" +
            "    \"Options\": {\n" +
            "      \"com.docker.network.bridge.enable_icc\": \"false\",\n" +
            "      \"com.docker.network.bridge.enable_ip_masquerade\": \"true\",\n" +
            "      \"com.docker.network.bridge.name\": \"docker_gwbridge\"\n" +
            "    },\n" +
            "    \"Labels\": {}\n" +
            "  }\n" +
            "]";

    public static void main(String[] args) throws ParseException, ReflectiveOperationException {
        List<NetworkInfo> lists =  NetworkInfo.load(tmp);

        Logger.simple("adfadf");
    }
}
