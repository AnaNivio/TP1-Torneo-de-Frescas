package classes;

import interfaces.Beber;
import interfaces.Orinar;

public class Espartano extends Humano {

    private int toleranciaExtra;

    public Espartano(String nombre, int edad, int peso, Orinar orinar, Beber beber, int toleranciaExtra, int limite) {
        super(nombre, edad, peso, orinar, beber, limite);
        this.toleranciaExtra = toleranciaExtra;
    }

    public int gettoleranciaExtra() {
        return toleranciaExtra;
    }

    public void settoleranciaExtra(int toleranciaExtra) {
        this.toleranciaExtra = toleranciaExtra;
    }

    @Override
    public String toString() {
        return super.toString()+"Espartano{" +
                "toleranciaExtra=" + toleranciaExtra +
                '}';
    }
}
