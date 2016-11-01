package org.voovan.docker.command.Volume;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.Volume.Volume;
import org.voovan.docker.message.network.NetworkCreate;
import org.voovan.docker.message.network.atom.IPAMConfig;
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
public class CmdVolumeCreate extends Cmd{

    private Volume volume;

    public CmdVolumeCreate() {
        volume = new Volume();
    }

    public CmdVolumeCreate name(String name){
        volume.setName(name);
        return this;
    }

    public CmdVolumeCreate driver(String driver){
        volume.setDriver(driver);
        return this;
    }

    public CmdVolumeCreate label(String key, String value){
        volume.getLabels().put(key,value);
        return this;
    }


    public static CmdVolumeCreate newInstance(){
        return new CmdVolumeCreate();
    }

    @Override
    public Result send() throws Exception {
        Result result = getDockerHttpClient().post("/volumes/create",getParameters(),volume);
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return result;
        }

    }
}