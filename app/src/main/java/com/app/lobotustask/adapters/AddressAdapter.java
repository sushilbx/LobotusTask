package com.app.lobotustask.adapters;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.app.lobotustask.MainActivity;
import com.app.lobotustask.R;
import com.app.lobotustask.databinding.AddressItemBinding;
import com.app.lobotustask.models.AddressModel;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.List;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.MyViewHolder> {
    public List<AddressModel.Result> address;
    public Context context;

    public AddressAdapter(List<AddressModel.Result> list, Context context) {
        this.address = list;
        this.context = context;
    }

    @Override
    public AddressAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.address_item, parent, false);
        return new AddressAdapter.MyViewHolder(AddressItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(final AddressAdapter.MyViewHolder holder, final int position) {


        holder.b.tvCompanyName.setText(address.get(position).clientName);
        holder.b.tvAddress.setText(address.get(position).clientLoc.location);
        holder.b.tvName.setText(address.get(position).userFullName);
        holder.b.tvPhone.setText(address.get(position).mobile);
        holder.b.tvEmail.setText(address.get(position).email);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.address.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private AddressItemBinding b;

        public MyViewHolder(AddressItemBinding b) {
            super(b.getRoot());
            this.b = b;
        }
    }
}

