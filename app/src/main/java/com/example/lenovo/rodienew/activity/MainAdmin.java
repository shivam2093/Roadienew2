package com.example.lenovo.rodienew.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.rodienew.R;
import com.example.lenovo.rodienew.fragment.Add_city;
import com.example.lenovo.rodienew.fragment.Add_state;
import com.example.lenovo.rodienew.fragment.FeddlistAdmin;
import com.example.lenovo.rodienew.fragment.SerPro_list;
import com.example.lenovo.rodienew.fragment.UserList;

public class MainAdmin extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    SharedPreferences sp;
    String sname;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sp=getSharedPreferences("pref",MODE_WORLD_READABLE);
        sname=sp.getString("name","");



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View v=navigationView.getHeaderView(0);
        name=(TextView)v.findViewById(R.id.txtaname);
        name.setText(sname);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_admin, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {

            SharedPreferences.Editor ed = sp.edit();
            ed.clear();
            ed.commit();
            Intent i=new Intent(MainAdmin.this,MainActivity.class);
            startActivity(i);
            MainAdmin.this.finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.



        int id = item.getItemId();

        Fragment f= null;

        if (id == R.id.nav_home) {

            Toast.makeText(this, "No Implementation", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_sevice) {

            f = new SerPro_list(MainAdmin.this);


        } else if (id == R.id.nav_user) {

            f = new UserList(MainAdmin.this);

        }

        else if (id == R.id.nav_city) {

            f = new Add_city(MainAdmin.this);

        }
        else if (id == R.id.nav_State) {

            f = new Add_state(MainAdmin.this);

        }
        else if (id == R.id.nav_feedback) {

            f = new FeddlistAdmin();
        }


        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.content_main_admin,f);
        ft.commit();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
