package com.example.m8_uf1_act1_2_agonzalez_adiaz_v2;

public class Cita {
    private int id;
    private String notari;
    private String sala;
    private String dia;
    private String hora;
    private String descripcio;

    public Cita(String notari, String sala, String dia, String hora, String descripcio) {
        this.notari = notari;
        this.sala = sala;
        this.dia = dia;
        this.hora = hora;
        this.descripcio = descripcio;
    }

    public int getId() {
        return id;
    }

    /* public int getId() { return id; }
     public String getNotari() { return notari; }
     public String getSala() { return sala; }
     public String getDia() { return dia; }
     public String getHora() { return hora; }
     public String getDescripcio() { return descripcio; }
 }*/
// Getters y setters necesarios para Retrofit
    public String getNotari() {
        return notari;
    }

    public void setNotari(String notari) {
        this.notari = notari;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
}