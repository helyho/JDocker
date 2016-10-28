package org.voovan.docker.client.Command.Container;

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
public class CmdContainerCommit extends Cmd {

    public CmdContainerCommit(String nameOrId) {
        addParameter("container",nameOrId);
    }

    public CmdContainerCommit repo(String repo){
        addParameter("repo",repo);
        return this;
    }

    public CmdContainerCommit tag(String tag){
        addParameter("tag",tag);
        return this;
    }

    public CmdContainerCommit comment(String comment){
        addParameter("comment",comment);
        return this;
    }

    public CmdContainerCommit author(String author){
        addParameter("author",author);
        return this;
    }
    public CmdContainerCommit pause(boolean pause){
        addParameter("pause",pause);
        return this;
    }
    public CmdContainerCommit changes(String changes){
        addParameter("changes",changes);
        return this;
    }
    public static CmdContainerCommit newInstance(String nameOrId){
        return new CmdContainerCommit(nameOrId);
    }

    @Override
    public Result send() throws Exception {
        Result result = getDockerHttpClient().post("/commit", getParameters(),null);
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return result;
        }
    }
}
