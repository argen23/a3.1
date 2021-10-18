package com.example.a31.ui.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.a31.ui.common.Resource;
import com.example.a31.ui.data.models.MainResponse;
import com.example.a31.ui.data.models.character.Character;

import java.util.List;

public interface MainRepository {

    MutableLiveData<Resource<MainResponse<Character>>> fetchCharacters();

}
