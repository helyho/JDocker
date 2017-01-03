package org.voovan.docker.command;

import org.voovan.docker.network.DockerClientException;
import org.voovan.docker.network.Result;
import org.voovan.tools.json.JSON;

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
public class CmdInfo extends Cmd {

    private String id;

    public CmdInfo() {
    }


    public static CmdInfo newInstance(){
        return new CmdInfo();
    }

    @Override
    public Map<String,Object> send() throws Exception {
        Result result = getDockerHttpClient().get("/info",getParameters());
        if(result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return (Map<String,Object>)JSON.parse(result.getMessage());
        }

    }
}
