package com.example.fkocak.notificationmanager;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.vdurmont.emoji.EmojiParser;

import java.io.InputStream;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyNotification extends BroadcastReceiver {

    IApiInterface4Dictionary iApiInterface4Dictionary;
    RetrofitCallInvoker retrofitCallInvoker;
    Bitmap bitmap;

    Context mContext;


    @Override
    public void onReceive(final Context context, Intent intent) {
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            new Timer().scheduleAtFixedRate(new TimerTask() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void run() {
                    sendNotif(context);

                }
            }, 0, 60000);
        } else {
            sendNotif(context);
        }*/
        mContext = context;
        sendNotif(context);
    }

    public void sendNotif(final Context context) {
        iApiInterface4Dictionary = ApiClient.getClient().create(IApiInterface4Dictionary.class);

        retrofitCallInvoker = new RetrofitCallInvoker();
        RetrofitCallReceiver retrofitCallReceiver = new RetrofitCallReceiver();
        ICommandCallService commandCallService = new ConcreteCommand(retrofitCallReceiver);
        retrofitCallInvoker.setCommandCallService(commandCallService);

        retrofitCallInvoker.callServiceAsync(setHangmanRandomWord(String.class), new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                final Example example = new Gson().fromJson(response.body(), Example.class);
                if (example.getImages().size() != 0) {
                    int index = new Random().nextInt(example.getImages().size());
                    Toast.makeText(context, index + " ", Toast.LENGTH_SHORT).show();

                    Glide.with(context)
                            .asBitmap()
                            .load(example.getImages().get(index).getUrl())
                            .into(new SimpleTarget<Bitmap>() {
                                @Override
                                public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                                    Toast.makeText(context, "Başarılı", Toast.LENGTH_SHORT).show();

                                    String title = "Kelimeniz fırından yeni çıktı :bread: :rocket:";
                                    String summaryText = ":pencil2: Kelimeniz: Dog :pencil2: Türkçe Anlamı Köpek' dir. :blush:";
                                    String contentText = "Görmek için bildirimi sürükleyin.. :sunglasses: :incoming_envelope:";

                                    String rTitle = EmojiParser.parseToUnicode(title);
                                    String rSummaryText = EmojiParser.parseToUnicode(summaryText);
                                    String rContentText = EmojiParser.parseToUnicode(contentText);
                                    NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context);
                                    notificationBuilder.setSmallIcon(R.mipmap.clock);
                                    notificationBuilder.setContentTitle(rTitle);
                                    notificationBuilder.setContentText(rContentText);
                                    notificationBuilder.setTicker("Yeni Kelimeniz var !");

                                    NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle().bigPicture(resource);
                                    bigPictureStyle.setSummaryText(rSummaryText);
                                    notificationBuilder.setStyle(bigPictureStyle);

                                    Intent resultIntent = new Intent(context, MainActivity.class);
                                    TaskStackBuilder TSB = TaskStackBuilder.create(context);
                                    TSB.addParentStack(MainActivity.class);
                                    TSB.addNextIntent(resultIntent);
                                    PendingIntent resultPendingIntent = TSB.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

                                    notificationBuilder.setContentIntent(resultPendingIntent);
                                    notificationBuilder.setAutoCancel(true);
                                    notificationBuilder.setTicker("trickk");
                                    notificationBuilder.setDefaults(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND | Notification.FLAG_SHOW_LIGHTS);
                                    notificationBuilder.setVisibility(NotificationCompat.VISIBILITY_PUBLIC);//to show content in lock screen

                                    NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                                    mNotificationManager.notify(11221, notificationBuilder.build());
                                }
                            });



                    /*Picasso.with(context).load(example.getImages().get(index).getUrl()).into(new Target() {
                        @Override
                        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                            Toast.makeText(context, "Başarılı", Toast.LENGTH_SHORT).show();

                            String title = "Kelimeniz fırından yeni çıktı :bread: :rocket:";
                            String summaryText = ":pencil2: Kelimeniz: Dog :pencil2: Türkçe Anlamı Köpek' dir. :blush:";
                            String contentText = "Görmek için bildirimi sürükleyin.. :sunglasses: :incoming_envelope:";

                            String rTitle = EmojiParser.parseToUnicode(title);
                            String rSummaryText = EmojiParser.parseToUnicode(summaryText);
                            String rContentText = EmojiParser.parseToUnicode(contentText);
                            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context);
                            notificationBuilder.setSmallIcon(R.mipmap.clock);
                            notificationBuilder.setContentTitle(rTitle);
                            notificationBuilder.setContentText(rContentText);
                            notificationBuilder.setTicker("Yeni Kelimeniz var !");

                            NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle().bigPicture(bitmap);
                            bigPictureStyle.setSummaryText(rSummaryText);
                            notificationBuilder.setStyle(bigPictureStyle);

                            Intent resultIntent = new Intent(context, MainActivity.class);
                            TaskStackBuilder TSB = TaskStackBuilder.create(context);
                            TSB.addParentStack(MainActivity.class);
                            TSB.addNextIntent(resultIntent);
                            PendingIntent resultPendingIntent = TSB.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

                            notificationBuilder.setContentIntent(resultPendingIntent);
                            notificationBuilder.setAutoCancel(true);
                            notificationBuilder.setTicker("trickk");
                            notificationBuilder.setDefaults(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND | Notification.FLAG_SHOW_LIGHTS);
                            notificationBuilder.setVisibility(NotificationCompat.VISIBILITY_PUBLIC);//to show content in lock screen

                            NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                            mNotificationManager.notify(11221, notificationBuilder.build());
                        }

                        @Override
                        public void onBitmapFailed(Drawable errorDrawable) {
                            Toast.makeText(context, "Başarılı değil", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onPrepareLoad(Drawable placeHolderDrawable) {
                            Toast.makeText(context, "PreLoad Start", Toast.LENGTH_SHORT).show();
                        }
                    });*/
                }

                else Toast.makeText(context, "Resim bulunamadı", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(context, "fawfawfawfawf", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public <T> Call<T> setHangmanRandomWord(Class<T> tClass) {
        Call<T> call = (Call<T>) iApiInterface4Dictionary.getHangmanWord("dog");
        return call;
    }

}

