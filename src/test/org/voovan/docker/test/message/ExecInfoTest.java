package org.voovan.docker.test.message;

import org.voovan.docker.message.Image.HubImageInfo;
import org.voovan.docker.message.exec.ExecInfo;
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
public class ExecInfoTest {

    public static String tmp = "{\n" +
            "  \"ID\": \"1d733ad4d632396b11fb1f3a2a1cf35a8ad5f1204e338e2e155351c029cea82d\",\n" +
            "  \"Running\": false,\n" +
            "  \"ExitCode\": 0,\n" +
            "  \"ProcessConfig\": {\n" +
            "    \"tty\": true,\n" +
            "    \"entrypoint\": \"echo\",\n" +
            "    \"arguments\": [\n" +
            "      \"Exec test message\"\n" +
            "    ],\n" +
            "    \"privileged\": false\n" +
            "  },\n" +
            "  \"OpenStdin\": false,\n" +
            "  \"OpenStderr\": true,\n" +
            "  \"OpenStdout\": true,\n" +
            "  \"CanRemove\": true,\n" +
            "  \"ContainerID\": \"23c45c53062f2d142e37249c9d614e2973e7c13006775617f582606d4d29fe56\",\n" +
            "  \"DetachKeys\": \"EBE=\"\n" +
            "}";

    public static void main(String[] args) throws ParseException, ReflectiveOperationException {
        ExecInfo execInfo = ExecInfo.load(tmp);

        Logger.simple("adfadf");
    }
}
