package org.voovan.docker.client.Command.Container;

import org.voovan.docker.client.Command.Cmd;
import org.voovan.docker.client.network.DockerClientException;
import org.voovan.docker.client.network.Result;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class CmdContainerLogs extends Cmd {
    private String nameOrId;

    public CmdContainerLogs(String nameOrId) {
        this.nameOrId = nameOrId;
        addParameter("stderr",1);
        addParameter("stdout",1);
        addParameter("tail",100);
    }

    public CmdContainerLogs timestamps(boolean timestamps){
        addParameter("timestamps",timestamps);
        return this;
    }

    public CmdContainerLogs tail(int tail){
        addParameter("tail",tail);
        return this;
    }

    public CmdContainerLogs details(boolean details){
        addParameter("details",details);
        return this;
    }

    public static CmdContainerLogs newInstance(String nameOrId){
        return new CmdContainerLogs(nameOrId);
    }

    @Override
    public Result send() throws Exception {
        Result result = getDockerHttpClient().get("/containers/"+nameOrId+"/logs", getParameters());
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return result;
        }
    }
}
