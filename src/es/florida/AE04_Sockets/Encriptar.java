package es.florida.AE04_Sockets;

//Sustituir cada carácter del string de contraseña en texto plano por el carácter ASCII 
//inmediatamente posterior de la tabla ASCII. Si el carácter sustituto fuera un carácter ASCII no 
//imprimible, utiliza el carácter asterisco (*) en su lugar.

public class Encriptar {

	//Al pasar los carácteres de char a int, el sistema los pasa a código Ascii, para mostrar el posterior, sumamos 1.
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

		
		System.out.println(encriptar("lo7se3é"));
	}
}
