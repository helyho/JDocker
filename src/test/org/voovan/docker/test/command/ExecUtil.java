package org.voovan.docker.test.command;

import junit.framework.TestCase;
import org.voovan.docker.command.Exec.CmdExecCreate;
import org.voovan.docker.command.Exec.CmdExecInfo;
import org.voovan.docker.command.Exec.CmdExecStart;
import org.voovan.docker.Global;
import org.voovan.docker.network.Result;
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
        Global.DOCKER_REST_HOST = "127.0.0.1";
        Global.DOCKER_REST_PORT = 2735;
        Global.DEBUG = true;
    }

    public String formatJSON(Object obj){
        return JSON.formatJson(JSON.toJSON(obj));
    }

    public void testExecCreate() throws Exception {
        CmdExecCreate cmdExecCreate = CmdExecCreate.newInstance("d_test");
        Object data = cmdExecCreate.cmd("echo","127.0.0.1").send();
        cmdExecCreate.close();
        Logger.info(formatJSON(data));
    }

    public void testExecStart() throws Exception {
        Global.DOCKER_REST_TIMEOUT = 15;
        CmdExecCreate cmdExecCreate = CmdExecCreate.newInstance("d_test");
        Result idata = cmdExecCreate.cmd("ifconfig","-a").send();
        JSONPath jsonpath = new JSONPath(idata.getMessage());
        String id = jsonpath.value("/Id").toString();


        CmdExecStart cmdExecStart = CmdExecStart
                .newInstance(id);
        Object data = cmdExecStart.send();
        Logger.info(formatJSON(data));

        byte[] tmp = null;
        cmdExecStart.beginLoadStream();
        System.out.println("------");
        for(tmp = cmdExecStart.loadStream(); tmp!=null ; tmp = cmdExecStart.loadStream()){
            System.out.print(new String(tmp).trim());
            System.out.println("------");
            TEnv.sleep(1000);//测试这个需要使用 ping 命令来测试
        }
        cmdExecStart.endLoadStream();
        cmdExecStart.close();

    }

    public void testExecInfo() throws Exception {
        CmdExecInfo cmdExecInfo = CmdExecInfo.newInstance("21ee94ad91d2574cabc8c5bbd2b2e83e6f874a89e12f947c469c7fcd99dfb155");
        Object data = cmdExecInfo.send();
        cmdExecInfo.close();
        Logger.info(formatJSON(data));
    }
}
