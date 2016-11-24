package org.voovan.docker.message.Image;

import org.voovan.tools.TObject;
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
    private Boolean is_official;
    private Boolean is_automated;
    private String description;
    private Integer star_count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean is_official() {
        return is_official;
    }

    public void setIs_official(Boolean is_official) {
        this.is_official = is_official;
    }

    public Boolean is_automated() {
        return is_automated;
    }

    public void setIs_automated(Boolean is_automated) {
        this.is_automated = is_automated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStar_count() {
        return star_count;
    }

    public void setStar_count(Integer star_count) {
        this.star_count = star_count;
    }

    public static List<HubImageInfo> load(String jsonStr) throws ParseException, ReflectiveOperationException {
        JSONPath jsonPath = JSONPath.newInstance(jsonStr);

        List<HubImageInfo> hubImages = jsonPath.listObject("/", HubImageInfo.class, new ArrayList<HubImageInfo>());

        return hubImages;
    }
}
