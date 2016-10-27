package org.voovan.docker.test.message;

import org.voovan.docker.message.container.ContainerInfo;
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
public class ContainerInfoTest {

    public static String tmp = "[\n" +
            "  {\n" +
            "    \"Id\": \"73f1553ef15f897ae258983bb685400827e71ba3efffee428f97dfe285dfb33c\",\n" +
            "    \"Names\": [\n" +
            "      \"/helyho\"\n" +
            "    ],\n" +
            "    \"Image\": \"alpine\",\n" +
            "    \"ImageID\": \"sha256:baa5d63471ead618ff91ddfacf1e2c81bf0612bfeb1daf00eb0843a41fbfade3\",\n" +
            "    \"Command\": \"nc -l 3000\",\n" +
            "    \"Created\": 1477063966,\n" +
            "    \"Ports\": [],\n" +
            "    \"Labels\": {},\n" +
            "    \"State\": \"created\",\n" +
            "    \"Status\": \"Created\",\n" +
            "    \"HostConfig\": {\n" +
            "      \"NetworkMode\": \"locbridge\"\n" +
            "    },\n" +
            "    \"NetworkSettings\": {\n" +
            "      \"Networks\": {\n" +
            "        \"locbridge\": {\n" +
            "          \"IPAMConfig\": null,\n" +
            "          \"Links\": null,\n" +
            "          \"Aliases\": null,\n" +
            "          \"NetworkID\": \"\",\n" +
            "          \"EndpointID\": \"\",\n" +
            "          \"Gateway\": \"\",\n" +
            "          \"IPAddress\": \"\",\n" +
            "          \"IPPrefixLen\": 0,\n" +
            "          \"IPv6Gateway\": \"\",\n" +
            "          \"GlobalIPv6Address\": \"\",\n" +
            "          \"GlobalIPv6PrefixLen\": 0,\n" +
            "          \"MacAddress\": \"\"\n" +
            "        }\n" +
            "      }\n" +
            "    },\n" +
            "    \"Mounts\": [\n" +
            "      {\n" +
            "        \"Name\": \"v_t1\",\n" +
            "        \"Source\": \"/var/lib/docker/volumes/v_t1/_data\",\n" +
            "        \"Destination\": \"/tmp\",\n" +
            "        \"Driver\": \"local\",\n" +
            "        \"Mode\": \"z\",\n" +
            "        \"RW\": true,\n" +
            "        \"Propagation\": \"rprivate\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"Id\": \"a5d72316a8065e6f8e4c677486946c0d9355633450936b2eb4adf1db4902ed59\",\n" +
            "    \"Names\": [\n" +
            "      \"/test1\"\n" +
            "    ],\n" +
            "    \"Image\": \"alpine\",\n" +
            "    \"ImageID\": \"sha256:baa5d63471ead618ff91ddfacf1e2c81bf0612bfeb1daf00eb0843a41fbfade3\",\n" +
            "    \"Command\": \"sh\",\n" +
            "    \"Created\": 1477045036,\n" +
            "    \"Ports\": [],\n" +
            "    \"Labels\": {},\n" +
            "    \"State\": \"running\",\n" +
            "    \"Status\": \"Up 5 hours\",\n" +
            "    \"HostConfig\": {\n" +
            "      \"NetworkMode\": \"locbridge\"\n" +
            "    },\n" +
            "    \"NetworkSettings\": {\n" +
            "      \"Networks\": {\n" +
            "        \"locbridge\": {\n" +
            "          \"IPAMConfig\": null,\n" +
            "          \"Links\": null,\n" +
            "          \"Aliases\": null,\n" +
            "          \"NetworkID\": \"fbee97ac533b45afaf77f659e28999962589c5c040d7e5b708d8ebcbb9fab0f8\",\n" +
            "          \"EndpointID\": \"e9616e5ecc7804bf54fb9c9ed2e64038d2f9b692c19dfefa5fec640e90eb8013\",\n" +
            "          \"Gateway\": \"172.18.0.1\",\n" +
            "          \"IPAddress\": \"172.18.0.2\",\n" +
            "          \"IPPrefixLen\": 16,\n" +
            "          \"IPv6Gateway\": \"\",\n" +
            "          \"GlobalIPv6Address\": \"\",\n" +
            "          \"GlobalIPv6PrefixLen\": 0,\n" +
            "          \"MacAddress\": \"02:42:ac:12:00:02\"\n" +
            "        }\n" +
            "      }\n" +
            "    },\n" +
            "    \"Mounts\": []\n" +
            "  },\n" +
            "  {\n" +
            "    \"Id\": \"218a3df24831ee65786f402c1ae124624437664d7d4298579b280fdc43d98522\",\n" +
            "    \"Names\": [\n" +
            "      \"/dockerfly\"\n" +
            "    ],\n" +
            "    \"Image\": \"dockerfly\",\n" +
            "    \"ImageID\": \"sha256:561f511a30a8b5e94574c9005cc1a6fb91e773e7c28987c3a7e47fbad647a839\",\n" +
            "    \"Command\": \"/bin/sh -c \\\"/root/dockertunnel\\\"\",\n" +
            "    \"Created\": 1476886257,\n" +
            "    \"Ports\": [\n" +
            "      {\n" +
            "        \"IP\": \"0.0.0.0\",\n" +
            "        \"PrivatePort\": 2735,\n" +
            "        \"PublicPort\": 2735,\n" +
            "        \"Type\": \"tcp\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"Labels\": {},\n" +
            "    \"State\": \"running\",\n" +
            "    \"Status\": \"Up 7 hours\",\n" +
            "    \"HostConfig\": {\n" +
            "      \"NetworkMode\": \"default\"\n" +
            "    },\n" +
            "    \"NetworkSettings\": {\n" +
            "      \"Networks\": {\n" +
            "        \"bridge\": {\n" +
            "          \"IPAMConfig\": null,\n" +
            "          \"Links\": null,\n" +
            "          \"Aliases\": null,\n" +
            "          \"NetworkID\": \"b27654522aaa4b26ab4c8c982de2181a81e11002ae9b6f5ee038b673b45bb291\",\n" +
            "          \"EndpointID\": \"8b077f69f184d9f0a67dd2701219bcc2c7e9f084026f70cd9cad6c815662ffb9\",\n" +
            "          \"Gateway\": \"172.17.0.1\",\n" +
            "          \"IPAddress\": \"172.17.0.2\",\n" +
            "          \"IPPrefixLen\": 16,\n" +
            "          \"IPv6Gateway\": \"\",\n" +
            "          \"GlobalIPv6Address\": \"\",\n" +
            "          \"GlobalIPv6PrefixLen\": 0,\n" +
            "          \"MacAddress\": \"02:42:ac:11:00:02\"\n" +
            "        }\n" +
            "      }\n" +
            "    },\n" +
            "    \"Mounts\": [\n" +
            "      {\n" +
            "        \"Source\": \"/var/run/docker.sock\",\n" +
            "        \"Destination\": \"/var/run/docker.sock\",\n" +
            "        \"Mode\": \"\",\n" +
            "        \"RW\": true,\n" +
            "        \"Propagation\": \"rprivate\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "]";

    public static void main(String[] args) throws ParseException, ReflectiveOperationException {
        List<ContainerInfo> containerInfos = ContainerInfo.load(tmp);

        Logger.simple("----");

    }
}
