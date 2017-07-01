package br.com.appdivulga.acitivites;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import br.com.appdivulga.R;

public class RecuperarSenhaActivity extends AppCompatActivity {


    private ImageView imageViewlogin;
    private EditText editTextresetarsenhamatricula;
    private TextInputLayout textInputLayout;
    private EditText editTextresetarsenhaemail;
    private TextInputLayout textInputLayout2;
    private Button buttonresetarsenha;
    private Button buttonresetsenhavoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha);
        this.buttonresetsenhavoltar = (Button) findViewById(R.id.button_reset_senha_voltar);
        this.buttonresetarsenha = (Button) findViewById(R.id.button_resetar_senha);
        this.textInputLayout2 = (TextInputLayout) findViewById(R.id.textInputLayout2);
        this.editTextresetarsenhaemail = (EditText) findViewById(R.id.editText_resetar_senha_email);
        this.textInputLayout = (TextInputLayout) findViewById(R.id.textInputLayout);
        this.editTextresetarsenhamatricula = (EditText) findViewById(R.id.editText_resetar_senha_matricula);
        this.imageViewlogin = (ImageView) findViewById(R.id.imageView_login);


        this.buttonresetarsenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
