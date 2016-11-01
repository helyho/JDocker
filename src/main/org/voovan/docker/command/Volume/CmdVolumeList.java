package org.voovan.docker.command.Volume;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.Volume.Volume;
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
public class CmdVolumeList extends Cmd{
    public CmdVolumeList() {
    }


    public static CmdVolumeList newInstance(){
        return new CmdVolumeList();
    }

    @Override
    public List<Volume> send() throws Exception {
        Result result = getDockerHttpClient().get("/volumes",getParameters());
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return Volume.load(result.getMessage());
        }

    }
}
