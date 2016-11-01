package org.voovan.docker.command.Task;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.Task.TaskInfo;
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
public class CmdTaskList extends Cmd {

    public CmdTaskList() {
    }


    public static CmdTaskList newInstance(){
        return new CmdTaskList();
    }

    @Override
    public List<TaskInfo> send() throws Exception {
        Result result = getDockerHttpClient().get("/tasks",getParameters());
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return TaskInfo.load(result.getMessage());
        }

    }

}
