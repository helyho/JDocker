package org.voovan.docker.test.command;

import junit.framework.TestCase;
import org.voovan.docker.Global;
import org.voovan.docker.command.Node.CmdNodeList;
import org.voovan.docker.command.Node.CmdNodeRemove;
import org.voovan.docker.command.Node.CmdNodeUpdate;
import org.voovan.docker.command.Swarm.*;
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
public class SwarmUtil extends TestCase {

    public void setUp(){
        Global.DOCKER_REST_HOST = "127.0.0.1";
        Global.DOCKER_REST_PORT = 2735;
        Global.DEBUG = true;
    }

    public String formatJSON(Object obj){
        return JSON.formatJson(JSON.toJSON(obj));
    }

    public void testCmdSwarmInfo() throws Exception {
        CmdSwarmInfo cmdSwarmInfo = CmdSwarmInfo.newInstance();
        Object data = cmdSwarmInfo.send();
        cmdSwarmInfo.close();
        Logger.info(formatJSON(data));
    }

    public void testCmdSwarmInit() throws Exception {
        CmdSwarmInit cmdSwarmInit = CmdSwarmInit.newInstance();
        Object data = cmdSwarmInit.advertiseAddr("192.168.65.2:2377")
                .taskHistoryRetentionLimit(0).forceNewCluster(true).send();
        cmdSwarmInit.close();
        Logger.info(formatJSON(data));
    }

    public void testCmdSwarmJoin() throws Exception {
        CmdSwarmJoin cmdSwarmJoin = CmdSwarmJoin.newInstance();
        Object data = cmdSwarmJoin.advertiseAddr("192.168.65.2:2377")
                .listenAddr("0.0.0.0:2377").joinToken("").send();
        cmdSwarmJoin.close();
        Logger.info(formatJSON(data));
    }

    public void testCmdSwarmLeave() throws Exception {
        CmdSwarmLeave cmdSwarmLeave = CmdSwarmLeave.newInstance();
        Object data = cmdSwarmLeave.send();
        cmdSwarmLeave.close();
        Logger.info(formatJSON(data));
    }

    public void testCmdSwarmUpdate() throws Exception {
        CmdSwarmUpdate cmdSwarmUpdate = CmdSwarmUpdate.newInstance();
        Object data = cmdSwarmUpdate.name("teaaaaa").send();
        cmdSwarmUpdate.close();
        Logger.info(formatJSON(data));
    }

}
