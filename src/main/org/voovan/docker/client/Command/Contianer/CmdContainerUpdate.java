package org.voovan.docker.client.Command.Contianer;

import org.voovan.docker.client.Command.Cmd;
import org.voovan.docker.client.network.Result;
import org.voovan.docker.message.container.ContainerCreate;
import org.voovan.docker.message.container.atom.ContainerUpdate;
import org.voovan.docker.message.container.atom.Device;

import java.util.Arrays;

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
    private String nameOrID;

    public CmdContainerUpdate(String nameOrID) {
        super();
        this.nameOrID = nameOrID;
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

    public static CmdContainerUpdate newInstance(String nameOrID){
        return new CmdContainerUpdate(nameOrID);
    }

    @Override
    public Result send() throws Exception {
        return getDockerHttpClient().post("/containers/"+nameOrID+"/update", getParameters(), containerUpdate);
    }

}
