package org.voovan.docker.command;

import org.voovan.docker.DockerGlobal;
import org.voovan.docker.network.DockerHttpClient;
import org.voovan.tools.TByteBuffer;
import org.voovan.tools.TString;
import org.voovan.tools.json.annotation.NotJSON;

import java.io.IOException;
import java.nio.ByteBuffer;
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

    @NotJSON
    private DockerHttpClient dockerHttpClient;

    @NotJSON
    private Map<String,Object> parameters;

    public Cmd() {
        String rootURL = "http://"+ DockerGlobal.DOCKER_REST_HOST+":"+ DockerGlobal.DOCKER_REST_PORT;
        dockerHttpClient = new DockerHttpClient(rootURL, DockerGlobal.DOCKER_REST_CHARSET, DockerGlobal.DOCKER_REST_TIMEOUT);

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

    public String loadStream() throws IOException {
        ByteBuffer byteBuffer = getDockerHttpClient().loadSteam();

        return byteBuffer==null ? null : TByteBuffer.toString(byteBuffer).replaceAll("\\u0001[\\u0000-\\uffff]{7}","");
    }

    public void endLoadStream(){
        getDockerHttpClient().endLoadStream();
    }

    public int send(String data) throws IOException {
        data =  TString.fromUnicode(data);
        return dockerHttpClient.send(data.getBytes());
    }

    public abstract  <T> T send() throws Exception;

}
