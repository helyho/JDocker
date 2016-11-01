package org.voovan.docker.test.message;

import org.voovan.docker.message.node.NodeInfo;
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
public class NodeInfoTest {
    public static String tmp = "[\n" +
            "  {\n" +
            "    \"ID\": \"89hfls6kcbg5qnv6jzi35o86m\",\n" +
            "    \"Version\": {\n" +
            "      \"Index\": 108656\n" +
            "    },\n" +
            "    \"CreatedAt\": \"2016-10-19T19:00:40.195359015Z\",\n" +
            "    \"UpdatedAt\": \"2016-10-24T15:52:02.483792905Z\",\n" +
            "    \"Spec\": {\n" +
            "      \"Role\": \"manager\",\n" +
            "      \"Availability\": \"active\"\n" +
            "    },\n" +
            "    \"Description\": {\n" +
            "      \"Hostname\": \"moby\",\n" +
            "      \"Platform\": {\n" +
            "        \"Architecture\": \"x86_64\",\n" +
            "        \"OS\": \"linux\"\n" +
            "      },\n" +
            "      \"Resources\": {\n" +
            "        \"NanoCPUs\": 2000000000,\n" +
            "        \"MemoryBytes\": 2096566272\n" +
            "      },\n" +
            "      \"Engine\": {\n" +
            "        \"EngineVersion\": \"1.12.1\",\n" +
            "        \"Plugins\": [\n" +
            "          {\n" +
            "            \"Type\": \"Network\",\n" +
            "            \"Name\": \"bridge\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"Type\": \"Network\",\n" +
            "            \"Name\": \"host\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"Type\": \"Network\",\n" +
            "            \"Name\": \"null\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"Type\": \"Network\",\n" +
            "            \"Name\": \"overlay\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"Type\": \"Volume\",\n" +
            "            \"Name\": \"local\"\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    },\n" +
            "    \"Status\": {\n" +
            "      \"State\": \"ready\"\n" +
            "    },\n" +
            "    \"ManagerStatus\": {\n" +
            "      \"Leader\": true,\n" +
            "      \"Reachability\": \"reachable\",\n" +
            "      \"Addr\": \"192.168.65.2:2377\"\n" +
            "    }\n" +
            "  }\n" +
            "]";


    public static void main(String[] args) throws ParseException, ReflectiveOperationException {
        List<NodeInfo> info = NodeInfo.load(tmp);
        Logger.simple("11111");
    }
}
