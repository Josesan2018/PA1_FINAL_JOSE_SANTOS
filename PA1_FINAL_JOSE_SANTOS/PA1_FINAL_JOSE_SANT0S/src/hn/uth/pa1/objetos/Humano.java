/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa1.objetos;

/**
 *
 * @author jose3
 */
public class Humano {
    private int id;
    private String identidad;
    private String nombre;
    private String apellido;
    private double peso;
    private int A_nacimiento;
    private double P_equipaje;

    public Humano(int id, String identidad, String nombre, String apellido, double peso, int A_nacimiento, double P_equipaje) {
        this.id = id;
        this.identidad = identidad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.peso = peso;
        this.A_nacimiento = A_nacimiento;
        this.P_equipaje = P_equipaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getA_nacimiento() {
        return A_nacimiento;
    }

    public void setA_nacimiento(int A_nacimiento) {
        this.A_nacimiento = A_nacimiento;
    }

    public double getP_equipaje() {
        return P_equipaje;
    }

    public void setP_equipaje(double P_equipaje) {
        this.P_equipaje = P_equipaje;
    }

    @Override
    public String toString() {
        return "humano{" + "id=" + id + ", identidad=" + identidad + ", nombre=" + nombre + ", apellido=" + apellido + ", peso=" + peso + ", A_nacimiento=" + A_nacimiento + ", P_equipaje=" + P_equipaje + '}';
    }
    
    
    
}
