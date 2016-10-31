package org.voovan.docker.client.Command.Image;

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
public class CmdImageRemove extends Cmd {

    private String nameOrId;

    public CmdImageRemove(String nameOrId){
        this.nameOrId = nameOrId;
    }

    public CmdImageRemove repo(String repo){
        addParameter("repo",repo);
        return this;
    }

    public CmdImageRemove tag(String tag){
        addParameter("tag",tag);
        return this;
    }

    public static CmdImageRemove newInstance(String nameOrId) {
        return new CmdImageRemove(nameOrId);
    }

    @Override
    public Result send() throws Exception {
        Result result = getDockerHttpClient().delete("/images/"+nameOrId,getParameters());
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return  result;
        }

    }
}
