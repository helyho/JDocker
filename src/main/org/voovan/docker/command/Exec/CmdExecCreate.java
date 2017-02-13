package org.voovan.docker.command.Exec;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.container.atom.HostConfig;
import org.voovan.docker.message.exec.ExecCreate;
import org.voovan.docker.network.DockerClientException;
import org.voovan.docker.network.Result;
import org.voovan.tools.json.JSONPath;

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
public class CmdExecCreate extends Cmd{
    private ExecCreate execCreate;
    private String nameOrId;

    public CmdExecCreate(String nameOrId) {
        super();
        this.nameOrId = nameOrId;
        execCreate = new ExecCreate();
    }


    public CmdExecCreate cmd(String ... cmd){
        execCreate.getCmd().addAll(Arrays.asList(cmd));
        return this;
    }

    public CmdExecCreate env(String ... env){
        execCreate.getCmd().addAll(Arrays.asList(env));
        return this;
    }

    public CmdExecCreate privileged(boolean privileged){
        execCreate.setPrivileged(privileged);
        return this;
    }

    public ExecCreate getEntity(){
        return execCreate;
    }

    public static CmdExecCreate newInstance(String nameOrId){
        return new CmdExecCreate(nameOrId);
    }

    @Override
    public String send() throws Exception {
        Result result = getDockerHttpClient().post("/containers/"+nameOrId+"/exec", getParameters(), execCreate);
        if(result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            JSONPath jsonpath = new JSONPath(result.getMessage());
            return jsonpath.value("/Id").toString();
        }
    }

}
