package com.infact.nightour.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.neto.nightour.R;
import com.infact.nightour.model.NavDrawerMenuItem;

import java.util.List;



public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.MyViewHolder> {
    public static List<NavDrawerMenuItem> data = NavDrawerMenuItem.getList();
    private LayoutInflater inflater;
    private Context context;
    private View view;

    public NavigationDrawerAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void delete(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.nav_drawer_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NavDrawerMenuItem current = data.get(position);
        holder.title.setText(current.getTitle());
        holder.img.setImageResource(current.getImg());
        if(current.selected){
            holder.tvmarcadordrawer.setVisibility(View.VISIBLE);
            holder.title.setTextColor(context.getResources().getColor(R.color.textColorPrimary));
        }
        else {
            holder.tvmarcadordrawer.setVisibility(View.INVISIBLE);
            holder.title.setTextColor(0x99FFFFFF);
        }
    }

    public void setSelected(int position, boolean selected){
        clearSelected();
        if(position<3){
            data.get(position).selected  = selected;
            notifyDataSetChanged();}
    }


    public void setAllAsSelected(){

    }

    public void clearSelected(){
        if(data != null){
            for(NavDrawerMenuItem item : data){
                item.selected = false;
            }
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView img;
        TextView tvmarcadordrawer;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tvMenuItem);
            img = (ImageView) itemView.findViewById(R.id.ivMenuItem);
            tvmarcadordrawer = (TextView) itemView.findViewById(R.id.tvmarcadordrawer);
        }
    }
}
