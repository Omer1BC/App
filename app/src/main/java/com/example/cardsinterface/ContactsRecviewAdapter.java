package com.example.cardsinterface;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import android.app.Activity;

public class ContactsRecviewAdapter extends RecyclerView.Adapter<ContactsRecviewAdapter.ViewHolder> {
    private ArrayList<Contact> contacts = new ArrayList<Contact>(0);
    private Context passed;
    private boolean isList;
    public ContactsRecviewAdapter (Context a,boolean isList){
        contacts = new ArrayList<Contact>();
        passed = a;
        this.isList = isList;
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.contacts_list_item,parent,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = contacts.get(position).getName();
        holder.txtName.setText(name);

            holder.parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (passed instanceof Invitation)
                        Toast.makeText(passed, "Invited " + name, Toast.LENGTH_SHORT).show();
                    else {
                        passed.startActivity(new Intent(passed, Messaging.class));
                    }
                }
            });


    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void setContacts(ArrayList<Contact> cont)
    {
        this.contacts = cont;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName;
        private RelativeLayout parent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            parent = itemView.findViewById(R.id.parent);


        }
    }

}
