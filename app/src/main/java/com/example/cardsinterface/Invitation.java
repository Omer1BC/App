package com.example.cardsinterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class Invitation extends AppCompatActivity {
    private ContactsRecviewAdapter adapter;
    private ArrayList<Contact> content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitation);
        content = new ArrayList<Contact>();
        content.add(new Contact("Gino","x",true));
        content.add(new Contact("Grant","y",true));
        content.add(new Contact("Christian","z",true));
        content.add(new Contact("Atapy","x",true));
        content.add(new Contact("Mike","y",true));
        content.add(new Contact("Micheal","z",true));
        content.add(new Contact("Noah","x",true));
        content.add(new Contact("Jeffrey","y",true));
        content.add(new Contact("David","z",true));
        content.add(new Contact("Daniel","x",true));
        content.add(new Contact("Caleb","y",true));
        content.add(new Contact("Liam","z",true));
        RecyclerView rcv = findViewById(R.id.list_rcv);

        adapter = new ContactsRecviewAdapter(this,false);
        adapter.setContacts(content);
        rcv.setAdapter(adapter);
        rcv.setLayoutManager(new LinearLayoutManager(this));
    }
    public void btnClicked(View view)
    {
        startActivity(new Intent(this,MainActivity.class));
    }
}