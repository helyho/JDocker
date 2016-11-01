package org.voovan.docker.message.Swarm.atom;

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
public class ExternalCA {
    private String protocol;
    private String url;
    private Map<String,String> options;

    public ExternalCA(String protocol, String url, Map<String, String> options) {
        this.protocol = protocol;
        this.url = url;
        this.options = options;
    }

    public ExternalCA() {
        options = new HashMap<String,String>();
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getOptions() {
        return options;
    }

    public void setOptions(Map<String, String> options) {
        this.options = options;
    }
}
