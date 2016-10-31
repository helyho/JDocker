package org.voovan.docker.client.Command.Image;

import org.voovan.docker.client.Command.Cmd;
import org.voovan.docker.client.network.DockerClientException;
import org.voovan.docker.client.network.Result;
import org.voovan.docker.message.Image.ImageListInfo;
import org.voovan.tools.TObject;

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
        addParameter("filters",filters);
    }

    public CmdImageListInfo all(Boolean all){
        addParameter("all",all);
        return this;
    }

    public CmdImageListInfo dangling(Boolean dangling){
        filters.put("dangling",TObject.newList(dangling));
        return this;
    }

    public CmdImageListInfo label(String key, String value){
        filters.put("label", TObject.newList(key+"="+value));
        return this;
    }

    public CmdImageListInfo before(String ... before){
        addParameter("before",TObject.newList(before));
        return this;
    }

    public CmdImageListInfo since(String ... since){
        addParameter("since",TObject.newList(since));
        return this;
    }

    public static CmdImageListInfo newInstance() {
        return new CmdImageListInfo();
    }

    @Override
    public List<ImageListInfo> send() throws Exception {
        Result result = getDockerHttpClient().get("/images/json",getParameters());
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return ImageListInfo.load(result.getMessage());
        }

    }
}
