package org.voovan.docker.network;

import org.voovan.docker.DockerGlobal;
import org.voovan.docker.command.Cmd;
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

    public DockerHttpClient(String rootURL, String charset, int timeOut) {
        this.charset = charset;
        httpClient = new HttpClient(rootURL, charset, timeOut);
        httpClient.getHeader().remove("Connection");
        if(DockerGlobal.DEBUG){
            Logger.simple("[DEBUG INFO] RootURL: "+rootURL+", Charset: "+charset+", TimeOut: "+timeOut);
        }
    }

    public void beginLoadStream(){
        httpClient.beginLoadStream();
    }

    public ByteBuffer loadSteam( ) throws IOException {
        return httpClient.loadStream();
    }
    public void endLoadStream(){
        httpClient.endLoadStream();
    }


    //=================== POST ===================

    public Result post(String url, String queryString, byte[] data)  {
        if (queryString != null && !queryString.isEmpty()) {
            url = url + "?" + queryString;
        }
        httpClient.getHeader().put("Content-Type", "application/json");
        Response response = null;
        try {
            if(DockerGlobal.DEBUG) {
                Logger.simple("[DEBUG INFO] SubURL: " + url + ", Method:POST, Data: " + data);
            }
            response = httpClient.setMethod("POST").setData(data).send(url);
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

    public Result post(String url, Map<String, Object> queryParams, String data)  {
        String queryString = HttpClient.buildQueryString(queryParams, charset);
        return post(url, queryString, data.getBytes());
    }

    public Result post(String url, Map<String, Object> queryParams, Object data)  {
        return post(url, queryParams, JSON.removeNullNode(JSON.toJSON(data)));
    }

    public Result post(String url, Map<String, Object> queryParams)  {
        String queryString = HttpClient.buildQueryString(queryParams, charset);
        return post(url, queryString, null);
    }

    //=================== GET ===================

    public Result put(String url, String queryString, byte[] data)  {
        if (queryString != null && !queryString.isEmpty()) {
            url = url + "?" + queryString;
        }
        httpClient.getHeader().put("Content-Type", "application/json");
        Response response = null;
        try {
            if(DockerGlobal.DEBUG) {
                Logger.simple("[DEBUG INFO] SubURL: " + url + ", Method:POST, Data: " + data);
            }
            response = httpClient.setMethod("PUT").setData(data).send(url);
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

    public Result put(String url, Map<String, Object> queryParams, byte[] data)  {
        String queryString = HttpClient.buildQueryString(queryParams, charset);
        return post(url, queryString, data);
    }

    //=================== GET ===================

    public Result get(String url, String queryString)  {
        if (queryString != null && !queryString.isEmpty()) {
            url = url + "?" + queryString;
        }
        httpClient.getHeader().put("Content-Type", "application/json");
        Response response = null;
        try {
            if(DockerGlobal.DEBUG){
                Logger.simple("[DEBUG INFO] SubURL: "+url+", Method: GET");
            }
            response = httpClient.setMethod("GET").send(url);
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

    public Result get(String url, Map<String, Object> queryParams)  {
        String queryString = HttpClient.buildQueryString(queryParams, charset);
        return get(url, queryString);
    }

    //=================== DELETE ===================

    public Result delete(String url, String queryString)  {
        if (queryString != null && !queryString.isEmpty()) {
            url = url + "?" + queryString;
        }
        httpClient.getHeader().put("Content-Type", "application/json");
        Response response = null;
        try {
            if(DockerGlobal.DEBUG) {
                Logger.simple("[DEBUG INFO] SubURL: " + url + ", Method: DELETE");
            }
            response = httpClient.setMethod("DELETE").send(url);
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

    public Result delete(String url, Map<String, Object> queryParams)  {
        String queryString = HttpClient.buildQueryString(queryParams, charset);
        return delete(url, queryString);
    }

    public void close() {
        httpClient.close();
    }

}
