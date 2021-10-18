package com.example.a31.ui.ui.characterList;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a31.R;
import com.example.a31.databinding.FragmentCharacterBinding;
import com.example.a31.ui.base.BaseFragment;
import com.example.a31.ui.data.local.CharacterDao;
import com.example.a31.ui.data.models.character.Character;
import com.example.a31.ui.data.models.MainResponse;
import com.example.a31.ui.ui.App;
import com.example.a31.ui.ui.characterDetail.CharacterDetailFragment;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CharacterFragment extends BaseFragment<FragmentCharacterBinding> implements OnItemClickListener {

    @Inject
    CharacterDao characterDao;
    private CharacterAdapter adapter;

    private CharacterViewModel viewModel;


    @Override
    protected FragmentCharacterBinding bind() {
        return FragmentCharacterBinding.inflate(getLayoutInflater());

    }

    @Override
    protected void initialize() {
        viewModel = new ViewModelProvider(requireActivity()).get(CharacterViewModel.class);
    }

    @Override
    protected void setupObservers() {
        viewModel.getCharacters().observe(getViewLifecycleOwner(),result ->{
            switch (result.status){
                case SUCCESS:{
                    binding.characterRv.setVisibility(View.VISIBLE);
                    binding.progressCircular.setVisibility(View.GONE);
                    adapter.setCharacters(result.data.getResults());
                    break;
                }
                case ERROR:{
                    binding.tvError.setText("Error");
                    break;
                }
                case LOADING:{
                    binding.characterRv.setVisibility(View.GONE);
                    binding.progressCircular.setVisibility(View.VISIBLE);
                    break;
                }
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecycler();

    }

    private void setupRecycler() {
        adapter = new CharacterAdapter();
        binding.characterRv.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
        adapter.setCharacters(characterDao.getAllCharacters());
    }

    @Override
    public void onItemClick(int id) {
        navController.navigate(CharacterFragmentDirections.actionCharacterToCharacterDetailFragment(id));



    }
}
