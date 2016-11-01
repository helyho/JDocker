package org.voovan.docker.command.Service;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.network.DockerClientException;
import org.voovan.docker.network.Result;
import org.voovan.docker.message.service.ServiceInfo;
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
public class CmdServiceList extends Cmd {
    private Map<String,List<String>> filters;

    public CmdServiceList() {
        filters = new HashMap<String,List<String>>();
    }

    public CmdServiceList id(String id){
        filters.put("id", TObject.newList(id));
        return this;
    }

    public CmdServiceList name(String name){
        filters.put("name", TObject.newList(name));
        return this;
    }

    public static CmdServiceList newInstance(){
        return new CmdServiceList();
    }

    @Override
    public List<ServiceInfo> send() throws Exception {
        addParameter("filters", JSON.toJSON(filters));
        Result result = getDockerHttpClient().get("/services",getParameters());
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return ServiceInfo.load(result.getMessage());
        }

    }

}