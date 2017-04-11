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
public class CmdContainerAttach extends Cmd {

    private String nameOrId;

    public CmdContainerAttach(String nameOrId) {
        this.nameOrId = nameOrId;
        addParameter("detachKeys","ctrl-p,ctrl-q");
    }

    public CmdContainerAttach detachKeys(String detachKeys){
        addParameter("detachKeys",detachKeys);
        return this;
    }

    public CmdContainerAttach logs(boolean logs){
        addParameter("logs", logs);
        return this;
    }

    public CmdContainerAttach stream(boolean stream){
        addParameter("stream", stream);
        return this;
    }

    public CmdContainerAttach stdin(boolean stdin){
        addParameter("stdin", stdin);
        return this;
    }

    public CmdContainerAttach stdout(boolean stdout){
        addParameter("stdout", stdout);
        return this;
    }

    public CmdContainerAttach stderr(boolean stderr){
        addParameter("stderr", stderr);
        return this;
    }
    public static CmdContainerAttach newInstance(String nameOrId){
        return new CmdContainerAttach(nameOrId);
    }

    @Override
    public String send() throws Exception {
        Result result = getDockerHttpClient().run("POST","/containers/"+nameOrId+"/attach", getParameters());
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return result.getMessage();
        }
    }
}
