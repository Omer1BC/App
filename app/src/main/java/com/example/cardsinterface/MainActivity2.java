package com.example.cardsinterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private ContactsRecviewAdapter adapter;
    private ArrayList<Contact> content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        content = new ArrayList<Contact>();
        content.add(new Contact("Gino","x",true));
        content.add(new Contact("Grant","y",true));
        content.add(new Contact("Christian","z",true));
        content.add(new Contact("Atapy","x",true));
        content.add(new Contact("Mike","y",true));
        content.add(new Contact("Micheal","z",true));
        content.add(new Contact("Noah","x",true));
        content.add(new Contact("Jeffrey","y",true));
        content.add(new Contact("Caleb","z",true));
        content.add(new Contact("Daniel","x",true));
        content.add(new Contact("Jordan","y",true));
        content.add(new Contact("Liam","z",true));
        RecyclerView rcv = findViewById(R.id.screen);

        adapter = new ContactsRecviewAdapter(this,true);
        adapter.setContacts(content);
        rcv.setAdapter(adapter);
        rcv.setLayoutManager(new LinearLayoutManager(this));



    }


}