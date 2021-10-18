package com.example.a31.ui.data.remote;

import com.example.a31.ui.data.models.character.Character;
import com.example.a31.ui.data.models.MainResponse;
import com.example.a31.ui.data.models.character.LocationDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("api/character")
    Call<MainResponse<Character>> fetchCharacters();


    @GET("api/character/{id}")
    Call<MainResponse<Character>> fetchCharacter(@Path("id") int id);

    @GET("api/location")
    Call<MainResponse<LocationDto>> fetchLocation();
}
