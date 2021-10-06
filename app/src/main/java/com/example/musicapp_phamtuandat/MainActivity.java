package com.example.musicapp_phamtuandat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import item.Item;
import item.ItemAdapter;
import song.Song;
import song.SongAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPhatGanDay;
    private ItemAdapter itemAdapter;

    private RecyclerView rcv_DeXuat;
    private SongAdapter songAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewPhatGanDay = findViewById(R.id.rcv_phatGanDay);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerViewPhatGanDay.setLayoutManager(linearLayoutManager);
        itemAdapter = new ItemAdapter(this);
        itemAdapter.setData(getItems());
        recyclerViewPhatGanDay.setAdapter(itemAdapter);

        rcv_DeXuat = findViewById(R.id.rcv_DeXuat);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcv_DeXuat.setLayoutManager(linearLayoutManager1);
        songAdapter = new SongAdapter(this);
        songAdapter.setData(getSongsDeXuat());
        rcv_DeXuat.setAdapter(songAdapter);

    }

    private List<Song> getSongsDeXuat(){
        List<Song> listSong =  new ArrayList<>();
        listSong.add(new Song(R.drawable.anhnhaodau,"Anh nhà ở đâu thế!","Amee"));
//        listSong.add(new Song(R.drawable.dendakhongduong,"Đen đá không đường","Amee"));
        listSong.add(new Song(R.drawable.chayngaydi,"Chạy ngay đi","Sơn Tùng M-TP"));
        listSong.add(new Song(R.drawable.cohenthanhxuan,"Có hẹn với thanh xuân","Monstar"));
        listSong.add(new Song(R.drawable.chungtacuahientai,"Chúng ta của hiện tại","Sơn Tùng M-TP"));
        listSong.add(new Song(R.drawable.chayngaydi,"Chạy ngay đi","Sơn Tùng M-TP"));
        listSong.add(new Song(R.drawable.cohenthanhxuan,"Có hẹn với thanh xuân","Monstar"));
        listSong.add(new Song(R.drawable.chungtacuahientai,"Chúng ta của hiện tại","Sơn Tùng M-TP"));
        listSong.add(new Song(R.drawable.chayngaydi,"Chạy ngay đi","Sơn Tùng M-TP"));
        listSong.add(new Song(R.drawable.cohenthanhxuan,"Có hẹn với thanh xuân","Monstar"));
        listSong.add(new Song(R.drawable.chungtacuahientai,"Chúng ta của hiện tại","Sơn Tùng M-TP"));
        listSong.add(new Song(R.drawable.chayngaydi,"Chạy ngay đi","Sơn Tùng M-TP"));
        listSong.add(new Song(R.drawable.cohenthanhxuan,"Có hẹn với thanh xuân","Monstar"));
        return listSong;
    }

    private List<Item> getItems(){
        List<Item> listItem = new ArrayList<>();
        listItem.add(new Item(R.drawable.ngungon,"Ngủ ngon","Instrumental"));
        listItem.add(new Item(R.drawable.woukout,"Tập luyện","Rèn luyện cơ thể"));
        listItem.add(new Item(R.drawable.dailymix,"Daili Mix 1","Bản phối cho bạn"));
        listItem.add(new Item(R.drawable.thisisst,"Đây là ST","Những bài hát hay nhất"));
        return listItem;
    }
}
