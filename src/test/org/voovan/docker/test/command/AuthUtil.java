package org.voovan.docker.test.command;

import junit.framework.TestCase;
import org.voovan.docker.Global;
import org.voovan.docker.command.Auth.CmdAuth;
import org.voovan.docker.command.Exec.CmdExecCreate;
import org.voovan.docker.command.Exec.CmdExecInfo;
import org.voovan.docker.command.Exec.CmdExecStart;
import org.voovan.tools.TEnv;
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
        Global.DOCKER_REST_HOST = "127.0.0.1";
        Global.DOCKER_REST_PORT = 2735;
        Global.DOCKER_REST_TIMEOUT = 20;
        Global.DEBUG = true;
    }

    public String formatJSON(Object obj){
        return JSON.formatJson(JSON.toJSON(obj));
    }

    public void testAuth() throws Exception {
        CmdAuth cmdAuth = CmdAuth.newInstance();
        Object data = cmdAuth.username("helyho").password("Ht543500").send();
        cmdAuth.close();
        Logger.info(formatJSON(data));
    }


}
