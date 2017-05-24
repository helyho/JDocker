package org.voovan.docker.command;

import org.voovan.docker.DockerGlobal;
import org.voovan.docker.network.DockerClientException;
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
        parameters = new HashMap<String,Object>();
    }

    public void connect4(String host, int port, int timeOut, boolean debug) {
        String rootURL = "http://"+ host+":"+ port;
        dockerHttpClient = new DockerHttpClient(rootURL, DockerGlobal.DOCKER_REST_CHARSET, timeOut, debug);
    }

    public void connect3(String host, int port, int timeOut) {
        String rootURL = "http://"+ host+":"+ port;
        dockerHttpClient = new DockerHttpClient(rootURL, DockerGlobal.DOCKER_REST_CHARSET, timeOut);
    }

    public void connect2(String host, int port) {
        String rootURL = "http://"+ host+":"+ port;
        dockerHttpClient = new DockerHttpClient(rootURL, DockerGlobal.DOCKER_REST_CHARSET, DockerGlobal.DOCKER_REST_TIMEOUT);
    }

    public void connect1(int timeOut) {
        String rootURL = "http://"+ DockerGlobal.DOCKER_REST_HOST+":"+ DockerGlobal.DOCKER_REST_PORT;
        dockerHttpClient = new DockerHttpClient(rootURL, DockerGlobal.DOCKER_REST_CHARSET, timeOut);
    }

    public void connect() {
        String rootURL = "http://"+ DockerGlobal.DOCKER_REST_HOST+":"+ DockerGlobal.DOCKER_REST_PORT;
        dockerHttpClient = new DockerHttpClient(rootURL, DockerGlobal.DOCKER_REST_CHARSET, DockerGlobal.DOCKER_REST_TIMEOUT);
    }

    protected DockerHttpClient getDockerHttpClient() throws DockerClientException {
        if(dockerHttpClient==null){
            throw new DockerClientException("when you must invoke the connect method before invoke the send method");
        }
        return dockerHttpClient;
    }

    protected void addParameter(String name, Object value){
        parameters.put(name,value);
    }

    protected Map<String, Object> getParameters() {
        return parameters;
    }

    public void close(){
        if(dockerHttpClient!=null) {
            dockerHttpClient.close();
        }
    }

    public String loadStream() throws IOException, DockerClientException {
        ByteBuffer byteBuffer = getDockerHttpClient().loadSteam();

        return byteBuffer==null ? null : TByteBuffer.toString(byteBuffer).replaceAll("\\u0001[\\u0000-\\uffff]{7}","");
    }

    public int sendData(String data) throws IOException {
        data =  TString.fromUnicode(data);
        return dockerHttpClient.sendData(data.getBytes());
    }

    public abstract  <T> T send() throws Exception;

}
