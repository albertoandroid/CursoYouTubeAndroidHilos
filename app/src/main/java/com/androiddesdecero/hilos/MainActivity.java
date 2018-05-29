package com.androiddesdecero.hilos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btLanzarTarea;
    private Button btLanzarHilo;
    private TextView tvMostrarDato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMostrarDato = findViewById(R.id.tvMostrarDato);

        btLanzarTarea = findViewById(R.id.btLanzarTarea);
        btLanzarTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tareaLarga();
            }
        });

        btLanzarHilo = findViewById(R.id.btLanzarHilo);
        btLanzarHilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tareaConHilos();
            }
        });
    }

    private void tareaLarga(){
        try{
            Thread.sleep(9000);
        }catch (InterruptedException e){

        }
    }

    private void tareaConHilos(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(9000);
                }catch (InterruptedException e){

                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvMostrarDato.setText("alberto");
                    }
                });
                

                Log.d("TAG", "Hilo Acabado");
            }
        }).start();
    }
}
