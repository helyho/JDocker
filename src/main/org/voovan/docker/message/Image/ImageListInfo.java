package org.voovan.docker.message.Image;

import org.voovan.tools.json.JSONPath;

import java.text.ParseException;
import java.util.*;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class ImageListInfo {
    private String id;
    private String parentId;
    private List<String> repoTags;
    private List<String> repoDigests;
    private Long created;
    private Long Size;
    private Long virtualSize;
    private Map<String, Object> labels;

    public ImageListInfo() {
        labels = new HashMap<String, Object>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<String> getRepoTags() {
        return repoTags;
    }

    public void setRepoTags(List<String> repoTags) {
        this.repoTags = repoTags;
    }

    public List<String> getRepoDigests() {
        return repoDigests;
    }

    public void setRepoDigests(List<String> repoDigests) {
        this.repoDigests = repoDigests;
    }

    public Date getCreated() {
        return new Date(created * 1000);
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getSize() {
        return Size;
    }

    public void setSize(Long size) {
        Size = size;
    }

    public Long getVirtualSize() {
        return virtualSize;
    }

    public void setVirtualSize(Long virtualSize) {
        this.virtualSize = virtualSize;
    }

    public Map<String, Object> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, Object> labels) {
        this.labels = labels;
    }

    public static List<ImageListInfo> load(String jsonStr) throws ParseException, ReflectiveOperationException {

        if(!jsonStr.trim().startsWith("[")){
            jsonStr = "["+jsonStr+"]";
        }

        JSONPath jsonPath = JSONPath.newInstance(jsonStr);

        List<ImageListInfo> imageInfos = jsonPath.value("/", List.class, new ArrayList<ImageListInfo>());

        return imageInfos;
    }
}
