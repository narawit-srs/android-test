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
import com.orbismobile.testingforandroid.model.entities.PetSectionEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlosleonardocamilovargashuaman on 8/9/17.
 */

public class PetSectionAdapter extends RecyclerView.Adapter<PetSectionAdapter.ContactItemViewHolder> {

    private List<PetSectionEntity> petSectionEntities;

    PetSectionAdapter(List<PetSectionEntity> petSectionEntities) {
        this.petSectionEntities = petSectionEntities;
    }

    private OnContactItemClickListener onContactItemClickListener;

    interface OnContactItemClickListener {
        void onContactItemClick(int position);

        void onContactLongItemClick(int position);
    }

    void setOnContactItemClickListener(OnContactItemClickListener onContactItemClickListener) {
        this.onContactItemClickListener = onContactItemClickListener;
    }

    @Override
    public ContactItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_pet_section, parent, false);
        return new ContactItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactItemViewHolder holder, int position) {

        holder.lblSectionTitle.setText(petSectionEntities.get(position).getTitle());


        Log.e("ONE TIME----","ONE TIME " + holder.getPetEntities());
        //Log.e("ONE TIME----","ONE TIME " + holder.isNotifiedOneTime());
        if (holder.getPetEntities() == null) {

            holder.petEntities = new ArrayList<>();
            holder.petEntities.addAll(petSectionEntities.get(position).getPetEntities());
            holder.petAdapter = new PetAdapter(holder.petEntities);
            holder.rcvHorizontal.setAdapter(holder.petAdapter);


        }else{
            holder.petEntities.clear();
            holder.petEntities.addAll(petSectionEntities.get(position).getPetEntities());
            holder.petAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return petSectionEntities.size();
    }

    public class ContactItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        private TextView lblSectionTitle;
        private RecyclerView rcvHorizontal;
        private PetAdapter petAdapter;
        private List<PetEntity> petEntities;

        private ContactItemViewHolder(View itemView) {
            super(itemView);
            lblSectionTitle = itemView.findViewById(R.id.lblSectionTitle);
            rcvHorizontal = itemView.findViewById(R.id.rcvHorizontal);
            //petAdapter = new PetAdapter();
            rcvHorizontal.setAdapter(petAdapter);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnFake:
                    Toast.makeText(itemView.getContext(), "position: " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }

        }

        public List<PetEntity> getPetEntities() {
            return petEntities;
        }

        @Override
        public boolean onLongClick(View view) {
            onContactItemClickListener.onContactLongItemClick(getAdapterPosition());
            return true;
        }
    }
}
