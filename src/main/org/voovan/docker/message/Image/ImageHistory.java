package org.voovan.docker.message.Image;

import org.voovan.tools.json.JSONPath;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         DockerFly Framework.
 *         WebSite: https://github.com/helyho/DockerFly
 *         Licence: Apache v2 License
 */
public class ImageHistory {
    private String id;
    private long created;
    private String createdBy;
    private List<String> tags;
    private long size;
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

    public void setCreated(long created) {
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

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
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

        for(int i=0;i<jsonPath.value("/",List.class).size();i++){
            ImageHistory imageHistory = new ImageHistory();
            imageHistory.setId(jsonPath.value("/["+i+"]/Id",String.class));
            imageHistory.setCreated(jsonPath.value("/["+i+"]/Created",int.class));
            imageHistory.setCreatedBy(jsonPath.value("/["+i+"]/CreatedBy",String.class));
            imageHistory.setTags(jsonPath.value("/["+i+"]/Tags",List.class));
            imageHistory.setSize(jsonPath.value("/["+i+"]/Size",int.class));
            imageHistory.setComment(jsonPath.value("/["+i+"]/Comment",String.class));
            imageHistories.add(imageHistory);
        }

        return imageHistories;
    }
}
