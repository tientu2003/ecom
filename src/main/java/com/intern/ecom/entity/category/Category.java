package com.intern.ecom.entity.category;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "uuid_category", nullable = false, length = 40)
    private String uuidCategory;

    @Column(name = "title", nullable = false, length = 75)
    private String title;

    @Column(name = "meta_title", length = 100)
    private String metaTitle;

    @Column(name = "slug", nullable = false, length = 100)
    private String slug;

    @Lob
    @Column(name = "content")
    private String content;

    public String getUuidCategory() {
        return uuidCategory;
    }

    public void setUuidCategory(String uuidCategory) {
        this.uuidCategory = uuidCategory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}