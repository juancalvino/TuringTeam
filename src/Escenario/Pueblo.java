package Escenario;

import Guerreros.*;

public abstract class Pueblo {
    private final Guerrero raza;
    private int cantidad;

    public Pueblo(int cantidad, Guerrero raza) {
        this.cantidad = cantidad;
        this.raza = raza;
    }

    public Guerrero getRaza() {
        return raza;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void desmayarUno() {
        this.cantidad--;
        if (this.cantidad > 0) {
            getRaza().posicionar();
        }
    }

    public void pelear(Pueblo objetivo) {
        getRaza().atacar(objetivo.getRaza());
    }

    public void devolverDatos() {
        System.out.println("Raza: " + this.getRaza() + ", Cantidad: " + getCantidad());
    }
}
