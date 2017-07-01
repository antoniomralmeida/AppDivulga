package br.com.appdivulga.acitivites;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import br.com.appdivulga.R;
import br.com.appdivulga.adaptadores.RequerimentosUsuarioAdapter;
import br.com.appdivulga.interfaces.CustomClickListener;
import br.com.appdivulga.util.Global;

import static br.com.appdivulga.R.id.fab;

public class MeusRequerimentosActivity extends AppCompatActivity {
    private FloatingActionButton floatingActionButton;
    private RequerimentosUsuarioAdapter requerimentosUsuarioAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_requerimentos);

        floatingActionButton = (FloatingActionButton) findViewById(fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeusRequerimentosActivity.this, NovoRequerimentoActivity.class);
                startActivity(intent);
            }
        });

        requerimentosUsuarioAdapter = new RequerimentosUsuarioAdapter(Global.getEventos());
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView_meus_requerimentos);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(requerimentosUsuarioAdapter);

        requerimentosUsuarioAdapter.setOnItemCustomClickListener(new CustomClickListener() {
            @Override
            public void clickItem(int position, View view) {
                switch (view.getId()) {
                    case R.id.imageButton_evento_ementa:
                        showDialog(position, view);
                        break;
                    case R.id.imageButton_evento_editar:
                        Intent intent = new Intent(MeusRequerimentosActivity.this,NovoRequerimentoActivity.class);
                        intent.putExtra("evento",requerimentosUsuarioAdapter.getItem(position));
                        startActivity(intent);
                        break;
                    case R.id.imageButton_evento_cancelar:
                        showDialogCancelar(position, view);
                        break;
                    case R.id.imageButton_evento_arquivar:
                        showDialogArquivar(position, view);
                        break;
                }
            }

            @Override
            public void clickLongItem(int position, View v) {

            }
        });


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    floatingActionButton.show();
                }
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0 || dy < 0 && floatingActionButton.isShown()) {
                    floatingActionButton.hide();
                }
            }
        });

    }

    public void showDialog(final int position, final View view) {
        AlertDialog.Builder builder = new
                AlertDialog.Builder(this);
        builder.setTitle(requerimentosUsuarioAdapter.getItem(position).getTitulo());
        builder.setMessage(requerimentosUsuarioAdapter.getItem(position).getEmenta());
        builder.setPositiveButton("OK", null);
        builder.show();
    }

    public void showDialogArquivar(final int position, final View view) {
        AlertDialog.Builder builder = new
                AlertDialog.Builder(this);
        builder.setTitle("Confirmaçao");
        builder.setMessage("Deseja arquivar o evento: " + requerimentosUsuarioAdapter.getItem(position).getTitulo());
        builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MeusRequerimentosActivity.this, "Requerimeto arquivado com susesso", Toast.LENGTH_SHORT).show();
                requerimentosUsuarioAdapter.deleteItem(position);

            }
        });
        builder.setNegativeButton("NAO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

    public void showDialogCancelar(final int position, final View view) {
        AlertDialog.Builder builder = new
                AlertDialog.Builder(this);
        builder.setTitle("Confirmaçao");
        builder.setMessage("Deseja cancelar requerimento do evento: " + requerimentosUsuarioAdapter.getItem(position).getTitulo());
        builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MeusRequerimentosActivity.this, "Requerimeto cancelado com susesso", Toast.LENGTH_SHORT).show();
                requerimentosUsuarioAdapter.getItem(position).setStatus("Cancelado");
                requerimentosUsuarioAdapter.notifyItemChanged(position);
            }
        });
        builder.setNegativeButton("NAO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

}

