package br.com.appdivulga.dominio;

import java.io.Serializable;

/**
 * Created by jardel on 24/06/2017.
 */

public class Local implements Serializable {

    private long id;
    private String local;
    private int capacidade;

    public Local(long id, String local, int capacidade) {
        this.id = id;
        this.local = local;
        this.capacidade = capacidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Local)) return false;

        Local local1 = (Local) o;

        if (getId() != local1.getId()) return false;
        if (getCapacidade() != local1.getCapacidade()) return false;
        return getLocal() != null ? getLocal().equals(local1.getLocal()) : local1.getLocal() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getLocal() != null ? getLocal().hashCode() : 0);
        result = 31 * result + getCapacidade();
        return result;
    }

    @Override
    public String toString() {
        return "Local{" +
                "id=" + id +
                ", local='" + local +
                ", capacidade=" + capacidade +
                '}';
    }
}
