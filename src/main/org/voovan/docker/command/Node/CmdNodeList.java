package org.voovan.docker.command.Node;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.node.NodeInfo;
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
public class CmdNodeList extends Cmd {

    private Map<String,List<String>> filters;

    public CmdNodeList() {
        filters = new HashMap<String,List<String>>();
    }


    public CmdNodeList id(String ...id){
       filters.put("id", TObject.newList(id));
        return this;
    }

    public CmdNodeList membership(String ... membership){
        filters.put("membership", TObject.newList(membership));
        return this;
    }

    public CmdNodeList role(String role){
        filters.put("role", TObject.newList(role));
        return this;
    }

    public static CmdNodeList newInstance(){
        return new CmdNodeList();
    }


    @Override
    public List<NodeInfo> send() throws Exception {
        addParameter("filters", JSON.toJSON(filters));
        Result result = getDockerHttpClient().get("/nodes",getParameters());
        if(result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return NodeInfo.load(result.getMessage());
        }

    }

}
