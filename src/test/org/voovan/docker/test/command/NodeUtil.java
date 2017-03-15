package org.voovan.docker.test.command;

import junit.framework.TestCase;
import org.voovan.docker.DockerGlobal;
import org.voovan.docker.command.Node.CmdNodeList;
import org.voovan.docker.command.Node.CmdNodeRemove;
import org.voovan.docker.command.Node.CmdNodeUpdate;
import org.voovan.docker.command.Task.CmdTaskList;
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
public class NodeUtil extends TestCase {

    public void setUp(){
        DockerGlobal.DOCKER_REST_HOST = "127.0.0.1";
        DockerGlobal.DOCKER_REST_PORT = 2735;
        DockerGlobal.DEBUG = true;
    }

    public String formatJSON(Object obj){
        return JSON.formatJson(JSON.toJSON(obj));
    }

    public void testCmdTaskList() throws Exception {
        CmdTaskList cmdTaskList = CmdTaskList.newInstance();
        cmdTaskList.connect();
        Object data = cmdTaskList.send();
        cmdTaskList.close();
        Logger.info(formatJSON(data));
    }

    public void testCmdNodeList() throws Exception {
        CmdNodeList cmdNodeList = CmdNodeList.newInstance();
        cmdNodeList.connect();
        Object data = cmdNodeList.id("71zei032twfrgy5053wfzmtz3").send();
        cmdNodeList.close();
        Logger.info(formatJSON(data));
    }

    public void testCmdNodeRemove() throws Exception {
        CmdNodeRemove cmdNodeRemoved = CmdNodeRemove.newInstance("3vyegqfzjfhdmmclc0hluhnpi");
        cmdNodeRemoved.connect();
        Object data = cmdNodeRemoved.send();
        cmdNodeRemoved.close();
        Logger.info(formatJSON(data));
    }

    public void testCmdNodeUpdate() throws Exception {
        CmdNodeUpdate cmdNodeUpdate = CmdNodeUpdate.newInstance("71zei032twfrgy5053wfzmtz3",10);
        cmdNodeUpdate.connect();
        Object data = cmdNodeUpdate.name("helyho_kkkk").role("manager").label("adfadf","ppppp").send();
        cmdNodeUpdate.close();
        Logger.info(formatJSON(data));
    }
}
