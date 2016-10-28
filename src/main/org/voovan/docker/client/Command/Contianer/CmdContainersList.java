package org.voovan.docker.client.Command.Contianer;

import org.voovan.docker.client.Command.Cmd;
import org.voovan.docker.client.network.DockerClientException;
import org.voovan.docker.client.network.Result;
import org.voovan.docker.message.container.ContainerInfo;
import org.voovan.docker.message.network.atom.Container;
import org.voovan.network.exception.ReadMessageException;
import org.voovan.network.exception.SendMessageException;
import org.voovan.tools.TObject;

import java.text.ParseException;
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
public class CmdContainersList extends Cmd {
    private boolean all;
    private int limit;
    private String since;
    private String before;
    private boolean size;
    private Map<String,List<String>> filters;

    public CmdContainersList() {
        filters = new HashMap<String,List<String>>();
        addParameter("filters",filters);
    }

    public CmdContainersList all(boolean all){
        addParameter("all",all);
        return this;
    }

    public CmdContainersList limit(int limit){
        addParameter("limit",limit);
        return this;
    }

    public CmdContainersList since(String since){
        addParameter("since",since);
        return this;
    }

    public CmdContainersList before(String before){
        addParameter("before",before);
        return this;
    }

    public CmdContainersList showSize(boolean size){
        addParameter("size",size);
        return this;
    }

    public CmdContainersList status(String ... status){
        filters.put("status", TObject.newList(status));
        return this;
    }

    public CmdContainersList label(String key, String value){
        filters.put("label", TObject.newList(key+"="+value));
        return this;
    }

    public CmdContainersList image(String ... imagename){
        filters.put("image", TObject.newList(imagename));
        return this;
    }

    public CmdContainersList volume(String ... volume){
        filters.put("volume", TObject.newList(volume));
        return this;
    }

    public CmdContainersList network(String ... network){
        filters.put("network", TObject.newList(network));
        return this;
    }

    public static CmdContainersList newInstance(){
        return new CmdContainersList();
    }

    @Override
    public List<ContainerInfo>  send() throws Exception {
        Result result = getDockerHttpClient().get("/containers/json", getParameters());
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return ContainerInfo.load(result.getMessage());
        }
    }

}
