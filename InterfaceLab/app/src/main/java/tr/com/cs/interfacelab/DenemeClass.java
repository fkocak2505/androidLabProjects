package tr.com.cs.interfacelab;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by fkocak on 20.02.2018.
 */

public class DenemeClass<T> implements Deneme {

    Context context;
    Class<T> tClass;

    public DenemeClass(){}

    public DenemeClass(Context context){
        this.context = context;
    }

    public DenemeClass(Class<T> tClass){
        this.tClass = tClass;
    }

    @Override
    public void deneme() {

        Toast.makeText(context, "Deneme Başarılı", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean isNetworkEnable() {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();

    }
}
