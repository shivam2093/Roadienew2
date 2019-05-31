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

import com.example.lenovo.rodienew.R;
import com.example.lenovo.rodienew.fragment.Bid_service;
import com.example.lenovo.rodienew.fragment.DetailService;
import com.example.lenovo.rodienew.fragment.Detail_bid;
import com.example.lenovo.rodienew.fragment.Detail_service;
import com.example.lenovo.rodienew.fragment.Single_req;
import com.example.lenovo.rodienew.fragment.Transporter_home;
import com.example.lenovo.rodienew.fragment.User_home;

public class Mainserviceprovider extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    SharedPreferences sp;
    String sname;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainserviceprovider);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sp=getSharedPreferences("pref",MODE_WORLD_READABLE);
        sname=sp.getString("name","");


        Fragment f=new Fragment();
        Transporter_home h=new Transporter_home();
        FragmentTransaction ft=getFragmentManager().beginTransaction();
        ft.addToBackStack(f.getClass().getName());
        ft.replace(R.id.content_service_provider,h);
        ft.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View v=navigationView.getHeaderView(0);
        name=(TextView)v.findViewById(R.id.txttname);
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
        getMenuInflater().inflate(R.menu.mainserviceprovider, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The ac1tion bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {

            SharedPreferences.Editor ed = sp.edit();
            ed.clear();
            ed.commit();
            Intent i=new Intent(Mainserviceprovider.this,MainActivity.class);
            startActivity(i);
            Mainserviceprovider.this.finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment f = null;

        if (id == R.id.nav_home) {
            Fragment f1=new Fragment();
            Transporter_home h=new Transporter_home();
            FragmentTransaction ft=getFragmentManager().beginTransaction();
            ft.addToBackStack(f1.getClass().getName());
            ft.replace(R.id.content_service_provider,h);
            ft.commit();
        } else if (id == R.id.profile) {

        }  else if (id == R.id.nav_bservice) {


            Fragment f1=new Fragment();
            Bid_service h=new Bid_service();
            FragmentTransaction ft=getFragmentManager().beginTransaction();
            ft.addToBackStack(f1.getClass().getName());
            ft.replace(R.id.content_service_provider,h);
            ft.commit();


        } else if (id == R.id.nav_request) {

            Fragment f1=new Fragment();
            Single_req h=new Single_req(Mainserviceprovider.this);
            FragmentTransaction ft=getFragmentManager().beginTransaction();
            ft.addToBackStack(f1.getClass().getName());
            ft.replace(R.id.content_service_provider,h);
            ft.commit();

        } else if (id == R.id.nav_Service_Request) {


            Fragment f1=new Fragment();
            Detail_bid h=new Detail_bid();
            FragmentTransaction ft=getFragmentManager().beginTransaction();
            ft.addToBackStack(f1.getClass().getName());
            ft.replace(R.id.content_service_provider,h);
            ft.commit();


        }
        else if (id == R.id.feedback){

            Fragment f1=new Fragment();
            DetailService h=new DetailService();
            FragmentTransaction ft=getFragmentManager().beginTransaction();
            ft.addToBackStack(f1.getClass().getName());
            ft.replace(R.id.content_service_provider,h);
            ft.commit();
        }




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
