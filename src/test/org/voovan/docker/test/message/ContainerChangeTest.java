package org.voovan.docker.test.message;

import org.voovan.docker.message.container.ContainerChange;
import org.voovan.docker.message.container.atom.ChangeItem;
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
public class ContainerChangeTest {

    public static String tmp = "[\n" +
            "  {\n" +
            "    \"Path\": \"/root\",\n" +
            "    \"Kind\": 0\n" +
            "  },\n" +
            "  {\n" +
            "    \"Path\": \"/root/.ash_history\",\n" +
            "    \"Kind\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"Path\": \"/run.sh\",\n" +
            "    \"Kind\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"Path\": \"/tmp\",\n" +
            "    \"Kind\": 0\n" +
            "  },\n" +
            "  {\n" +
            "    \"Path\": \"/tmp/xxx.log\",\n" +
            "    \"Kind\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"Path\": \"/var\",\n" +
            "    \"Kind\": 0\n" +
            "  },\n" +
            "  {\n" +
            "    \"Path\": \"/var/run\",\n" +
            "    \"Kind\": 0\n" +
            "  },\n" +
            "  {\n" +
            "    \"Path\": \"/var/run/docker.sock\",\n" +
            "    \"Kind\": 1\n" +
            "  }\n" +
            "]";

    public static void main(String[] args) throws ParseException, ReflectiveOperationException {
        List<ChangeItem> lists =  ContainerChange.load(tmp);

        Logger.simple("adfadf");
    }
}
