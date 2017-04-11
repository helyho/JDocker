package org.voovan.docker.test.command;

import junit.framework.TestCase;
import org.voovan.docker.DockerGlobal;
import org.voovan.docker.command.Volume.CmdVolumeCreate;
import org.voovan.docker.command.Volume.CmdVolumeList;
import org.voovan.docker.command.Volume.CmdVolumeRemove;
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
public class VolumeUtil extends TestCase {

    public void setUp(){
        DockerGlobal.DOCKER_REST_HOST = "127.0.0.1";
        DockerGlobal.DOCKER_REST_PORT = 2735;
        DockerGlobal.DEBUG = true;
    }

    public String formatJSON(Object obj){
        return JSON.formatJson(JSON.toJSON(obj));
    }

    public void testVolumeCreate() throws Exception {
        CmdVolumeCreate cmdVolumeCreate = CmdVolumeCreate.newInstance();
        cmdVolumeCreate.connect();
        Object data = cmdVolumeCreate.name("v_helyho").driver("local").label("adfad","1111")
                .label("1212","122233443").send();
        cmdVolumeCreate.close();
        Logger.info(formatJSON(data));
    }

    public void testVolumeList() throws Exception {
        CmdVolumeList cmdVolumeList = CmdVolumeList.newInstance();
        cmdVolumeList.connect();
        Object data = cmdVolumeList.send();
        cmdVolumeList.close();
        Logger.info(formatJSON(data));
    }


    public void testVolumeRemove() throws Exception {
        CmdVolumeRemove cmdVolumeRemove = CmdVolumeRemove.newInstance("v_helyho");
        cmdVolumeRemove.connect();
        Object data = cmdVolumeRemove.send();
        cmdVolumeRemove.close();
        Logger.info(formatJSON(data));
    }

}
