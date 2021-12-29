package es.florida.AE04_Sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Servidor_Hilos implements Runnable {

	Socket socket;
	
	public Servidor_Hilos(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			
			//Creamos y enviamos el objeto
			Thread.sleep(1000);
			System.err.println("SERVIDOR Hilo " + Thread.currentThread().getName() + " -> Enviamos el objeto...");
			Thread.sleep(2000);
			Password password = new Password("","");
			ObjectOutputStream outObjeto = new ObjectOutputStream(socket.getOutputStream());
			outObjeto.writeObject(password);
			System.err.println("SERVIDOR Hilo " + Thread.currentThread().getName() + " -> Envío correctamente el objeto");
			
			//Recibimos el objeto
			ObjectInputStream inObjeto = new ObjectInputStream(socket.getInputStream());
			password = (Password) inObjeto.readObject();
			System.err.println("SERVIDOR Hilo " + Thread.currentThread().getName() + " -> Objeto recibido correctamente");
			Thread.sleep(1000);
			
			//Encriptamos la contraseña
			System.err.println("SERVIDOR Hilo " + Thread.currentThread().getName() + " -> Encriptando...");
			Thread.sleep(3000);
			Encriptar encriptando = new Encriptar();
			String contrasEncriptada = encriptando.encriptar(password.getContTextoPlano());
			password.setContEncriptada(contrasEncriptada);
			System.err.println("SERVIDOR Hilo " + Thread.currentThread().getName() + " -> Tachaaaan! Contraseña encriptada");

			//Enviamos el objeto actualizado
			Thread.sleep(1000);
			System.err.println("SERVIDOR Hilo " + Thread.currentThread().getName() + " -> Enviando objeto...");
			Thread.sleep(2000);
			outObjeto = new ObjectOutputStream(socket.getOutputStream());
			outObjeto.writeObject(password);
			System.err.println("SERVIDOR Hilo " + Thread.currentThread().getName() + " -> Objeto enviado correctamente");

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			System.err.println("SERVIDOR Hilo: " + Thread.currentThread().getName() + " -> Error");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("SERVIDOR Hilo: " + Thread.currentThread().getName() + " -> Error 'ClassNotFound'");
		}
	}
}
