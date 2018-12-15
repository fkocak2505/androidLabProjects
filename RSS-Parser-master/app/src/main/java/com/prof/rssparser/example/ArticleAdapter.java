/*
*   Copyright 2016 Marco Gomiero
*
*   Licensed under the Apache License, Version 2.0 (the "License");
*   you may not use this file except in compliance with the License.
*   You may obtain a copy of the License at
*
*       http://www.apache.org/licenses/LICENSE-2.0
*
*   Unless required by applicable law or agreed to in writing, software
*   distributed under the License is distributed on an "AS IS" BASIS,
*   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*   See the License for the specific language governing permissions and
*   limitations under the License.
*
*/

package com.prof.rssparser.example;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.prof.rssparser.Article;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Marco Gomiero on 12/02/2015.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private ArrayList<Article> articles;

    private int rowLayout;
    private Context mContext;
    WebView articleView;

    public ArticleAdapter(ArrayList<Article> list, int rowLayout, Context context) {

        this.articles = list;
        this.rowLayout = rowLayout;
        this.mContext = context;
    }


    @Override
    public long getItemId(int item) {
        // TODO Auto-generated method stub
        return item;
    }

    public void clearData() {
        if (articles != null)
            articles.clear();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        Article currentArticle = articles.get(position);
        viewHolder.title.setText(currentArticle.getTitle());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                String title = articles.get(position).getTitle();
                String link = articles.get(position).getLink();

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                mContext.startActivity(browserIntent);


            }


        });
    }

    @Override
    public int getItemCount() {

        return articles == null ? 0 : articles.size();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public ViewHolder(View itemView) {

            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}