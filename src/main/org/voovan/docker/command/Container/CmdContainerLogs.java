package org.voovan.docker.command.Container;

import org.voovan.docker.command.Cmd;
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
public class CmdContainerLogs extends Cmd {
    private String nameOrId;

    public CmdContainerLogs(String nameOrId) {
        super();
        this.nameOrId = nameOrId;
        addParameter("stderr",1);
        addParameter("stdout",1);
        addParameter("tail",100);
    }

    public CmdContainerLogs(String nameOrId, int timeOut) {
        super(timeOut);
        this.nameOrId = nameOrId;
        addParameter("stderr",1);
        addParameter("stdout",1);
        addParameter("tail",100);
    }

    public CmdContainerLogs timestamps(boolean timestamps){
        addParameter("timestamps",timestamps);
        return this;
    }

    public CmdContainerLogs since(long since){
        addParameter("since",since);
        return this;
    }

    public CmdContainerLogs tail(String tail){
        addParameter("tail",tail);
        return this;
    }

    public CmdContainerLogs details(boolean details){
        addParameter("details",details);
        return this;
    }

    public CmdContainerLogs follow(boolean follow){
        addParameter("follow",follow);
        return this;
    }

    public static CmdContainerLogs newInstance(String nameOrId){
        return new CmdContainerLogs(nameOrId);
    }

    public static CmdContainerLogs newInstance(String nameOrId, int timeOut){
        return new CmdContainerLogs(nameOrId, timeOut);
    }

    @Override
    public String send() throws Exception {
        Result result = getDockerHttpClient().get("/containers/"+nameOrId+"/logs", getParameters());
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return result.getMessage().replaceAll("\\u0001[\\u0000-\\uffff]{7}","");
        }
    }
}
