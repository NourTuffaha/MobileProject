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
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design,parent,false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        int resource = userList.get(position).getImageview();
        String model=userList.get(position).getModel();
        String cost=userList.get(position).getCost();
        String line= String.valueOf(userList.get(position).getImageBtn());

        holder.setData(resource,model,cost,line);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView watchname;
        private TextView price;
        private TextView line;
        private ImageButton imgBtn;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //here use xml ids
            //give different name not like constructor
            imageView=itemView.findViewById(R.id.watchImg);
            watchname=itemView.findViewById(R.id.watchName);
            price=itemView.findViewById(R.id.price);
            line=itemView.findViewById(R.id.line);
            imgBtn=itemView.findViewById(R.id.removeFromCartImg);

        }

        public void setData(int resource, String model, String cost, String data) {

            imageView.setImageResource(resource);
            watchname.setText(model);
            price.setText(cost);
            line.setText(data);
            imgBtn.setImageResource(R.drawable.trash);



        }
    }
}