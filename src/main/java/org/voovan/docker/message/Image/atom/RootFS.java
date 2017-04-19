package org.voovan.docker.message.Image.atom;

import java.util.List;

/**
 * 类文字命名
 *
 * @author: helyho
 * JDocker Framework.
 * WebSite: https://github.com/helyho/JDocker
 * Licence: Apache v2 License
 */
public class RootFS {
    private String type;
    private List<String> layers;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getLayers() {
        return layers;
    }

    public void setLayers(List<String> layers) {
        this.layers = layers;
    }
}
