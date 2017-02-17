package org.voovan.docker.command.Container;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.network.DockerClientException;
import org.voovan.docker.network.Result;

import java.nio.ByteBuffer;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class CmdContainerArchiveGet extends Cmd{
    private String nameOrId;

    public CmdContainerArchiveGet(String nameOrId) {
        super();
        this.nameOrId = nameOrId;
    }

    public CmdContainerArchiveGet path(String path){
        addParameter("path", path);
        return this;
    }

    public static CmdContainerArchiveGet newInstance(String nameOrId){
        return new CmdContainerArchiveGet(nameOrId);
    }

    @Override
    public ByteBuffer send() throws Exception {
        Result result = getDockerHttpClient().run("GET","/containers/"+nameOrId+"/archive", getParameters());
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return result.getBufferData();
        }
    }

}
