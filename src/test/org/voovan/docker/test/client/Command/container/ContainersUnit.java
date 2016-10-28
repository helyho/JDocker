package org.voovan.docker.test.client.Command.container;

import junit.framework.TestCase;
import org.junit.Test;
import org.voovan.docker.client.Command.Contianer.CmdContainerCreate;
import org.voovan.docker.client.Command.Contianer.CmdContainerUpdate;
import org.voovan.docker.client.Command.Contianer.CmdContainersList;
import org.voovan.docker.client.Global;
import org.voovan.docker.client.network.Result;
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

    public void setUp(){
        Global.DOCKER_REST_HOST = "127.0.0.1";
        Global.DOCKER_REST_PORT = 2735;
    }

    public void testCreate() throws Exception {
        CmdContainerCreate createCmd =  CmdContainerCreate.newInstance("d_test");
        Result result = createCmd.image("alpine").network("HostNetwork")
                .volume("v_tx:/v_tx").link("dockerfly:dockerfly")
                .cmd("ping","127.0.0.1").env("author=helyho")
                .exposePort(22,"tcp","2222").send();
        createCmd.close();
        Logger.info(result);
    }

    public void testInfo() throws Exception {
        CmdContainersList cmdContainersList = CmdContainersList.newInstance();
        Logger.info(cmdContainersList.send().size());
        cmdContainersList.close();
    }

    public void testUpdate() throws Exception {
        CmdContainerUpdate updateCmd =  CmdContainerUpdate.newInstance("d_test");
        Result result = updateCmd.cpuPeriod(1000000).memory(250).send();
        updateCmd.close();
        Logger.info(result);
    }
}
