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
public class CmdContainerRemove extends Cmd{
    private String nameOrId;

    public CmdContainerRemove(String nameOrId) {
        this.nameOrId = nameOrId;
    }

    public CmdContainerRemove force(boolean force){
        addParameter("force",force);
        return this;
    }

    public CmdContainerRemove volume(boolean volume){
        addParameter("volume",volume);
        return this;
    }

    public static CmdContainerRemove newInstance(String nameOrId){
        return new CmdContainerRemove(nameOrId);
    }

    @Override
    public String send() throws Exception {
        Result result = getDockerHttpClient().run("DELETE","/containers/"+nameOrId, getParameters());
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return result.getMessage();
        }
    }
}
