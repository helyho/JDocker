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
public class CmdContainerReStart extends Cmd {
    private String nameOrId;

    public CmdContainerReStart(String nameOrId) {
        this.nameOrId = nameOrId;
    }

    public CmdContainerReStart waitForKill(int waitForKill){
        addParameter("t",waitForKill);
        return this;
    }

    public static CmdContainerReStart newInstance(String nameOrId){
        return new CmdContainerReStart(nameOrId);
    }

    @Override
    public Result send() throws Exception {
        Result result = getDockerHttpClient().post("/containers/"+nameOrId+"/restart", getParameters(),null);
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return result;
        }
    }
}
