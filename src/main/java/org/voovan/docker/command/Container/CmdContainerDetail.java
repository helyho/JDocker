package org.voovan.docker.command.Container;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.container.ContainerDetial;
import org.voovan.docker.message.container.ContainerInfo;
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
public class CmdContainerDetail extends Cmd {
    private String nameOrId;

    public CmdContainerDetail(String nameOrId) {
        this.nameOrId = nameOrId;
    }

    public static CmdContainerDetail newInstance(String nameOrId){
        return new CmdContainerDetail(nameOrId);
    }

    @Override
    public ContainerDetial send() throws Exception {

        Result result = getDockerHttpClient().run("GET","/containers/"+nameOrId+"/json", getParameters());
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return ContainerDetial.load(result.getMessage());
        }
    }

}
