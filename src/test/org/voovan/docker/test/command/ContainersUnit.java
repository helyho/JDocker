package org.voovan.docker.test.command;

import junit.framework.TestCase;
import org.voovan.docker.command.Container.*;
import org.voovan.docker.Global;
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
public class ContainersUnit extends TestCase {

    public ContainersUnit(String name) {
        super(name);
    }

    public String formatJSON(Object obj){
        return JSON.formatJson(JSON.toJSON(obj));
    }

    public void setUp(){
        Global.DOCKER_REST_HOST = "127.0.0.1";
        Global.DOCKER_REST_PORT = 2735;
        Global.DEBUG = true;
    }

    public void testCreate() throws Exception {
        CmdContainerCreate createCmd =  CmdContainerCreate.newInstance("d_test");
        Object data = createCmd.image("alpine").network("HostNetwork")
                .volume("v_tx:/v_tx").link("dockerfly:dockerfly")
                .cmd("ping","127.0.0.1").env("author=helyho")
                .exposePort(22,"tcp","2222").send();
        createCmd.close();
        Logger.info(formatJSON(data));
    }

    public void testInfo() throws Exception {
        CmdContainerList cmdContainersList = CmdContainerList.newInstance();
        Object data = cmdContainersList.send();
        cmdContainersList.close();
        Logger.info(formatJSON(data));
    }

    public void testRename() throws Exception {
        CmdContainerRename cmdContainerRename = CmdContainerRename.newInstance("31f0c56b79419a6349c7a368951e733dfc92f71966ec40628780f12e9628cf73");
        Object data = cmdContainerRename.newName("dockfly_1").send();
        cmdContainerRename.close();
        Logger.info(formatJSON(data));
    }

    public void testUpdate() throws Exception {
        CmdContainerUpdate updateCmd =  CmdContainerUpdate.newInstance("d_test");
        Object data = updateCmd.cpuPeriod(1000000).memory(250).send();
        updateCmd.close();
        Logger.info(formatJSON(data));
    }

    public void testRemove() throws Exception {
        CmdContainerRemove cmdContainerRemove = CmdContainerRemove.newInstance("d_test");
        Object data = cmdContainerRemove.send();
        cmdContainerRemove.close();
        Logger.info(formatJSON(data));
    }

    public void testStart() throws Exception {
        CmdContainerStart cmdContainerStart = CmdContainerStart.newInstance("d_test");
        Object data = cmdContainerStart.send();
        cmdContainerStart.close();
        Logger.info(formatJSON(data));
    }

    public void testStop() throws Exception {
        CmdContainerStop cmdContainerStop = CmdContainerStop.newInstance("d_test");
        Object data = cmdContainerStop.send();
        cmdContainerStop.close();
        Logger.info(formatJSON(data));
    }

    public void testChange() throws Exception {
        CmdContainerChange cmdContainerChange = CmdContainerChange.newInstance("d_test");
        Object data = cmdContainerChange.send();
        cmdContainerChange.close();
        Logger.info(formatJSON(data));
    }

    public void testTop() throws Exception {
        CmdContainerTop cmdContainerTop = CmdContainerTop.newInstance("d_test");
        Object data = cmdContainerTop.send();
        cmdContainerTop.close();
        Logger.info(formatJSON(data));
    }

    public void testStats() throws Exception {
        CmdContainerStats cmdContainerStats = CmdContainerStats.newInstance("d_test");
        Object data = cmdContainerStats.send();
        cmdContainerStats.close();
        Logger.info(formatJSON(data));
    }

    public void testPause() throws Exception {
        CmdContainerPause cmdContainerPause = CmdContainerPause.newInstance("d_test");
        Object data = cmdContainerPause.send();
        cmdContainerPause.close();
        Logger.info(formatJSON(data));
    }

    public void testUnPause() throws Exception {
        CmdContainerUnPause cmdContainerUnPause = CmdContainerUnPause.newInstance("d_test");
        Object data = cmdContainerUnPause.send();
        cmdContainerUnPause.close();
        Logger.info(formatJSON(data));
    }

    public void testReStart() throws Exception {
        CmdContainerReStart cmdContainerReStart = CmdContainerReStart.newInstance("d_test");
        Object data = cmdContainerReStart.send();
        cmdContainerReStart.close();
        Logger.info(formatJSON(data));
    }


    public void testLogs() throws Exception {
        CmdContainerLogs cmdContainerLogs = CmdContainerLogs.newInstance("d_test");
        Object data = cmdContainerLogs.send();
        cmdContainerLogs.close();
        Logger.info(formatJSON(data));
    }

    public void testCommit() throws Exception {
        CmdContainerCommit cmdContainerCommit = CmdContainerCommit.newInstance("d_test");
        Object data = cmdContainerCommit.repo("helyhotest").tag("latest").pause(true).send();
        cmdContainerCommit.close();
        Logger.info(formatJSON(data));
    }
}

