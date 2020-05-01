package com.example.myapplication.Models;

public class Bilgi {
    // json datamızın url adresi : https://jsonplaceholder.typicode.com/photos
    //1: json datamıızdaki key lere göre değişkenlerimizi tanımlayalım
    private Integer albumId;
    private Integer id;
    private String title;
    private String url;
    private String thumbnailUrl;


    //2: bu değişkenlere ait getter and setter meetodu
    //sağ tık- generate getter and setter


    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
    //3: loglama yapacağız verileri daha düzenli göstermesi için toString metodu
    //sağ tık-generate-toString

    @Override
    public String toString() {
        return "Bilgi{" +
                "albumId=" + albumId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                '}';
    }
}
