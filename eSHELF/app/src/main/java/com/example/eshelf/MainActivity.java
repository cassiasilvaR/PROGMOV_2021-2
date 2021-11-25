package com.example.eshelf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtEmail, edtSenha;
    private DBHelper dbHelper = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = findViewById(R.id.edt_email);
        edtSenha = findViewById(R.id.edt_senha);
    }

    public void acessar(View view) {
        String email = edtEmail.getText().toString();
        String senha = edtSenha.getText().toString();
        String pass = dbHelper.buscarSenha(email);
        if(senha.equals(pass)){
            Intent intent = new Intent(MainActivity.this, iniciar.class);
            intent.putExtra("ch_usuario", email);
            startActivity(intent);
        }
        else {
            Toast t = Toast.makeText(MainActivity.this, "Usuário ou senha não encontrados", Toast.LENGTH_LONG);
            t.show();
        }
    }

    public void cadastrar(View view) {
        Intent it = new Intent(MainActivity.this, Cadastrar.class);
        startActivity(it);
    }
}