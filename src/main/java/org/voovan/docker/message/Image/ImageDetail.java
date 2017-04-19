package org.voovan.docker.message.Image;

import org.voovan.docker.message.Image.atom.Config;
import org.voovan.docker.message.Image.atom.GraphDriver;
import org.voovan.docker.message.Image.atom.RootFS;
import org.voovan.tools.json.JSONPath;

import java.text.ParseException;
import java.util.List;

/**
 * 类文字命名
 *
 * @author: helyho
 * JDocker Framework.
 * WebSite: https://github.com/helyho/JDocker
 * Licence: Apache v2 License
 */
public class ImageDetail {
    private String id;
    private String parent;
    private List<String> repoTags;
    private List<String> repoDigests;
    private String comment;
    private String created;
    private String container;
    private String dockerVersion;
    private String author;
    private String architecture;
    private String os;
    private long size;
    private long virtualSize;

    private Config config;
    private GraphDriver graphDriver;
    private RootFS rootFS;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getDockerVersion() {
        return dockerVersion;
    }

    public void setDockerVersion(String dockerVersion) {
        this.dockerVersion = dockerVersion;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getVirtualSize() {
        return virtualSize;
    }

    public void setVirtualSize(long virtualSize) {
        this.virtualSize = virtualSize;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public GraphDriver getGraphDriver() {
        return graphDriver;
    }

    public void setGraphDriver(GraphDriver graphDriver) {
        this.graphDriver = graphDriver;
    }

    public RootFS getRootFS() {
        return rootFS;
    }

    public void setRootFS(RootFS rootFS) {
        this.rootFS = rootFS;
    }


    public static ImageDetail load(String jsonStr) throws ParseException, ReflectiveOperationException {

        JSONPath jsonPath = JSONPath.newInstance(jsonStr);

        ImageDetail imageInfo = jsonPath.value("/", ImageDetail.class);

        return imageInfo;
    }
}
