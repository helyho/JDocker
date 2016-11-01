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

        List<ImageListInfo> imageInfos = new ArrayList<ImageListInfo>();
        JSONPath jsonPath = JSONPath.newInstance(jsonStr);

        for (int i = 0; i < jsonPath.value("/", List.class).size(); i++) {
            ImageListInfo imageListInfo = new ImageListInfo();
            imageListInfo.setId(jsonPath.value("/[" + i + "]/Id", String.class,""));
            imageListInfo.setParentId(jsonPath.value("/[" + i + "]/ParentId", String.class,""));
            imageListInfo.setRepoTags(jsonPath.value("/[" + i + "]/RepoTags", List.class, new ArrayList<String>()));
            imageListInfo.setRepoDigests(jsonPath.value("/[" + i + "]/RepoDigests", List.class, new ArrayList<String>()));
            imageListInfo.setCreated(new Long(jsonPath.value("/[" + i + "]/Created", "-1").toString()));
            imageListInfo.setSize(new Long(jsonPath.value("/[" + i + "]/Size",  "-1").toString()));
            imageListInfo.setVirtualSize(new Long(jsonPath.value("/[" + i + "]/VirtualSize", "-1").toString()));
            imageListInfo.setLabels(jsonPath.value("/[" + i + "]/Labels", Map.class, new HashMap<String,Object>()));
            imageInfos.add(imageListInfo);
        }

        return imageInfos;
    }
}
