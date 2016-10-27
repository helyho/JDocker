package org.voovan.docker.test.client.Command.container;

import org.voovan.docker.client.Command.Contianer.CmdContainerCreate;
import org.voovan.docker.client.Global;
import org.voovan.docker.client.network.Result;
import org.voovan.network.exception.ReadMessageException;
import org.voovan.network.exception.SendMessageException;
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
public class CreateTest {

    public static void main(String[] args) throws SendMessageException, ReadMessageException {
        Global.DOCKER_REST_HOST = "127.0.0.1";
        Global.DOCKER_REST_PORT = 2735;

        CmdContainerCreate createCmd = new CmdContainerCreate();
        Result result = createCmd.setName("d_test").image("alpine").network("HostNetwork")
                .volume("v_tx:/v_tx").link("dockerfly:dockerfly")
                .cmd("ping","127.0.0.1").env("author=helyho")
                .exposePort(22,"tcp","2222").send();
        createCmd.close();
        Logger.info("------");
    }
}
