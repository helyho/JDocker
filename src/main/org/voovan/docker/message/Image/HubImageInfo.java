package org.voovan.docker.message.Image;

import org.voovan.tools.json.JSONPath;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class HubImageInfo {

    private String name;
    private boolean is_official;
    private boolean is_automated;
    private String description;
    private int star_count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean is_official() {
        return is_official;
    }

    public void setIs_official(boolean is_official) {
        this.is_official = is_official;
    }

    public boolean is_automated() {
        return is_automated;
    }

    public void setIs_automated(boolean is_automated) {
        this.is_automated = is_automated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStar_count() {
        return star_count;
    }

    public void setStar_count(int star_count) {
        this.star_count = star_count;
    }

    public static List<HubImageInfo> load(String jsonStr) throws ParseException, ReflectiveOperationException {
        JSONPath jsonPath = JSONPath.newInstance(jsonStr);
        List<HubImageInfo> hubImages = new ArrayList<HubImageInfo>();
        for (int i = 0; i < jsonPath.value("/", List.class).size(); i++) {
            hubImages.add(jsonPath.value("/[" + i + "]", HubImageInfo.class,new HubImageInfo()));
        }

        return hubImages;
    }
}
