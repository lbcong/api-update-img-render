/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "comics")
@NamedQueries({
    @NamedQuery(name = "Comics.findAll", query = "SELECT p FROM Comics p")})
public class Comics implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;

    @Column(name = "link_avatar")
    private String linkAvatar;

    @Column(name = "link_comic_name")
    private String linkComicName;

    @Column(name = "link_banner")
    private String linkBanner;

    @Column(name = "link_video_banner_2")
    private String linkVideoBanner2;

    @Column(name = "link_video_banner")
    private String linkVideoBanner;

    @Column(name = "link_comic_small_name")
    private String linkComicSmallName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLinkAvatar() {
        return linkAvatar;
    }

    public void setLinkAvatar(String linkAvatar) {
        this.linkAvatar = linkAvatar;
    }

    public String getLinkComicName() {
        return linkComicName;
    }

    public void setLinkComicName(String linkComicName) {
        this.linkComicName = linkComicName;
    }

    public String getLinkBanner() {
        return linkBanner;
    }

    public void setLinkBanner(String linkBanner) {
        this.linkBanner = linkBanner;
    }

    public String getLinkVideoBanner2() {
        return linkVideoBanner2;
    }

    public void setLinkVideoBanner2(String linkVideoBanner2) {
        this.linkVideoBanner2 = linkVideoBanner2;
    }

    public String getLinkVideoBanner() {
        return linkVideoBanner;
    }

    public void setLinkVideoBanner(String linkVideoBanner) {
        this.linkVideoBanner = linkVideoBanner;
    }

    public String getLinkComicSmallName() {
        return linkComicSmallName;
    }

    public void setLinkComicSmallName(String linkComicSmallName) {
        this.linkComicSmallName = linkComicSmallName;
    }




    
    
}
