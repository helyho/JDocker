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
public class CmdImageTag extends Cmd {

    private String nameOrId;

    public  CmdImageTag(String nameOrId){
        this.nameOrId = nameOrId;
    }

    public CmdImageTag repo(String repo){
        addParameter("repo",repo);
        return this;
    }

    public CmdImageTag tag(String tag){
        addParameter("tag",tag);
        return this;
    }

    public static CmdImageTag newInstance(String nameOrId) {
        return new CmdImageTag(nameOrId);
    }

    @Override
    public String send() throws Exception {
        Result result = getDockerHttpClient().post("/images/"+nameOrId+"/tag",getParameters());
        if(result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return  result.getMessage();
        }

    }
}
