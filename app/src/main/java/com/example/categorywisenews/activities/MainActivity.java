package com.example.categorywisenews.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.categorywisenews.API.APIInterface;
import com.example.categorywisenews.API.ApiClient;
import com.example.categorywisenews.API.response.GetTopHeadLinesResponse;
import com.example.categorywisenews.R;
import com.example.categorywisenews.adapters.CatNameListAdapter;
import com.example.categorywisenews.adapters.GetTopHeadLinesAdapter;
import com.example.categorywisenews.models.CategoryModel;
import com.example.categorywisenews.util.CatNameList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_cat_news_source, rv_cat_list;
    GetTopHeadLinesAdapter adapter;
    CatNameListAdapter catNameListAdapter;
    public static View.OnClickListener myOnClickListener;
    List<GetTopHeadLinesResponse> getTopHeadLinesResponseArrayList= new ArrayList<>();
    ArrayList<CategoryModel> categoryModels;
    List<CatNameList> catNameLists;

//    List<ArticlesItem> articlesItems= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);

        rv_cat_news_source= findViewById( R.id.rv_cat_news_source );
        rv_cat_list= findViewById( R.id.rv_cat_list );
        rv_cat_news_source.setLayoutManager(new LinearLayoutManager(this));
        //rv_cat_list.setLayoutManager(new LinearLayoutManager(this));

        categoryModels=new ArrayList<>();
        categoryModels.add(new CategoryModel("https://images.unsplash.com/photo-1570126646281-5ec88111777f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1141&q=80", "Business"));
        categoryModels.add(new CategoryModel("https://media.istockphoto.com/photos/the-musicians-were-playing-rock-music-on-stage-there-was-an-audience-picture-id1319479588", "Entertainment"));
        categoryModels.add(new CategoryModel("https://images.unsplash.com/photo-1507925921958-8a62f3d1a50d?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1176&q=80", "General"));
        categoryModels.add(new CategoryModel("https://images.unsplash.com/photo-1506126613408-eca07ce68773?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=799&q=80", "Health"));
        categoryModels.add(new CategoryModel("https://media.istockphoto.com/photos/computer-hacker-with-icons-working-and-stealing-information-on-laptop-picture-id914796628?s=612x612", "Science"));
        categoryModels.add(new CategoryModel("https://images.unsplash.com/photo-1579952363873-27f3bade9f55?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=735&q=80", "Sports"));
        categoryModels.add(new CategoryModel("https://images.unsplash.com/photo-1485827404703-89b55fcc595e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1170&q=80", "Technology"));

        catNameListAdapter = new CatNameListAdapter(MainActivity.this, categoryModels);
        rv_cat_list.setScrollingTouchSlop( RecyclerView.HORIZONTAL );
        rv_cat_list.setAdapter( catNameListAdapter );


        APIInterface apiInterface = ApiClient.getRetrofitInstance().create(APIInterface.class);
        Call<GetTopHeadLinesResponse>call= apiInterface.getTopHeadLines( "in","51b0cdb639bf41ed9a7f361b7d75521f" );
       call.enqueue( new Callback<GetTopHeadLinesResponse>() {
           @Override
           public void onResponse(Call<GetTopHeadLinesResponse> call, Response<GetTopHeadLinesResponse> response) {
               if (response.isSuccessful()){
//                   getTopHeadLinesResponseArrayList.size();
                   getTopHeadLinesResponseArrayList = new ArrayList<>();
                   getTopHeadLinesResponseArrayList.add( response.body() );
                   adapter = new GetTopHeadLinesAdapter( MainActivity.this,  getTopHeadLinesResponseArrayList.get( 0 ).getArticles());
                   rv_cat_news_source.setAdapter( adapter );
                   Log.d( "GetTopHeadLinesResponse", "onResponse: "+ response.body().getArticles().size() );
               }
           }

           @Override
           public void onFailure(Call<GetTopHeadLinesResponse> call, Throwable t) {
               Log.d( "GetTopHeadLinesResponse", "onResponse: "+ t.getMessage() );
           }
       } );
    }
}