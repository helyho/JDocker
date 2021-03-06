package org.voovan.docker.test.command;

import junit.framework.TestCase;
import org.voovan.docker.DockerGlobal;
import org.voovan.docker.command.Exec.CmdExecCreate;
import org.voovan.docker.command.Exec.CmdExecInfo;
import org.voovan.docker.command.Exec.CmdExecStart;
import org.voovan.tools.TEnv;
import org.voovan.tools.json.JSON;
import org.voovan.tools.json.JSONPath;
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
public class ExecUtil extends TestCase {

    public void setUp(){
        DockerGlobal.DOCKER_REST_HOST = "127.0.0.1";
        DockerGlobal.DOCKER_REST_PORT = 2735;
        DockerGlobal.DEBUG = true;
    }

    public String formatJSON(Object obj){
        return JSON.formatJson(JSON.toJSON(obj));
    }

    public void testExecCreate() throws Exception {
        CmdExecCreate cmdExecCreate = CmdExecCreate.newInstance("d_test");
        cmdExecCreate.connect();
        Object data = cmdExecCreate.cmd("echo","127.0.0.1").send();
        cmdExecCreate.close();
        Logger.info(formatJSON(data));
    }

    public void testExecStart() throws Exception {
        DockerGlobal.DOCKER_REST_TIMEOUT = 5000;
        CmdExecCreate cmdExecCreate = CmdExecCreate.newInstance("Voovan");
        cmdExecCreate.connect();
        String idata = cmdExecCreate.cmd("ping","127.0.0.1").send();
        JSONPath jsonpath = new JSONPath(idata);
        String id = jsonpath.value("/Id").toString();


        CmdExecStart cmdExecStart = CmdExecStart
                .newInstance(id);
        cmdExecStart.connect();
        Object data = cmdExecStart.send();
        //Logger.info(formatJSON(data));

        String tmp = null;
        System.out.println("//------");
        for(tmp = cmdExecStart.loadStream(); tmp!=null ; tmp = cmdExecStart.loadStream()){
            if(tmp!=null && !tmp.isEmpty()){
                System.out.println("=>"+tmp.trim());
            }
            TEnv.sleep(1000);//测试这个需要使用 ping 命令来测试
        }
        System.out.println("\r\n//------");
        cmdExecStart.close();
    }

    public void testExecInfo() throws Exception {
        CmdExecInfo cmdExecInfo = CmdExecInfo.newInstance("3842c2559fadd60a7426d4744ee3f81765a07ccdb6a6d63125ee9b5ce3ae5f17");
        cmdExecInfo.connect();
        Object data = cmdExecInfo.send();
        cmdExecInfo.close();
        Logger.info(formatJSON(data));
    }
}
