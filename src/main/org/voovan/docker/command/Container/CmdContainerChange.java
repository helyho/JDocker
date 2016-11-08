package org.voovan.docker.command.Container;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.container.ContainerChange;
import org.voovan.docker.message.container.atom.ChangeItem;
import org.voovan.docker.network.DockerClientException;
import org.voovan.docker.network.Result;

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
public class CmdContainerChange extends Cmd{

    private String nameOrId;

    public CmdContainerChange(String nameOrId) {
        this.nameOrId = nameOrId;
    }

    public static CmdContainerChange newInstance(String nameOrId){
        return new CmdContainerChange(nameOrId);
    }

    @Override
    public List<ChangeItem> send() throws Exception {
        Result result = getDockerHttpClient().get("/containers/"+nameOrId+"/changes", getParameters());
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return ContainerChange.load(result.getMessage());
        }
    }}
