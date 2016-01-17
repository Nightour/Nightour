package com.infact.nightour.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.neto.nightour.R;
import com.infact.nightour.model.Evento;
import com.infact.nightour.interfaces.RecyclerViewOnClickListenerHack;
import com.infact.nightour.model.Usuario;

import java.util.List;

/**
 * Created by Neto on 08/12/2015.
 */
public class SeguidoresAdapter extends RecyclerView.Adapter<SeguidoresAdapter.MyViewHolder> {
    private List<Usuario> list;
    private LayoutInflater layoutInflater;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;


    public SeguidoresAdapter(Context c, List<Usuario> usuarios){
        list = usuarios;
        layoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Log.i("LOG", "onCreateViewHolder()");
        View v = layoutInflater.inflate(R.layout.seguidor_ou_seguindo_item, viewGroup, false);
        MyViewHolder mvh = new MyViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        Log.i("LOG", "onBindViewHolder()");
        myViewHolder.tvNomeSeguidorOuSeguindo.setText(list.get(position).getNome() );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void setRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r){
        mRecyclerViewOnClickListenerHack = r;
    }


    public void addListItem(Usuario usuario, int position){
        list.add(usuario);
        notifyItemInserted(position);
    }


    public void removeListItem(int position){
        list.remove(position);
        notifyItemRemoved(position);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView ivFotoSeguidorOuSeguindo;
        public TextView tvNomeSeguidorOuSeguindo;

        public MyViewHolder(View itemView) {
            super(itemView);

            ivFotoSeguidorOuSeguindo = (ImageView) itemView.findViewById(R.id.ivFotoSeguidorOuSeguindo);
            tvNomeSeguidorOuSeguindo = (TextView) itemView.findViewById(R.id.tvNomeSeguidorOuSeguindo);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mRecyclerViewOnClickListenerHack != null){
                mRecyclerViewOnClickListenerHack.onClickListener(v, getPosition());
            }
        }
    }
}
