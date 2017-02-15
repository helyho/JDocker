package org.voovan.docker.command.Exec;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.exec.ExecCreate;
import org.voovan.docker.network.DockerClientException;
import org.voovan.docker.network.Result;

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

    public CmdExecCreate attachStdin(boolean attachStdin){
        execCreate.setAttachStdin(attachStdin);
        return this;
    }

    public CmdExecCreate attachStdout(boolean attachStdout){
        execCreate.setAttachStdout(attachStdout);
        return this;
    }

    public CmdExecCreate attachStderr(boolean attachStderr){
        execCreate.setAttachStderr(attachStderr);
        return this;
    }

    public CmdExecCreate detachKeys(String detachKeys){
        execCreate.setDetachKeys(detachKeys);
        return this;
    }

    public CmdExecCreate tty(boolean tty){
        execCreate.setTty(tty);
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
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return result.getMessage();
        }
    }

}
