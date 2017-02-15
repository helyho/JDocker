package org.voovan.docker.command.Info;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.info.Info;
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
public class CmdDockerInfo extends Cmd {

    private String id;

    public CmdDockerInfo() {
    }


    public static CmdDockerInfo newInstance(){
        return new CmdDockerInfo();
    }

    @Override
    public Info send() throws Exception {
        Result result = getDockerHttpClient().get("/info",getParameters());
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return Info.load(result.getMessage());
        }

    }
}
