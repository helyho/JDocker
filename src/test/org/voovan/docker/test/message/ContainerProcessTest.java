package org.voovan.docker.test.message;

import org.voovan.docker.message.container.ContainerChange;
import org.voovan.docker.message.container.ContainerProcess;
import org.voovan.docker.message.container.atom.ChangeItem;
import org.voovan.docker.message.container.atom.Process;
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
public class ContainerProcessTest {

    public static String tmp = "{\n" +
            "  \"Processes\": [\n" +
            "    [\n" +
            "      \"1966\",\n" +
            "      \"root\",\n" +
            "      \"0:00\",\n" +
            "      \"/bin/sh -c \\\"/root/dockertunnel\\\"\"\n" +
            "    ],\n" +
            "    [\n" +
            "      \"1986\",\n" +
            "      \"root\",\n" +
            "      \"0:00\",\n" +
            "      \"{busybox} ash /root/dockertunnel\"\n" +
            "    ],\n" +
            "    [\n" +
            "      \"1987\",\n" +
            "      \"root\",\n" +
            "      \"0:00\",\n" +
            "      \"socat tcp4-listen:2735,reuseaddr,fork unix-connect:/var/run/docker.sock\"\n" +
            "    ],\n" +
            "    [\n" +
            "      \"7281\",\n" +
            "      \"root\",\n" +
            "      \"0:00\",\n" +
            "      \"socat tcp4-listen:2735,reuseaddr,fork unix-connect:/var/run/docker.sock\"\n" +
            "    ]\n" +
            "  ],\n" +
            "  \"Titles\": [\n" +
            "    \"PID\",\n" +
            "    \"USER\",\n" +
            "    \"TIME\",\n" +
            "    \"COMMAND\"\n" +
            "  ]\n" +
            "}";

    public static void main(String[] args) throws ParseException, ReflectiveOperationException {
        List<Process> lists =  ContainerProcess.load(tmp);

        Logger.simple("adfadf");
    }
}
