package es.florida.AE04_Sockets;

//Sustituir cada car�cter del string de contrase�a en texto plano por el car�cter ASCII 
//inmediatamente posterior de la tabla ASCII. Si el car�cter sustituto fuera un car�cter ASCII no 
//imprimible, utiliza el car�cter asterisco (*) en su lugar.

public class Encriptar {

	//Al pasar los car�cteres de char a int, el sistema los pasa a c�digo Ascii, para mostrar el posterior, sumamos 1.
	public static String encriptar (String contrasenya){
		// TODO Auto-generated method stub

		char[] caracteres = contrasenya.toCharArray();
		String contrEncriptada = "";
		
		for(char caracter : caracteres) {
			
			int numAscii = (int) caracter;
			numAscii++;
			
			if(numAscii >= 32 && numAscii <= 126) {
				caracter = (char) numAscii;
				contrEncriptada += caracter;
			} else {
				contrEncriptada += "*";
			}
		}
		return contrEncriptada;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println(encriptar("lo7se3�"));
	}
}
