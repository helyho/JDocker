package org.voovan.docker.command.Exec;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.exec.ExecInfo;
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
public class CmdExecResize extends Cmd{
    private String execId;

    public CmdExecResize(String execId) {
        super();
        this.execId = execId;
    }

    public CmdExecResize height(int height){
        addParameter("h",height);
        return this;
    }

    public CmdExecResize width(int width){
        addParameter("w", width);
        return this;
    }

    public static CmdExecResize newInstance(String nameOrId){
        return new CmdExecResize(nameOrId);
    }

    @Override
    public String send() throws Exception {
        Result result = getDockerHttpClient().run("POST","/containers/"+execId+"/resize", getParameters());
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return result.getMessage();
        }
    }
}
