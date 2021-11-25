package com.example.eshelf;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class iniciar extends AppCompatActivity {

    private TextView txtNome;
    SQLiteDatabase db;
    DBHelper dtb = new DBHelper(this);
    Cursor cursor;
    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar);
        txtNome = findViewById(R.id.txtNome);
        navigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new HomeFragment()).commit();
        navigationView.setSelectedItemId(R.id.nav_home);

        Bundle args = getIntent().getExtras();
        String nome = args.getString("ch_usuario");
        String a = nome;
        db = dtb.getReadableDatabase();
        cursor = db.rawQuery("select nome from usuario;", null);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;

                switch (menuItem.getItemId()){
                    case R.id.nav_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.nav_shop:
                        fragment = new ShopFragment();
                        break;
                    case R.id.nav_menu:
                        fragment = new MenuFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();

                return true;
            }
        });

        if(cursor.moveToFirst()){
            do {
                a = cursor.getString(0);
                if(a.equals(nome)){
                    break;
                }
            }while (cursor.moveToNext());
        }
        txtNome.setText("Bem vind@ " + a);
        cursor.close();
    }
}