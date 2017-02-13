package org.voovan.docker.command.Image;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.network.DockerClientException;
import org.voovan.docker.network.Result;
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
public class CmdImagePrune extends Cmd {

    private Map<String,List<String>> filters;

    public CmdImagePrune() {
        filters = new HashMap<String,List<String>>();
    }

    public static CmdImagePrune newInstance(String nameOrId){
        return new CmdImagePrune();
    }

    public CmdImagePrune dangling(Boolean dangling){
        filters.put("dangling", TObject.newList(dangling));
        return this;
    }

    @Override
    public String send() throws Exception {
        Result result = getDockerHttpClient().post("/images/prune", getParameters());
        if(result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return result.getMessage();
        }
    }
}
