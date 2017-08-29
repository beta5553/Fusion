/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fusion;

import java.sql.Array;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Rafelleal
 * @author netoklak
 */
public class Conexion {

    public String NombreUsuario;
    public int Acceso;
    public static String AleacionSelect;
    public static int TamanioSelect;
    public static int IdBtn;
    public Float PesoTotalArana;
    //---------------------------------SQl
    private static String Servidor = "Archestra";
    private static String Bd = "Access";
    private static String Usuario = "sa";
    private static String Contrasena = "fimex.kss.0";
    private static Connection cn;
    private static Statement st = null;
    private static ResultSet rs = null;
    private static int Statement; // para ExecuteUpdate
    //private static IMF Imf = new IMF();
    ImageIcon MoldeNormal = new ImageIcon(getClass().getResource("Molde.png"));
    ImageIcon MoldeActivo = new ImageIcon(getClass().getResource("Molde2.png"));
    Vector VectorBotones = new Vector();
    Vector VectorBotones2 = new Vector();
    Vector VectorNombreUsuarios = new Vector();
    public static int gPLC[] = new int[10];
      public static String[] MES_POS= new String[128];

    public static Connection Conectar() {
        try {
            System.out.println("Entro");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://" + Servidor + ":1433;DatabaseName=" + Bd + ";user=" + Usuario + ";Password=" + Contrasena;
            cn = DriverManager.getConnection(connectionUrl);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
            
            JOptionPane.showConfirmDialog(null,"Verifique su conexion");
        };
        if (cn != null) {
            System.out.println("Conexion Exitosa SQL");
        }
        return cn;
    }

