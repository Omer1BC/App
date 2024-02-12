package com.example.cardsinterface;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter  extends RecyclerView.Adapter<MessageAdapter.MyViewHolder>{
    private List<Message> list;
    public MessageAdapter (List<Message> messageList){
        list = messageList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View chatView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item,null);

        return new MyViewHolder(chatView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Message message = list.get(position);
        if (message.getBy().equals(Message.SENT_BY_ME))
        {
            holder.left.setVisibility(View.GONE);
            holder.right.setVisibility(View.VISIBLE);
            holder.rightEdit.setText(message.getMessage());
        }
        else {
            holder.right.setVisibility(View.GONE);
            holder.left.setVisibility(View.VISIBLE);
            holder.leftEdit.setText(message.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout left,right;
        TextView leftEdit,rightEdit;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            leftEdit = itemView.findViewById(R.id.left);
            rightEdit = itemView.findViewById(R.id.right);
            left = itemView.findViewById(R.id.leftLinear);
            right = itemView.findViewById(R.id.rightLinear);



        }

    }
}
