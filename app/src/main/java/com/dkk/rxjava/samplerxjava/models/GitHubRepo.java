package com.dkk.rxjava.samplerxjava.models;

/**
 * Created by deepak on 23/2/17.
 */

public class GitHubRepo extends BaseModel {

    private Integer id;
    private String name;
    private String htmlUrl;
    private String description;
    private String language;
    private Integer stargazerCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getStargazerCount() {
        return stargazerCount;
    }

    public void setStargazerCount(Integer stargazerCount) {
        this.stargazerCount = stargazerCount;
    }
}
