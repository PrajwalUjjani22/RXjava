package com.ujjani.rxjavaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RVCustomAdapter extends RecyclerView.Adapter<RVCustomAdapter.MyViewHolder> {

    private final List<Entry> entries = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(myView);
        return myViewHolder;
    }


//    Instead of creating new view for each new row, an old view is recycled and reused by binding new data to it.
//    This happens exactly in onBindViewHolder() .
//    Initially you will get new unused view holders and you have to fill them with data you want to display.
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

       // holder.txtName.setText(stringValues.get(position));



        Entry entry = entries.get(position);
        holder.setTxtName(entry.getEntryName());
        holder.setTxtPrice(entry.getEntryPrice());
        holder.setTxtDate(entry.getEntryDate());

    }

    @Override
    public int getItemCount() {
        return entries.size();
    }

    public void addEntry(Entry value){

        entries.add(value);
        notifyItemInserted(entries.size() - 1); //ex : size =  10-1 = position = 9

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.txtName)
        TextView txtName;

        @BindView(R.id.txtPrice)
        TextView txtPrice;

        @BindView(R.id.txtDate)
        TextView txtDate;


        //Format of the price
        private final NumberFormat ENTRY_PRICE_FORMAT = new DecimalFormat("$#0.00");


        public void setTxtName(String en) {
            this.txtName.setText(en);
        }

        public void setTxtPrice(BigDecimal ep) {
            this.txtPrice.setText(ENTRY_PRICE_FORMAT.format(ep.doubleValue()));
        }

        public void setTxtDate(Date ed) {
            this.txtDate.setText(android.text.format.DateFormat.format("yyyy-MM-dd hh:mm", ed)); ;
        }

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }

}
