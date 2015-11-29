package com.infact.nightour.model;

import com.example.neto.nightour.R;

import java.util.ArrayList;
import java.util.List;

public class DescubraOuOQueRolaItem extends ImagemETituloItem {
    public String descricao;
    public int classificacao;
    public DescubraOuOQueRolaItem(int title, int img){
        super(title, img);
    }
    public static List<DescubraOuOQueRolaItem> getList()
    {
        List<DescubraOuOQueRolaItem> list = new ArrayList<DescubraOuOQueRolaItem>();
        list.add(new DescubraOuOQueRolaItem(R.string.nav_item_home, R.drawable.profile_exemple));
        list.add(new DescubraOuOQueRolaItem(R.string.nav_item_buscar, R.drawable.profile_exemple));
        list.add(new DescubraOuOQueRolaItem(R.string.nav_item_news, R.drawable.profile_exemple));
        return list;
    }
}
