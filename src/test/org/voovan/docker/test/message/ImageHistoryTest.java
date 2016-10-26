package org.voovan.docker.test.message;

import org.voovan.docker.message.Image.ImageHistory;
import org.voovan.tools.TDateTime;
import org.voovan.tools.log.Logger;

import java.text.ParseException;
import java.util.Date;
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
public class ImageHistoryTest {
    public static String tmp="[\n" +
            "  {\n" +
            "    \"Id\": \"sha256:561f511a30a8b5e94574c9005cc1a6fb91e773e7c28987c3a7e47fbad647a839\",\n" +
            "    \"Created\": 1476870324,\n" +
            "    \"CreatedBy\": \"/bin/sh -c #(nop)  ENTRYPOINT [\\\"/bin/sh\\\" \\\"-c\\\" \\\"\\\\\\\"/root/dockertunnel\\\\\\\"\\\"]\",\n" +
            "    \"Tags\": [\n" +
            "      \"dockerfly:latest\"\n" +
            "    ],\n" +
            "    \"Size\": 0,\n" +
            "    \"Comment\": \"\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Id\": \"sha256:9465c893364d79eb45ab952b3efa40a0a9748a0c4223571619a892fb7f028b8a\",\n" +
            "    \"Created\": 1476870324,\n" +
            "    \"CreatedBy\": \"/bin/sh -c chmod +x /root/dockertunnel\",\n" +
            "    \"Tags\": null,\n" +
            "    \"Size\": 72,\n" +
            "    \"Comment\": \"\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Id\": \"sha256:41f9314c76b3fbb8190157cabfa82ba623521173960818f94524cd51b4f6e2ea\",\n" +
            "    \"Created\": 1476870323,\n" +
            "    \"CreatedBy\": \"/bin/sh -c echo \\\"socat tcp4-listen:2735,reuseaddr,fork unix-connect:/var/run/docker.sock\\\" > /root/dockertunnel\",\n" +
            "    \"Tags\": null,\n" +
            "    \"Size\": 72,\n" +
            "    \"Comment\": \"\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Id\": \"sha256:866d0062ac1b373205399c722454a1fdcd60f0d7638c0f72fdefc7e8520ad3f6\",\n" +
            "    \"Created\": 1476870321,\n" +
            "    \"CreatedBy\": \"/bin/sh -c apk --no-cache add socat\",\n" +
            "    \"Tags\": null,\n" +
            "    \"Size\": 3225184,\n" +
            "    \"Comment\": \"\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Id\": \"sha256:804ae09b8166ce54480b8d057b671bd0a6e29c3cadfecbc5f648411bb82f06f3\",\n" +
            "    \"Created\": 1476870298,\n" +
            "    \"CreatedBy\": \"/bin/sh -c #(nop)  MAINTAINER helyho <helyho@gmail.com>\",\n" +
            "    \"Tags\": null,\n" +
            "    \"Size\": 0,\n" +
            "    \"Comment\": \"\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Id\": \"sha256:ee4603260daafe1a8c2f3b78fd760922918ab2441cbb2853ed5c439e59c52f96\",\n" +
            "    \"Created\": 1474648197,\n" +
            "    \"CreatedBy\": \"/bin/sh -c #(nop) ADD file:d6ee3ba7a4d59b161917082cc7242c660c61bb3f3cc1549c7e2dfff2b0de7104 in / \",\n" +
            "    \"Tags\": null,\n" +
            "    \"Size\": 4802964,\n" +
            "    \"Comment\": \"\"\n" +
            "  }\n" +
            "]";

    public static void main(String[] args) throws ParseException, ReflectiveOperationException {
        List<ImageHistory> imageHistories = ImageHistory.load(tmp);
        Date d = new  Date(1476870324*1000L);
        Logger.simple("--------------"+ TDateTime.format(d, TDateTime.STANDER_DATETIME_TEMPLATE));
    }
}
