package com.example.motex.adapters;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.motex.R;
import com.example.motex.models.Product;

import java.util.List;

public class TopProductAdapter extends RecyclerView.Adapter<TopProductAdapter.ViewHolder> {

    List<Product> lst;

    public TopProductAdapter(List<Product> lst) {
        this.lst = lst;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_product_saample,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Product category = lst.get(position);

        holder.imageView.setImageResource(category.getImage());
        holder.textView.setText(category.getName());
        holder.priceTV.setText(category.getPrice());
        holder.maxPriceTV.setText(category.getMaxPrice());

    }

    @Override
    public int getItemCount() {
        return lst.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView,maxPriceTV,priceTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.topProductImage);
            textView = itemView.findViewById(R.id.topProductName);
            maxPriceTV = itemView.findViewById(R.id.topProductMaxPrice);
            priceTV = itemView.findViewById(R.id.topProductPrice);

            maxPriceTV.setPaintFlags(maxPriceTV.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        }
    }
}
