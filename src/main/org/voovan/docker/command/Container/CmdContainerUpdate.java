package org.voovan.docker.command.Container;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.container.ContainerCreate;
import org.voovan.docker.message.container.atom.HostConfig;
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
public class CmdContainerUpdate extends Cmd{
    private HostConfig hostConfig;
    private String nameOrId;

    public CmdContainerUpdate(String nameOrId) {
        super();
        this.nameOrId = nameOrId;
        hostConfig = new HostConfig();
    }


    public CmdContainerUpdate cpuQuota(int cpuQuota){
        hostConfig.setCpuQuota(cpuQuota);
        return this;
    }

    public CmdContainerUpdate cpuPeriod(int cpuPeriod){
        hostConfig.setCpuPeriod(cpuPeriod);
        return this;
    }

    public CmdContainerUpdate memory(int memory){
        hostConfig.setMemory(memory*1024L*1024L);
        return this;
    }

    public HostConfig getEntity(){
        return hostConfig;
    }

    public static CmdContainerUpdate newInstance(String nameOrId){
        return new CmdContainerUpdate(nameOrId);
    }

    @Override
    public Result send() throws Exception {
        Result result = getDockerHttpClient().post("/containers/"+nameOrId+"/update", getParameters(), hostConfig);
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return result;
        }
    }

}
