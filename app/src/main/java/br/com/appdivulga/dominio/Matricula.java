package br.com.appdivulga.dominio;

import java.io.Serializable;

/**
 * Created by jardel on 24/06/2017.
 */

public class Matricula implements Serializable {
    private long id;
    private String matricula;


    public Matricula(long id, String matricula) {
        this.id = id;
        this.matricula = matricula;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matricula)) return false;

        Matricula matricula1 = (Matricula) o;

        if (getId() != matricula1.getId()) return false;
        return getMatricula() != null ? getMatricula().equals(matricula1.getMatricula()) : matricula1.getMatricula() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getMatricula() != null ? getMatricula().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "id=" + id +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
