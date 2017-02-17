package org.voovan.docker.command.Volume;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.network.DockerClientException;
import org.voovan.docker.network.Result;

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
public class CmdVolumePrune extends Cmd {
    private Map<String,List<String>> filters;

    public CmdVolumePrune() {
        filters = new HashMap<String,List<String>>();
    }

    public static CmdVolumePrune newInstance(String nameOrId){
        return new CmdVolumePrune();
    }

    @Override
    public String send() throws Exception {
        Result result = getDockerHttpClient().run("POST","/containers/prune", getParameters());
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return result.getMessage();
        }
    }
}
