package org.voovan.docker.message.service.atom;

import java.util.ArrayList;
import java.util.List;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class DNSConfig {
    private List<String> nameservers;
    private List<String> search;
    private List<String> options;

    public DNSConfig(){
        nameservers = new ArrayList<String>();
        search = new ArrayList<String>();
        options = new ArrayList<String>();
    }

    public List<String> getNameservers() {
        return nameservers;
    }

    public void setNameservers(List<String> nameservers) {
        this.nameservers = nameservers;
    }

    public List<String> getSearch() {
        return search;
    }

    public void setSearch(List<String> search) {
        this.search = search;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
