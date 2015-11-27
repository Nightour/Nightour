package com.infact.nightour.activity;

import android.support.v7.app.*;
import android.support.v7.widget.Toolbar;
import com.example.neto.nightour.R;
public class BaseActivity extends AppCompatActivity{
    protected Toolbar toolbar;
    protected void setUpToolBar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            toolbar.setTitleTextColor(getResources().getColor(R.color.goldColor));
        /*toolbar.setTitleTextColor(0x99daa520);*/

        }
    }
}
