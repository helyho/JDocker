package org.voovan.docker.test.command;

import junit.framework.TestCase;
import org.voovan.docker.command.Image.*;
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
public class ImageUtil extends TestCase {

    public void setUp(){
        Global.DOCKER_REST_HOST = "127.0.0.1";
        Global.DOCKER_REST_PORT = 2735;
        Global.DEBUG = true;
    }

    public String formatJSON(Object obj){
        return JSON.formatJson(JSON.toJSON(obj));
    }

    public void testHubImageInfo() throws Exception {
        CmdHubImageInfo cmdHubImageInfo =  CmdHubImageInfo.newInstance();
        Object data = cmdHubImageInfo.limit(10).term("ubuntu").send();
        cmdHubImageInfo.close();
        Logger.info(formatJSON(data));
    }

    public void testImageHistory() throws Exception {
        CmdImageHistroy cmdImageHistroy =  CmdImageHistroy.newInstance("dockerfly");
        Object data = cmdImageHistroy.send();
        cmdImageHistroy.close();
        Logger.info(formatJSON(data));
    }

    public void testImageTag() throws Exception {
        CmdImageTag cmdImageTag =  CmdImageTag.newInstance("dockerfly");
        Object data = cmdImageTag.repo("prog").tag("1031").send();
        cmdImageTag.close();
        Logger.info(formatJSON(data));
    }

    public void testImageInfo() throws Exception {
        CmdImageListInfo cmdImageInfo =  CmdImageListInfo.newInstance();
        Object data = cmdImageInfo.send();
        cmdImageInfo.close();
        Logger.info(formatJSON(data));
    }

    public void testImageRemove() throws Exception {
        CmdImageRemove cmdImageRemove =  CmdImageRemove.newInstance("prog:1031");
        Object data = cmdImageRemove.send();
        cmdImageRemove.close();
        Logger.info(formatJSON(data));
    }

    public void testImageCreate() throws Exception {
        Global.DOCKER_REST_TIMEOUT = 60;
        CmdImageCreate cmdImageCreate = CmdImageCreate.newInstance();
        Object data = cmdImageCreate.fromImage("alpine:3.2").send();
        cmdImageCreate.close();
        Logger.info(formatJSON(data));
    }
}
