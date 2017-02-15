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
public class CmdContainerRename extends Cmd {
    private String nameOrId;

    public CmdContainerRename(String nameOrId) {
        this.nameOrId = nameOrId;
    }

    public CmdContainerRename newName(String name){
        addParameter("name",name);
        return this;
    }

    public static CmdContainerRename newInstance(String nameOrId){
        return new CmdContainerRename(nameOrId);
    }

    @Override
    public String send() throws Exception {
        Result result = getDockerHttpClient().post("/containers/"+nameOrId+"/rename", getParameters());
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return result.getMessage();
        }
    }
}
