package org.voovan.docker.command.Container;

import org.voovan.docker.command.Cmd;
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
    public String send() throws Exception {
        Result result = getDockerHttpClient().post("/containers/"+nameOrId+"/restart", getParameters());
        if(result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return result.getMessage();
        }
    }
}
