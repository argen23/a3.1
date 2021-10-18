package com.example.a31.ui.data.local;

import android.content.Context;

import androidx.room.Room;

import com.example.a31.ui.ui.App;

public class RoomClient {

    public AppDatabase provideDatabase(Context context){
        return Room.databaseBuilder(context,AppDatabase.class,"rick-and-morty")
                .allowMainThreadQueries()
                .build();
    }

    public CharacterDao provideCharacterDao(AppDatabase database){
        return database.characterDao();
    }
}
