package com.infact.nightour.fragment;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.neto.nightour.R;
import com.infact.nightour.adapter.PerfilTabsAdapter;
import com.infact.nightour.filtros.BlurFilter;

/**
 * Created by aluno on 03/12/2015.
 */
public class PerfilTabFragment extends BaseFragment implements TabLayout.OnTabSelectedListener{

    private ViewPager vpPerfil;
    private TabLayout tlPerfil;
    private ImageView imageView;
    private static final float BLUR_RADIUS = 25f;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*ZoomableImageView touch = (ZoomableImageView) getView().findViewById(R.id.IMAGEID);
        touch.setImageBitmap(bitmap);*/


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_perfil_tab, container, false);

        // ViewPager
        vpPerfil = (ViewPager) rootView.findViewById(R.id.vpPerfil);
        vpPerfil.setOffscreenPageLimit(2);
        vpPerfil.setAdapter(new PerfilTabsAdapter(getContext(), getChildFragmentManager()));

        // Tabs
        tlPerfil = (TabLayout) rootView.findViewById(R.id.tlPerfil);

        // Cor Branca no texto
        int corNormal = getContext().getResources().getColor(R.color.textColorPrimary);
        int corSelecionado = getContext().getResources().getColor(R.color.goldColor);
        tlPerfil.setTabTextColors(corNormal, corSelecionado);
        // Adiciona Tabs
        tlPerfil.addTab(tlPerfil.newTab().setText(R.string.interesses));
        tlPerfil.addTab(tlPerfil.newTab().setText(R.string.seguindo));
        tlPerfil.addTab(tlPerfil.newTab().setText(R.string.seguidores));

        // Listener tratar eventos de clique na tab
        tlPerfil.setOnTabSelectedListener(this);
        // Se mudar o ViewPager atualiza a tab selecionada
        vpPerfil.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tlPerfil));

        imageView = (ImageView) rootView.findViewById(R.id.ivFotoDeFundoBlurPerfilSeguindoSeguidores);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.perfil_do_cara___ok_05);
        BlurFilter blur = new BlurFilter(getContext());
        imageView.setImageBitmap(blur.blur(bitmap));


        return rootView;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        // Se alterar a tab, atualiza o viewpager
        vpPerfil.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}