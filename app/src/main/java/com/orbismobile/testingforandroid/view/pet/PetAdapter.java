package com.orbismobile.testingforandroid.view.pet;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.orbismobile.testingforandroid.R;
import com.orbismobile.testingforandroid.model.entities.PetEntity;

import java.util.List;

/**
 * Created by carlosleonardocamilovargashuaman on 8/9/17.
 */

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetItemViewHolder> {

    public List<PetEntity> petEntities;


    public PetAdapter(List<PetEntity> petEntities) {
        this.petEntities = petEntities;
    }


    private OnPetItemClickListener onPetItemClickListener;

    interface OnPetItemClickListener {
        void onPetItemClick(int position);
    }

    void setOnContactItemClickListener(OnPetItemClickListener onPetItemClickListener) {
        this.onPetItemClickListener = onPetItemClickListener;
    }


    @Override
    public PetItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_pet, parent, false);
        return new PetItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PetItemViewHolder holder, int position) {

        holder.lblPetName.setText(petEntities.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return petEntities.size();
    }

    public class PetItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView lblPetName;

        private PetItemViewHolder(View itemView) {
            super(itemView);
            lblPetName = itemView.findViewById(R.id.lblPetName);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(itemView.getContext(), petEntities.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
        }
    }
}
