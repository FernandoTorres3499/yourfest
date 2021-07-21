package app.modelo.yourfest.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import app.modelo.yourfest.api.AppUtil;
import app.modelo.yourfest.R;




public class SplashActivity extends AppCompatActivity {


    TextView txtAppVersion;


    int tempoDeEspera = 1000 * 7;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Log.d(AppUtil.TAG, "onCreate: Tela Splash Carregada");

        txtAppVersion = findViewById(R.id.txtAppVersion);
        txtAppVersion.setText(AppUtil.versaoDoAplicativo());

        trocarTela();

    }

    private void trocarTela() {

        Log.d(AppUtil.TAG, "trocarTela: Mudando de tela");



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d(AppUtil.TAG, "trocarTela: Esperando um tempo");


                //Criando intencao de troca de tela
                Intent trocarDeTela = new Intent(SplashActivity.this, MainActivity.class);


                //Trocando de tela
                startActivity(trocarDeTela);
                finish();

            }
        },tempoDeEspera);




    }

}