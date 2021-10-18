package com.example.a31.ui.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.a31.ui.data.models.character.Character;

@Database(entities = {Character.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CharacterDao characterDao();
}
