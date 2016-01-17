package com.infact.nightour.model;

import android.widget.TextView;

import com.example.neto.nightour.R;
import java.util.ArrayList;
import java.util.List;

public class NavDrawerMenuItem extends ImagemETituloItem {
    public TextView tvSelecionado;
    public int imgNaoSelecionado;
    public NavDrawerMenuItem(int title, int img, int imgNaoSelecionado){
        super(title, img);
        this.imgNaoSelecionado = imgNaoSelecionado;
    }

    public void setImgNaoSelecionado(int imgNaoSelecionado) {
        this.imgNaoSelecionado = imgNaoSelecionado;
    }

    public int getImgNaoSelecionado() {
        return imgNaoSelecionado;
    }

    public static List<NavDrawerMenuItem> getList()
    {
        List<NavDrawerMenuItem> list = new ArrayList<NavDrawerMenuItem>();
        list.add(new NavDrawerMenuItem(R.string.nav_item_home, R.drawable.home_ok_01, R.drawable.home___cinza_ok_03));
        list.add(new NavDrawerMenuItem(R.string.nav_item_buscar, R.drawable.pesquisa_ok_04, R.drawable.pesquisa_ok___cinza_05));
        list.add(new NavDrawerMenuItem(R.string.nav_item_news, R.drawable.news_ok_06, R.drawable.news_ok___cinza_07));
        return list;
    }
}
