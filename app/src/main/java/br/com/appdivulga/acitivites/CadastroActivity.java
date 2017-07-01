package br.com.appdivulga.acitivites;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import br.com.appdivulga.R;
import br.com.appdivulga.dominio.Usuario;

public class CadastroActivity extends AppCompatActivity {


    private Usuario usuario;
    private EditText EditTextcadastronome;
    private TextInputLayout textInputLayoutcadastronome;
    private EditText EditTextcadastroemail;
    private TextInputLayout textInputLayoutcadastroemail;
    private EditText EditTextcadastrotelefone;
    private TextInputLayout textInputLayoutcadastrotelefone;
    private EditText EditTextcadastromatricula;
    private TextInputLayout textInputLayoutcadastromatricula;
    private EditText EditTextcadastrosenha;
    private TextInputLayout textInputLayoutcadastrosenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Button buttoncadastroconfirmar = (Button) findViewById(R.id.button_cadastro_confirmar);
        final Spinner spinnercadastroarea = (Spinner) findViewById(R.id.spinner_cadastro_area);
        this.textInputLayoutcadastrosenha = (TextInputLayout) findViewById(R.id.textInputLayout_cadastro_senha);
        this.EditTextcadastrosenha = (EditText) findViewById(R.id.EditText_cadastro_senha);
        this.textInputLayoutcadastromatricula = (TextInputLayout) findViewById(R.id.textInputLayout_cadastro_matricula);
        this.EditTextcadastromatricula = (EditText) findViewById(R.id.EditText_cadastro_matricula);
        this.textInputLayoutcadastrotelefone = (TextInputLayout) findViewById(R.id.textInputLayout_cadastro_telefone);
        this.EditTextcadastrotelefone = (EditText) findViewById(R.id.EditText_cadastro_telefone);
        this.textInputLayoutcadastroemail = (TextInputLayout) findViewById(R.id.textInputLayout_cadastro_email);
        this.EditTextcadastroemail = (EditText) findViewById(R.id.EditText_cadastro_email);
        this.textInputLayoutcadastronome = (TextInputLayout) findViewById(R.id.textInputLayout_cadastro_nome);
        this.EditTextcadastronome = (EditText) findViewById(R.id.EditText_cadastro_nome);





        buttoncadastroconfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateForm()) {

                    confirmDialog(usuario.toString());
                }
            }
        });

        ArrayAdapter<CharSequence> area = ArrayAdapter.createFromResource(this,
                R.array.area, android.R.layout.simple_spinner_item);
        area.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnercadastroarea.setAdapter(area);


    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * validar inputs
     *
     * @return
     */
    private boolean validateForm() {
        boolean ret = true;
        if (!validarNome()) {
            ret = false;
            return false;
        }
        if (!validateEmail()) {
            ret = false;
            return false;
        }
        if (!validarTelefone()) {
            ret = false;
            return false;
        }
        if (!validarMatricula()) {
            ret = false;
            return false;
        }
        if (!validarSenha()) {
            ret = false;
            return false;
        }
        return ret;
    }

    /**
     * validar telefone
     *
     * @return
     */
    private boolean validarTelefone() {
        String phone = this.EditTextcadastrotelefone.getText().toString().trim();
        if (phone.isEmpty() || !isValidPhone(phone)) {
            this.textInputLayoutcadastrotelefone.setError(getString(R.string.error_msg_telefone));
            requestFocus(this.EditTextcadastrotelefone);
            return false;
        } else {
            this.textInputLayoutcadastrotelefone.setErrorEnabled(false);
        }
        return true;
    }

    private static boolean isValidPhone(String phone) {
        return !TextUtils.isEmpty(phone) && Patterns.PHONE.matcher(phone).matches();
    }

    /**
     * validar senha
     *
     * @return
     */
    private boolean validarSenha() {
        if (this.EditTextcadastrosenha.getText().toString().trim().isEmpty() && this.EditTextcadastrosenha.getText().length() < 6) {
            this.textInputLayoutcadastrosenha.setError(getString(R.string.error_msg_senha));
            requestFocus(this.EditTextcadastrosenha);
            return false;
        } else {
            this.textInputLayoutcadastrosenha.setErrorEnabled(false);
        }
        return true;
    }

    /**
     * validar nome
     *
     * @return
     */
    private boolean validarNome() {
        if (this.EditTextcadastronome.getText().toString().trim().isEmpty()) {
            textInputLayoutcadastronome.setError(getString(R.string.error_msg_nome));
            requestFocus(this.EditTextcadastronome);
            return false;
        } else {
            textInputLayoutcadastronome.setErrorEnabled(false);
        }
        return true;
    }

    /**
     * validar matricula
     *
     * @return
     */
    private boolean validarMatricula() {
        if (this.EditTextcadastromatricula.getText().toString().trim().isEmpty() || this.EditTextcadastromatricula.getText().length() < 12) {
            textInputLayoutcadastromatricula.setError(getString(R.string.error_msg_matricula));
            requestFocus(this.EditTextcadastromatricula);
            return false;
        } else {
            textInputLayoutcadastromatricula.setErrorEnabled(false);
        }
        return true;
    }

    /**
     * validar email
     *
     * @return
     */
    private boolean validateEmail() {
        String email = this.EditTextcadastroemail.getText().toString().trim();
        if (email.isEmpty() || !isValidEmail(email)) {
            this.textInputLayoutcadastroemail.setError(getString(R.string.error_msg_email));
            requestFocus(this.EditTextcadastroemail);
            return false;
        } else {
            this.textInputLayoutcadastroemail.setErrorEnabled(false);
        }
        return true;
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /**
     * trazer o foco para o TextInputLayout
     *
     * @param view
     */
    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    /**
     * dialog
     */

    public void confirmDialog(String string) {
        AlertDialog.Builder builder = new
                AlertDialog.Builder(CadastroActivity.this);
        builder.setTitle("Sucesso");
        builder.setMessage("ok");
        builder.setMessage(string);
        builder.setPositiveButton("OK", null);
        builder.show();
    }


    /**
     * validar enquanto digitar
     */

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.EditText_cadastro_nome:
                    validarNome();
                    break;
                case R.id.EditText_cadastro_email:
                    validateEmail();
                    break;
                case R.id.EditText_cadastro_telefone:
                    validarTelefone();
                    break;
                case R.id.EditText_cadastro_matricula:
                    validarMatricula();
                    break;
                case R.id.EditText_cadastro_senha:
                    validarSenha();
                    break;
            }
        }
    }
}


