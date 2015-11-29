package com.infact.nightour.model;

import android.widget.TextView;

import com.example.neto.nightour.R;
import java.util.ArrayList;
import java.util.List;

public class NavDrawerMenuItem extends ImagemETituloItem {
    public TextView tvSelecionado;
    public NavDrawerMenuItem(int title, int img){
        super(title, img);
    }
    public static List<NavDrawerMenuItem> getList()
    {
        List<NavDrawerMenuItem> list = new ArrayList<NavDrawerMenuItem>();
        list.add(new NavDrawerMenuItem(R.string.nav_item_home, R.drawable.home___draw_10));
        list.add(new NavDrawerMenuItem(R.string.nav_item_buscar, R.drawable.ic_search_white_24dp));
        list.add(new NavDrawerMenuItem(R.string.nav_item_news, R.drawable.ic_newspaper_white_32px));
        return list;
    }
}
