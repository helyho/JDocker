package org.voovan.docker.client.Command.Contianer;

import org.voovan.docker.client.Command.Cmd;
import org.voovan.docker.client.network.Result;
import org.voovan.docker.message.container.ContainerCreate;
import org.voovan.network.exception.ReadMessageException;
import org.voovan.network.exception.SendMessageException;

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
public class CmdContainerCreate extends Cmd{
    private ContainerCreate containerCreate;

    public CmdContainerCreate() {
        super();
        containerCreate = new ContainerCreate();
    }

    public CmdContainerCreate setName(String name) {
        addParameter("name",name);
        return this;
    }

    public CmdContainerCreate image(String image){
        containerCreate.setImage(image);
        return this;
    }


    public CmdContainerCreate cmd(String ... cmds){
        containerCreate.getCmd().addAll(Arrays.asList(cmds));
        return this;
    }


    public CmdContainerCreate env(String ... envs){
        containerCreate.getCmd().addAll(Arrays.asList(envs));
        return this;
    }

    public CmdContainerCreate cpuQuota(int cpuQuota){
        containerCreate.getHostConfig().setCpuQuota(cpuQuota);
        return this;
    }

    public CmdContainerCreate cpuPeriod(int cpuPeriod){
        containerCreate.getHostConfig().setCpuPeriod(cpuPeriod);
        return this;
    }

    public CmdContainerCreate memory(int memory){
        containerCreate.getHostConfig().setMemory(memory*1024*1024);
        return this;
    }

    public CmdContainerCreate network(String network){
        containerCreate.getHostConfig().setNetworkMode(network);
        return this;
    }

    public CmdContainerCreate volume(String ... bind){
        containerCreate.getHostConfig().getBinds().addAll(Arrays.asList(bind));
        return this;
    }

    public CmdContainerCreate link(String ... link){
        containerCreate.getHostConfig().getLinks().addAll(Arrays.asList(link));
        return this;
    }

    public CmdContainerCreate exposePort(int containerPort, String protocol, String... hostPortStrs){
        containerCreate.addPortBind(containerPort,protocol,hostPortStrs);
        return this;
    }

    @Override
    public Result send() throws SendMessageException, ReadMessageException {
        return getDockerHttpClient().post("/containers/create", getParameters(), containerCreate);
    }

}
