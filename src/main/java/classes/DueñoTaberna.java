package classes;

import interfaces.Beber;
import interfaces.Orinar;

public class DueñoTaberna extends Humano{
    private int bebedorProfesional;
    private int toleranciaExtra;

    public DueñoTaberna(String nombre, int edad, int peso, Orinar orinar, Beber beber, int limite, int bebedorProfesional, int toleranciaExtra) {
        super(nombre, edad, peso, orinar, beber, limite);
        this.bebedorProfesional = bebedorProfesional;
        this.toleranciaExtra = toleranciaExtra;
    }

    public int getBebedorProfesional() {
        return bebedorProfesional;
    }

    public void setBebedorProfesional(int bebedorProfesional) {
        this.bebedorProfesional = bebedorProfesional;
    }

    public int getToleranciaExtra() {
        return toleranciaExtra;
    }

    public void setToleranciaExtra(int toleranciaExtra) {
        this.toleranciaExtra = toleranciaExtra;
    }

    @Override
    public String toString() {
        return super.toString()+"DueñoTaberna{" +
                "bebedorProfesional=" + bebedorProfesional +
                ", toleranciaExtra=" + toleranciaExtra +
                '}';
    }
}
