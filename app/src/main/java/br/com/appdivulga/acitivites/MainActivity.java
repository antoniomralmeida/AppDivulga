package br.com.appdivulga.acitivites;

import android.content.Intent;
import android.net.Uri;
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
import br.com.appdivulga.adaptadores.RequerimentosMainAdapter;
import br.com.appdivulga.interfaces.CustomClickListener;
import br.com.appdivulga.util.Global;

import static br.com.appdivulga.R.id.fab;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton floatingActionButton;
    private RequerimentosMainAdapter requerimentosMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = (FloatingActionButton) findViewById(fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NovoRequerimentoActivity.class);
                startActivity(intent);
            }
        });

        requerimentosMainAdapter = new RequerimentosMainAdapter(Global.getEventos());
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView_main);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(requerimentosMainAdapter);

        requerimentosMainAdapter.setOnItemCustomClickListener(new CustomClickListener() {
            @Override
            public void clickItem(int position, View view) {
                switch (view.getId()) {
                    case R.id.imageButton_evento_ementa:
                        showDialog(position, view);
                        break;
                    case R.id.imageButton_evento_share:
                        String espaço = " ";
                        String evento = requerimentosMainAdapter.getItem(position).toString();
                        String titulomesgsahre = "Estou compartilhando este evento com voce:";
                        Intent sharingIntent = new Intent(
                                Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        String shareBody = titulomesgsahre + espaço
                                + evento;
                        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "");
                        sharingIntent
                                .putExtra(Intent.EXTRA_TEXT, shareBody);
                        startActivity(Intent.createChooser(sharingIntent, "Compartilha atavez de"));
                        break;
                    case R.id.imageButton_evento_mapa:
                        Uri location = Uri.parse("geo:0,0?q=" + requerimentosMainAdapter.getItem(position).getCampus().getEndereco());
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                        startActivity(mapIntent);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_requerimentos:
                Intent intent = new Intent(MainActivity.this, MeusRequerimentosActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_notificacao:
                Toast.makeText(this, "nao implementado", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_alterar_senha:
                Toast.makeText(this, "nao implementado", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_logof:
                Toast.makeText(this, "nao implementado", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void showDialog(final int position, final View view) {
        AlertDialog.Builder builder = new
                AlertDialog.Builder(this);
        builder.setTitle(requerimentosMainAdapter.getItem(position).getTitulo());
        builder.setMessage(requerimentosMainAdapter.getItem(position).getEmenta());
        builder.setPositiveButton("OK", null);
        builder.show();
    }
}
