package org.voovan.docker.command.Container;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.network.DockerClientException;
import org.voovan.docker.network.Result;
import org.voovan.docker.message.container.ContainerProcess;
import org.voovan.docker.message.container.atom.Process;

import java.util.List;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class CmdContainerTop extends Cmd {
    private String nameOrId;
    private String paArgs;

    public CmdContainerTop(String nameOrId) {
        this.nameOrId = nameOrId;
    }

    public CmdContainerTop psArgs(String paArgs){
        addParameter("ps_args",paArgs);
        return this;
    }

    public static CmdContainerTop newInstance(String nameOrId){
        return new CmdContainerTop(nameOrId);
    }

    @Override
    public List<Process> send() throws Exception {
        Result result = getDockerHttpClient().get("/containers/"+nameOrId+"/top", getParameters());
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return ContainerProcess.load(result.getMessage());
        }
    }
}
