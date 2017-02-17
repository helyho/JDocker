package org.voovan.docker.command.Network;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.network.NetworkInfo;
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
public class CmdNetworkList extends Cmd{
    private Map<String,List<String>> filters;

    public CmdNetworkList() {
        filters = new HashMap<String,List<String>>();
    }


    public CmdNetworkList name(String ...name){
        filters.put("name", TObject.newList(name));
        return this;
    }
    public CmdNetworkList id(String ...id){
        filters.put("id", TObject.newList(id));
        return this;
    }
    public CmdNetworkList driver(String driver){
        filters.put("driver", TObject.newList(driver));
        return this;
    }
    public CmdNetworkList label(String key, Object value){
        filters.put("label", TObject.newList(key+"="+value));
        return this;
    }

    public CmdNetworkList type(String type){
        filters.put("type", TObject.newList(type));
        return this;
    }

    public static CmdNetworkList newInstance(){
        return new CmdNetworkList();
    }

    @Override
    public List<NetworkInfo> send() throws Exception {
        addParameter("filters", JSON.toJSON(filters));
        Result result = getDockerHttpClient().run("GET","/networks",getParameters());
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return NetworkInfo.load(result.getMessage());
        }

    }
}
