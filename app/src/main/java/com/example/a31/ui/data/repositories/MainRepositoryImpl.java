package com.example.a31.ui.data.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.a31.ui.common.Resource;
import com.example.a31.ui.data.local.CharacterDao;
import com.example.a31.ui.data.remote.ApiService;
import com.example.a31.ui.ui.App;
import com.example.a31.ui.data.models.MainResponse;
import com.example.a31.ui.data.models.character.Character;
import com.example.a31.ui.repositories.MainRepository;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepositoryImpl implements MainRepository{


    private ApiService service;
    private CharacterDao dao;

    @Inject
    public MainRepositoryImpl(ApiService service, CharacterDao dao) {
        this.service = service;
        this.dao = dao;
    }

    @Override

    public MutableLiveData<Resource<MainResponse<Character>>> fetchCharacters() {

        MutableLiveData<Resource<MainResponse<Character>>> liveData = new MutableLiveData<>();

        liveData.setValue(Resource.loading(null));

        service.fetchCharacters().enqueue(new Callback<MainResponse<Character>>() {
            @Override
            public void onResponse(Call<MainResponse<Character>> call, Response<MainResponse<Character>> response) {
                if (response.isSuccessful() && response.body() != null) {

                    liveData.setValue(Resource.success(response.body()));

                    dao.insertAllCharacter(response.body().getResults());
                }else{
                    liveData.setValue(Resource.error(response.message(),null));
                }
            }

            @Override
            public void onFailure(Call<MainResponse<Character>> call, Throwable t) {
                liveData.setValue(Resource.error(t.getLocalizedMessage(),null));
            }
        });
        return liveData;
    }

    public MutableLiveData<Resource<MainResponse<Character>>> fetchCharactersById(int id) {

        MutableLiveData<Resource<MainResponse<Character>>> liveData = new MutableLiveData<>();

        liveData.setValue(Resource.loading(null));

        service.fetchCharacter(id).enqueue(new Callback<MainResponse<Character>>() {
            @Override
            public void onResponse(Call<MainResponse<Character>> call, Response<MainResponse<Character>> response) {
                liveData.setValue(Resource.success(response.body()));
            }

            @Override
            public void onFailure(Call<MainResponse<Character>> call, Throwable t) {

            }
        });

        return liveData;
    }


}
