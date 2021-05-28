package Escenario;

import Guerreros.Guerrero;

import java.util.ArrayDeque;
import java.util.Queue;

public class PuebloAliado extends Pueblo {

    protected Queue<Guerrero> heridos;

    public PuebloAliado(int cantidad, Guerrero raza) {
        super(cantidad, raza);
        heridos = new ArrayDeque<>();
    }


}

