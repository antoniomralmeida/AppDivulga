package br.com.appdivulga.dominio;

import java.io.Serializable;

/**
 * Created by jardel on 24/06/2017.
 */

public class Evento implements Serializable {

    private long id;
    private String titulo;
    private String ementa;
    private Area area;
    private String data;
    private String hora;
    private String horaFinal;
    private int vagas;
    private Campus campus;
    private Local local;
    private Tipo tipo;
    private String status;
    private Usuario usuario;


    public Evento(long id, String titulo, String ementa, Area area, String data, String hora, String horaFinal, int vagas, Campus campus, Local local, Tipo tipo, String status, Usuario usuario) {
        this.id = id;
        this.titulo = titulo;
        this.ementa = ementa;
        this.area = area;
        this.data = data;
        this.hora = hora;
        this.horaFinal = horaFinal;
        this.vagas = vagas;
        this.campus = campus;
        this.local = local;
        this.tipo = tipo;
        this.status = status;
        this.usuario = usuario;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", ementa='" + ementa + '\'' +
                ", area=" + area +
                ", data='" + data + '\'' +
                ", hora='" + hora + '\'' +
                ", horaFinal='" + horaFinal + '\'' +
                ", vagas=" + vagas +
                ", campus=" + campus +
                ", local=" + local +
                ", tipo=" + tipo +
                ", status='" + status + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
