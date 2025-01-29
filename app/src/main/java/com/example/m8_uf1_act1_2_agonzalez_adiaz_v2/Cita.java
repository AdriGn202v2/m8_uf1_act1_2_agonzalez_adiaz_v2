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

    public int getId() { return id; }
    public String getNotari() { return notari; }
    public String getSala() { return sala; }
    public String getDia() { return dia; }
    public String getHora() { return hora; }
    public String getDescripcio() { return descripcio; }
}
