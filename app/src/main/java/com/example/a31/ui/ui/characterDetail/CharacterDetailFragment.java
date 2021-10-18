package com.example.a31.ui.ui.characterDetail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.a31.R;
import com.example.a31.databinding.FragmentCharacterBinding;
import com.example.a31.databinding.FragmentCharacterDetailBinding;
import com.example.a31.ui.base.BaseFragment;
import com.example.a31.ui.data.local.CharacterDao;
import com.example.a31.ui.data.models.character.Character;
import com.example.a31.ui.data.remote.RetrofitClient;
import com.example.a31.ui.ui.characterList.CharacterViewModel;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CharacterDetailFragment extends Fragment {

  private FragmentCharacterDetailBinding binding;
  private CharacterViewModel viewModel;
  private int id;

  @Inject
  public CharacterDao dao;

  private int characterId ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCharacterDetailBinding.inflate(inflater,container,false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       characterId = CharacterDetailFragmentArgs.fromBundle(getArguments()).getId();

        Character character = (Character) dao.getCharacters(characterId);
        binding.tvName.setText(character.getName());
        binding.tvStatus.setText(character.getStatus());
        Glide.with(requireActivity()).load(character.getImage()).circleCrop().into(binding.ivCh);

    }
}
