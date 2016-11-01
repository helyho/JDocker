package org.voovan.docker.command.Image;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.network.DockerClientException;
import org.voovan.docker.network.Result;
import org.voovan.docker.message.Image.ImageHistory;

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
public class CmdImageHistroy extends Cmd {

    private String nameOrId;

    public CmdImageHistroy (String nameOrId) {
        this.nameOrId = nameOrId;
    }

    public static CmdImageHistroy newInstance(String nameOrId) {
        return new CmdImageHistroy(nameOrId);
    }


    @Override
    public List<ImageHistory> send() throws Exception {
        Result result = getDockerHttpClient().get("/images/"+nameOrId+"/history",getParameters());
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return ImageHistory.load(result.getMessage());
        }
    }
}
