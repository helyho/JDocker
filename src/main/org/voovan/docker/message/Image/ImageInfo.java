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
public class ImageInfo {
    private String id;
    private String parentId;
    private List<String> repoTags;
    private List<String> repoDigests;
    private long created;
    private long Size;
    private long virtualSize;
    private Map<String, Object> labels;

    public ImageInfo() {
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

    public void setCreated(long created) {
        this.created = created;
    }

    public long getSize() {
        return Size;
    }

    public void setSize(long size) {
        Size = size;
    }

    public long getVirtualSize() {
        return virtualSize;
    }

    public void setVirtualSize(long virtualSize) {
        this.virtualSize = virtualSize;
    }

    public Map<String, Object> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, Object> labels) {
        this.labels = labels;
    }

    public static List<ImageInfo> load(String jsonStr) throws ParseException, ReflectiveOperationException {

        List<ImageInfo> imageInfos = new ArrayList<ImageInfo>();
        JSONPath jsonPath = JSONPath.newInstance(jsonStr);

        for (int i = 0; i < jsonPath.value("/", List.class).size(); i++) {
            ImageInfo imageInfo = new ImageInfo();
            imageInfo.setId(jsonPath.value("/[" + i + "]/Id", String.class));
            imageInfo.setParentId(jsonPath.value("/[" + i + "]/ParentId", String.class));
            imageInfo.setRepoTags(jsonPath.value("/[" + i + "]/RepoTags", List.class));
            imageInfo.setRepoDigests(jsonPath.value("/[" + i + "]/RepoDigests", List.class));
            imageInfo.setCreated(jsonPath.value("/[" + i + "]/Created", int.class));
            imageInfo.setSize(jsonPath.value("/[" + i + "]/Size", int.class));
            imageInfo.setVirtualSize(jsonPath.value("/[" + i + "]/VirtualSize", int.class));
            imageInfo.setLabels(jsonPath.value("/[" + i + "]/Labels", Map.class));
            imageInfos.add(imageInfo);
        }

        return imageInfos;
    }
}
