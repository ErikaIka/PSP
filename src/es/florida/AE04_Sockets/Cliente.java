package es.florida.AE04_Sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		String host = "localhost";
		int puerto = 1234;		
		String nombreCliente = "CLIENTE";
		String nombreUsuario = "Erika";

		Thread.sleep(2000);
		System.out.println(nombreCliente + " -> Arranca cliente");
		Socket socket = new Socket(host,puerto);
		Thread.sleep(1000);
		System.out.println(nombreCliente + " -> Conectado al servidor");		

		//Recibe el objeto
		ObjectInputStream inObjeto = new ObjectInputStream(socket.getInputStream());
		Password password = (Password) inObjeto.readObject();
		System.out.print(nombreCliente + " -> Objeto recibido :)\n");
		
		//Introducir contraseña
		Thread.sleep(2000);
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce la contraseña que deseas: ");
		String pass = teclado.nextLine();
		
		//Actualizamos valor de la contraseña
		password.setContTextoPlano(pass);
		System.out.println(nombreCliente + " -> Contraseña recibida");

		//Enviamos el objeto
		System.out.println(nombreCliente + " -> Enviando datos... ");
		Thread.sleep(2000);
		ObjectOutputStream outObjeto = new ObjectOutputStream(socket.getOutputStream());
		outObjeto.writeObject(password);
		System.out.println(nombreCliente + " -> Objeto enviado.");
		
		//Recibimos nuevamente el objeto y mostramos datos
		System.out.println(nombreCliente + " -> Preparado canal para recibir el objeto");
		Thread.sleep(1000);
		inObjeto = new ObjectInputStream(socket.getInputStream());
		password = (Password) inObjeto.readObject();
		System.out.println(nombreCliente + " -> Objeto recibido, vamos a mostrar tus datos, " + nombreUsuario);
		Thread.sleep(1500);
		System.out.println(nombreCliente + " -> " + nombreUsuario + ", tu contraseña original es: " + password.getContTextoPlano());
		System.out.println(nombreCliente + " -> " + nombreUsuario + ", tu contraseña encriptada es:" + password.getContEncriptada());
		
		inObjeto.close();
		outObjeto.close();
		teclado.close();
		socket.close();
	}
	


}
