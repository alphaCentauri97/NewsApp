package com.example.retrofitpractice2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebViewClient;

import com.example.retrofitpractice2.databinding.ActivityWebviewBinding;

public class Webview extends AppCompatActivity {

    ActivityWebviewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWebviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        binding.webview.setWebViewClient(new WebViewClient());
        binding.webview.loadUrl(url);

    }
}