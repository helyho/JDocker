package org.voovan.docker.command.Image;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.network.DockerClientException;
import org.voovan.docker.network.Result;
import org.voovan.docker.message.Image.HubImageInfo;

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
public class CmdHubImageInfo extends Cmd {
    private HubImageInfo hubImageInfo;

    public CmdHubImageInfo() {
        hubImageInfo = new HubImageInfo();
    }

    public CmdHubImageInfo term(String term){
        addParameter("term",term);
        return this;
    }

    public CmdHubImageInfo limit(int limit){
        addParameter("limit",limit);
        return this;
    }

    public CmdHubImageInfo stars(int stars){
        addParameter("stars",stars);
        return this;
    }

    public CmdHubImageInfo automated(boolean automated){
        addParameter("automated",automated);
        return this;
    }

    public CmdHubImageInfo official(boolean official){
        addParameter("official",official);
        return this;
    }


    public static CmdHubImageInfo newInstance() {
        return new CmdHubImageInfo();
    }


    @Override
    public List<HubImageInfo> send() throws Exception {
        Result result = getDockerHttpClient().get("/images/search",getParameters());
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return HubImageInfo.load(result.getMessage());
        }

    }
}
