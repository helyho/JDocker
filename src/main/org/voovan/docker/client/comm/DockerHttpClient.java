package org.voovan.docker.client.comm;

import org.voovan.docker.message.Volume.Volume;
import org.voovan.http.client.HttpClient;
import org.voovan.http.message.Response;
import org.voovan.network.exception.ReadMessageException;
import org.voovan.network.exception.SendMessageException;
import org.voovan.tools.json.JSON;
import org.voovan.tools.log.Logger;

import java.util.Map;

/**
 *
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

    public static void main(String[] args) throws SendMessageException, ReadMessageException {
        DockerHttpClient httpClient = new DockerHttpClient("http://127.0.0.1:2735", "UTF-8", 500);
        Logger.info(httpClient.get("/images/json", "all=0").getMessage());
        Logger.info(httpClient.get("/images/dockerfly/history", "").getMessage());
        Logger.info(httpClient.delete("/containers/sleepy_austin", "").getMessage());

        Volume volume = new Volume();
        volume.setDriver("local");
        volume.setName("v_tx");
        Logger.info(httpClient.post("/volumes/create", "", JSON.toJSON(volume)).getMessage());
        httpClient.close();
    }

}
