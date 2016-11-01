package org.voovan.docker.command.Swarm;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.Swarm.SwarmInfo;
import org.voovan.docker.message.service.ServiceInfo;
import org.voovan.docker.network.DockerClientException;
import org.voovan.docker.network.Result;
import org.voovan.tools.TObject;
import org.voovan.tools.json.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class CmdSwarmInfo extends Cmd {

    public CmdSwarmInfo() {
    }

    public static CmdSwarmInfo newInstance(){
        return new CmdSwarmInfo();
    }

    @Override
    public SwarmInfo send() throws Exception {
        Result result = getDockerHttpClient().get("/swarm",getParameters());
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return SwarmInfo.load(result.getMessage());
        }

    }

}
