package org.voovan.docker.command.Image;

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
public class CmdImageRemove extends Cmd {

    private String nameOrId;

    public CmdImageRemove(String nameOrId){
        this.nameOrId = nameOrId;
    }

    public CmdImageRemove force(boolean force){
        addParameter("force",force);
        return this;
    }

    public CmdImageRemove noprune(boolean noprune){
        addParameter("noprune",noprune);
        return this;
    }

    public static CmdImageRemove newInstance(String nameOrId) {
        return new CmdImageRemove(nameOrId);
    }

    @Override
    public String send() throws Exception {
        Result result = getDockerHttpClient().run("DELETE","/images/"+nameOrId,getParameters());
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return  result.getMessage();
        }
    }
}
