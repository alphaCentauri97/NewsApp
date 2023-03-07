package com.example.retrofitpractice2.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.retrofitpractice2.MainClass;
import com.example.retrofitpractice2.ModelClass;
import com.example.retrofitpractice2.R;
import com.example.retrofitpractice2.RecyclerViewAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    String api = "ef6ff7ca71494d9eb9bc092d61167a10";
    ArrayList<ModelClass> list;
    RecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    String country= "in";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recycleview);
        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RecyclerViewAdapter(getContext(),list);
        recyclerView.setAdapter(adapter);

        findNews();

        return view;
    }

    private void findNews() {

        ApiUtilies.getApiInterface().getNews(country,100,api).enqueue(new Callback<MainClass>() {
            @Override
            public void onResponse(Call<MainClass> call, Response<MainClass> response) {
                if(response.isSuccessful())
                {
                    list.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
                else
                {
                    Toast.makeText(getContext(), "Something went Wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MainClass> call, Throwable t) {

            }
        });
    }
}