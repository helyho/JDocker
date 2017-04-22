package org.voovan.docker.test.command;

import junit.framework.TestCase;
import org.voovan.docker.DockerGlobal;
import org.voovan.docker.command.Network.*;
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
public class NetworkUtil extends TestCase {

    public void setUp() {
        DockerGlobal.DOCKER_REST_HOST = "192.168.99.103";
        DockerGlobal.DOCKER_REST_PORT = 2735;
        DockerGlobal.DEBUG = true;
    }

    public String formatJSON(Object obj) {
        return JSON.formatJson(JSON.toJSON(obj));
    }

    public void testNetworkList() throws Exception {
        CmdNetworkList cmdNetworkList = CmdNetworkList.newInstance();
        cmdNetworkList.connect();
        Object data = cmdNetworkList.name("bridge").send();
        cmdNetworkList.close();
        Logger.info(formatJSON(data));
    }

    public void testNetworkInfo() throws Exception {
        CmdNetworkInfo cmdNetworkInfo = CmdNetworkInfo.newInstance("bridge");
        cmdNetworkInfo.connect();
        Object data = cmdNetworkInfo.send();
        cmdNetworkInfo.close();
        Logger.info(formatJSON(data));
    }

    public void testNetworkCreate() throws Exception {
        CmdNetworkCreate cmdNetworkCreate = CmdNetworkCreate.newInstance();
        cmdNetworkCreate.connect();
        Object data = cmdNetworkCreate.name("voovan_p").driver("overlay").label("adfadf","dfadfadf").ipamConfig().send();
        cmdNetworkCreate.close();
        Logger.info(formatJSON(data));
    }

    public void testNetworkRemove() throws Exception {
        CmdNetworkRemove cmdNetworkRemove = CmdNetworkRemove.newInstance("50berova8jjttexezcfgofg17");
        cmdNetworkRemove.connect();
        Object data = cmdNetworkRemove.send();
        cmdNetworkRemove.close();
        Logger.info(formatJSON(data));
    }

    public void testNetworkConnect() throws Exception {
        CmdNetworkConnect cmdNetworkConnect = CmdNetworkConnect.newInstance("voovan_bridge");
        cmdNetworkConnect.connect();
        cmdNetworkConnect.container("voovan");
        cmdNetworkConnect.ipv4Address("10.1.1.39");
        Object data = cmdNetworkConnect.send();
        cmdNetworkConnect.close();
        Logger.info(formatJSON(data));
    }

    public void testNetworkDisConnect() throws Exception {
        CmdNetworkDisConnect cmdNetworkDisConnect = CmdNetworkDisConnect.newInstance("voovan_bridge");
        cmdNetworkDisConnect.connect();
        cmdNetworkDisConnect.container("voovan");
        Object data = cmdNetworkDisConnect.send();
        cmdNetworkDisConnect.close();
        Logger.info(formatJSON(data));
    }
}


