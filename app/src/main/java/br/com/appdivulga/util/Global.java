package br.com.appdivulga.util;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import br.com.appdivulga.dominio.Area;
import br.com.appdivulga.dominio.Campus;
import br.com.appdivulga.dominio.Evento;
import br.com.appdivulga.dominio.Local;
import br.com.appdivulga.dominio.Matricula;
import br.com.appdivulga.dominio.Tipo;
import br.com.appdivulga.dominio.Usuario;

/**
 * Created by jardel on 26/06/2017.
 */

public class Global extends Application {


    public static List<Evento> getEventos() {
        Area area1 = new Area(1, "Todas");
        Area area2 = new Area(2, "Tecnologia");
        Area area3 = new Area(3, "Administraçao");

        Local local1 = new Local(1, "Laboratorio 01", 20);
        Local local2 = new Local(2, "Hall", 200);
        Local local3 = new Local(3, "Auditorio", 80);

        Matricula matricula = new Matricula(1, "201700000000");
        Matricula matricula1 = new Matricula(2, "201600000000");

        Campus campus1 = new Campus(1, "Estacio Parangaba", "Av beira mar 2020, meireles, fortaleza", local1);
        Campus campus2 = new Campus(2, "Estacio Moreira Campos", "rua monsenhor furtado 1134, rodolfo teofilo, fortaleza", local2);
        Campus campus3 = new Campus(3, "Estacio Agua Fria", "Av lineu machado 50, enrique jorge, fortaleza", local3);

        Tipo tipo1 = new Tipo(1, "Festa");
        Tipo tipo2 = new Tipo(2, "Palestra");
        Tipo tipo3 = new Tipo(2, "Oficina");

        Usuario usuario = new Usuario(1, "Jose Ribeiro", "jose@jose.com", "123456", matricula, "8596666-9999", area1);
        Usuario usuario2 = new Usuario(2, "Jose Ribeiro", "jose@jose.com", "123456", matricula1, "8596666-9999", area3);

        Evento evento1 = new Evento(1, "Programaçao para dispositivos moveis", "Desenvolver uma aplicaçao com acesso a web service", area2, "11/05/2016", "11:00", "12:00", 15, campus1, local1, tipo3, "Pendente", usuario);
        Evento evento2 = new Evento(2, "Formatura", "Confeternizaçao dos alunos da estacio", area1, "08/11/2016", "11:00", "22:00", 200, campus3, local2, tipo1, "Recusado", usuario);
        Evento evento3 = new Evento(3, "Adimintraçao para pequenas empresas", "Aborda os principais topicos relacionados com a rotina administrativa das pequenas empresas", area3, "13/08/2021", "20:00", "22:00", 60, campus2, local3, tipo2, "Aprovado", usuario);
        Evento evento4 = new Evento(2, "Formatura", "Confeternizaçao dos alunos da estacio", area1, "08/11/2016", "11:00", "22:00", 200, campus3, local2, tipo1, "Realizado", usuario);

        List<Evento> eventos = new ArrayList<>();
        eventos.add(evento1);
        eventos.add(evento2);
        eventos.add(evento3);
        eventos.add(evento4);
        return eventos;
    }

    public static List<Usuario> getUsuario() {
        List<Usuario> usuarios = new ArrayList<>();
        Area area1 = new Area(1, "Todas");
        Area area2 = new Area(2, "Tecnologia");
        Area area3 = new Area(3, "Administraçao");
        Matricula matricula = new Matricula(1, "201700000000");
        Matricula matricula1 = new Matricula(2, "201600000000");
        Usuario usuario = new Usuario(1, "Jose Ribeiro", "jose@jose.com", "123456", matricula, "8596666-9999", area1);
        Usuario usuario2 = new Usuario(2, "Jose Ribeiro", "jose@jose.com", "123456", matricula1, "8596666-9999", area3);
        usuarios.add(usuario);
        usuarios.add(usuario2);
        return usuarios;
    }

}

