package com.example.fkocak.notificationmanager;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.vdurmont.emoji.EmojiParser;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlarmReceiver extends Service {

    Timer timer;
    TimerTask timerTask;
    String TAG = "Timers";


    IApiInterface4Dictionary iApiInterface4Dictionary;
    RetrofitCallInvoker retrofitCallInvoker;
    Bitmap bitmap;


    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand");
        super.onStartCommand(intent, flags, startId);

        startTimer();

        return START_STICKY;
    }


    @Override
    public void onCreate() {
        Log.e(TAG, "onCreate");


    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy");
        stoptimertask();
        super.onDestroy();
    }

    final Handler handler = new Handler();

    public void startTimer() {
        timer = new Timer();
        initializeTimerTask();
        timer.schedule(timerTask, 0,  10000); //
    }

    public void stoptimertask() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    public void initializeTimerTask() {

        timerTask = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        sendNotification();
                    }
                });
            }
        };
    }

    public void sendNotification() {
        iApiInterface4Dictionary = ApiClient.getClient().create(IApiInterface4Dictionary.class);

        retrofitCallInvoker = new RetrofitCallInvoker();
        RetrofitCallReceiver retrofitCallReceiver = new RetrofitCallReceiver();
        ICommandCallService commandCallService = new ConcreteCommand(retrofitCallReceiver);
        retrofitCallInvoker.setCommandCallService(commandCallService);

        retrofitCallInvoker.callServiceAsync(setHangmanRandomWord(String.class), new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                final Example example = new Gson().fromJson(response.body(),Example.class);
                if(example.getImages().size() != 0) {
                    int index = new Random().nextInt(example.getImages().size());
                    Toast.makeText(AlarmReceiver.this, index + " ", Toast.LENGTH_SHORT).show();
                    Picasso.with(getApplicationContext()).load(example.getImages().get(index).getUrl()).into(new Target() {
                        @Override
                        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                            Toast.makeText(AlarmReceiver.this, "Başarılı", Toast.LENGTH_SHORT).show();

                            String title = "Kelimeniz fırından yeni çıktı :bread: :rocket:";
                            String summaryText = ":pencil2: Kelimeniz: Dog :pencil2: Türkçe Anlamı Köpek' dir. :blush:";
                            String contentText = "Görmek için bildirimi sürükleyin.. :sunglasses: :incoming_envelope:";

                            String rTitle = EmojiParser.parseToUnicode(title);
                            String rSummaryText = EmojiParser.parseToUnicode(summaryText);
                            String rContentText = EmojiParser.parseToUnicode(contentText);
                            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getApplicationContext());
                            notificationBuilder.setSmallIcon(R.mipmap.clock);
                            notificationBuilder.setContentTitle(rTitle);
                            notificationBuilder.setContentText(rContentText);
                            notificationBuilder.setTicker("Yeni Kelimeniz var !");

                            NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle().bigPicture(bitmap);
                            bigPictureStyle.setSummaryText(rSummaryText);
                            notificationBuilder.setStyle(bigPictureStyle);

                            Intent resultIntent = new Intent(getApplicationContext(), MainActivity.class);
                            TaskStackBuilder TSB = TaskStackBuilder.create(getApplicationContext());
                            TSB.addParentStack(MainActivity.class);
                            TSB.addNextIntent(resultIntent);
                            PendingIntent resultPendingIntent = TSB.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

                            notificationBuilder.setContentIntent(resultPendingIntent);
                            notificationBuilder.setAutoCancel(true);
                            notificationBuilder.setTicker("trickk");
                            notificationBuilder.setDefaults(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND | Notification.FLAG_SHOW_LIGHTS);
                            notificationBuilder.setVisibility(NotificationCompat.VISIBILITY_PUBLIC);//to show content in lock screen

                            NotificationManager mNotificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
                            mNotificationManager.notify(11221, notificationBuilder.build());
                        }

                        @Override
                        public void onBitmapFailed(Drawable errorDrawable) {
                            Toast.makeText(AlarmReceiver.this, "Başarılı değil", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onPrepareLoad(Drawable placeHolderDrawable) {
                            Toast.makeText(AlarmReceiver.this, "PreLoad Start", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                else Toast.makeText(getApplicationContext(), "Resim bulunamadı", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "fawfawfawfawf", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public <T> Call<T> setHangmanRandomWord(Class<T> tClass) {
        Call<T> call = (Call<T>) iApiInterface4Dictionary.getHangmanWord("dog");
        return call;
    }

}