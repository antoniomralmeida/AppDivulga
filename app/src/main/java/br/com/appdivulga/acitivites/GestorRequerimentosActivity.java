package br.com.appdivulga.acitivites;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import br.com.appdivulga.R;
import br.com.appdivulga.adaptadores.RequerimentosGestorAdapter;
import br.com.appdivulga.interfaces.CustomClickListener;
import br.com.appdivulga.util.Global;

import static br.com.appdivulga.R.id.fab;

public class GestorRequerimentosActivity extends AppCompatActivity {
    private FloatingActionButton floatingActionButton;
    private RequerimentosGestorAdapter requerimentosGestorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestor_requerimentos);

        floatingActionButton = (FloatingActionButton) findViewById(fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GestorRequerimentosActivity.this, NovoRequerimentoActivity.class);
                startActivity(intent);
            }
        });


        requerimentosGestorAdapter = new RequerimentosGestorAdapter(Global.getEventos());
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView_gestor);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(requerimentosGestorAdapter);

        requerimentosGestorAdapter.setOnItemCustomClickListener(new CustomClickListener() {
            @Override
            public void clickItem(int position, View view) {
                switch (view.getId()) {
                    case R.id.imageButton_evento_aprovar:
                        showDialogEvento(position, view, "Aprovar", "Evento: " + requerimentosGestorAdapter.getItem(position).getTitulo() + "\nSolicitante: " + requerimentosGestorAdapter.getItem(position).getUsuario().getNome());
                        break;
                    case R.id.imageButton_evento_negar:
                        showDialogEvento(position, view, "Negar", "Evento: " + requerimentosGestorAdapter.getItem(position).getTitulo() + "\nSolicitante: " + requerimentosGestorAdapter.getItem(position).getUsuario().getNome());
                        break;
                    case R.id.imageButton_evento_ementa:
                        showDialog(position, view);
                        break;
                    case R.id.imageButton_evento_usuario:
                        showDialogUsuario(position, view);
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
        builder.setTitle(requerimentosGestorAdapter.getItem(position).getTitulo());
        builder.setMessage(requerimentosGestorAdapter.getItem(position).getEmenta());
        builder.setPositiveButton("OK", null);
        builder.show();
    }

    public void showDialogUsuario(final int position, final View view) {
        AlertDialog.Builder builder = new
                AlertDialog.Builder(this);
        builder.setTitle("Solicitante");
        builder.setMessage("Evento: " + requerimentosGestorAdapter.getItem(position).getTitulo() + "\nNome: " + requerimentosGestorAdapter.getItem(position).getUsuario().toString());
        builder.setPositiveButton("OK", null);
        builder.show();
    }

    public void showDialogEvento(final int position, final View view, final CharSequence titulo, final CharSequence menssage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(titulo);
        builder.setMessage(menssage);
        if (view.getId() == R.id.imageButton_evento_aprovar) {
            builder.setPositiveButton("Sim", new DialogInterface.OnClickListener()

            {
                public void onClick(DialogInterface dialog, int id) {
                    requerimentosGestorAdapter.deleteItem(position);
                    Toast.makeText(GestorRequerimentosActivity.this, "requerimento aprovado", Toast.LENGTH_SHORT).show();
                }
            });
        }
        if (view.getId() == R.id.imageButton_evento_negar) {
            builder.setPositiveButton("Sim", new DialogInterface.OnClickListener()

            {
                public void onClick(DialogInterface dialog, int id) {
                    requerimentosGestorAdapter.deleteItem(position);
                    Toast.makeText(GestorRequerimentosActivity.this, "requerimento negado", Toast.LENGTH_SHORT).show();
                }
            });
        }
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.gestor, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.menu_requerimentos_ativos:
                intent = new Intent(GestorRequerimentosActivity.this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_requerimentos:
                Toast.makeText(this, "todos os requerimentos com filtros para localizaçao", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_cadastrar_locais:
                Toast.makeText(this, "cadastrar locas do campus", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_cadastar_tipos:
                Toast.makeText(this, "cadastrar tipo de evento no campos201", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
