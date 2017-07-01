package br.com.appdivulga.acitivites;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;

import br.com.appdivulga.R;

/**
 * Created by jardel on 25/05/2017.
 */

public class InicioActivity extends AppCompatActivity {
    private int state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }

    @Override
    protected void onResume() {
        super.onResume();

        /**
         * espera 2 segundo para abrir tela de login
         * no back ficha o app
         */
        if (state == 1)
            finishAffinity();
        else
            new CountDownTimer(1000, 2000) {
                public void onTick(long millisUntilFinished) {

                }

                public void onFinish() {
                    Intent intent = new Intent(InicioActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }.start();

    }

    @Override
    protected void onPause() {
        state = 1;
        super.onPause();
    }
}

