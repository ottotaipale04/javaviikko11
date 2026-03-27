package com.example.viikko11;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder{
    TextView contactName, contactNumber, contactGroup;
    Button contactDetails, contactDelete;
    boolean isVisible = false;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        contactName = itemView.findViewById(R.id.ContactNameText);
        contactNumber = itemView.findViewById(R.id.ContactNumberText);
        contactGroup = itemView.findViewById(R.id.ContactGroupText);
        contactDetails = itemView.findViewById(R.id.ContactDetailsButton);
        contactDelete = itemView.findViewById(R.id.ContactDeleteButton);
        /**
        contactNumber.setVisibility(View.GONE);
        contactGroup.setVisibility(View.GONE);
        */
    }
}
