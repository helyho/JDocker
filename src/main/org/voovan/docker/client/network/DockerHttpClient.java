package org.voovan.docker.client.network;

import org.voovan.http.client.HttpClient;
import org.voovan.http.message.Response;
import org.voovan.network.exception.ReadMessageException;
import org.voovan.network.exception.SendMessageException;
import org.voovan.tools.json.JSON;

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
    }


    public Result post(String url, String queryString, String data) throws SendMessageException, ReadMessageException {
        if (queryString != null && !queryString.isEmpty()) {
            url = url + "?" + queryString;
        }
        httpClient.getHeader().put("Content-Type", "application/json");
        Response response = httpClient.setMethod("POST").setData(data).send(url);
        return Result.newInstance(response);
    }

    public Result post(String url, Map<String, Object> queryParams, String data) throws SendMessageException, ReadMessageException {
        String queryString = HttpClient.buildQueryString(queryParams, charset);
        return post(url, queryString, data);
    }

    public Result post(String url, Map<String, Object> queryParams, Object data) throws SendMessageException, ReadMessageException {
        String queryString = HttpClient.buildQueryString(queryParams, charset);
        if(data.getClass().getName().startsWith("java")){
            return post(url, queryString, data.toString());
        }else{
            return post(url, queryString, JSON.toJSON(data));
        }

    }

    public Result get(String url, String queryString) throws SendMessageException, ReadMessageException {
        if (queryString != null && !queryString.isEmpty()) {
            url = url + "?" + queryString;
        }
        httpClient.getHeader().put("Content-Type", "application/json");
        Response response = httpClient.setMethod("GET").send(url);
        return Result.newInstance(response);
    }

    public Result get(String url, Map<String, Object> queryParams) throws SendMessageException, ReadMessageException {
        String queryString = HttpClient.buildQueryString(queryParams, charset);
        return get(url, queryString);
    }

    public Result delete(String url, String queryString) throws SendMessageException, ReadMessageException {
        if (queryString != null && !queryString.isEmpty()) {
            url = url + "?" + queryString;
        }
        httpClient.getHeader().put("Content-Type", "application/json");
        Response response = httpClient.setMethod("DELETE").send(url);
        return Result.newInstance(response);
    }

    public Result delete(String url, Map<String, Object> queryParams) throws SendMessageException, ReadMessageException {
        String queryString = HttpClient.buildQueryString(queryParams, charset);
        return get(url, queryString);
    }

    public void close() {
        httpClient.close();
    }

}
