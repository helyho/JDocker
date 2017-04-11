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
public class CmdContainerKill extends Cmd {
    private String nameOrId;

    public CmdContainerKill(String nameOrId) {
        this.nameOrId = nameOrId;
    }

    public CmdContainerKill signal(boolean signal){
        addParameter("signal", signal);
        return this;
    }

    public static CmdContainerKill newInstance(String nameOrId){
        return new CmdContainerKill(nameOrId);
    }

    @Override
    public String send() throws Exception {
        Result result = getDockerHttpClient().run("POST","/containers/"+nameOrId+"/kill", getParameters());
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return result.getMessage();
        }
    }
}
