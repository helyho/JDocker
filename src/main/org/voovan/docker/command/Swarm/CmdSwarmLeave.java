package org.voovan.docker.command.Swarm;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.Swarm.SwarmInfo;
import org.voovan.docker.network.DockerClientException;
import org.voovan.docker.network.Result;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class CmdSwarmLeave extends Cmd {

    public CmdSwarmLeave() {
    }

    public static CmdSwarmLeave newInstance(){
        return new CmdSwarmLeave();
    }

    @Override
    public SwarmInfo send() throws Exception {
        Result result = getDockerHttpClient().post("/swarm/leave",getParameters(),null);
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return SwarmInfo.load(result.getMessage());
        }

    }

}
