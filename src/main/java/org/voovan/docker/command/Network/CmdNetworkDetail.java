package org.voovan.docker.command.Network;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.network.NetworkDetail;
import org.voovan.docker.message.network.NetworkInfo;
import org.voovan.docker.network.DockerClientException;
import org.voovan.docker.network.Result;

import java.util.List;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class CmdNetworkDetail extends Cmd{
    private String nameOrId;

    public CmdNetworkDetail(String nameOrId) {
        this.nameOrId = nameOrId;
    }


    public static CmdNetworkDetail newInstance(String nameOrId){
        return new CmdNetworkDetail(nameOrId);
    }

    @Override
    public NetworkDetail send() throws Exception {
        Result result = getDockerHttpClient().run("GET","/networks/"+nameOrId,getParameters());
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return NetworkDetail.load(result.getMessage());
        }

    }
}
