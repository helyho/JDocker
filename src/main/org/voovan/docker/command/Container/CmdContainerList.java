package org.voovan.docker.command.Container;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.container.ContainerInfo;
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
public class CmdContainerList extends Cmd {
    private boolean all;
    private int limit;
    private String since;
    private String before;
    private boolean size;
    private Map<String,List<String>> filters;

    public CmdContainerList() {
        filters = new HashMap<String,List<String>>();
    }

    public CmdContainerList name(String name){
        filters.put("name", TObject.newList(name));
        return this;
    }

    public CmdContainerList id(String id){
        filters.put("id", TObject.newList(id));
        return this;
    }

    public CmdContainerList all(boolean all){
        addParameter("all",all);
        return this;
    }

    public CmdContainerList limit(int limit){
        addParameter("limit",limit);
        return this;
    }

    public CmdContainerList since(String since){
        addParameter("since",since);
        return this;
    }

    public CmdContainerList before(String before){
        addParameter("before",before);
        return this;
    }

    public CmdContainerList showSize(boolean size){
        addParameter("size",size);
        return this;
    }

    public CmdContainerList status(String ... status){
        filters.put("status", TObject.newList(status));
        return this;
    }

    public CmdContainerList label(String key, Object value){
        filters.put("label", TObject.newList(key+"="+value));
        return this;
    }

    public CmdContainerList image(String ... imagename){
        filters.put("image", TObject.newList(imagename));
        return this;
    }

    public CmdContainerList volume(String ... volume){
        filters.put("Volume", TObject.newList(volume));
        return this;
    }

    public CmdContainerList network(String ... network){
        filters.put("network", TObject.newList(network));
        return this;
    }

    public static CmdContainerList newInstance(){
        return new CmdContainerList();
    }

    @Override
    public List<ContainerInfo>  send() throws Exception {
        addParameter("filters", JSON.toJSON(filters));

        Result result = getDockerHttpClient().get("/containers/json", getParameters());
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return ContainerInfo.load(result.getMessage());
        }
    }

}
