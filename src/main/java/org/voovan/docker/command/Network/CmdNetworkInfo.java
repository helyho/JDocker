package org.voovan.docker.command.Network;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.network.NetworkInfo;
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
public class CmdNetworkInfo extends Cmd{
    private String nameOrId;

    public CmdNetworkInfo(String nameOrId) {
        this.nameOrId = nameOrId;
    }


    public static CmdNetworkInfo newInstance(String nameOrId){
        return new CmdNetworkInfo(nameOrId);
    }

    @Override
    public List<NetworkInfo> send() throws Exception {
        Result result = getDockerHttpClient().run("GET","/networks/"+nameOrId,getParameters());
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return NetworkInfo.load(result.getMessage());
        }

    }
}
