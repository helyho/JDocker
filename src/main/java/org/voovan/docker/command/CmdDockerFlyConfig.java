package org.voovan.docker.command;

import org.voovan.docker.DockerGlobal;
import org.voovan.tools.TObject;

import java.util.Map;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class CmdDockerFlyConfig {

    public static void config(String host, int port, String charSet, int timeout, boolean isDebug){
        DockerGlobal.DOCKER_REST_HOST = host;
        DockerGlobal.DOCKER_REST_PORT = port;
        DockerGlobal.DOCKER_REST_CHARSET = charSet;
        DockerGlobal.DOCKER_REST_TIMEOUT = timeout;
        DockerGlobal.DEBUG = isDebug;
    }

    public static void config(String host, int port ){
        DockerGlobal.DOCKER_REST_HOST = host;
        DockerGlobal.DOCKER_REST_PORT = port;
    }

    public static void config(String host, int port, int timeout){
        DockerGlobal.DOCKER_REST_HOST = host;
        DockerGlobal.DOCKER_REST_PORT = port;
        DockerGlobal.DOCKER_REST_TIMEOUT = timeout;
    }

    public static void config(String host, int port, boolean isDebug){
        DockerGlobal.DOCKER_REST_HOST = host;
        DockerGlobal.DOCKER_REST_PORT = port;
        DockerGlobal.DEBUG = isDebug;
    }

    public static void config(String host, int port, int timeout, boolean isDebug){
        DockerGlobal.DOCKER_REST_HOST = host;
        DockerGlobal.DOCKER_REST_PORT = port;
        DockerGlobal.DEBUG = isDebug;
        DockerGlobal.DOCKER_REST_TIMEOUT = timeout;
    }

    public static Map<String,Object> config(){
        return (Map<String,Object>)TObject.asMap("host", DockerGlobal.DOCKER_REST_HOST,
                "port", DockerGlobal.DOCKER_REST_PORT,
                "timeout", DockerGlobal.DOCKER_REST_TIMEOUT,
                "isDebug", DockerGlobal.DEBUG
        );
    }
}
