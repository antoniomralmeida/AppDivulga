package br.com.appdivulga.dominio;

import java.io.Serializable;

/**
 * Created by jardel on 24/06/2017.
 */

public class Tipo implements Serializable {

    private long id;
    private String tipo;


    public Tipo(long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Tipo(String tipo) {
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tipo)) return false;

        Tipo tipo1 = (Tipo) o;

        if (getId() != tipo1.getId()) return false;
        return getTipo() != null ? getTipo().equals(tipo1.getTipo()) : tipo1.getTipo() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getTipo() != null ? getTipo().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
