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
import java.net.*;
import java.io.*;

public class ServerProtocol {
  private static final int WAITING = 0;
  private int state = WAITING;

  

  public String processInput(String theInput) {
    String theOutput = null;

    if (state == WAITING) {
      theOutput = "Knock! Knock!";
      }
      return theOutput;
    }
}