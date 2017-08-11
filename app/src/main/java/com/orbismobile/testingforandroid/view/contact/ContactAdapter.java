package com.orbismobile.testingforandroid.view.contact;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.orbismobile.testingforandroid.model.entities.ContactEntity;
import com.orbismobile.testingforandroid.R;

import java.util.List;

/**
 * Created by carlosleonardocamilovargashuaman on 8/9/17.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactItemViewHolder> {

    private List<ContactEntity> contactEntities;

    ContactAdapter(List<ContactEntity> contactEntities) {
        this.contactEntities = contactEntities;
    }

    private OnContactItemClickListener onContactItemClickListener;

    interface OnContactItemClickListener {
        void onContactItemClick(int position);

        void onContactLongItemClick(int position);
    }

    void setOnContactItemClickListener(OnContactItemClickListener onContactItemClickListener) {
        this.onContactItemClickListener = onContactItemClickListener;
    }

    void toggleSelection(int position) {
        if (contactEntities.get(position).isSelected()) {
            contactEntities.get(position).setSelected(false);
        } else {
            contactEntities.get(position).setSelected(true);
        }
        notifyItemChanged(position);
    }

    void clearSelection() {

    }

    @Override
    public ContactItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactItemViewHolder holder, int position) {
        if (contactEntities.get(position).isSelected()) {
            holder.flContainer.setBackgroundResource(R.color.md_grey_300);
        } else {
            holder.flContainer.setBackgroundResource(android.R.color.transparent);
        }

    }

    @Override
    public int getItemCount() {
        return contactEntities.size();
    }

    class ContactItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        FrameLayout flContainer;
        ImageView imgContact;
        ImageView imgSelected;
        TextView lblTitle;
        TextView lblDescription;

        private ContactItemViewHolder(View itemView) {
            super(itemView);
            flContainer = itemView.findViewById(R.id.flContainer);
            imgSelected = itemView.findViewById(R.id.imgSelected);
            imgContact = itemView.findViewById(R.id.imgContact);
            lblTitle = itemView.findViewById(R.id.lblTitle);
            lblDescription = itemView.findViewById(R.id.lblDescription);
            flContainer.setOnClickListener(this);
            flContainer.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onContactItemClickListener.onContactItemClick(getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View view) {
            onContactItemClickListener.onContactLongItemClick(getAdapterPosition());
            return true;
        }
    }

}
