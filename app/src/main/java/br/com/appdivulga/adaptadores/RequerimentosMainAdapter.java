package br.com.appdivulga.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.List;

import br.com.appdivulga.interfaces.CustomClickListener;
import br.com.appdivulga.R;
import br.com.appdivulga.dominio.Evento;

/**
 * Created by jardel on 25/06/2017.
 */

public class RequerimentosMainAdapter extends RecyclerView.Adapter<RequerimentosMainAdapter.ViewHolder> {
    private CustomClickListener customClickListener;
    private List<Evento> eventos;

    public RequerimentosMainAdapter(List<Evento> eventos) {
        this.eventos = eventos;
    }

    @Override
    public RequerimentosMainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.evento_modelo_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RequerimentosMainAdapter.ViewHolder holder, int position) {
        holder.tipo.setText(eventos.get(position).getTipo().getTipo());
        holder.titulo.setText(eventos.get(position).getTitulo());
        holder.campus.setText(eventos.get(position).getCampus().getCampus());
        holder.local.setText(eventos.get(position).getLocal().getLocal());
        holder.data.setText(eventos.get(position).getData());
        holder.hora.setText(eventos.get(position).getHora());
        holder.area.setText(eventos.get(position).getArea().getArea());
        holder.horaFinal.setText(eventos.get(position).getHoraFinal());
        holder.vagas.setText(eventos.get(position).getVagas()+" ");
        YoYo.with(Techniques.FadeInLeft).duration(1500).playOn(holder.itemView);
    }

    @Override
    public int getItemCount() {
        return eventos.size();
    }

    public Evento getItem(int position) {
        return eventos.get(position);
    }
    public void setOnItemCustomClickListener(CustomClickListener customClickListener) {
        this.customClickListener = customClickListener;
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        TextView tipo;
        TextView titulo;
        TextView area;
        TextView campus;
        TextView local;
        TextView data;
        TextView hora;
        TextView horaFinal;
        TextView vagas;
        ImageButton ementa;
        ImageButton share;
        ImageButton mapa;

        ViewHolder(View itemView) {
            super(itemView);
            tipo = (TextView) itemView.findViewById(R.id.textView_evento_tipo);
            titulo = (TextView) itemView.findViewById(R.id.textView_evento_titulo);
            area = (TextView) itemView.findViewById(R.id.textView_evento_area);
            campus = (TextView) itemView.findViewById(R.id.textView_evento_campus);
            local = (TextView) itemView.findViewById(R.id.textView_evento_local);
            data = (TextView) itemView.findViewById(R.id.textView_evento_data);
            hora = (TextView) itemView.findViewById(R.id.textView_evento_hora);
            horaFinal = (TextView) itemView.findViewById(R.id.textView_evento_hora_final);
            vagas = (TextView) itemView.findViewById(R.id.textView_evento_vagas);
            ementa = (ImageButton) itemView.findViewById(R.id.imageButton_evento_ementa);
            share = (ImageButton) itemView.findViewById(R.id.imageButton_evento_share);
            mapa = (ImageButton) itemView.findViewById(R.id.imageButton_evento_mapa);

            mapa.setOnClickListener(this);
            ementa.setOnClickListener(this);
            share.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            customClickListener.clickItem(getAdapterPosition(), v);
            YoYo.with(Techniques.Wave).duration(100).playOn(v);
        }

        @Override
        public boolean onLongClick(View v) {
            return false;
        }
    }

}
