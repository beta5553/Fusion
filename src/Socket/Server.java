/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Socket;

/**
 *
 * @author Archestra
 */
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.DefaultListModel;

/**
 * Servidor de chat.
 * Acepta conexiones de clientes, crea un hilo para atenderlos, y espera la
 * siguiente conexion.
 * @author Chuidiang
 *
 */
import java.net.*;
import java.io.*;

public class Server {
    public static void EjecutaServer() throws IOException {
        ServerSocket serverSocket = null;
        boolean listening = true;

        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("No se pudo escuchar en el puerto: 4444.");
            //System.exit(-1);
        }

        while (listening)
	    new ServerThread(serverSocket.accept()).start();

        serverSocket.close();
    }
}