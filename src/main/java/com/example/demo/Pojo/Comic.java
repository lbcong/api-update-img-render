/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Pojo;

import org.springframework.lang.Nullable;

/**
 *
 * @author Alex
 */
public class Comic {

    private String id;
    @Nullable
    private String link_bg;
    @Nullable
    private String link_avatar;
    @Nullable
    private String link_comic_name;
    @Nullable
    private String link_banner;
    @Nullable
    private String link_video_banner_2;
    @Nullable
    private String link_video_banner;
    @Nullable
    private String link_comic_small_name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink_bg() {
        return link_bg;
    }

    public void setLink_bg(String link_bg) {
        this.link_bg = link_bg;
    }

    public String getLink_avatar() {
        return link_avatar;
    }

    public void setLink_avatar(String link_avatar) {
        this.link_avatar = link_avatar;
    }

    public String getLink_comic_name() {
        return link_comic_name;
    }

    public void setLink_comic_name(String link_comic_name) {
        this.link_comic_name = link_comic_name;
    }

    public String getLink_banner() {
        return link_banner;
    }

    public void setLink_banner(String link_banner) {
        this.link_banner = link_banner;
    }

    public String getLink_video_banner_2() {
        return link_video_banner_2;
    }

    public void setLink_video_banner_2(String link_video_banner_2) {
        this.link_video_banner_2 = link_video_banner_2;
    }

    public String getLink_video_banner() {
        return link_video_banner;
    }

    public void setLink_video_banner(String link_video_banner) {
        this.link_video_banner = link_video_banner;
    }

    public String getLink_comic_small_name() {
        return link_comic_small_name;
    }

    public void setLink_comic_small_name(String link_comic_small_name) {
        this.link_comic_small_name = link_comic_small_name;
    }

}
