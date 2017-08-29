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

    private List<PetEntity> petEntities;

    PetAdapter(List<PetEntity> petEntities) {
        this.petEntities = petEntities;
    }

    private OnContactItemClickListener onContactItemClickListener;

    interface OnContactItemClickListener {
        void onContactItemClick(int position);
    }

    void setOnContactItemClickListener(OnContactItemClickListener onContactItemClickListener) {
        this.onContactItemClickListener = onContactItemClickListener;
    }


    @Override
    public PetItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_pet, parent, false);
        return new PetItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PetItemViewHolder holder, int position) {

        //Log.e("evaluemos ","evaluemos " + position);


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
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnFake:
                    Toast.makeText(itemView.getContext(), "position: " +getAdapterPosition(), Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    }
}
