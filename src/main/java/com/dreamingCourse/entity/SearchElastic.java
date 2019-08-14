package com.dreamingCourse.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = SearchElastic.INDEX , type = SearchElastic.ORDER_TYPE)
public class SearchElastic {
    public static final String INDEX = "ykt";

    public static final String ORDER_TYPE = "_doc";
    @Id
    private  String id;
    private String name;
    private String subtitle;
    private String detail;
    private String main_images;
    @Field(type = FieldType.Double)
    private String price;
    private String tag_id;

    public SearchElastic(String id, String name, String subtitle, String detail, String main_images, String price, String tag_id) {
        this.id = id;
        this.name = name;
        this.subtitle = subtitle;
        this.detail = detail;
        this.main_images = main_images;
        this.price = price;
        this.tag_id = tag_id;
    }
    public SearchElastic(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getMain_images() {
        return main_images;
    }

    public void setMain_images(String main_images) {
        this.main_images = main_images;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTag_id() {
        return tag_id;
    }

    public void setTag_id(String tag_id) {
        this.tag_id = tag_id;
    }
}
