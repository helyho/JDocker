package org.voovan.docker.command.Volume;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.Volume.Volume;
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
public class CmdVolumeList extends Cmd{

    private Map<String,List<String>> filters;

    public CmdVolumeList() {
        filters = new HashMap<String,List<String>>();
    }


    public CmdVolumeList name(String name){
        filters.put("name", TObject.newList(name));
        return this;
    }

    public CmdVolumeList dangling(boolean dangling){
        filters.put("dangling", TObject.newList(dangling));
        return this;
    }

    public CmdVolumeList driver(String driver){
        filters.put("driver", TObject.newList(driver));
        return this;
    }

    public static CmdVolumeList newInstance(){
        return new CmdVolumeList();
    }

    @Override
    public List<Volume> send() throws Exception {
        addParameter("filters", JSON.toJSON(filters));

        Result result = getDockerHttpClient().get("/volumes",getParameters());
        if(result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return Volume.load(result.getMessage());
        }

    }
}
