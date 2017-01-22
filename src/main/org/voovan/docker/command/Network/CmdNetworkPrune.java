package org.voovan.docker.command.Network;

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
public class CmdNetworkPrune extends Cmd {
    private Map<String,List<String>> filters;

    public CmdNetworkPrune() {
        filters = new HashMap<String,List<String>>();
    }

    public static CmdNetworkPrune newInstance(String nameOrId){
        return new CmdNetworkPrune();
    }

    @Override
    public String send() throws Exception {
        Result result = getDockerHttpClient().post("/containers/prune", getParameters(),null);
        if(result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return result.getMessage();
        }
    }
}
