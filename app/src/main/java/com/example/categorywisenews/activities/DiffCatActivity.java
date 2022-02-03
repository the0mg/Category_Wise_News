package com.example.categorywisenews.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.categorywisenews.API.APIInterface;
import com.example.categorywisenews.API.ApiClient;
import com.example.categorywisenews.API.response.GetSourcrsResponse;
import com.example.categorywisenews.API.response.GetTopHeadLinesResponse;
import com.example.categorywisenews.R;
import com.example.categorywisenews.adapters.CatNameListAdapter;
import com.example.categorywisenews.adapters.GetSourcrsAdapter;
import com.example.categorywisenews.adapters.GetTopHeadLinesAdapter;
import com.example.categorywisenews.models.CategoryModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiffCatActivity extends AppCompatActivity {

    ImageView back_to_home;
    TextView cat;
    RecyclerView rv_SourcesItems;
    List<GetSourcrsResponse> getSourcrsResponses= new ArrayList<>();
    GetSourcrsAdapter sourcrsAdapter;
    String category;
    public ArrayList<CategoryModel> categoryModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_diff_cat );

        Intent i = getIntent();
        String message = i.getStringExtra( CatNameListAdapter.MSG );

        cat= findViewById( R.id.cat );
        cat.setText( message );

        rv_SourcesItems= findViewById( R.id.rv_SourcesItems );
        rv_SourcesItems.setLayoutManager(new LinearLayoutManager(this));

        back_to_home= findViewById( R.id.back_to_home );
        back_to_home.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DiffCatActivity.this, MainActivity.class);
                startActivity( i );
            }
        } );

        APIInterface apiInterface = ApiClient.getRetrofitInstance().create(APIInterface.class);
        Call<GetSourcrsResponse> call= apiInterface.getSourcrs( message, "51b0cdb639bf41ed9a7f361b7d75521f" );
        call.enqueue( new Callback<GetSourcrsResponse>() {
            @Override
            public void onResponse(Call<GetSourcrsResponse> call, Response<GetSourcrsResponse> response) {
                if (response.isSuccessful()){
                    getSourcrsResponses= new ArrayList<>();
                    getSourcrsResponses.add( response.body() );
                    sourcrsAdapter = new GetSourcrsAdapter( DiffCatActivity.this,  getSourcrsResponses.get( 0 ).getSources());
                    rv_SourcesItems.setAdapter( sourcrsAdapter );
                    Log.d( "TAG", "onResponse: "+ response.body().getSources().get( 0 ).getName() );
                    Log.d( "TAG", "onResponse: "+ response.body().getSources().get( 0 ).getDescription() );
                    Log.d( "TAG", "onResponse: "+ response.body().getSources().get( 0 ).getUrl() );
                }
            }

            @Override
            public void onFailure(Call<GetSourcrsResponse> call, Throwable t) {

            }
        } );

    }
}