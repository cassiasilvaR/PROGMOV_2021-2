package com.example.eshelf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Cadastrar extends AppCompatActivity {

    private Button btnCadastro;
    private EditText edtNomeCompleto, edtCpf, edtEmail, edtCelular, edtSenha1, edtSenha2;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        edtNomeCompleto= findViewById(R.id.edt_nome_completo);
        edtCpf = findViewById(R.id.edt_cpf);
        edtEmail = findViewById(R.id.edt_email_cadastro);
        edtCelular = findViewById(R.id.edt_celular);
        edtSenha1 = findViewById(R.id.edt_senha_cadastro);
        edtSenha2 = findViewById(R.id.edt_senha_cadastro_repeat);
        btnCadastro = findViewById(R.id.btn_cadastrar);

        /*btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }

}