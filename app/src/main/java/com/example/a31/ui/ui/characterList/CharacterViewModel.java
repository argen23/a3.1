package com.example.a31.ui.ui.characterList;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a31.ui.common.Resource;
import com.example.a31.ui.data.models.MainResponse;
import com.example.a31.ui.data.models.character.Character;
import com.example.a31.ui.data.repositories.MainRepositoryImpl;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class CharacterViewModel extends ViewModel {

    private MainRepositoryImpl repository;

    @Inject
    public CharacterViewModel(MainRepositoryImpl repository){
        this.repository = repository;
    }

    public MutableLiveData<Resource<MainResponse<Character>>> getCharacters(){
        return repository.fetchCharacters();
    }

    public MutableLiveData<Resource<MainResponse<Character>>> getCharacterById(int id){
        return repository.fetchCharactersById(id);
    }

}
