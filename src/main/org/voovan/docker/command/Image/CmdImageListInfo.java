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
public class CmdImageListInfo extends Cmd {

    private Map<String,List<String>> filters;

    public CmdImageListInfo() {
        filters = new HashMap<String,List<String>>();
    }

    public CmdImageListInfo all(Boolean all){
        addParameter("all",all);
        return this;
    }

    public CmdImageListInfo dangling(Boolean dangling){
        filters.put("dangling",TObject.newList(dangling));
        return this;
    }

    public CmdImageListInfo label(String key, Object value){
        filters.put("label", TObject.newList(key+"="+value));
        return this;
    }

    public CmdImageListInfo before(String ... before){
        filters.put("before",TObject.newList(before));
        return this;
    }

    public CmdImageListInfo since(String ... since){
        filters.put("since",TObject.newList(since));
        return this;
    }

    public CmdImageListInfo filter(String ... filter){
        addParameter("filter",TObject.newList(filter));
        return this;
    }

    public static CmdImageListInfo newInstance() {
        return new CmdImageListInfo();
    }

    @Override
    public List<ImageListInfo> send() throws Exception {
        addParameter("filters", JSON.toJSON(filters));
        Result result = getDockerHttpClient().get("/images/json",getParameters());
        if(result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return ImageListInfo.load(result.getMessage());
        }

    }
}
