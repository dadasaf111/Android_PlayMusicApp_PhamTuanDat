package service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.musicapp_phamtuandat.R;
import com.example.musicapp_phamtuandat.song_play;

import song.Song;

public class MyService extends Service {

    public static final int ACTION_PAUSE =1;
    public static final int ACTION_RESUME =2;
    public static final int ACTION_CLEAR =3;
    public static final int ACTION_START =4;

    private MediaPlayer mediaPlayer;
    private Boolean isPlaying;
    private Song mSong;


    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("Dat","My service onCreate");

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle bundle =  intent.getExtras();
        if(bundle != null){
            Song song = (Song) bundle.get("object_song");
            if(song != null) {
                mSong = song;
                startMusic(song);
                sendNotification(song);
            }
        }

        int actionMusic = intent.getIntExtra("action_music_service",0);
        handleActionMusic(actionMusic);


        return START_NOT_STICKY;
    }

    private void handleActionMusic(int actionMusic) {
        switch (actionMusic){
            case ACTION_PAUSE:
                pauseMusic();
                break;

            case ACTION_RESUME:
                resumeMusic();
                break;

            case ACTION_CLEAR:
                stopSelf();
                sendActionToActivity(ACTION_CLEAR);
                break;
        }
    }

    private void resumeMusic() {
        if (mediaPlayer != null && !isPlaying){
            mediaPlayer.start();
            isPlaying = true;
            sendNotification(mSong);
            sendActionToActivity(ACTION_RESUME);
        }
    }

    private void pauseMusic() {
        if (mediaPlayer != null && isPlaying){
            mediaPlayer.pause();
            isPlaying = false;
            sendNotification(mSong);
            sendActionToActivity(ACTION_PAUSE);
        }
    }

    private void sendNotification(Song song) {
        Intent intent = new Intent(this, song_play.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), song.getResourceId());

        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.layout_custom_nofiticatoin);
        remoteViews.setTextViewText(R.id.tv_Title,song.getNameSong());
        remoteViews.setTextViewText(R.id.tv_Singer,song.getNameArtist());
        remoteViews.setImageViewBitmap(R.id.img_song, bitmap);

        remoteViews.setImageViewResource(R.id.img_play_or_pause,R.drawable.outline_pause_circle_black_20);

        if(isPlaying){
            remoteViews.setOnClickPendingIntent(R.id.img_play_or_pause,getPendingIntent(this,ACTION_PAUSE));
            remoteViews.setImageViewResource(R.id.img_play_or_pause,R.drawable.outline_pause_circle_black_20);
        } else {
            remoteViews.setOnClickPendingIntent(R.id.img_play_or_pause,getPendingIntent(this,ACTION_RESUME));
            remoteViews.setImageViewResource(R.id.img_play_or_pause,R.drawable.outline_play_circle_black_20);
        }

        remoteViews.setOnClickPendingIntent(R.id.img_clear,getPendingIntent(this,ACTION_CLEAR));



        Notification notification = new NotificationCompat.Builder(this, MyApplication.CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notifocation)
                .setContentIntent(pendingIntent)
                .setCustomContentView(remoteViews)
                .setSound(null)
                .build();

        startForeground(1,notification);

    }

    private void startMusic(Song song) {
        if(mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), song.getMp3());
        }
        mediaPlayer.start();
        isPlaying = true;
        sendActionToActivity(ACTION_START);
    }

    private void sendActionToActivity(int actionStart) {
        Intent intent = new Intent("send_data_to_activity");
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_song",mSong);
        bundle.putBoolean("status_player", isPlaying);
        bundle.putInt("action_music", actionStart);

        intent.putExtras(bundle);

        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);

    }
    private PendingIntent getPendingIntent(Context context, int action){
        Intent intent = new Intent(this, MyReciever.class);
        intent.putExtra("action_music",action);

        return PendingIntent.getBroadcast(context.getApplicationContext(),action,intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("Dat","My service onDestroy");
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
