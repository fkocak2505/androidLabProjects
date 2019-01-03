package com.example.fkocak.customtoggleswitch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class ToggleSwitchButtonCustom {

    private View view;
    private TextView textView;
    private View separator;

    public ToggleSwitchButtonCustom(Context context) {
        this(LayoutInflater.from(context).inflate(belka.us.androidtoggleswitch.R.layout.item_widget_toggle_switch, null));
    }

    public ToggleSwitchButtonCustom(View view) {
        this.view = view;
        this.textView = (TextView) view.findViewById(belka.us.androidtoggleswitch.R.id.text_view);
        this.separator = view.findViewById(belka.us.androidtoggleswitch.R.id.separator);
    }

    public View getView() {
        return view;
    }

    public TextView getTextView() {
        return textView;
    }

    public View getSeparator() {
        return separator;
    }

    public void showSeparator(){
        getSeparator().setVisibility(View.VISIBLE);
    }

    public void hideSeparator(){
        getSeparator().setVisibility(View.INVISIBLE);
    }

}
