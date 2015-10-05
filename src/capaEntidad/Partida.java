package capaEntidad;

import java.util.ArrayList;

public class Partida {
	Jugador j_b, j_n;
	ArrayList<Pieza> piezas= new ArrayList<Pieza>();
	public ArrayList<Pieza> getPiezas() {
		return piezas;
	}
	public void setPiezas(ArrayList<Pieza> piezas) {
		this.piezas.addAll(piezas);
	}
	public Jugador getJ_b() {
		return j_b;
	}
	public void setJ_b(Jugador j_b) {
		this.j_b = j_b;
	}
	public Jugador getJ_n() {
		return j_n;
	}
	public void setJ_n(Jugador j_n) {
		this.j_n = j_n;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	String turno;
}

	



