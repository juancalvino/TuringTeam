package Guerreros;


public class Nortaichian extends Guerrero {

	private int turnosEnfurecido;
	private int turnosPiedra;
	
	@Override
	public void posicionar() {
		this.salud = 66;
		this.danioBasico = 18;
	}
	
	public int atacar() {
		this.salud += salud * 0.04;
		return (turnosEnfurecido > 0)
					? super.atacar() *2
					: super.atacar() ;
	}
	
	@Override
	public void atacar(Guerrero enemigo) {
		if(turnosPiedra > 0) {
			--turnosPiedra;
		}
		else {
		enemigo.recibirAtaque(this.atacar());		
		}

		--turnosEnfurecido;
	}

	@Override
	public void recibirAtaque(int ataque) {
		
		turnosEnfurecido = 2;
		
		int ataqueRecibido = ataque;
		
		if(turnosPiedra > 0) {
			ataqueRecibido = ataque / 2;
		}
		
		salud -= ataqueRecibido;
	}
	
	@Override
	public void descansar() {
		this.salud = 66;
		turnosPiedra = 2;
	}





}
