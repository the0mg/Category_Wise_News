package com.example.categorywisenews.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.categorywisenews.API.response.ArticlesItem;
import com.example.categorywisenews.API.response.SourcesItem;
import com.example.categorywisenews.R;
import com.example.categorywisenews.activities.MainActivity;

import java.util.List;

public class GetSourcrsAdapter extends RecyclerView.Adapter<GetSourcrsAdapter.MyViewHolder> {
    TextView name_cat_wise_news, country, description_cat, read_more, lang_cat;
    List<SourcesItem> getSourcesItems;
    Context context;

    public GetSourcrsAdapter(Context context, List<SourcesItem> sourcesItems) {
        this.context = context;
        this.getSourcesItems = sourcesItems;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name_cat_wise_news, country, description_cat, read_more, lang_cat;

        public MyViewHolder(View itemView) {
            super( itemView );
            this.name_cat_wise_news = (TextView) itemView.findViewById( R.id.name_cat_wise_news);
            this.country = (TextView) itemView.findViewById( R.id.country);
            this.description_cat = (TextView) itemView.findViewById( R.id.description_cat);
            this.read_more = (TextView) itemView.findViewById( R.id.read_more);
            this.lang_cat = (TextView) itemView.findViewById( R.id.lang_cat);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.list_cat_wise_news_extra, parent, false);
        view.setOnClickListener( MainActivity.myOnClickListener);
        GetSourcrsAdapter.MyViewHolder myViewHolder = new GetSourcrsAdapter.MyViewHolder(view);
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SourcesItem sourcesItem = getSourcesItems.get( position );
        holder.name_cat_wise_news.setText(sourcesItem.getName());
        holder.country.setText(sourcesItem.getCountry());
        holder.description_cat.setText(sourcesItem.getDescription());
//        holder.read_more.setText(sourcesItem.getUrl());
        holder.lang_cat.setText(sourcesItem.getCategory());
        Log.d( "yoyo", "onBindViewHolder: " + " --- " + " --- " + sourcesItem.getCountry());
    }

    @Override
    public int getItemCount() {
        return getSourcesItems.size();
    }

}
