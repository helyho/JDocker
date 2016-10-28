package org.voovan.docker.client.Command.Container;

import org.voovan.docker.client.Command.Cmd;
import org.voovan.docker.client.network.DockerClientException;
import org.voovan.docker.client.network.Result;
import org.voovan.docker.message.container.atom.ContainerUpdate;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class CmdContainerUpdate extends Cmd{
    private ContainerUpdate containerUpdate;
    private String nameOrId;

    public CmdContainerUpdate(String nameOrId) {
        super();
        this.nameOrId = nameOrId;
        containerUpdate = new ContainerUpdate();
    }


    public CmdContainerUpdate cpuQuota(int cpuQuota){
        containerUpdate.setCpuQuota(cpuQuota);
        return this;
    }

    public CmdContainerUpdate cpuPeriod(int cpuPeriod){
        containerUpdate.setCpuPeriod(cpuPeriod);
        return this;
    }

    public CmdContainerUpdate memory(int memory){
        containerUpdate.setMemory(memory*1024L*1024L);
        return this;
    }

    public static CmdContainerUpdate newInstance(String nameOrId){
        return new CmdContainerUpdate(nameOrId);
    }

    @Override
    public Result send() throws Exception {
        Result result = getDockerHttpClient().post("/containers/"+nameOrId+"/update", getParameters(), containerUpdate);
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return result;
        }
    }

}
