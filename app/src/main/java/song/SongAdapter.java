package song;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp_phamtuandat.R;
import com.example.musicapp_phamtuandat.song_play;

import java.util.List;

import service.MyService;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder>{
    private Context mContext;
    private List<Song> mSongs;

    public SongAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Song> list){
        this.mSongs = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dexuat,parent,false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        Song song = mSongs.get(position);
        if(song == null){
            return;
        }
        holder.imgSong.setImageResource(song.getResourceId());
        holder.tvNameSong.setText(song.getNameSong());
        holder.tvArtist.setText(song.getNameArtist());

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickGoToSongPlay(song);
            }
        });
    }

    private void onClickGoToSongPlay(Song song){
        Intent intent = new Intent(mContext, song_play.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_song", song);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    public void release(){
        mContext = null;
    }

    @Override
    public int getItemCount() {
        if(mSongs != null){
            return mSongs.size();
        }
        return 0;
    }

    public class SongViewHolder extends RecyclerView.ViewHolder{

        private RelativeLayout relativeLayout;

        private ImageView imgSong;
        private TextView tvNameSong;
        private TextView tvArtist;

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.layout_song);
            imgSong = itemView.findViewById(R.id.img_dexuat2);
            tvNameSong = itemView.findViewById(R.id.tv_tieudeBaiHat);
            tvArtist = itemView.findViewById(R.id.tv_nghesi);

        }
    }
}
