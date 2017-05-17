package org.voovan.docker.network;

import org.voovan.docker.DockerGlobal;
import org.voovan.http.client.HttpClient;
import org.voovan.http.message.Response;
import org.voovan.network.exception.ReadMessageException;
import org.voovan.network.exception.SendMessageException;
import org.voovan.tools.json.JSON;
import org.voovan.tools.log.Logger;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;

/**
 * Docker Http客户端访问工具类
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class DockerHttpClient {

    private HttpClient httpClient;
    private String charset;
    private boolean debug;

    public DockerHttpClient(String rootURL, String charset, int timeOut) {
        this.charset = charset;
        httpClient = new HttpClient(rootURL, charset, timeOut);
        httpClient.getHeader().remove("Connection");
        this.debug =DockerGlobal.DEBUG;
        if(debug){
            Logger.simple("[DEBUG INFO] RootURL: "+rootURL+", Charset: "+charset+", TimeOut: "+timeOut);
        }
    }

    public DockerHttpClient(String rootURL, String charset, int timeOut, boolean debug) {
        this.charset = charset;
        httpClient = new HttpClient(rootURL, charset, timeOut);
        httpClient.getHeader().remove("Connection");
        this.debug = debug;
        if(debug){
            Logger.simple("[DEBUG INFO] RootURL: "+rootURL+", Charset: "+charset+", TimeOut: "+timeOut);
        }
    }

    public ByteBuffer loadSteam( ) throws IOException {
        return httpClient.loadStream();
    }

    //=================== POST ===================

    public Result run(String method, String url, String queryString, byte[] data)  {
        if (queryString != null && !queryString.isEmpty()) {
            url = url + "?" + queryString;
        }
        httpClient.getHeader().put("Content-Type", "application/json");
        Response response = null;
        try {
            if(debug) {
                Logger.simple("[DEBUG INFO] SubURL: " + url + ", Method:"+method+", Data: " + data);
            }
            httpClient.setMethod(method);
            if(data != null) {
                httpClient.setData(data);
            }
            response = httpClient.send(url);
        } catch (SendMessageException|ReadMessageException e) {
            if(response==null){
                response = new Response();
            }
            response.protocol().setStatus(555);
            response.protocol().setStatusCode("EXCEPTION");
            response.body().write(e.getMessage());
            e.printStackTrace();
            httpClient.close();
        }

        return Result.newInstance(response);
    }

    public Result run(String method, String url, Map<String, Object> queryParams, String data)  {
        String queryString = "";
        if(queryParams!=null) {
            queryString = HttpClient.buildQueryString(queryParams, charset);
        }
        return run(method, url, queryString, (data==null? null :data.getBytes()) );
    }

    public Result run(String method, String url, Map<String, Object> queryParams, Object data)  {
        return run(method, url, queryParams, JSON.removeNullNode(JSON.toJSON(data)));
    }

    public Result run(String method, String url, Map<String, Object> queryParams)  {
        return run(method, url, queryParams, null);
    }

    public void close() {
        httpClient.close();
    }

    public int sendData(byte[] data) throws IOException{
        return httpClient.send(ByteBuffer.wrap(data));
    }
}
