package com.project.be.model.guide;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Guide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String content;

    private Integer deleteStatus;

    @JsonManagedReference
    @OneToMany(mappedBy = "guide")
    private Set<ImgUrlGuide> imgUrlGuideSet;

    public Guide() {
    }

    public Guide(Integer id, String title, String content, Integer deleteStatus) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.deleteStatus = deleteStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Set<ImgUrlGuide> getImgUrlGuideSet() {
        return imgUrlGuideSet;
    }

    public void setImgUrlGuideSet(Set<ImgUrlGuide> imgUrlGuideSet) {
        this.imgUrlGuideSet = imgUrlGuideSet;
    }
}
