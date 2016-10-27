package org.voovan.docker.test.message;

import org.voovan.docker.message.Image.ImageInfo;
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
public class ImageInfoTest {

    public static String tmp = "[\n" +
            "  {\n" +
            "    \"Id\": \"sha256:68a70731abcf825ba91fb011972023febdd71e53760a9da0797ae50e6c5c5282\",\n" +
            "    \"ParentId\": \"sha256:561f511a30a8b5e94574c9005cc1a6fb91e773e7c28987c3a7e47fbad647a839\",\n" +
            "    \"RepoTags\": [\n" +
            "      \"myrepo:latest\"\n" +
            "    ],\n" +
            "    \"RepoDigests\": null,\n" +
            "    \"Created\": 1476881256,\n" +
            "    \"Size\": 8028292,\n" +
            "    \"VirtualSize\": 8028292,\n" +
            "    \"Labels\": {}\n" +
            "  },\n" +
            "  {\n" +
            "    \"Id\": \"sha256:561f511a30a8b5e94574c9005cc1a6fb91e773e7c28987c3a7e47fbad647a839\",\n" +
            "    \"ParentId\": \"sha256:9465c893364d79eb45ab952b3efa40a0a9748a0c4223571619a892fb7f028b8a\",\n" +
            "    \"RepoTags\": [\n" +
            "      \"dockerfly:latest\"\n" +
            "    ],\n" +
            "    \"RepoDigests\": null,\n" +
            "    \"Created\": 1476870324,\n" +
            "    \"Size\": 8028292,\n" +
            "    \"VirtualSize\": 8028292,\n" +
            "    \"Labels\": {}\n" +
            "  }" +
            "]";

    public static void main(String[] args) throws ParseException, ReflectiveOperationException {
        List<ImageInfo> infos = ImageInfo.load(tmp);

        Logger.simple("CreateDate:" + infos.get(0).getCreated());
        Logger.simple("Size:" + infos.get(0).getSize());
        Logger.simple("VirtualSize:" + infos.get(0).getVirtualSize());
    }
}
