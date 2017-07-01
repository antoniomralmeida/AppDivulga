package br.com.appdivulga.acitivites;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.appdivulga.R;
import br.com.appdivulga.util.Global;


/**
 * Created by jardel on 25/05/2017.
 */

public class LoginActivity extends AppCompatActivity {


    private android.widget.EditText editTextloginmatricula;
    private android.support.design.widget.TextInputLayout textInputLayoutloginmatricula;
    private android.widget.EditText editTextloginsenha;
    private android.support.design.widget.TextInputLayout textInputLayoutloginsenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView textViewloginrecuperarsenha = (TextView) findViewById(R.id.textView_login_recuperar_senha);
        Button buttonlogincadastrarusuario = (Button) findViewById(R.id.button_login_cadastrar_usuario);
        Button buttonloginentrar = (Button) findViewById(R.id.button_login_entrar);
        this.textInputLayoutloginsenha = (TextInputLayout) findViewById(R.id.textInputLayout_login_senha);
        this.editTextloginsenha = (EditText) findViewById(R.id.editText_login_senha);
        this.textInputLayoutloginmatricula = (TextInputLayout) findViewById(R.id.textInputLayout_login_matricula);
        this.editTextloginmatricula = (EditText) findViewById(R.id.editText_login_matricula);



//        verificar texto dos inputs passar feedback
        this.editTextloginmatricula.addTextChangedListener(new MyWatcher(this.editTextloginmatricula));
        this.editTextloginsenha.addTextChangedListener(new MyWatcher(this.editTextloginsenha));


        /**
         * açoes do botao de login
         */
        buttonloginentrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    if (Global.getUsuario().get(0).getMatricula().getMatricula().equals(editTextloginmatricula.getText().toString()) && Global.getUsuario().get(0).getSenha().equals(editTextloginsenha.getText().toString())) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                    if (Global.getUsuario().get(1).getMatricula().getMatricula().equals(editTextloginmatricula.getText().toString()) && Global.getUsuario().get(1).getSenha().equals(editTextloginsenha.getText().toString())) {
                        Intent intent = new Intent(LoginActivity.this, GestorRequerimentosActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });


        buttonloginentrar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(LoginActivity.this, GestorRequerimentosActivity.class);
                startActivity(intent);
                return false;
            }
        });

        /**
         * açoes do botao de cadastro
         */
        buttonlogincadastrarusuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                    startActivity(intent);
                }
            }
        });


        /**
         * açoes do texto de recuperaçao de senha
         */
        textViewloginrecuperarsenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RecuperarSenhaActivity.class);
                startActivity(intent);
            }
        });

    }

    /**
     * validar requistos dos inputs
     *
     * @return
     */
    private boolean validateInputs() {
        boolean r = true;
        if (!validateEnrolment()) {
            r = false;
            return false;
        }
        if (!validatePassword()) {
            r = false;
            return false;
        }
        return r;
    }

    /**
     * validar requistos da senha
     *
     * @return
     */
    private boolean validatePassword() {
        if (this.editTextloginsenha.getText().toString().trim().isEmpty() && this.editTextloginsenha.getText().length() < 6) {
            this.textInputLayoutloginsenha.setError(getString(R.string.error_msg_senha));
            textFocus(this.editTextloginsenha);
            return false;
        } else {
            this.textInputLayoutloginsenha.setErrorEnabled(false);
        }
        return true;
    }

    /**
     * validar requistos da matricula
     *
     * @return
     */
    private boolean validateEnrolment() {
        if (this.editTextloginmatricula.getText().toString().trim().isEmpty() || this.editTextloginmatricula.getText().length() < 12) {
            textInputLayoutloginmatricula.setError(getString(R.string.error_msg_matricula));
            textFocus(this.editTextloginmatricula);
            return false;
        } else {
            textInputLayoutloginmatricula.setErrorEnabled(false);
        }
        return true;
    }

    /**
     * trazer o foco para o TextInputLayout
     *
     * @param view
     */
    private void textFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    /**
     * pegar events dos input
     */
    private class MyWatcher implements TextWatcher {

        private View view;

        private MyWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.editText_login_matricula:
                    validateEnrolment();
                    break;
                case R.id.editText_login_senha:
                    validatePassword();
                    break;
            }
        }
    }

    /**
     * fechar app se user aperta no back
     */
    @Override
    public void onBackPressed() {
        finishAffinity();
        super.onBackPressed();
    }
}

