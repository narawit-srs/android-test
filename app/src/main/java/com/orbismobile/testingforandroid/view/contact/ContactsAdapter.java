package com.orbismobile.testingforandroid.view.contact;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.orbismobile.testingforandroid.model.entities.ContactEntity;
import com.orbismobile.testingforandroid.R;

import java.util.List;

/**
 * Created by carlosleonardocamilovargashuaman on 8/9/17.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactItemViewHolder> {

    private List<ContactEntity> contactEntities;

    ContactsAdapter(List<ContactEntity> contactEntities) {
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
            holder.itemView.setActivated(true);
            holder.flContainer.setBackgroundResource(R.color.md_grey_200);
        } else {
            holder.itemView.setActivated(false);
            holder.flContainer.setBackgroundResource(R.color.md_white_1000);
        }

        if(position == 2){
            holder.btnFake.setVisibility(View.VISIBLE);
            holder.btnFake.setEnabled(false);
        }else if(position == 4){
            holder.btnFake.setVisibility(View.VISIBLE);
            holder.btnFake.setEnabled(true);
        }else{
            holder.btnFake.setVisibility(View.INVISIBLE);
            holder.btnFake.setEnabled(true);
        }

        if (position == 6) {
            holder.lblTitle.setText("Get hands-on with");
            holder.lblTitle.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.md_red_600));
        } else {
            holder.lblTitle.setText(contactEntities.get(position).getName());
            holder.lblTitle.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.md_grey_700));
        }

        holder.lblDescription.setText(contactEntities.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return contactEntities.size();
    }

    public class ContactItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        FrameLayout flContainer;
        ImageView imgContact;
        ImageView imgSelected;
        public TextView lblTitle;
        TextView lblDescription;
        public Button btnFake;

        private ContactItemViewHolder(View itemView) {
            super(itemView);
            flContainer = itemView.findViewById(R.id.flContainer);
            imgSelected = itemView.findViewById(R.id.imgSelected);
            imgContact = itemView.findViewById(R.id.imgContact);
            lblTitle = itemView.findViewById(R.id.lblTitle);
            lblDescription = itemView.findViewById(R.id.lblDescription);
            btnFake = itemView.findViewById(R.id.btnFake);
            flContainer.setOnClickListener(this);
            flContainer.setOnLongClickListener(this);
            btnFake.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnFake:
                    Toast.makeText(itemView.getContext(), "position: " +getAdapterPosition(), Toast.LENGTH_SHORT).show();
                    break;
                default:
                    if(contactEntities.get(getAdapterPosition()).isSelected()){
                        itemView.setActivated(false);
                        flContainer.setBackgroundResource(R.color.md_white_1000);
                    }else{
                        flContainer.setBackgroundResource(R.color.md_grey_200);
                        itemView.setActivated(true);
                    }
                    onContactItemClickListener.onContactItemClick(getAdapterPosition());
                    break;
            }

        }

        @Override
        public boolean onLongClick(View view) {
            onContactItemClickListener.onContactLongItemClick(getAdapterPosition());
            return true;
        }
    }

}
