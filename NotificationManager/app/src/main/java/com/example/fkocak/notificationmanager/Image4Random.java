package com.example.fkocak.notificationmanager;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image4Random {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("large_url")
    @Expose
    private String largeUrl;
    @SerializedName("source_id")
    @Expose
    private Integer sourceId;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("site")
    @Expose
    private String site;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLargeUrl() {
        return largeUrl;
    }

    public void setLargeUrl(String largeUrl) {
        this.largeUrl = largeUrl;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

}
