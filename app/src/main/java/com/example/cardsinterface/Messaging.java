package com.example.cardsinterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Messaging extends AppCompatActivity {
    RecyclerView rcv;
    EditText edit;
    ImageButton send;
    List<Message> list;
    MessageAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String defaultMessage = "Tell me something";
        String response = "Cap";
        setContentView(R.layout.activity_messaging);

        rcv = findViewById(R.id.recycler_view);
        edit = findViewById(R.id.sendBar);
        send = findViewById(R.id.send);
        list = new ArrayList<>();


        adapter = new MessageAdapter(list);
        rcv.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setStackFromEnd(true);
        rcv.setLayoutManager(llm);

        addToChat(defaultMessage,Message.SENT_BY_BOT);


        send.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Toast.makeText(Messaging.this,edit.getText().toString(),Toast.LENGTH_LONG).show();
                addToChat(edit.getText().toString(),Message.SENT_BY_ME);
                edit.setText("");
                addToChat(response,Message.SENT_BY_BOT);
            }
        });


    }
    void addToChat(String message,String sentBy)
    {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                list.add(new Message(message,sentBy));
                adapter.notifyDataSetChanged();
                rcv.smoothScrollToPosition(adapter.getItemCount());
            }
        });
    }
}