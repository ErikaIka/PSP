package es.florida.AE04_Sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		int puerto = 1234;
		System.err.println("SERVIDOR >> Arranca el servidor, espera petici�n");
		ServerSocket socketEscucha = null;
		
		try {
			socketEscucha = new ServerSocket(puerto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Servidor -> Error");
		}
		
		//Dejamos el servidor a la espera de una entrada
		while(true) {
			Socket conexion = socketEscucha.accept();
			System.err.println("SERVIDOR >> Conexi�n recibida --> Lanza hilo clase Petici�n");
			
			//Instancia de la clase Servidor_Hilos
			Servidor_Hilos h = new Servidor_Hilos(conexion);
			Thread hilo = new Thread(h);
			hilo.start();
		}
	}

}
