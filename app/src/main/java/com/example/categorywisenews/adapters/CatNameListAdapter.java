package com.example.categorywisenews.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.categorywisenews.activities.DiffCatActivity;
import com.example.categorywisenews.activities.MainActivity;
import com.example.categorywisenews.R;
import com.example.categorywisenews.activities.OtherTrialActivity;
import com.example.categorywisenews.models.CategoryModel;
import com.google.gson.Gson;

import java.util.ArrayList;

public class CatNameListAdapter extends RecyclerView.Adapter<CatNameListAdapter.MyViewHolder> {

    public Context mContext;
    public ArrayList<CategoryModel> categoryModelArrayList;
    public static final String MSG = "com.example.categorywisenews.adapters.ORDER";

    public CatNameListAdapter(MainActivity mContext, ArrayList<CategoryModel> categoryModelNameArrayList) {
        this.mContext=mContext;
        this.categoryModelArrayList= categoryModelNameArrayList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView cat_img;
        TextView cat_name;

        public MyViewHolder(View itemView) {
            super( itemView );
            this.cat_name = (TextView) itemView.findViewById( R.id.cat_name);
            this.cat_img = (ImageView) itemView.findViewById(R.id.cat_img);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.list_catagory, parent, false);
        view.setOnClickListener( MainActivity.myOnClickListener);
        CatNameListAdapter.MyViewHolder myViewHolder = new CatNameListAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {

        CategoryModel categoryModel = categoryModelArrayList.get( position );
        holder.cat_name.setText(categoryModel.getNameCat());
        Glide.with(mContext)
                .load(categoryModel.getImgCat())
                .into(holder.cat_img);

      /*  holder.cat_name.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d( "mg-rv-item-id-click", "onClick: woahhhhhhh its clickable"  );
                Intent i=new Intent(mContext, OtherTrialActivity.class);
                mContext.startActivity( i );
            }
        } );*/

        holder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new Gson();
                String s=  categoryModel.getNameCat();
                Intent intent = new Intent(mContext, DiffCatActivity.class);
                intent.putExtra("obj", gson.toJson(categoryModel));
                intent.putExtra( MSG , s);
                mContext.startActivity(intent);
                ((Activity) mContext).finish();
            }
        } );
    }

    @Override
    public int getItemCount() {
        return categoryModelArrayList.size();
    }

}
