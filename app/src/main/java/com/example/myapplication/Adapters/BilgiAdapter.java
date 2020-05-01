package com.example.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Models.Bilgi;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

//18: bu class BaseAdapterdan kalıtım alır daima
public class BilgiAdapter extends BaseAdapter {
    //19: nesnelerimizi tanımlayalım
    List<Bilgi> list;
    Context context;
    //20: nesnelere ait constructor oluşturalım
    //sağ tık-generate-constructor
    public BilgiAdapter(List<Bilgi> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    //21: listSize döndür
    public int getCount() {
        return list.size();
    }

    @Override
    //22: listtenin positionunuu döndür
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    //23: burada converView dönecek ve View ları tanımlayacağız
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.layout,parent,false);
        TextView AlbumId = convertView.findViewById(R.id.idAlbumId);
        TextView ID =convertView.findViewById(R.id.idId);
        TextView title = convertView.findViewById(R.id.idTitle);
        TextView url=convertView.findViewById(R.id.idUrl);
        ImageView img = convertView.findViewById(R.id.idImg);
        //24:Viewların text lerini çekelim ve burada tanımladığmız view lara atayalım
        //AlbumId integer dönüyor o yüzde ""+ bu string ifade ile birleştir
        AlbumId.setText(""+list.get(position).getAlbumId());
        ID.setText(""+list.get(position).getId());
        title.setText(list.get(position).getTitle());
        url.setText(list.get(position).getUrl());

        //25: picasso kütüphanesini kullanarak resmi çekelim
        Picasso.with(context).load(list.get(position).getThumbnailUrl()).into(img);
        return convertView;
    }
}
