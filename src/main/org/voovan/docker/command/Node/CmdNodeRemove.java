package org.voovan.docker.command.Node;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.task.TaskInfo;
import org.voovan.docker.network.DockerClientException;
import org.voovan.docker.network.Result;

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
public class CmdNodeRemove extends Cmd {

    private String id;

    public CmdNodeRemove(String id) {
        this.id = id;
    }

    public CmdNodeRemove force(boolean force){
        addParameter("force",force);
        return this;
    }


    public static CmdNodeRemove newInstance(String id){
        return new CmdNodeRemove(id);
    }

    @Override
    public List<TaskInfo> send() throws Exception {
        Result result = getDockerHttpClient().delete("/nodes/"+id,getParameters());
        if(result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return TaskInfo.load(result.getMessage());
        }

    }

}
