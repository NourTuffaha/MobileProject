package com.example.mobileproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<ModelClass> userList;

    public Adapter(List<ModelClass>userList) {
        this.userList=userList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design,parent,false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        int resource = userList.get(position).getImageview();
        String name=userList.get(position).getwatchname();
        String msg=userList.get(position).getprice();
        String time=userList.get(position).getquantity();
        String line=userList.get(position).getimageBtn();

        holder.setData(resource,name,msg,time,line);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView watchname;
        private TextView price;
        private TextView quantity;
        private ImageButton imgBtn;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //here use xml ids
            //give different name not like constructor
            imageView=itemView.findViewById(R.id.watchImg);
            watchname=itemView.findViewById(R.id.watchName);
            price=itemView.findViewById(R.id.price);
            quantity=itemView.findViewById(R.id.quantity);
            imgBtn=itemView.findViewById(R.id.removeFromCartImg);

        }

        public void setData(int resource, String name, String msg, String time,String line) {

            imageView.setImageResource(resource);
            watchname.setText(name);
            price.setText(msg);
            quantity.setText(time);
            imgBtn.setImageResource(R.drawable.trash);



        }
    }
}