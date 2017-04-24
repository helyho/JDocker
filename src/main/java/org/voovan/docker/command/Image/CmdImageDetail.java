package org.voovan.docker.command.Image;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.Image.ImageDetail;
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
public class CmdImageDetail extends Cmd {

    private String nameOrId;

    public CmdImageDetail(String nameOrId){
        this.nameOrId = nameOrId;
    }

    public static CmdImageDetail newInstance(String nameOrId) {
        return new CmdImageDetail(nameOrId);
    }

    @Override
    public ImageDetail send() throws Exception {
        Result result = getDockerHttpClient().run("GET","/images/"+nameOrId+"/json",getParameters());
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return  ImageDetail.load(result.getMessage());
        }
    }
}
