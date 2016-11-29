package org.voovan.docker.test.command;

import junit.framework.TestCase;
import org.voovan.docker.DockerGlobal;
import org.voovan.docker.command.Auth.CmdAuth;
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
public class AuthUtil extends TestCase {

    public void setUp(){
        DockerGlobal.DOCKER_REST_HOST = "127.0.0.1";
        DockerGlobal.DOCKER_REST_PORT = 2735;
        DockerGlobal.DOCKER_REST_TIMEOUT = 20;
        DockerGlobal.DEBUG = true;
    }

    public String formatJSON(Object obj){
        return JSON.formatJson(JSON.toJSON(obj));
    }

    public void testAuth() throws Exception {
        CmdAuth cmdAuth = CmdAuth.newInstance();
        Object data = cmdAuth.username("helyho").password("12345").send();
        cmdAuth.close();
        Logger.info(formatJSON(data));
    }


}
