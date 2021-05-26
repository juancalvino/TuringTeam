package Escenario;

import Guerreros.*;

import java.util.Stack;

public class PuebloPropio extends PuebloAliado {

    private Stack<PuebloAliado> aliados;

    public PuebloPropio(int cantidad, Guerrero raza) {
        super(cantidad, raza);
    }

}
