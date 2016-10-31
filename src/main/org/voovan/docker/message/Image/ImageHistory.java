package org.voovan.docker.message.Image;

import org.voovan.tools.json.JSONPath;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class ImageHistory {
    private String id;
    private Long created;
    private String createdBy;
    private List<String> tags;
    private Long size;
    private String comment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreated() {
        return new Date(created);
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public static List<ImageHistory> load(String jsonStr) throws ParseException, ReflectiveOperationException {
        List<ImageHistory> imageHistories = new ArrayList<ImageHistory>();
        JSONPath jsonPath = JSONPath.newInstance(jsonStr);

        for (int i = 0; i < jsonPath.value("/", List.class).size(); i++) {
            ImageHistory imageHistory = new ImageHistory();
            imageHistory.setId(jsonPath.value("/[" + i + "]/Id", String.class,""));
            imageHistory.setCreated(new Long(jsonPath.value("/[" + i + "]/Created", "-1").toString()));
            imageHistory.setCreatedBy(jsonPath.value("/[" + i + "]/CreatedBy", String.class, ""));
            imageHistory.setTags(jsonPath.value("/[" + i + "]/Tags", List.class, new ArrayList<String>()));
            imageHistory.setSize(new Long(jsonPath.value("/[" + i + "]/Size", "-1").toString()));
            imageHistory.setComment(jsonPath.value("/[" + i + "]/Comment", String.class,""));
            imageHistories.add(imageHistory);
        }

        return imageHistories;
    }
}
