package org.voovan.docker.message.service.atom;

import java.util.HashMap;
import java.util.Map;

/**
 * 类文字命名
 *
 * @author: helyho
 * JDocker Framework.
 * WebSite: https://github.com/helyho/JDocker
 * Licence: Apache v2 License
 */
public class LogDriver {
    private String name;
    private Map<String, String> options;

    public LogDriver(){
        options = new HashMap<String, String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getOptions() {
        return options;
    }

    public void setOptions(Map<String, String> options) {
        this.options = options;
    }
}
