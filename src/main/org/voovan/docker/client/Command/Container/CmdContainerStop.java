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
public class CmdContainerStop extends Cmd {
    private String nameOrId;

    public CmdContainerStop(String nameOrId) {
        this.nameOrId = nameOrId;
    }

    public CmdContainerStop waitForKill(int waitForKill){
        addParameter("t",waitForKill);
        return this;
    }

    public static CmdContainerStop newInstance(String nameOrId){
        return new CmdContainerStop(nameOrId);
    }

    @Override
    public Result send() throws Exception {
        Result result = getDockerHttpClient().post("/containers/"+nameOrId+"/stop", getParameters(),null);
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return result;
        }
    }
}
