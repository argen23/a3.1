package com.example.a31.ui.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.a31.ui.data.models.character.Character;

import java.util.List;

@Dao
public interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllCharacter(List<Character> character);

    @Query("SELECT * FROM character")
    List<Character> getAllCharacters();

    @Query("SELECT * FROM character WHERE id = :id")
    Character getCharacters(int id);


}
