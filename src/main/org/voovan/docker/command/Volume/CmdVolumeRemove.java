package org.voovan.docker.command.Volume;

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
public class CmdVolumeRemove extends Cmd{

    private String nameOrId;

    public CmdVolumeRemove(String nameOrId) {
        this.nameOrId = nameOrId;
    }

    public static CmdVolumeRemove newInstance(String nameOrId){
        return new CmdVolumeRemove(nameOrId);
    }

    @Override
    public Result send() throws Exception {
        Result result = getDockerHttpClient().delete("/volumes/"+nameOrId,getParameters());
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return result;
        }

    }
}
