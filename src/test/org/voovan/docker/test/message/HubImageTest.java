package org.voovan.docker.test.message;

import org.voovan.docker.message.Image.HubImageInfo;
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
public class HubImageTest {

    public static String tmp = "[\n" +
            "  {\n" +
            "    \"star_count\": 4926,\n" +
            "    \"is_official\": true,\n" +
            "    \"name\": \"ubuntu\",\n" +
            "    \"is_automated\": false,\n" +
            "    \"description\": \"Ubuntu is a Debian-based Linux operating system based on free software.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"star_count\": 67,\n" +
            "    \"is_official\": true,\n" +
            "    \"name\": \"ubuntu-upstart\",\n" +
            "    \"is_automated\": false,\n" +
            "    \"description\": \"Upstart is an event-based replacement for the /sbin/init daemon which starts processes at boot\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"star_count\": 28,\n" +
            "    \"is_official\": true,\n" +
            "    \"name\": \"ubuntu-debootstrap\",\n" +
            "    \"is_automated\": false,\n" +
            "    \"description\": \"debootstrap --variant=minbase --components=main,universe --include=inetutils-ping,iproute2 <suite> /\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"star_count\": 9,\n" +
            "    \"is_official\": false,\n" +
            "    \"name\": \"nuagebec/ubuntu\",\n" +
            "    \"is_automated\": true,\n" +
            "    \"description\": \"Simple always updated Ubuntu docker images with SSH access and supervisord.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"star_count\": 47,\n" +
            "    \"is_official\": false,\n" +
            "    \"name\": \"rastasheep/ubuntu-sshd\",\n" +
            "    \"is_automated\": true,\n" +
            "    \"description\": \"Dockerized SSH service, built on top of official Ubuntu images.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"star_count\": 0,\n" +
            "    \"is_official\": false,\n" +
            "    \"name\": \"konstruktoid/ubuntu\",\n" +
            "    \"is_automated\": true,\n" +
            "    \"description\": \"Ubuntu base image\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"star_count\": 5,\n" +
            "    \"is_official\": false,\n" +
            "    \"name\": \"nimmis/ubuntu\",\n" +
            "    \"is_automated\": true,\n" +
            "    \"description\": \"This is a docker images different LTS version of Ubuntu with a working init process and syslog \"\n" +
            "  },\n" +
            "  {\n" +
            "    \"star_count\": 27,\n" +
            "    \"is_official\": false,\n" +
            "    \"name\": \"torusware/speedus-ubuntu\",\n" +
            "    \"is_automated\": true,\n" +
            "    \"description\": \"Always updated official Ubuntu docker image with Torusware Speedus acceleration software\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"star_count\": 1,\n" +
            "    \"is_official\": false,\n" +
            "    \"name\": \"darksheer/ubuntu\",\n" +
            "    \"is_automated\": true,\n" +
            "    \"description\": \"Base Ubuntu Image -- Updated hourly\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"star_count\": 1,\n" +
            "    \"is_official\": false,\n" +
            "    \"name\": \"admiringworm/ubuntu\",\n" +
            "    \"is_automated\": true,\n" +
            "    \"description\": \"Base ubuntu images based on the official ubuntu.\\nContains cmake > 3.2 gcc and sqlite3\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"star_count\": 0,\n" +
            "    \"is_official\": false,\n" +
            "    \"name\": \"webhippie/ubuntu\",\n" +
            "    \"is_automated\": true,\n" +
            "    \"description\": \"Docker images for ubuntu\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"star_count\": 0,\n" +
            "    \"is_official\": false,\n" +
            "    \"name\": \"datenbetrieb/ubuntu\",\n" +
            "    \"is_automated\": true,\n" +
            "    \"description\": \"custom flavor of the official ubuntu base image\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"star_count\": 2,\n" +
            "    \"is_official\": false,\n" +
            "    \"name\": \"maxexcloo/ubuntu\",\n" +
            "    \"is_automated\": true,\n" +
            "    \"description\": \"Base image built on Ubuntu with init, Supervisor and minimal packages.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"star_count\": 10,\n" +
            "    \"is_official\": false,\n" +
            "    \"name\": \"nickistre/ubuntu-lamp\",\n" +
            "    \"is_automated\": true,\n" +
            "    \"description\": \"LAMP server on Ubuntu\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"star_count\": 1,\n" +
            "    \"is_official\": false,\n" +
            "    \"name\": \"jordi/ubuntu\",\n" +
            "    \"is_automated\": true,\n" +
            "    \"description\": \"Ubuntu Base Image\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"star_count\": 0,\n" +
            "    \"is_official\": false,\n" +
            "    \"name\": \"lynxtp/ubuntu\",\n" +
            "    \"is_automated\": true,\n" +
            "    \"description\": \"https://github.com/lynxtp/docker-ubuntu\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"star_count\": 0,\n" +
            "    \"is_official\": false,\n" +
            "    \"name\": \"esycat/ubuntu\",\n" +
            "    \"is_automated\": true,\n" +
            "    \"description\": \"Ubuntu LTS\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"star_count\": 0,\n" +
            "    \"is_official\": false,\n" +
            "    \"name\": \"teamrock/ubuntu\",\n" +
            "    \"is_automated\": true,\n" +
            "    \"description\": \"TeamRock's Ubuntu image configured with AWS Elasticache cluster client for PHP 5.6\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"star_count\": 0,\n" +
            "    \"is_official\": false,\n" +
            "    \"name\": \"ustclug/ubuntu\",\n" +
            "    \"is_automated\": true,\n" +
            "    \"description\": \"ubuntu image for docker with USTC mirror\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"star_count\": 0,\n" +
            "    \"is_official\": false,\n" +
            "    \"name\": \"labengine/ubuntu\",\n" +
            "    \"is_automated\": true,\n" +
            "    \"description\": \"Images base ubuntu\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"star_count\": 0,\n" +
            "    \"is_official\": false,\n" +
            "    \"name\": \"widerplan/ubuntu\",\n" +
            "    \"is_automated\": true,\n" +
            "    \"description\": \"Our basic Ubuntu images.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"star_count\": 26,\n" +
            "    \"is_official\": false,\n" +
            "    \"name\": \"consol/ubuntu-xfce-vnc\",\n" +
            "    \"is_automated\": true,\n" +
            "    \"description\": \"Ubuntu container with \\\"headless\\\" VNC session and preinstalled Firefox and Chrome browser\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"star_count\": 0,\n" +
            "    \"is_official\": false,\n" +
            "    \"name\": \"vcatechnology/ubuntu\",\n" +
            "    \"is_automated\": true,\n" +
            "    \"description\": \"A Ubuntu image that is updated daily\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"star_count\": 6,\n" +
            "    \"is_official\": false,\n" +
            "    \"name\": \"nickistre/ubuntu-lamp-wordpress\",\n" +
            "    \"is_automated\": true,\n" +
            "    \"description\": \"LAMP on Ubuntu with wp-cli installed\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"star_count\": 0,\n" +
            "    \"is_official\": false,\n" +
            "    \"name\": \"dorapro/ubuntu\",\n" +
            "    \"is_automated\": true,\n" +
            "    \"description\": \"ubuntu image\"\n" +
            "  }\n" +
            "]";

    public static void main(String[] args) throws ParseException, ReflectiveOperationException {
        List<HubImageInfo> lists = HubImageInfo.load(tmp);

        Logger.simple("adfadf");
    }
}
