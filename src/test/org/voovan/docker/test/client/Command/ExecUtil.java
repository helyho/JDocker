package org.voovan.docker.test.client.Command;

import junit.framework.TestCase;
import org.voovan.docker.client.Command.Container.CmdContainerLogs;
import org.voovan.docker.client.Command.exec.CmdExecCreate;
import org.voovan.docker.client.Command.exec.CmdExecInfo;
import org.voovan.docker.client.Command.exec.CmdExecStart;
import org.voovan.docker.client.Global;
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
        Object data = cmdExecCreate.cmd("echo","asdfadfadf").send();
        cmdExecCreate.close();
        Logger.info(formatJSON(data));
    }

    public void testExecStart() throws Exception {
        CmdExecStart cmdExecStart = CmdExecStart.newInstance("21ee94ad91d2574cabc8c5bbd2b2e83e6f874a89e12f947c469c7fcd99dfb155");
        Object data = cmdExecStart.send();
        byte[] tmp = null;
        cmdExecStart.beginLoadStream();
        System.out.println("------");
        for(tmp = cmdExecStart.loadStream(); tmp!=null ; tmp = cmdExecStart.loadStream()){
            System.out.print(new String(tmp));
            System.out.println("------");
            TEnv.sleep(1000);//测试这个需要使用 ping 命令来测试
        }
        cmdExecStart.endLoadStream();
        cmdExecStart.close();
        Logger.info(formatJSON(data));
    }

    public void testExecInfo() throws Exception {
        CmdExecInfo cmdExecInfo = CmdExecInfo.newInstance("21ee94ad91d2574cabc8c5bbd2b2e83e6f874a89e12f947c469c7fcd99dfb155");
        Object data = cmdExecInfo.send();
        cmdExecInfo.close();
        Logger.info(formatJSON(data));
    }
}