    public static void LeerDatos(String Consulta, int Idbtn, String bdpos, int bdLinea) {
        if (cn == null) {
            Conectar();
        }
        try {
            String Aleacion = ValidarAleacion();
            int Tamanio = ValidarTamanio();
            st = cn.createStatement();
            rs = st.executeQuery(Consulta);
            while (rs.next()) {
//                System.out.println("Id: " + rs.getInt(1));
//                System.out.println("Identificador: " + rs.getString(2));
//                System.out.println("Descripcion: " + rs.getString(3));
//                System.out.println("PesoCasting: " + rs.getFloat(4));
//                System.out.println("PesoArana: " + rs.getFloat(5));
//                System.out.println("Aleacion: " + rs.getString(6));
//                System.out.println("Tamaño: " + rs.getInt(7));
                
                System.out.println("Aleacion Select "+AleacionSelect + Aleacion);
                Boolean validar = false;
                if (Aleacion.matches("1E627|WCB|A-27|LCC") && AleacionSelect.matches("1E627|WCB|A-27|LCC")) {
                    validar = true;
                } else if (Aleacion.matches("1E1074|1E1123") && AleacionSelect.matches("1E1074|1E1123")) {
                    validar = true;
                } else if (Aleacion.matches("A487|8320") && AleacionSelect.matches("A487|8320")) {
                    validar = true;
                } else if (Aleacion.matches("CF3M|CF8M") && AleacionSelect.matches("CF3M|CF8M")) {
                    validar = true;
                } else if (Aleacion.equals(AleacionSelect) || Aleacion.equals("")) {
                    validar = true;
                }
                if (validar) {
                    System.out.println("El Tamaño: " + (Tamanio));
                    if ((Tamanio + TamanioSelect) <= 4) {
                        System.out.println("Entro despuesde tamaño");
                        AgregarDatos(Idbtn, rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getFloat(5), rs.getString(6), rs.getInt(7), bdpos, bdLinea,rs.getInt(8),0);
                    } else {
                        JOptionPane.showMessageDialog(null, "El tamaño excede");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Aleacion no compatible");
                }
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
        }
    }

    public static void AgregarDatos(int Idbtn, int Id, String Identificador, String Descripcion, Float PesoCasting, Float PesoArana, String Aleacion, int Tamano, String Posicion, int Linea,int TEnfriado,int Vaciado) {
        System.out.println("Entro a Agregar datos");
        String Consulta = "insert into Imf values(" + Idbtn + "," + Id + ",'" + Identificador + "','" + Descripcion + "'," + PesoCasting + "," + PesoArana + ",'" + Aleacion + "','" + Tamano + "','" + Posicion + "'," + Linea + ","+TEnfriado+ ","+ Vaciado+");";
        try {
            //  st =cn.createStatement();
            Statement = st.executeUpdate(Consulta);
            st.close();
            rs.close();
            EliminarEquipo("delete from Access.dbo.Inventario where Id=" + Id + ";");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    private DefaultTableModel m;

    public static Boolean EliminarEquipo(String Consulta) {
        Conectar();
        try {
            st = cn.createStatement();
            Statement = st.executeUpdate(Consulta);
            st.close();
            rs.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public DefaultTableModel VerModelos(int IdBtn) {
        String Titulos[] = {"Id", "Identificador", "Descripcion", "Peso Casting", "peso Araña", "Aleacion", "Tamaño", "Posicion", "Linea","T. Enfriado","Vaciado"};
        String Fila[] = new String[11];
        String Consulta = "Select * from Access.dbo.Imf where IdBtn=" + IdBtn + ";";
        m = new DefaultTableModel(null, Titulos);
        Conectar();
        try {
            st = cn.createStatement();
            rs = st.executeQuery(Consulta);
            while (rs.next()) {
                Fila[0] = rs.getString(2);
                Fila[1] = rs.getString(3);
                Fila[2] = rs.getString(4);
                Fila[3] = rs.getString(5);
                Fila[4] = rs.getString(6);
                Fila[5] = rs.getString(7);
                Fila[6] = rs.getString(8);
                Fila[7] = rs.getString(9);
                Fila[8] = rs.getString(10);
                Fila[9] = rs.getString(11);
                Fila[10] = rs.getString(12);
                m.addRow(Fila);
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return m;
    }

    public DefaultTableModel VerModelosEnInventario(String Nombre) {
        String Titulos[] = {"ID", "Identificador", "Descripcion", "Peso Casting", "peso Araña", "Aleacion", "Tamaño","T. Enfriado"};
        String Fila[] = new String[8];
        String Consulta = "Select * from Access.dbo.Inventario where Identificador Like ?;";

        m = new DefaultTableModel(null, Titulos);
        Conectar();
        try {
            PreparedStatement query = cn.prepareStatement(Consulta);
            query.setString(1, Nombre);
            rs = query.executeQuery();
            while (rs.next()) {
                Fila[0] = rs.getString(1);
                Fila[1] = rs.getString(2);
                Fila[2] = rs.getString(3);
                Fila[3] = rs.getString(4);
                Fila[4] = rs.getString(5);
                Fila[5] = rs.getString(6);
                Fila[6] = rs.getString(7);
                Fila[7] = rs.getString(8);
                m.addRow(Fila);
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return m;
    }

    public DefaultTableModel VerTodosLosModelos(String Nombre, int NumSem, int NumAnio) {
        String Titulos[] = {"ID", "Identificador", "Descripcion", "Peso Casting", "peso Araña", "Aleacion", "Cantidad", "T.Enfriamiento"};
        String Fila[] = new String[8];
     //   String Consulta = "Select Id,Identificador,Descripcion,PesoCasting,PesoArana,Aleacion,Cantidad,TEnfriamiento from Access.dbo.Pdp_acero where Identificador like ? and semana =? and Anio=? and Cantidad>0;";
       String Consulta = "Select Id,Identificador,Descripcion,PesoCasting,PesoArana,Aleacion,Cantidad,TEnfriamiento from Access.dbo.Pdp_acero where Identificador like ? ;";
        m = new DefaultTableModel(null, Titulos);
        Conectar();
        try {
            PreparedStatement query = cn.prepareStatement(Consulta);
            query.setString(1, Nombre);
          //  query.setInt(2, NumSem);
          //  query.setInt(3, NumAnio);
            rs = query.executeQuery();
            while (rs.next()) {
                Fila[0] = rs.getString(1);
                Fila[1] = rs.getString(2);
                Fila[2] = rs.getString(3);
                Fila[3] = rs.getString(4);
                Fila[4] = rs.getString(5);
                Fila[5] = rs.getString(6);
                Fila[6] = rs.getString(7);
                Fila[7] = rs.getString(8);
                m.addRow(Fila);
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return m;
    }

    public boolean UpdateTabla(String Consulta) {
        if (cn == null) {
            Conectar();
        }
        try {
            st = cn.createStatement();
            Statement = st.executeUpdate(Consulta);
            st.close();
            rs.close();
            //JOptionPane.showMessageDialog(null,"Se Actualizo Con Exito");
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            // JOptionPane.showMessageDialog(null,"No se pudo Actualizar");
            return false;
        }
    }

    public String PesoArania(String Aleacion, int vaciado) {
        String Peso = null;
        if (cn == null) {
            Conectar();
        }
        try {
            st = cn.createStatement();
            rs = st.executeQuery("Select Sum(PesoArana) From Access.dbo.Imf where Vaciado="+vaciado+" and  Aleacion ='" + Aleacion + "';");
            while (rs.next()) {
                Peso = rs.getString(1);
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
        }
        return Peso;
    }

    public void LeerAleacion(String Consulta, int tipo) {
        if (cn == null) {
            Conectar();
        }
        if (tipo == 1) {
            VectorBotones.clear();
        } else if (tipo == 2) {
            VectorBotones2.clear();
        }
        try {
            st = cn.createStatement();
            rs = st.executeQuery(Consulta);
            int x = 0;
            while (rs.next()) {
                if (tipo == 1) {
                    VectorBotones.add(rs.getString(1));
                } else if (tipo == 2) {
                    VectorBotones2.add(rs.getString(1));
                }
                x++;
            }
            rs = st.executeQuery("Select Sum(PesoArana) From Access.dbo.Imf where Vaciado=0 and Aleacion ='" + AleacionSelect + "';");
            while (rs.next()) {
                PesoTotalArana = rs.getFloat(1);
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
        }
    }

    public static String ValidarAleacion() {
        String x = "";
        try {
            st = cn.createStatement();
            rs = st.executeQuery("Select TOP 1 Aleacion From Access.dbo.Imf where IdBtn =" + IdBtn );
            while (rs.next()) {
                x = rs.getString(1);
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return x;
    }

    public static int ValidarTamanio() {
        int x = 0;
        try {
            st = cn.createStatement();
            rs = st.executeQuery("Select Sum(Tamano) From Access.dbo.Imf where IdBtn =" + IdBtn );
            while (rs.next()) {
                x = rs.getInt(1);
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
        }
        return x;
    }

    public static Boolean ValidarPosicion(String Pos) {
        Boolean Encontro = false;
        try {
            st = cn.createStatement();
            rs = st.executeQuery("Select Posicion From Access.dbo.Imf group by Posicion");
            while (rs.next() && Encontro == false) {
              //  System.out.println("Entro antes Ocupado: " + rs.getString(1));
                if (Pos.equals(rs.getString(1))) {
                    Encontro = true;
                }
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
        }
        return Encontro;
    }

    public static ArrayList<String> MoverTarimas(int Linea) {
        ArrayList<String> IdBtnArray = new ArrayList<String>();
        Conectar();
        IdBtnArray.clear();
        try {
            st = cn.createStatement();
            rs = st.executeQuery("Select IdBtn from Access.dbo.IMf Where Linea=" + Linea + " Group by IdBtn");
            while (rs.next()) {
                System.out.println("Entro IdBtn: " + rs.getString(1));
                IdBtnArray.add(rs.getString(1));
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return IdBtnArray;
    }
  public void QuerymoldesVaciados(){
       if (cn == null) {
            Conectar();
        }
        try {
            st = cn.createStatement();
            rs = st.executeQuery("Select IdBtn From Access.dbo.Imf where Vaciado=1 group by Idbtn");
            while (rs.next()) {
                ;
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
        }
        
    }

    public void QueryRestablecerMoldes() throws SQLException {
        if (cn == null || cn.isClosed()==true ) {
            Conectar();
        }
        try {
            st = cn.createStatement();
            rs = st.executeQuery("Select IdBtn,Posicion From Access.dbo.Imf;");
            while (rs.next()) {
                IMF.Restablecermoldes(rs.getString(1), rs.getString(2));
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
        }
    }
//--------------------Query's Usuarios------------------------------

    public static void AgregaUsuario(String Nombre, String Usuario, String Contrasenia, int Acceso) {
        if (cn == null) {
            Conectar();
        }
        String Consulta = "insert into fusionUsuarios(Nombre,Usuario,Contrasena,Acceso) values('" + Nombre + "','" + Usuario + "','" + Contrasenia + "'," + Acceso + ");";
        try {
            st = cn.createStatement();
            Statement = st.executeUpdate(Consulta);
            JOptionPane.showMessageDialog(null, "El usuario : " + Nombre + " Se agrego correctamente.");
            st.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar Usuario : " + Nombre);
            System.out.println(ex);
        }
    }

    public static void EliminarUsuario(String Consulta) {
        Conectar();
        try {
            st = cn.createStatement();
            Statement = st.executeUpdate(Consulta);
            st.close();
            rs.close();
            JOptionPane.showMessageDialog(null, "Se Elimino Con Exito");

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "No se pudo Eliminar");
        }
    }

    public boolean QueryLogin(String Usuario, String Contrasenia) {
        Boolean Validar = false;
        if (cn == null) {
            Conectar();
        }
        try {
            st = cn.createStatement();
            PreparedStatement query = cn.prepareStatement("Select Nombre,Acceso From Access.dbo.FusionUsuarios where Usuario =? And Contrasena =? ;");
            query.setString(1, Usuario);
            query.setString(2, Contrasenia);
            rs = query.executeQuery();
            if (rs.next()) {
                NombreUsuario = rs.getString(1);
                Acceso = rs.getInt(2);
                IMF Principal = new IMF();
                Principal.setBounds(0, 0, 1440, 900);
                Principal.setVisible(true);
                fusion.IMF.CurrentUser.setText(NombreUsuario);
                fusion.IMF.LblCurrentAccess.setText(String.valueOf(Acceso));
                Validar = true;
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
        }
        return Validar;
    }

    public void LeerNombreUsuarios(String Consulta) {
        if (cn == null) {
            Conectar();
        }
        try {
            st = cn.createStatement();
            rs = st.executeQuery(Consulta);
            VectorNombreUsuarios.clear();
            while (rs.next()) {
                VectorNombreUsuarios.add(rs.getString(1));
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
        }
    }

    public Boolean QueryDesmoldeo(int IdBtn) {
        if (cn == null) {
            Conectar();
        }
        try {
            String Consulta = "INSERT INTO Access.dbo.MoldesGk (Identificador,Descripcion,PesoCasting,PesoArana,Aleacion,Tamano,Dia,Hora,comentario)";
            Consulta += "SELECT  Identificador,Descripcion,PesoCasting,PesoArana,Aleacion,Tamano,GETDATE(),GETDATE(),'Desmoldeo Normal' ";
            Consulta += "FROM  Access.dbo.IMF   WHERE  Idbtn=" + IdBtn;
            if (IdBtn == 0) {
                Consulta = "INSERT INTO Access.dbo.MoldesGk (Identificador,Descripcion,PesoCasting,PesoArana,Aleacion,Tamano,Dia,Hora)values('tarima vacia','tarima vacia',0,0,'N/A','0',GETDATE(),GETDATE())";
            }
            st = cn.createStatement();
            Statement = st.executeUpdate(Consulta);
            st.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return EliminarEquipo("delete from Access.dbo.Imf where IdBtn='" + IdBtn + "';");
    }
     public Boolean QueryDesmoldeoManual(String Id) {
        if (cn == null) {
            Conectar();        }
        try {
            String Consulta = "INSERT INTO Access.dbo.MoldesGk (Identificador,Descripcion,PesoCasting,PesoArana,Aleacion,Tamano,Dia,Hora,comentario)";
            Consulta += "SELECT  Identificador,Descripcion,PesoCasting,PesoArana,Aleacion,Tamano,GETDATE(),GETDATE(),'Desmoldeo Manual' ";
            Consulta += "FROM  Access.dbo.IMF   WHERE  Id=" + Id;
            st = cn.createStatement();
            Statement = st.executeUpdate(Consulta);
            st.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return EliminarEquipo("delete from Access.dbo.Imf where Id='" + Id + "';");
    }

    public void CargarInventario(int Sem, int Anio) {
        if (cn == null) {
            Conectar();           
        }
        EliminarEquipo("delete from Access.dbo.Inventario;");   
        try {
            st = cn.createStatement();
            rs = st.executeQuery("Select Id,Cantidad from  Access.dbo.Pdp_acero where Semana=" + (Sem) + "and Anio=" + Anio + " and Cantidad>0 order by Identificador ASC ;");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt(1) + "Cantidad" + rs.getInt(2));
                for (int i = 1; i <= rs.getInt(2); i++) {
                    String Consulta = "INSERT INTO Inventario(Identificador,Descripcion,PesoCasting,PesoArana,Aleacion,TEnfriamiento) ";
                    Consulta += "SELECT  Identificador,Descripcion,PesoCasting,PesoArana,Aleacion,TEnfriamiento ";
                    Consulta += "FROM  Access.dbo.Pdp_acero  Where  Id=" + rs.getInt(1) + ";";
                    st = cn.createStatement();
                    Statement = st.executeUpdate(Consulta);
                    
                }
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void InsertEnInventario(int Id) {
        if (cn == null) {
            Conectar();
        }
        try {
            String Consulta = "INSERT INTO Inventario(Identificador,Descripcion,PesoCasting,PesoArana,Aleacion,TEnfriamiento) ";
            Consulta += "SELECT  Identificador,Descripcion,PesoCasting,PesoArana,Aleacion,TEnfriamiento ";
            Consulta += "FROM  Access.dbo.Pdp_acero  Where  Id=" + Id + ";";
            st = cn.createStatement();
            Statement = st.executeUpdate(Consulta);
            st.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void InsertEnDesperdicios(String Id,String Comentario) {
        if (cn == null) {
            Conectar();
        }
        try {
            String Consulta = "INSERT INTO Desperdicio(Identificador,Descripcion,PesoCasting,PesoArana,Aleacion,Tamano,Dia,Hora,Comentario) ";
            Consulta += "SELECT Identificador,Descripcion,PesoCasting,PesoArana,Aleacion,Tamano,GETDATE(),GETDATE(),'"+Comentario+"'  ";
            Consulta += "FROM  Access.dbo.Imf  Where  Id=" + Id + ";";
            st = cn.createStatement();
            Statement = st.executeUpdate(Consulta);
            st.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //--------Select para traer Datos de runtime------
    public void select() throws SQLException {
        if (cn.isClosed() == true || cn == null) {
            Conectar();
        }
        try {
            st = cn.createStatement();
            //  rs = st.executeUpdate("");
            rs = st.executeQuery("SELECT Value"
                    + " FROM Runtime.dbo.v_AnalogLive"
                    + " WHERE v_AnalogLive.TagName IN ('DatosJava.LineaCarro1', 'DatosJava.LineaCarro2', 'DatosJava.Pasos_IMF', 'DatosJava.PosC1', 'DatosJava.PosC2')"
                    + " Order by TagName ASC");
            int k = 0;
            while (rs.next()) {
                gPLC[k] = rs.getInt(1);
                //   System.out.println(rs.getInt(1));
                k++;
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            IMF.TimerBajarCarro1.stop();
            JOptionPane.showMessageDialog(null, "Se perdio la conexion reinicie el sistema");
            System.exit(0);
        }
    }
   public void ActualizarDesdePLC(int dato,int numero){  
    
             if (cn == null) {
            Conectar();
        }
             try {
                 String Pos = "0";
                  if (numero <= 21) {
                     Pos = "A" + numero;
                 } else if (numero >= 22 && numero <= 42) {
                     Pos = "B" + (numero - 21);
                 } else if (numero >= 43 && numero <= 63) {
                     Pos = "C" + (numero - 42);
                 } else if (numero >= 64 && numero <= 84) {
                     Pos = "D" + (numero - 63);
                 } else if (numero >= 85 && numero <= 105) {
                     Pos = "E" + (numero - 84);
                 } else if (numero >= 106 && numero <= 126) {
                     Pos = "F" + (numero - 105);
                 } else if (numero == 127) {
                     Pos = "A22";
                 } else if (numero == 128) {
                     Pos = "A0";
                 }
                String Consulta ="Update Access.Dbo.IMF set Posicion=? where Idbtn=?";
                st = cn.createStatement();
                PreparedStatement query = cn.prepareStatement(Consulta);
            query.setString(1, Pos);
            query.setInt(2, dato);
            rs = query.executeQuery();
                 Statement = st.executeUpdate(Consulta);
            st.close();
            rs.close();
         
            } catch (SQLException ex) {
               //System.out.println(ex);    
                          }         
   }
    public int LeerUnInt(String Consulta) {
       int Dato=0;
        if (cn == null) {
            Conectar();
        }
        try {
            st = cn.createStatement();
            rs = st.executeQuery(Consulta);
                while (rs.next()){                                  
                Dato=rs.getInt(1);
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return Dato;
    }

}
