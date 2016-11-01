package org.voovan.docker.test.command;

import junit.framework.TestCase;
import org.voovan.docker.command.Service.CmdServiceCreate;
import org.voovan.docker.command.Service.CmdServiceList;
import org.voovan.docker.command.Service.CmdServiceRemove;
import org.voovan.docker.command.Service.CmdServiceUpdate;
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
public class ServiceUtil extends TestCase {

    public void setUp(){
        Global.DOCKER_REST_HOST = "127.0.0.1";
        Global.DOCKER_REST_PORT = 2735;
        Global.DEBUG = true;
    }

    public String formatJSON(Object obj){
        return JSON.formatJson(JSON.toJSON(obj));
    }

    public void testServiceCreate() throws Exception {
        CmdServiceCreate cmdServiceCreate = CmdServiceCreate.newInstance();
        Object data = cmdServiceCreate.name("helyho").image("alpine").cmd("ping","127.0.0.1")
                .network("voovan_p").mountReadWrite("v_t1","/v_t1").replicate(4).portTcp(223,22233).send();
        cmdServiceCreate.close();
        Logger.info(formatJSON(data));
    }

    public void testServiceList() throws Exception {
        CmdServiceList cmdServiceList = CmdServiceList.newInstance();
        Object data = cmdServiceList.name("helyho").send();
        cmdServiceList.close();
        Logger.info(formatJSON(data));
    }

    public void testServiceUpdate() throws Exception {
        CmdServiceUpdate cmdServiceUpdate = new CmdServiceUpdate("3jfu6sx9wc1dqngiv4oqzvgdj",42);
        Object data = cmdServiceUpdate.name("helyho1111").image("alpine").cmd("ping","127.0.0.1")
                .network("voovan_p").mountReadWrite("v_tx","/v_tx").replicate(1).portTcp(223,22233).send();
        cmdServiceUpdate.close();
        Logger.info(formatJSON(data));
    }

    public void testServiceRemove() throws Exception {
        CmdServiceRemove cmdServiceRemove = new CmdServiceRemove("75tlqcvv56l2fitoqtdc169dv");
        Object data = cmdServiceRemove.send();
        cmdServiceRemove.close();
        Logger.info(formatJSON(data));
    }

}