package com.example.myapplication.RestApi;

import com.example.myapplication.Models.Bilgi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    //url : https://jsonplaceholder.typicode.com/photos
    //4: get anatotionunu ekle ve url in son kısmını tanımla
    @GET("/photos")
    //5: Bilgi interface class tipinde bir tane list oluşturalım
    Call<List<Bilgi>> getir();
}
