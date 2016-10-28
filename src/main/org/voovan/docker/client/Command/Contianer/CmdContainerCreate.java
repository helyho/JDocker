package org.voovan.docker.client.Command.Contianer;

import org.voovan.docker.client.Command.Cmd;
import org.voovan.docker.client.network.Result;
import org.voovan.docker.message.container.ContainerCreate;
import org.voovan.docker.message.container.atom.Device;
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
    private String name;

    public CmdContainerCreate(String name) {
        super();
        addParameter("name",name);
        containerCreate = new ContainerCreate();
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
        containerCreate.getEnv().addAll(Arrays.asList(envs));
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
        containerCreate.getHostConfig().setMemory(memory*1024L*1024L);
        return this;
    }

    public CmdContainerCreate network(String network){
        containerCreate.getHostConfig().setNetworkMode(network);
        return this;
    }

    public CmdContainerCreate dns(String dnses){
        containerCreate.getHostConfig().getDns().addAll(Arrays.asList(dnses));
        return this;
    }

    public CmdContainerCreate device(String pathOnHost,String pathInContainer,String cgroupPermissions){
        containerCreate.getHostConfig().getDevices().add(new Device(pathOnHost,pathInContainer,cgroupPermissions));
        return this;
    }

    public CmdContainerCreate volume(String ... bind){
        containerCreate.getHostConfig().getBinds().addAll(Arrays.asList(bind));
        return this;
    }

    public CmdContainerCreate volumeFrom(String ... volumeFroms){
        containerCreate.getHostConfig().getVolumesFrom().addAll(Arrays.asList(volumeFroms));
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

    public static CmdContainerCreate newInstance(String name){
        return new CmdContainerCreate(name);
    }

    @Override
    public Result send() throws Exception {
        return getDockerHttpClient().post("/containers/create", getParameters(), containerCreate);
    }

}
