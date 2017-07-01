package br.com.appdivulga.dominio;

import java.io.Serializable;

/**
 * Created by jardel on 24/06/2017.
 */

public class Usuario implements Serializable {

    private long id;
    private String nome;
    private String email;
    private String senha;
    private Matricula matricula;
    private String celular;
    private Area areas;


    public Usuario(long id, String nome, String email, String senha, Matricula matricula, String celular, Area areas) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.matricula = matricula;
        this.celular = celular;
        this.areas = areas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Area getAreas() {
        return areas;
    }

    public void setAreas(Area areas) {
        this.areas = areas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;

        Usuario usuario = (Usuario) o;

        if (getId() != usuario.getId()) return false;
        if (getNome() != null ? !getNome().equals(usuario.getNome()) : usuario.getNome() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(usuario.getEmail()) : usuario.getEmail() != null)
            return false;
        if (getSenha() != null ? !getSenha().equals(usuario.getSenha()) : usuario.getSenha() != null)
            return false;
        if (getMatricula() != null ? !getMatricula().equals(usuario.getMatricula()) : usuario.getMatricula() != null)
            return false;
        if (getCelular() != null ? !getCelular().equals(usuario.getCelular()) : usuario.getCelular() != null)
            return false;
        return getAreas() != null ? getAreas().equals(usuario.getAreas()) : usuario.getAreas() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getSenha() != null ? getSenha().hashCode() : 0);
        result = 31 * result + (getMatricula() != null ? getMatricula().hashCode() : 0);
        result = 31 * result + (getCelular() != null ? getCelular().hashCode() : 0);
        result = 31 * result + (getAreas() != null ? getAreas().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", matricula=" + matricula +
                ", celular='" + celular + '\'' +
                ", areas=" + areas +
                '}';
    }
}


