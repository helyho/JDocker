package org.voovan.docker.command.Container;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.network.DockerClientException;
import org.voovan.docker.network.Result;
import org.voovan.tools.TFile;

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
public class CmdContainerArchivePut extends Cmd{
    private String nameOrId;
    private String targetFile;

    public CmdContainerArchivePut(String nameOrId, String targetFile) {
        super();
        this.targetFile = targetFile;
        this.nameOrId = nameOrId;
    }

    public CmdContainerArchivePut path(String path){
        addParameter("path", path);
        return this;
    }

    public CmdContainerArchivePut noOverwriteDirNonDir(boolean noOverwriteDirNonDir){
        addParameter("noOverwriteDirNonDir", noOverwriteDirNonDir);
        return this;
    }

    public static CmdContainerArchivePut newInstance(String nameOrId, String targetFile){
        return new CmdContainerArchivePut(nameOrId, targetFile);
    }

    @Override
    public ByteBuffer send() throws Exception {
        byte[] tarBytes = TFile.loadFileFromSysPath(targetFile);
        Result result = getDockerHttpClient().run("PUT","/containers/"+nameOrId+"/archive", getParameters(), tarBytes);
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return result.getBufferData();
        }
    }

}
