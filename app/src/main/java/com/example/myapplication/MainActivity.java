package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.myapplication.Adapters.BilgiAdapter;
import com.example.myapplication.Models.Bilgi;
import com.example.myapplication.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //14: Bilgi classı tipinde bir list oluşturalım
    List<Bilgi> list;
    //27: activity_main.xml deki listview ın nesnesini oluşturalım
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //29: tanimla fonk
        tanimla();
        //13: istek fonk
        istek();
    }

    //28:activity_main.xml deki view ı tanımlayalım
    public void tanimla() {
        listView = findViewById(R.id.idLst);
    }

    //12: web servisten cevap alalım
    public void istek() {
        //15:listemizi tanımlayalım
        list = new ArrayList<>();
        //31:progressDialog oluşturalım
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Bilgiler Ekranı");
        //32:progressDialogda gösterilecek mesajı set edelim
        progressDialog.setMessage("İçerik Yükleniyor, Lütfen Bekleyiniz");
        //33: iptal edilebilirliği false yapalım çünkü kullanıcı ekran yüklenene kadar
        //herhangi bir yere tıkladığnda mesaj kaybolmasın
        progressDialog.setCancelable(false);
        progressDialog.show();;

        Call<List<Bilgi>> servis = ManagerAll.getInstance().getirBilgi();
        servis.enqueue(new Callback<List<Bilgi>>() {
            @Override
            public void onResponse(Call<List<Bilgi>> call, Response<List<Bilgi>> response) {
                //eğer ki response başarılıysa
                if (response.isSuccessful()) {
                    //loglayalım bakalım doğru bir şekilde servisten cevap geldi mi
                    //Log.i("cevappp",response.body().toString());
                    //16: listem,ze cevabın body sini ekleyelim
                    //body bize listemizin interface classı tipinde değer döndürür
                    list = response.body();
                    //30: adapter ımızı oluşturalım ve set edelim yani listeyi dolduralım
                    BilgiAdapter bilgiAdapter = new BilgiAdapter(list, getApplicationContext());
                    listView.setAdapter(bilgiAdapter);
                }
                //34: liste doldurma işlemi bittiğinde progressDialog kapansın
                progressDialog.cancel();


            }

            @Override
            public void onFailure(Call<List<Bilgi>> call, Throwable t) {

            }
        });

    }

}
