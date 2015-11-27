package com.infact.nightour.activity;

import android.os.Bundle;
import android.util.Log;

/**
 * Created by Neto on 19/11/2015.
 */
public class DebugActivity extends BaseActivity {
    protected final String TAG = "ciclo";
    @Override
    protected void onCreate(Bundle icicle)
    {
        Log.i(TAG, getClassName() + ".onCreate() chamado: " + icicle);
        super.onCreate(icicle);
    }
    @Override
    protected void onStart(){
        Log.i(TAG, getClassName() + ".onStart() chamado: ");
        super.onStart();
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i(TAG, getClassName() + ".onRestart() chamado: ");
    }
    @Override
    protected void onResume(){
        Log.i(TAG, getClassName() + ".onResume() chamado: ");
        super.onResume();
    }
    @Override
    protected  void onPause(){
        super.onPause();
        Log.i(TAG, getClassName() + ".onPause() chamado: ");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        Log.i(TAG, getClassName() + ".onSaveInstanceState() chamado: ");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG, getClassName() + ".onStop() chamado: ");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG, getClassName() + ".onDestroy() chamado: ");
    }
    public String getClassName(){
        //Retorna o nome da classe sem o pacote
        String s = getClass().getName();
        return s.substring(s.lastIndexOf("."));
    }

}
