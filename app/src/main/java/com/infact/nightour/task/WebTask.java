package com.infact.nightour.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.infact.nightour.listener.ResultadoListener;
import com.infact.nightour.rest.RestClient;

/**
 * Created by Klinsman
 */
public class WebTask extends AsyncTask <Object, Object, String>{

    private Context context;
    private ProgressDialog dialog;
    private ResultadoListener listener;

    public WebTask(Context context, ResultadoListener listener){
        this.context = context;
        this.listener = listener;
    }

    @Override
    protected String doInBackground(Object... params) {
        RestClient restClient =  new RestClient((String) params[0]);

        if(params.length == 2){
            return restClient.post((String) params[1]);
        }

        String valorRecebido = restClient.get();
        return  valorRecebido;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = ProgressDialog.show(context, "Wait", "Syncing", true, true);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        dialog.dismiss();
        //Log.d("Foo", (s == null) ? "abubub" : s);
        listener.getResult(s);
    }
}
