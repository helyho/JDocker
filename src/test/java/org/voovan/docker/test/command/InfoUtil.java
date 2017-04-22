package org.voovan.docker.test.command;

import junit.framework.TestCase;
import org.voovan.docker.DockerGlobal;
import org.voovan.docker.command.Info.CmdDockerInfo;
import org.voovan.tools.json.JSON;
import org.voovan.tools.log.Logger;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class InfoUtil  extends TestCase {
    public void setUp(){
        DockerGlobal.DOCKER_REST_HOST = "192.168.99.103";
        DockerGlobal.DOCKER_REST_PORT = 2735;
        DockerGlobal.DOCKER_REST_TIMEOUT = 20;
        DockerGlobal.DEBUG = true;
    }

    public String formatJSON(Object obj){
        return JSON.formatJson(JSON.toJSON(obj));
    }

    public void testInfo() throws Exception {
        CmdDockerInfo cmdInfo = CmdDockerInfo.newInstance();
        cmdInfo.connect();
        Object data = cmdInfo.send();
        cmdInfo.close();
        Logger.info(formatJSON(data));
    }

}
