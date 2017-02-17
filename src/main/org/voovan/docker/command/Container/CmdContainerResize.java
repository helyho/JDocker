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
public class CmdContainerResize extends Cmd {

    private String nameOrId;

    public CmdContainerResize(String nameOrId) {
        this.nameOrId = nameOrId;
    }

    public CmdContainerResize height(int height){
        addParameter("h",height);
        return this;
    }

    public CmdContainerResize width(int width){
        addParameter("w", width);
        return this;
    }

    public static CmdContainerResize newInstance(String nameOrId){
        return new CmdContainerResize(nameOrId);
    }

    @Override
    public String send() throws Exception {
        Result result = getDockerHttpClient().run("POST","/containers/"+nameOrId+"/resize", getParameters());
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return result.getMessage();
        }
    }
}
