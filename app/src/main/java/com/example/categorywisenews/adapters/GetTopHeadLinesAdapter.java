package com.example.categorywisenews.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.categorywisenews.API.response.ArticlesItem;
import com.example.categorywisenews.API.response.SourcesItem;
import com.example.categorywisenews.ClickListner;
import com.example.categorywisenews.activities.DiffCatActivity;
import com.example.categorywisenews.activities.MainActivity;
import com.example.categorywisenews.R;

import java.util.List;


public class GetTopHeadLinesAdapter extends RecyclerView.Adapter<GetTopHeadLinesAdapter.ViewHolder> {

//    private ArrayList<ArticlesItem> articlesItems;
    public Context context;
    List<ArticlesItem> getArticlerList;
    ImageView urlToImg;
    RecyclerView rv_cat_news;
    TextView title_con, con_news, des_news ,time, author;

    public GetTopHeadLinesAdapter(Context context, List<ArticlesItem> articlesItems) {
        this.context = context;
        this.getArticlerList = articlesItems;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView urlToImg;
        LinearLayout layoutclick;
        TextView title_con, con_news, des_news ,time, author;
        private ClickListner clicklistener= null;

        public ViewHolder(View itemView) {
            super( itemView );
            this.title_con = (TextView) itemView.findViewById(R.id.title_con);
            this.con_news = (TextView) itemView.findViewById(R.id.con_news);
            this.des_news = (TextView) itemView.findViewById(R.id.des_news);
            this.author = (TextView) itemView.findViewById(R.id.author);
            this.time = (TextView) itemView.findViewById(R.id.time);
            this.urlToImg = (ImageView) itemView.findViewById(R.id.urlToImg);
        }
    }


    @Override
    public GetTopHeadLinesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.list_card_source, parent, false);
        view.setOnClickListener( MainActivity.myOnClickListener);
//        Log.d("TAG", "onCreateViewHolder: "+"  ?anything happened? ");
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(GetTopHeadLinesAdapter.ViewHolder holder, int position) {

        ArticlesItem articlesItem = getArticlerList.get( position );

        holder.title_con.setText(articlesItem.getTitle());
            holder.con_news.setText(articlesItem.getContent());
            holder.des_news.setText(articlesItem.getDescription());
            holder.time.setText(articlesItem.getPublishedAt());
            holder.author.setText(String.valueOf( articlesItem.getAuthor()));
        Log.d( "yoyo", "onBindViewHolder: " + " --- " + String.valueOf( articlesItem.getAuthor())+ " --- " + articlesItem.getAuthor());
            Glide.with(context)
                    .load(articlesItem.getUrlToImage())
                    .into(holder.urlToImg);
    }

    @Override
    public int getItemCount() {
        return getArticlerList.size();
    }
}