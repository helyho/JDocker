package org.voovan.docker.command.Task;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.task.TaskInfo;
import org.voovan.docker.network.DockerClientException;
import org.voovan.docker.network.Result;
import org.voovan.tools.TObject;
import org.voovan.tools.json.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private Map<String,List<String>> filters;

    public CmdTaskList() {
        filters = new HashMap<String,List<String>>();
    }

    public CmdTaskList id(String ...id){
        filters.put("id",TObject.newList(id));
        return this;
    }

    public CmdTaskList service(String service){
        filters.put("service",TObject.newList(service));
        return this;
    }

    public CmdTaskList node(String node){
        filters.put("node",TObject.newList(node));
        return this;
    }

    public CmdTaskList label(String key, String value){
        filters.put("label",TObject.newList(key+"="+value));
        return this;
    }


    public CmdTaskList desiredState(String desiredState){
        filters.put("desired-state",TObject.newList(desiredState));
        return this;
    }

    public static CmdTaskList newInstance(){
        return new CmdTaskList();
    }

    @Override
    public List<TaskInfo> send() throws Exception {
        addParameter("filters", JSON.toJSON(filters));
        Result result = getDockerHttpClient().run("GET","/tasks",getParameters());
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return TaskInfo.load(result.getMessage());
        }

    }

}
