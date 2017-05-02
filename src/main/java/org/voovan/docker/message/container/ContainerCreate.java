package org.voovan.docker.message.container;

import org.voovan.docker.message.container.atom.Config;
import org.voovan.docker.message.container.atom.Healthcheck;
import org.voovan.docker.message.container.atom.HostConfig;
import org.voovan.tools.TObject;
import org.voovan.tools.json.JSON;
import org.voovan.tools.log.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class ContainerCreate extends Config {

    private HostConfig hostConfig;
    private Boolean networkDisabled;
    private String shell;

    //1.25
    private Integer stopTimeout;

    public ContainerCreate() {
        this.setAttachStdin(false);
        this.setAttachStdout(true);
        this.setAttachStderr(true);
        this.setTty(false);
        this.setOpenStdin(false);
        this.setStdinOnce(false);
        this.setCmd(new ArrayList<String>());
        this.setEnv(new ArrayList<String>());
        this.setLabels(new HashMap<String, Object>());
        this.setExposedPorts(new HashMap<String, Map<String, String>>());
        this.setHostConfig(new HostConfig());
        this.setHealthcheck(new Healthcheck());
        this.setEntrypoint(new ArrayList<String>());
        this.setOnBuild(new ArrayList<String>());
        this.setStopSignal("SIGTERM");
    }

    public HostConfig getHostConfig() {
        return hostConfig;
    }

    public void setHostConfig(HostConfig hostConfig) {
        this.hostConfig = hostConfig;
    }


    public Boolean getNetworkDisabled() {
        return networkDisabled;
    }

    public void setNetworkDisabled(Boolean networkDisabled) {
        this.networkDisabled = networkDisabled;
    }


    public String getShell() {
        return shell;
    }

    public void setShell(String shell) {
        this.shell = shell;
    }

    //v1.25
    public Integer getStopTimeout() {
        return stopTimeout;
    }

    //v1.25
    public void setStopTimeout(Integer stopTimeout) {
        this.stopTimeout = stopTimeout;
    }

    /**
     * 增加端口绑定
     *
     * @param containerPort 容器端口
     * @param protocol      协议
     * @param hostPortStrs  主机端口 127.0.0.1:3000
     */
    public void addPortBind(int containerPort, String protocol, String... hostPortStrs) {
        String containerPortAndProtcol = containerPort + "/" + protocol;

        //端口绑定需要设置两个节点,并且要对应
        //1.设置 ExposedPorts 节点
        this.getExposedPorts().put(containerPortAndProtcol, new HashMap<String, String>());

        //2.设置HostConfig.PortBindings 节点
        List<Map<String, String>> hostPortList = new ArrayList<Map<String, String>>();
        for (String hostPortStr : hostPortStrs) {
            String[] hostPortArr = hostPortStr.split(":");
            String hostIP = "0.0.0.0";
            String hostPort = null;
            if (hostPortArr.length == 2) {
                hostIP = hostPortArr[0];
                hostPort = hostPortArr[1];
            } else {
                hostPort = hostPortStr;
            }

            Map<String, String> hostPortMaps = new HashMap<String, String>();
            hostPortMaps.put("HostIp", hostIP);
            hostPortMaps.put("HostPort", hostPort);
            hostPortList.add(hostPortMaps);
        }

        hostConfig.getPortBindings().put(containerPortAndProtcol, hostPortList);
    }

    public static void main(String[] args) {
        ContainerCreate containerCreate = new ContainerCreate();

        //镜像名称
        containerCreate.setImage("alpine");

        //指令
        containerCreate.getCmd().addAll(TObject.asList("ping", "www.baidu.com"));

        //环境变量
        containerCreate.getEnv().add("test=helyho");

        containerCreate.getHostConfig().setCpuQuota(50000);
        containerCreate.getHostConfig().setCpuPeriod(100000);
        containerCreate.getHostConfig().setMemory((long) 314572800);

        //网络设置
        containerCreate.getHostConfig().setNetworkMode("locbridge");

        //卷挂载
        containerCreate.getHostConfig().getBinds().add("v_t1:/v_t1");

        //主机关联
        containerCreate.getHostConfig().getLinks().add("test1:test1");

        //端口映射
        containerCreate.addPortBind(5000, "tcp", "127.0.0.1:8500", "52001");

        Logger.simple(JSON.formatJson(JSON.toJSON(containerCreate)));
    }
}
