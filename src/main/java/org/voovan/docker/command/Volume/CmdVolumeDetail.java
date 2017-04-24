package org.voovan.docker.command.Volume;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.volume.VolumeDetail;
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
public class CmdVolumeDetail extends Cmd{

    private String nameOrId;

    public CmdVolumeDetail(String nameOrId) {
        this.nameOrId = nameOrId;
    }

    public static CmdVolumeDetail newInstance(String nameOrId){
        return new CmdVolumeDetail(nameOrId);
    }

    @Override
    public VolumeDetail send() throws Exception {
        Result result = getDockerHttpClient().run("GET","/volumes/"+nameOrId,getParameters());
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return VolumeDetail.load(result.getMessage());
        }

    }
}
