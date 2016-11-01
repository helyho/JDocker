package org.voovan.docker.command.Node;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.Node.NodeInfo;
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
public class CmdNodeList extends Cmd {

    private String nameOrId;

    public CmdNodeList(String nameOrId) {
        this.nameOrId = nameOrId;
    }


    public static CmdNodeList newInstance(String nameOrId){
        return new CmdNodeList(nameOrId);
    }

    public static CmdNodeList newInstance(){
        return new CmdNodeList("");
    }

    @Override
    public List<NodeInfo> send() throws Exception {
        Result result = getDockerHttpClient().get("/nodes/"+nameOrId,getParameters());
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return NodeInfo.load(result.getMessage());
        }

    }

}
