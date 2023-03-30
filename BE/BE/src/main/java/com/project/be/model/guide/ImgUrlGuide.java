package com.project.be.model.guide;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class ImgUrlGuide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String url;

    private Integer deleteStatus;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "guide_id", referencedColumnName = "id")
    private Guide guide;

    public ImgUrlGuide() {
    }

    public ImgUrlGuide(Integer id, String url, Integer deleteStatus) {
        this.id = id;
        this.url = url;
        this.deleteStatus = deleteStatus;
    }

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

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }
}

