package org.voovan.docker.client.Command;

import org.voovan.docker.client.Global;
import org.voovan.docker.client.network.DockerHttpClient;
import org.voovan.network.exception.ReadMessageException;
import org.voovan.network.exception.SendMessageException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public abstract class Cmd {
    private DockerHttpClient dockerHttpClient;
    private Map<String,Object> parameters;

    public Cmd() {
        String rootURL = "http://"+ Global.DOCKER_REST_HOST+":"+Global.DOCKER_REST_PORT;
        dockerHttpClient = new DockerHttpClient(rootURL, Global.DOCKER_REST_CHARSET, Global.DOCKER_REST_TIMEOUT);

        parameters = new HashMap<String,Object>();
    }

    protected DockerHttpClient getDockerHttpClient() {
        return dockerHttpClient;
    }

    protected void addParameter(String name, Object value){
        parameters.put(name,value);
    }

    protected Map<String, Object> getParameters() {
        return parameters;
    }

    public void close(){
        dockerHttpClient.close();
    }


    public void beginLoadStream(){
        getDockerHttpClient().beginLoadStream();
    }

    public byte[] loadStream() throws IOException {
        return getDockerHttpClient().loadSteam().array();
    }

    public void endLoadStream(){
        getDockerHttpClient().endLoadStream();
    }

    public abstract  <T> T send() throws Exception;

}
