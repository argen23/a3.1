package com.example.a31.ui.ui;

import android.app.Application;

import com.example.a31.ui.data.local.CharacterDao;
import com.example.a31.ui.data.local.RoomClient;
import com.example.a31.ui.data.models.character.Character;
import com.example.a31.ui.data.remote.ApiService;
import com.example.a31.ui.data.remote.RetrofitClient;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
