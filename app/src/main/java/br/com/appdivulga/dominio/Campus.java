package br.com.appdivulga.dominio;

import java.io.Serializable;

/**
 * Created by jardel on 24/06/2017.
 */

public class Campus implements Serializable {

    private long id;
    private String campus;
    private String endereco;
    private Local local;

    public Campus(long id, String campus, String endereco, Local local) {
        this.id = id;
        this.campus = campus;
        this.endereco = endereco;
        this.local = local;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Campus)) return false;

        Campus campus1 = (Campus) o;

        if (getId() != campus1.getId()) return false;
        if (getCampus() != null ? !getCampus().equals(campus1.getCampus()) : campus1.getCampus() != null)
            return false;
        if (getEndereco() != null ? !getEndereco().equals(campus1.getEndereco()) : campus1.getEndereco() != null)
            return false;
        return getLocal() != null ? getLocal().equals(campus1.getLocal()) : campus1.getLocal() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getCampus() != null ? getCampus().hashCode() : 0);
        result = 31 * result + (getEndereco() != null ? getEndereco().hashCode() : 0);
        result = 31 * result + (getLocal() != null ? getLocal().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Campus{" +
                "id=" + id +
                ", campus='" + campus + '\'' +
                ", endereco='" + endereco + '\'' +
                ", local=" + local +
                '}';
    }
}
