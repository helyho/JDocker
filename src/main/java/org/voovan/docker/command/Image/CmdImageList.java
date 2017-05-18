package org.voovan.docker.command.Image;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.Image.ImageListInfo;
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
public class CmdImageList extends Cmd {

    private Map<String,List<String>> filters;

    public CmdImageList() {
        filters = new HashMap<String,List<String>>();
    }

    public CmdImageList all(Boolean all){
        addParameter("all",all);
        return this;
    }

    public CmdImageList dangling(Boolean dangling){
        filters.put("dangling",TObject.asList(dangling));
        return this;
    }

    public CmdImageList label(String key, String value){
        filters.put("label", TObject.asList(key+"="+value));
        return this;
    }

    public CmdImageList before(String ... before){
        filters.put("before",TObject.asList(before));
        return this;
    }

    public CmdImageList since(String ... since){
        filters.put("since",TObject.asList(since));
        return this;
    }

    public CmdImageList filter(String filter){
        addParameter("filter",filter);
        return this;
    }

    //v1.25
    public CmdImageList reference(String reference){
        addParameter("reference",reference);
        return this;
    }


    public static CmdImageList newInstance() {
        return new CmdImageList();
    }

    @Override
    public List<ImageListInfo> send() throws Exception {
        addParameter("filters", JSON.toJSON(filters));
        Result result = getDockerHttpClient().run("GET","/images/json",getParameters());
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return ImageListInfo.load(result.getMessage());
        }

    }
}
