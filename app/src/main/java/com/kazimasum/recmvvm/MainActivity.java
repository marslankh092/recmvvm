package com.kazimasum.recmvvm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kazimasum.recmvvm.adapters.MovieListAdapter;
import com.kazimasum.recmvvm.models.MovieModel;
import com.kazimasum.recmvvm.viewmodels.MovieListViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
   RecyclerView recview;
   List<MovieModel> movielist;
   MovieListViewModel listViewModel;
   MovieListAdapter adapter;
   TextView noresfound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         recview=findViewById(R.id.recview);
         noresfound=findViewById(R.id.noresult);

         recview.setLayoutManager(new LinearLayoutManager(this));
         recview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

         adapter=new MovieListAdapter(movielist);
         recview.setAdapter(adapter);



        listViewModel= ViewModelProviders.of(this).get(MovieListViewModel.class);
        listViewModel.getMovielistObserver().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                if(movieModels!=null) {
                    movielist= movieModels;
                    adapter.updatemovielist(movieModels);
                    noresfound.setVisibility(View.GONE);
                }
                if(movieModels==null)
                {
                    recview.setVisibility(View.GONE);
                    noresfound.setVisibility(View.VISIBLE);
                }
            }
        });
        listViewModel.makeApiCall();


    }


}