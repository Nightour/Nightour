package com.infact.nightour.activity;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.neto.nightour.R;
import com.infact.nightour.adapter.NavigationDrawerAdapter;
import com.infact.nightour.fragment.BuscarFragment;
import com.infact.nightour.fragment.ConfiguracoesFragment;
import com.infact.nightour.fragment.DrawerFragment;
import com.infact.nightour.fragment.HomeFragment;
import com.infact.nightour.fragment.InBoxFragment;
import com.infact.nightour.fragment.NewsFragment;
import com.infact.nightour.fragment.PerfilFragment;

public class MainActivity extends DebugActivity implements DrawerFragment.FragmentDrawerListener {


private static String TAG = MainActivity.class.getSimpleName();

    private View vi;
    private DrawerFragment drawerFragment;
    public static SearchView svBuscar;
    public static MenuItem searchMenuItem;
    public static MenuItem switchMenuItem;

    public static Fragment fragment = null;private String title;
    public static int APosicao;
    public static HomeFragment homefragment;
     //caso o searchview suma e apareça, tornar public não static

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolBar();


        drawerFragment = (DrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);

        drawerFragment.ibFotoDePerfilNaNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                onDrawerItemSelected(v, 3);
            }
        });

        drawerFragment.ibInBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDrawerItemSelected(v, 4);
            }
        });

        drawerFragment.ibConfiguracoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDrawerItemSelected(v, 5);
            }
        });


        // display the first navigation drawer view on app launch

        DrawerFragment.adapter.clearSelected();
        NavigationDrawerAdapter.data.get(0).selected = true;
        displayView(0);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        SearchView.OnQueryTextListener listener = new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        };


        getMenuInflater().inflate(R.menu.menu_main, menu);

        searchMenuItem = menu.findItem(R.id.action_search);
        svBuscar = (SearchView) searchMenuItem.getActionView();
        svBuscar.setOnQueryTextListener(listener);
        svBuscar.setIconifiedByDefault(false);
        //svBuscar.setOnCloseListener(listener);


        switchMenuItem = menu.findItem(R.id.action_switch);
        if(APosicao == 1)
        {

            searchMenuItem.setVisible(true);
            svBuscar.setMaxWidth(900);
            svBuscar.onActionViewExpanded();
            svBuscar.setQueryHint("Buscar");
            switchMenuItem.setVisible(false);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_search){
            Toast.makeText(getApplicationContext(), "Search action is selected!", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onDrawerItemSelected(View view, int position) {
        vi = view;
        DrawerFragment.adapter.setSelected(position, true);
        displayView(position);

    }
    private void displayView(int position) {
        APosicao = position;
        switch (position) {
            case 0:
                title = getString(R.string.app_name);
                homefragment = new HomeFragment();
                fragment = homefragment;
                title = fragment + "";
                break;
            case 1:
                fragment = new BuscarFragment();
                title = fragment + "";
                break;
            case 2:
                title = getString(R.string.app_name);
                fragment = new NewsFragment();
                title = fragment + "";
                break;
            case 3:
                title = getString(R.string.app_name);
                fragment = new PerfilFragment();
                title = "" + fragment;
                break;
            case 4:
                title = getString(R.string.app_name);
                fragment = new InBoxFragment();
                title = "" + fragment;
                break;
            case 5:
                title = getString(R.string.app_name);
                fragment = new ConfiguracoesFragment();
                title = "" + fragment;
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            if(APosicao == 1 || APosicao > 3){
                getSupportActionBar().setTitle(null);}
            else{
                getSupportActionBar().setTitle(title);}
            drawerFragment.getDrawerLayout().closeDrawer(GravityCompat.START);

        }
    }
}

