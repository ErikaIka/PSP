package es.florida.AE04_Sockets;

import java.io.Serializable;

//Creamos la clase, los constructores, getters, setters.
public class Password implements Serializable {

	String ContTextoPlano;
	String ContEncriptada;
	
	public Password() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Password(String contTextoPlano, String contEncriptada) {
		super();
		ContTextoPlano = contTextoPlano;
		ContEncriptada = contEncriptada;
	}

	public String getContTextoPlano() {
		return ContTextoPlano;
	}

	public void setContTextoPlano(String contTextoPlano) {
		ContTextoPlano = contTextoPlano;
	}

	public String getContEncriptada() {
		return ContEncriptada;
	}

	public void setContEncriptada(String contEncriptada) {
		ContEncriptada = contEncriptada;
	}

	@Override
	public String toString() {
		return "Password [ContTextoPlano=" + ContTextoPlano + ", ContEncriptada=" + ContEncriptada + "]";
	}

	

}
