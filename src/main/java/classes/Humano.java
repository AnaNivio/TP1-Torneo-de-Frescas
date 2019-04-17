package classes;
/*-Decidi agregar la variable int limite porque me parece justo que haya una variable la cual se vea afectada
* por tolerancia(espartano) y bebedor profesional(vikingo)
* En el caso de Vikingo,  se le sumara al limite establecido la cantidad de anios por dos que es bebedor.
* En el caso de Espartano, se le sumata al limite establecido la tolerancia que tiene
**/

import interfaces.Beber;
import interfaces.Orinar;

public class Humano {
    private String nombre;
    private int edad;
    private int peso;
    private Orinar orinar;
    private Beber beber;
    private int limite;//limite va a cumplir la funcion de indicarnos el limite del espartano/vikingo. Esta variable es constante ya que el limite no se puede mmodificar; siempre va a ser el mismo
    private int bebidaEnCuerpo;//esta variable sera la encargada de mostrarnos la bebida en cuerpo



    public Humano(){

    }

    public Humano(String nombre, int edad, int peso, Orinar orinar, Beber beber, int limite) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.orinar = orinar;
        this.beber = beber;
        this.limite=limite;
        this.bebidaEnCuerpo=0;//lo pongo en cero ya que al principio no tomo nada
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

    public int getBebidaEnCuerpo() {
        return bebidaEnCuerpo;
    }

    public void setBebidaEnCuerpo(int bebidaEnCuerpo) {
        this.bebidaEnCuerpo = bebidaEnCuerpo;
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
