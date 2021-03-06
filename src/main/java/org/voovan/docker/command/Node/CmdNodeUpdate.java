package org.voovan.docker.command.Node;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.node.NodeUpdate;
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
public class CmdNodeUpdate extends Cmd {

    private String nameOrId;
    private NodeUpdate nodeUpdate;

    public CmdNodeUpdate(String nameOrId,Integer version) {
        this.nameOrId = nameOrId;
        addParameter("version",version);
        this.nodeUpdate = new NodeUpdate();
    }

    public CmdNodeUpdate name(String name){
        nodeUpdate.setName(name);
        return this;
    }

    public CmdNodeUpdate role(String role){
        nodeUpdate.setRole(role);
        return this;
    }

    public CmdNodeUpdate availability(String availability){
        nodeUpdate.setAvailability(availability);
        return this;
    }

    public CmdNodeUpdate label(String key,String value){
        nodeUpdate.getLabels().put(key, value);
        return this;
    }

    public NodeUpdate getEntity(){
        return nodeUpdate;
    }

    public static CmdNodeUpdate newInstance(String id, Integer version){
        return new CmdNodeUpdate(id,version);
    }

    @Override
    public List<TaskInfo> send() throws Exception {
        Result result = getDockerHttpClient().run("POST","/nodes/"+nameOrId+"/update",getParameters(),nodeUpdate);
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return TaskInfo.load(result.getMessage());
        }

    }

}
