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
public class Chapter {
    private String id;
    @Nullable
    private String link_small_icon;
   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink_small_icon() {
        return link_small_icon;
    }

    public void setLink_small_icon(String link_small_icon) {
        this.link_small_icon = link_small_icon;
    }

  
}
