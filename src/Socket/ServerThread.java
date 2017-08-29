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
import java.net.Socket;
/**
 *
 * @author Archestra
 */
import java.net.*;
import java.io.*;

public class ServerThread extends Thread {
    private Socket socket = null;

    public ServerThread(Socket socket) {
	super("ServerThread");
	this.socket = socket;
    }

    public void run() {
	try {
	    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	    BufferedReader in = new BufferedReader(
				    new InputStreamReader(
				    socket.getInputStream()));

	   String inputLine, outputLine;
	
            outputLine = null;
	    out.println(outputLine);
	  
	     while ((inputLine = in.readLine()) != null) {
		outputLine =  fusion.Conexion.gPLC[0]+","+fusion.Conexion.gPLC[1]+","+fusion.Conexion.gPLC[2]+","+fusion.Conexion.gPLC[3]+","+fusion.Conexion.gPLC[4];// kkp.processInput(inputLine);
		out.println(outputLine);
		if (outputLine.equals("Bye"))
		    break;
	    }
	    out.close();
	    in.close();
	    socket.close();

	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}