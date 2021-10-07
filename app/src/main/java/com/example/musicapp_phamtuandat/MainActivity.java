package com.example.musicapp_phamtuandat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

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
        listSong.add(new Song("Chúng ta của hiện tại","Sơn Tùng M-TP",R.drawable.chungtacuahientai,R.raw.chungtacuahientai));
        listSong.add(new Song("Anh nhà ở đâu thế!","Amee",R.drawable.anhnhaodau,R.raw.anhnhaodau));
        listSong.add(new Song("Đen đá không đường","Amee",R.drawable.dendakhongduong,R.raw.dendakhongduong));
        listSong.add(new Song("Chạy ngay đi","Sơn Tùng M-TP",R.drawable.chayngaydi,R.raw.chayngaydi));
        listSong.add(new Song("Có hẹn với thanh xuân","Monstar",R.drawable.cohenthanhxuan,R.raw.cohenvoithanhxuan));
        listSong.add(new Song("Chúng ta của hiện tại","Sơn Tùng M-TP",R.drawable.chungtacuahientai,R.raw.chungtacuahientai));
        listSong.add(new Song("Anh nhà ở đâu thế!","Amee",R.drawable.anhnhaodau,R.raw.anhnhaodau));
        listSong.add(new Song("Đen đá không đường","Amee",R.drawable.dendakhongduong,R.raw.dendakhongduong));
        listSong.add(new Song("Chạy ngay đi","Sơn Tùng M-TP",R.drawable.chayngaydi,R.raw.chayngaydi));
        listSong.add(new Song("Có hẹn với thanh xuân","Monstar",R.drawable.cohenthanhxuan,R.raw.cohenvoithanhxuan));
        listSong.add(new Song("Chúng ta của hiện tại","Sơn Tùng M-TP",R.drawable.chungtacuahientai,R.raw.chungtacuahientai));
        listSong.add(new Song("Anh nhà ở đâu thế!","Amee",R.drawable.anhnhaodau,R.raw.anhnhaodau));
        listSong.add(new Song("Đen đá không đường","Amee",R.drawable.dendakhongduong,R.raw.dendakhongduong));
        listSong.add(new Song("Chạy ngay đi","Sơn Tùng M-TP",R.drawable.chayngaydi,R.raw.chayngaydi));
        listSong.add(new Song("Có hẹn với thanh xuân","Monstar",R.drawable.cohenthanhxuan,R.raw.cohenvoithanhxuan));
        return listSong;
    }

    private List<Item> getItems(){
        List<Item> listItem = new ArrayList<>();
        listItem.add(new Item(R.drawable.ngungon,"Ngủ ngon","Instrumental"));
        listItem.add(new Item(R.drawable.woukout,"Tập luyện","Rèn luyện cơ thể"));
        listItem.add(new Item(R.drawable.dailymix,"Daili Mix 1","Bản phối cho bạn"));
        listItem.add(new Item(R.drawable.thisisst,"Đây là ST","Những bài hát hay nhất"));
        listItem.add(new Item(R.drawable.ngungon,"Ngủ ngon","Instrumental"));
        listItem.add(new Item(R.drawable.woukout,"Tập luyện","Rèn luyện cơ thể"));
        listItem.add(new Item(R.drawable.dailymix,"Daili Mix 1","Bản phối cho bạn"));
        listItem.add(new Item(R.drawable.thisisst,"Đây là ST","Những bài hát hay nhất"));
        return listItem;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (songAdapter != null){
            songAdapter.release();
        }
    }
}
