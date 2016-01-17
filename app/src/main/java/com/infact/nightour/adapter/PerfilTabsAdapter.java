package com.infact.nightour.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.neto.nightour.R;
import com.infact.nightour.fragment.InteressesFragment;
import com.infact.nightour.fragment.SeguidoresFragment;
import com.infact.nightour.fragment.SeguindoFragment;

/**
 * Created by aluno on 04/12/2015.
 */


    public class PerfilTabsAdapter extends FragmentPagerAdapter {

        private Context context;

        public PerfilTabsAdapter(Context context, FragmentManager fm){
            super(fm);
            this.context = context;
        }


        @Override
        public Fragment getItem(int position) {

            if(position == 0){
                return new InteressesFragment();
            }else if(position == 1){
                return new SeguindoFragment();
            }else if(position == 2){
                return new SeguidoresFragment();
            }

            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position == 0){
                return context.getString(R.string.interesses);
            }else if(position == 1){
                return context.getString(R.string.seguindo);
            }else if (position == 2){
                return context.getString(R.string.seguidores);
            }

            return super.getPageTitle(position);
        }
}

