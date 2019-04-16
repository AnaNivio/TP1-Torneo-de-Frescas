package classes;
/*-Decidi agregar la variable int limite porque me parece justo que haya una variable la cual se vea afectada
* por tolerancia(espartano) y bebedor profesional(vikingo)
* En el caso de Vikingo, a la hora de crearse, se le atribuira, ademas del limite establecido por lo ingresado en el new,
* la cantidad de anios por dos que es bebedor.
* En el caso de Espartano, a la hora de beber, en caso que su limite llegue a 0, se le atribuira la cantidad
* establecida por la tolerancia extra.
*
* De esta forma, por cada vuelta (es decir, por cada bebida por ambos) se le ira restando su limite*/

import interfaces.Beber;
import interfaces.Orinar;

public class Humano {
    private String nombre;
    private int edad;
    private int peso;
    private Orinar orinar;
    private Beber beber;
    private int limite;

    public Humano(String nombre, int edad, int peso, Orinar orinar, Beber beber, int limite) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.orinar = orinar;
        this.beber = beber;
        this.limite=limite;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void orinar() {

        (this.orinar).orinar();
    }

    public void beber() {

        (this.beber).beber();
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = peso;
    }

    @Override
    public String toString() {
        return "Humano{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", orinar=" + orinar +
                ", beber=" + beber +
                '}';
    }

}
