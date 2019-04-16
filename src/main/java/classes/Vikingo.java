package classes;

import interfaces.Beber;
import interfaces.Orinar;

public class Vikingo extends Humano {

    private int bebedorProfesional;

    public Vikingo(String nombre, int edad, int peso, Orinar orinar, Beber beber, int bebedorProfesional, int limite) {
        super(nombre, edad, peso, orinar, beber, limite);
        this.bebedorProfesional = bebedorProfesional;
    }


    public int getbebedorProfesional() {
        return bebedorProfesional;
    }

    public void setbebedorProfesional(int bebedorProfesional) {
        this.bebedorProfesional = bebedorProfesional;
    }

    @Override
    public String toString() {
        return super.toString()+"Vikingo{" +
                "bebedorProfesional=" + bebedorProfesional +
                '}';
    }
}
