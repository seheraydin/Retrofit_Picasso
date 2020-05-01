package com.example.myapplication.RestApi;

import com.example.myapplication.Models.Bilgi;

import java.util.List;

import retrofit2.Call;

//bu sınıf BaseMAnager sınıfından kalıtılmalı
//protected metodu kullanmak için
public class ManagerAll extends BaseManager{
    //9: ana activity mizide bu classı çağıracağız
    //bu clasın kendisini döndürelim yani main activity de bu claassın
    //nesnesini oluştumamak için instance yapalım
    private static ManagerAll ourGetInstance =new ManagerAll();

    //10: bu classın dönmesini sağlayan bir metot tanımlayalım
    public static synchronized ManagerAll getInstance()
    {
        return ourGetInstance;
    }
    //11: main activity de çağğıracağımız fonksiyonu tanımlayalım
    public Call<List<Bilgi>> getirBilgi()
    {
        //BaseManager RestApi yi döndürüyor. BaseManager içerisindeki
        //getRestApiClient metodunu kullanalım
        Call<List<Bilgi>> x = getRestapiClient().getir();
        return x;
    }

}
