/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa;



/**
 *
 * @author pablo
 */
public class Barco {
     private int idbarcos, posAmarre, idsocios;
    private String nombre, matricula, nombreSocio;
    private int cuota;

    public Barco() {
    }

    public Barco(int idbarcos) {
        this.idbarcos = idbarcos;
    }

    public Barco(int numAmarre, int idsocios, String nomBarco, String matricula, int cuota) {
        this.posAmarre = numAmarre;
        this.idsocios = idsocios;
        this.nombre = nomBarco;
        this.matricula = matricula;
        this.cuota = cuota;
    }

    public Barco(int idbarcos, int numAmarre, int idsocios, String nombreB, String matricula) {
        this.idbarcos = idbarcos;
        this.posAmarre = numAmarre;
        this.idsocios = idsocios;
        this.nombre = nombreB;
        this.matricula = matricula;
    }

    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }

    public String getNombreSocio() {
        return nombreSocio;
    }

    public int getIdbarcos() {
        return idbarcos;
    }

    public int getNumAmarre() {
        return posAmarre;
    }

    public int getIdsocios() {
        return idsocios;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getCuota() {
        return cuota;
    }

    public void setIdbarcos(int idbarcos) {
        this.idbarcos = idbarcos;
    }

    public void setNumAmarre(int numAmarre) {
        this.posAmarre = numAmarre;
    }

    public void setIdsocios(int idsocios) {
        this.idsocios = idsocios;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

}
