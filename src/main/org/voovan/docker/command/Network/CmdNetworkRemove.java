package org.voovan.docker.command.Network;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.network.DockerClientException;
import org.voovan.docker.network.Result;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class CmdNetworkRemove extends Cmd{

    private String nameOrId;

    public CmdNetworkRemove(String nameOrId) {
        this.nameOrId = nameOrId;
    }

    public static CmdNetworkRemove newInstance(String nameOrId){
        return new CmdNetworkRemove(nameOrId);
    }

    @Override
    public String send() throws Exception {
        Result result = getDockerHttpClient().delete("/networks/"+nameOrId,getParameters());
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return result.getMessage();
        }

    }
}
