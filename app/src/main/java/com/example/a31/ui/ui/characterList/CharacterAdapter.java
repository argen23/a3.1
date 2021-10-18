package com.example.a31.ui.ui.characterList;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a31.databinding.ItemChBinding;
import com.example.a31.ui.data.models.character.Character;

import java.util.ArrayList;
import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {
    private List<Character> characters = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemChBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(characters.get(position));
        holder.itemView.setOnClickListener(v -> {onItemClickListener.onItemClick(characters.get(position).getId());});
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemChBinding binding;
        public ViewHolder(@NonNull ItemChBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void onBind(Character character) {
            Glide.with(binding.getRoot()).load(character.getImage()).circleCrop().into(binding.ivAvatar);
            binding.tvName.setText(character.getName());
            binding.tvStatus.setText(character.getStatus());
//            itemView.setOnClickListener(v -> {
//                onItemClickListener.onItemClick(character);
//            });

        }
    }


}
