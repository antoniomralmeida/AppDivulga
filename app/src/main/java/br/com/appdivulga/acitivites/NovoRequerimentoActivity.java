package br.com.appdivulga.acitivites;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import br.com.appdivulga.R;
import br.com.appdivulga.dominio.Evento;
import br.com.appdivulga.util.TimeSet;

public class NovoRequerimentoActivity extends AppCompatActivity {


    private EditText editTextrequerimentostitulo;
    private TextInputLayout textInputLayoutrequerimentostitulo;
    private Spinner spinnerrequerimentoscampus;
    private Spinner spinnerrequerimentoslocal;
    private Spinner spinnerrequerimentostipo;
    private Spinner spinnerrequerimentosarea;
    private TextView textViewrequerimentosdata;
    private TextInputLayout textInputLayoutrequerimentosdata;
    private TextView textViewrequerimentoshora;
    private TextInputLayout textInputLayoutrequerimentoshora;
    private TextView textViewrequerimentoshorafim;
    private TextInputLayout textInputLayoutrequerimentoshorafim;
    private EditText editTextrequerimentosvagas;
    private TextInputLayout textInputLayoutrequerimentosvagas;
    private TextView textViewrequerimentosdescricaocont;
    private EditText editTextrequerimentosdescricao;
    private TextInputLayout textInputLayoutrequerimentosdescricao;
    private Button buttonrequerimentosconfirmar;
    private  Evento evento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_requerimento);
        this.buttonrequerimentosconfirmar = (Button) findViewById(R.id.button__requerimentos_confirmar);
        this.textInputLayoutrequerimentosdescricao = (TextInputLayout) findViewById(R.id.textInputLayout_requerimentos_descricao);
        this.editTextrequerimentosdescricao = (EditText) findViewById(R.id.editText_requerimentos_descricao);
        this.textViewrequerimentosdescricaocont = (TextView) findViewById(R.id.textView_requerimentos_descricao_cont);
        this.textInputLayoutrequerimentosvagas = (TextInputLayout) findViewById(R.id.textInputLayout_requerimentos_vagas);
        this.editTextrequerimentosvagas = (EditText) findViewById(R.id.editText_requerimentos_vagas);
        this.textInputLayoutrequerimentoshorafim = (TextInputLayout) findViewById(R.id.textInputLayout_requerimentos_hora_fim);
        this.textViewrequerimentoshorafim = (TextView) findViewById(R.id.textView_requerimentos_hora_fim);
        this.textInputLayoutrequerimentoshora = (TextInputLayout) findViewById(R.id.textInputLayout_requerimentos_hora);
        this.textViewrequerimentoshora = (TextView) findViewById(R.id.textView_requerimentos_hora);
        this.textInputLayoutrequerimentosdata = (TextInputLayout) findViewById(R.id.textInputLayout_requerimentos_data);
        this.textViewrequerimentosdata = (TextView) findViewById(R.id.textView_requerimentos_data);
        this.spinnerrequerimentosarea = (Spinner) findViewById(R.id.spinner_requerimentos_area);
        this.spinnerrequerimentostipo = (Spinner) findViewById(R.id.spinner_requerimentos_tipo);
        this.spinnerrequerimentoslocal = (Spinner) findViewById(R.id.spinner_requerimentos_local);
        this.spinnerrequerimentoscampus = (Spinner) findViewById(R.id.spinner_requerimentos_campus);
        this.textInputLayoutrequerimentostitulo = (TextInputLayout) findViewById(R.id.textInputLayout_requerimentos_titulo);
        this.editTextrequerimentostitulo = (EditText) findViewById(R.id.editText_requerimentos_titulo);


        this.editTextrequerimentostitulo.addTextChangedListener(new MyTextWatcher(textInputLayoutrequerimentostitulo));
        this.editTextrequerimentosdescricao.addTextChangedListener(new MyTextWatcher(editTextrequerimentosdescricao));
        this.editTextrequerimentosvagas.addTextChangedListener(new MyTextWatcher(editTextrequerimentosvagas));
        this.textViewrequerimentoshorafim.addTextChangedListener(new MyTextWatcher(textViewrequerimentoshorafim));
        this.textViewrequerimentoshora.addTextChangedListener(new MyTextWatcher(textViewrequerimentoshora));
        this.textViewrequerimentosdata.addTextChangedListener(new MyTextWatcher(textViewrequerimentosdata));
        Intent intent = getIntent();
        evento = (Evento) intent.getSerializableExtra("evento");



        ArrayAdapter<CharSequence> tipo = ArrayAdapter.createFromResource(this,
                R.array.campus, android.R.layout.simple_spinner_item);
        tipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerrequerimentoscampus.setAdapter(tipo);

        ArrayAdapter<CharSequence> instituicao = ArrayAdapter.createFromResource(this,
                R.array.locais, android.R.layout.simple_spinner_item);
        instituicao.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerrequerimentoslocal.setAdapter(instituicao);

        ArrayAdapter<CharSequence> local = ArrayAdapter.createFromResource(this,
                R.array.tipo, android.R.layout.simple_spinner_item);
        local.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerrequerimentostipo.setAdapter(local);

        ArrayAdapter<CharSequence> area = ArrayAdapter.createFromResource(this,
                R.array.area, android.R.layout.simple_spinner_item);
        area.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerrequerimentosarea.setAdapter(area);

        this.editTextrequerimentosdescricao.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                textViewrequerimentosdescricaocont.setText(String.valueOf(editTextrequerimentosdescricao.length()) + "/120");
            }
        });


        buttonrequerimentosconfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateForm()) {
/*
                    Evento evento = new Evento(editTextrequerimentostitulo.getText().toString(), editTextrequerimentosdescricao.getText().toString(), new Area(1,(String) spinnerrequerimentosarea.getSelectedItem().toString()), textViewrequerimentosdata.getText().toString(), textViewrequerimentoshora.getText().toString(), textViewrequerimentoshorafim.getText().toString(), Integer.parseInt(editTextrequerimentosvagas.getText().toString()), new Campus(1,(String) spinnerrequerimentoscampus.getSelectedItem().toString()," "," "), new Local(1,(String) spinnerrequerimentoslocal.getSelectedItem().toString(), 50), new Tipo((String) spinnerrequerimentostipo.getSelectedItem().toString()));
*/
                    //confirmDialog(evento);

                    Toast.makeText(NovoRequerimentoActivity.this, "nada aqui", Toast.LENGTH_SHORT).show();
                }
            }
        });




        this.textViewrequerimentosdata.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    new TimeSet(NovoRequerimentoActivity.this).setData(textViewrequerimentosdata);
            }
        });
        this.textViewrequerimentoshora.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    new TimeSet(NovoRequerimentoActivity.this).setHora(textViewrequerimentoshora);
            }
        });

        this.textViewrequerimentoshorafim.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    new TimeSet(NovoRequerimentoActivity.this).setHora(textViewrequerimentoshorafim);
            }
        });

    }


    private boolean validateForm() {
        boolean ret = true;
        if (!validarTitulo()) {
            ret = false;
            return false;
        }
        if (!validarData()) {
            ret = false;
            return false;
        }
        if (!validarHora()) {
            ret = false;
            return false;
        }
        if (!validarHoraFim()) {
            ret = false;
            return false;
        }
        if (!validarVagas()) {
            ret = false;
            return false;
        }
        if (!validarDescricao()) {
            ret = false;
            return false;
        }
        return ret;
    }

    private boolean validarData() {
        if (this.textViewrequerimentosdata.getText().toString().trim().isEmpty()) {
            textInputLayoutrequerimentosdata.setError(getString(R.string.error_msg_data));
            requestFocus(textViewrequerimentosdata);
            return false;
        } else {
            textInputLayoutrequerimentosdata.setErrorEnabled(false);
        }
        return true;
    }


    private boolean validarHora() {
        if (this.textViewrequerimentoshora.getText().toString().trim().isEmpty()) {
            textInputLayoutrequerimentoshora.setError(getString(R.string.error_msg_hora));
            requestFocus(textViewrequerimentoshora);
            return false;
        } else {
            textInputLayoutrequerimentoshora.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validarDescricao() {
        if (this.editTextrequerimentosdescricao.getText().toString().trim().isEmpty()) {
            textInputLayoutrequerimentosdescricao.setError(getString(R.string.error_msg_descricao));
            requestFocus(editTextrequerimentosdescricao);
            return false;
        } else {
            textInputLayoutrequerimentosdescricao.setErrorEnabled(false);
        }
        return true;
    }


    private boolean validarTitulo() {
        if (this.editTextrequerimentostitulo.getText().toString().trim().isEmpty()) {
            textInputLayoutrequerimentostitulo.setError(getString(R.string.error_msg_titulo));
            requestFocus(editTextrequerimentostitulo);
            return false;
        } else {
            textInputLayoutrequerimentostitulo.setErrorEnabled(false);
        }
        return true;
    }


    private boolean validarHoraFim() {
        if (this.textViewrequerimentoshorafim.getText().toString().trim().isEmpty()) {
            textInputLayoutrequerimentoshorafim.setError(getString(R.string.error_msg_hora_final));
            requestFocus(textViewrequerimentoshorafim);
            return false;
        } else {
            textInputLayoutrequerimentoshorafim.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validarVagas() {
        if (this.editTextrequerimentosvagas.getText().toString().trim().isEmpty()) {
            textInputLayoutrequerimentosvagas.setError(getString(R.string.error_msg_vagas));
            requestFocus(editTextrequerimentosvagas);
            return false;
        } else {
            textInputLayoutrequerimentosvagas.setErrorEnabled(false);
        }
        return true;
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
    public void confirmDialog(Evento evento) {
        AlertDialog.Builder mensagem = new
                AlertDialog.Builder(this);
        mensagem.setTitle("Sucesso");
        mensagem.setMessage(evento.toString());
        mensagem.setPositiveButton("OK", null);
        mensagem.show();
    }


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
                case R.id.editText_requerimentos_titulo:
                    validarTitulo();
                    break;
                case R.id.textView_requerimentos_data:
                    validarData();
                    break;
                case R.id.textView_requerimentos_hora:
                    validarHora();
                    break;
                case R.id.textInputLayout_requerimentos_hora_fim:
                    validarHoraFim();
                    break;
                case R.id.editText_requerimentos_vagas:
                    validarVagas();
                    break;
                case R.id.editText_requerimentos_descricao:
                    validarDescricao();
                    break;
            }
        }
    }

    @Override
    protected void onResume() {
        if(evento!=null){
            this.editTextrequerimentostitulo.setText(evento.getTitulo());
            this.editTextrequerimentosdescricao.setText(evento.getEmenta());
            this.editTextrequerimentosvagas.setText(""+evento.getVagas());
            this.textViewrequerimentoshorafim.setText(evento.getHoraFinal());
            this.textViewrequerimentoshora.setText(evento.getHora());
            this.textViewrequerimentosdata.setText(evento.getData());
        }
        super.onResume();
    }
}
