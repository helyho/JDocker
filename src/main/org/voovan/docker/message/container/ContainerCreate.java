package org.voovan.docker.message.container;

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
public class ContainerCreate {

    private String hostName;
    private String domainName;
    private String user;
    private String image;
    private List<String> cmd;
    private Map<String, Object> labels;
    private Boolean attachStdin;
    private Boolean attachStdout;
    private Boolean attachStderr;
    private Boolean tty;
    private Boolean openStdin;
    private Boolean stdinOnce;
    private List<String> env;
    private Map<String, Map<String, String>> exposedPorts;
    private HostConfig hostConfig;

    //1.25
    private Integer stopTimeout;

    public ContainerCreate() {
        attachStdin = false;
        attachStdout = true;
        attachStderr = true;
        tty = false;
        openStdin = false;
        stdinOnce = false;
        cmd = new ArrayList<String>();
        env = new ArrayList<String>();
        labels = new HashMap<String, Object>();
        exposedPorts = new HashMap<String, Map<String, String>>();
        hostConfig = new HostConfig();
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getCmd() {
        return cmd;
    }

    public void setCmd(List<String> cmd) {
        this.cmd = cmd;
    }

    public Map<String, Object> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, Object> labels) {
        this.labels = labels;
    }

    public Boolean isAttachStdin() {
        return attachStdin;
    }

    public void setAttachStdin(Boolean attachStdin) {
        this.attachStdin = attachStdin;
    }

    public Boolean isAttachStdout() {
        return attachStdout;
    }

    public void setAttachStdout(Boolean attachStdout) {
        this.attachStdout = attachStdout;
    }

    public Boolean isAttachStderr() {
        return attachStderr;
    }

    public void setAttachStderr(Boolean attachStderr) {
        this.attachStderr = attachStderr;
    }

    public Boolean isTty() {
        return tty;
    }

    public void setTty(Boolean tty) {
        this.tty = tty;
    }

    public Boolean isOpenStdin() {
        return openStdin;
    }

    public void setOpenStdin(Boolean openStdin) {
        this.openStdin = openStdin;
    }

    public Boolean isStdinOnce() {
        return stdinOnce;
    }

    public void setStdinOnce(Boolean stdinOnce) {
        this.stdinOnce = stdinOnce;
    }

    public List<String> getEnv() {
        return env;
    }

    public void setEnv(List<String> env) {
        this.env = env;
    }

    public Map<String, Map<String, String>> getExposedPorts() {
        return exposedPorts;
    }

    public void setExposedPorts(Map<String, Map<String, String>> exposedPorts) {
        this.exposedPorts = exposedPorts;
    }

    public HostConfig getHostConfig() {
        return hostConfig;
    }

    public void setHostConfig(HostConfig hostConfig) {
        this.hostConfig = hostConfig;
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
        exposedPorts.put(containerPortAndProtcol, new HashMap<String, String>());

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
        containerCreate.cmd.addAll(TObject.newList("ping", "www.baidu.com"));

        //环境变量
        containerCreate.env.add("test=helyho");

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
