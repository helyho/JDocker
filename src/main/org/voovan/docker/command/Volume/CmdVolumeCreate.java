package org.voovan.docker.command.Volume;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.volume.Volume;
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

    public CmdVolumeCreate driverOpts(String key, String value){
        volume.getDriverOpts().put(key,value);
        return this;
    }

    public CmdVolumeCreate label(String key, String value){
        volume.getLabels().put(key,value);
        return this;
    }


    public Volume getEntity(){
        return volume;
    }

    public static CmdVolumeCreate newInstance(){
        return new CmdVolumeCreate();
    }

    @Override
    public String send() throws Exception {
        Result result = getDockerHttpClient().post("/volumes/create",getParameters(),volume);
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return result.getMessage();
        }

    }
}
