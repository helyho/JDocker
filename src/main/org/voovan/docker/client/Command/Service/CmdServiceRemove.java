package org.voovan.docker.client.Command.Service;

import org.voovan.docker.client.Command.Cmd;
import org.voovan.docker.client.network.DockerClientException;
import org.voovan.docker.client.network.Result;
import org.voovan.docker.message.service.ServiceInfo;
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
public class CmdServiceRemove extends Cmd {
    private String nameOrId ;

    public CmdServiceRemove(String nameOrId) {
        this.nameOrId = nameOrId;
    }



    public static CmdServiceRemove newInstance(String nameOrId){
        return new CmdServiceRemove(nameOrId);
    }

    @Override
    public Result send() throws Exception {
        Result result = getDockerHttpClient().delete("/services/"+nameOrId,getParameters());
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return result;
        }

    }

}
