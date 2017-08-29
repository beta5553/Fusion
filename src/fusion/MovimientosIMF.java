/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fusion;

import javax.swing.JButton;
import javax.swing.JOptionPane;
/**
 *
 * @author Archestra
 */
public class MovimientosIMF {

    Conexion Cn = new Conexion();
     String  pos = "0";
    private int Linea;
    public  int labelx;
    public int labely;

    public void inicio() {
        
    }

    public void MovIzqDer(JButton Button, int IdBtn) { //Carro1----->Carro2
        Button.setLocation((Button.getLocation().x + 45), Button.getLocation().y + 50);
        AcomodarBtn(Button, Button.getLocation().x, Button.getLocation().y, IdBtn);
    }

    public void MovDerIzq(JButton Button, int IdBtn) {//Carro1<-----Carro2
        Button.setLocation((Button.getLocation().x - 50), Button.getLocation().y + 50);
        AcomodarBtn(Button, Button.getLocation().x, Button.getLocation().y, IdBtn);
    }

    public void AcomodarBtn(JButton button, int x, int y, int IdBtn) {
        labelx = x;
        labely = y;
        int CarroX = IMF.jLblTra003.getLocation().x + 10;
        int CarroY = IMF.jLblTra003.getLocation().y + 16;
        int Carro2X = IMF.jLblTra002.getLocation().x + 7;
        int Carro2Y = IMF.jLblTra002.getLocation().y + 16;
        int a = 48;
        if ((x >= 65 && x <= 115) && (y >= 145 && y <= 200)) {
            pos = "A0";
            IMF.MoldeEnCarro2 = String.valueOf(IdBtn);           
            button.setLocation(CarroX, CarroY);
        } else if ((x >= 115 && x <= 165) && (y >= 145 && y <= 200)) {
            pos = "A1";
            button.setLocation((0 * a) + 165, 117);
        } else if ((x >= 165 && x <= 215) && (y >= 145 && y <= 200)) {
            pos = "A2";
            button.setLocation((1 * a) + 165, 117);
        } else if ((x >= 215 && x <= 265) && (y >= 145 && y <= 200)) {
            pos = "A3";
            button.setLocation((2 * a) + 165, 117);
        } else if ((x >= 265 && x <= 315) && (y >= 145 && y <= 200)) {
            pos = "A4";
            button.setLocation((3 * a) + 165, 117);
        } else if ((x >= 315 && x <= 362) && (y >= 145 && y <= 200)) {
            pos = "A5";
            button.setLocation((4 * a) + 165, 117);
        } else if ((x >= 362 && x <= 409) && (y >= 145 && y <= 200)) {
            pos = "A6";
            button.setLocation((5 * a) + 165, 117);
        } else if ((x >= 410 && x <= 457) && (y >= 145 && y <= 200)) {
            pos = "A7";
            button.setLocation((6 * a) + 163, 117);
        } else if ((x >= 458 && x <= 503) && (y >= 145 && y <= 200)) {
            pos = "A8";
            button.setLocation((7 * a) + 163, 117);
        } else if ((x >= 505 && x <= 551) && (y >= 145 && y <= 200)) {
            pos = "A9";
            button.setLocation((8 * a) + 162, 117);
        } else if ((x >= 552 && x <= 598) && (y >= 145 && y <= 200)) {
            pos = "A10";
            button.setLocation((9 * a) + 162, 117);
        } else if ((x >= 599 && x <= 644) && (y >= 145 && y <= 200)) {
            pos = "A11";
            button.setLocation((10 * a) + 160, 117);
        } else if ((x >= 645 && x <= 692) && (y >= 145 && y <= 200)) {
            pos = "A12";
            button.setLocation((11 * a) + 160, 117);
        } else if ((x >= 693 && x <= 739) && (y >= 145 && y <= 200)) {
            pos = "A13";
            button.setLocation((12 * a) + 159, 117);
        } else if ((x >= 740 && x <= 786) && (y >= 145 && y <= 200)) {
            pos = "A14";
            button.setLocation((13 * a) + 159, 117);
        } else if ((x >= 787 && x <= 834) && (y >= 145 && y <= 200)) {
            pos = "A15";
            button.setLocation((14 * a) + 158, 117);
        } else if ((x >= 835 && x <= 881) && (y >= 145 && y <= 200)) {
            pos = "A16";
            button.setLocation((15 * a) + 158, 117);
        } else if ((x >= 882 && x <= 929) && (y >= 145 && y <= 200)) {
            pos = "A17";
            button.setLocation((16 * a) + 156, 117);
        } else if ((x >= 930 && x <= 977) && (y >= 145 && y <= 200)) {
            pos = "A18";
            button.setLocation((17 * a) + 156, 117);
        } else if ((x >= 978 && x <= 1024) && (y >= 145 && y <= 200)) {
            pos = "A19";
            button.setLocation((18 * a) + 155, 117);
        } else if ((x >= 1025 && x <= 1073) && (y >= 145 && y <= 200)) {
            pos = "A20";
            button.setLocation((19 * a) + 155, 117);
        } else if ((x >= 1075 && x <= 1121) && (y >= 145 && y <= 200)) {
            pos = "A21";
            button.setLocation((20 * a) + 154, 117);
        } else if ((x >= 1122) && (y >= 145 && y <= 200)) {
            pos = "A22";
          IMF.MoldeEnCarro1 = String.valueOf(IdBtn); 
          button.setLocation(Carro2X, Carro2Y);
        }
//------------------------------------Inicio B----------------------------------
        if ((x >= 65 && x <= 115) && (y >= 280 && y <= 335)) {
            pos = "B0";
            IMF.MoldeEnCarro2 = String.valueOf(IdBtn);
            button.setLocation(CarroX, CarroY);
        } else if ((x >= 115 && x <= 165) && (y >= 280 && y <= 335)) {
            pos = "B1";
            button.setLocation((0 * a) + 165, 252);
        } else if ((x >= 165 && x <= 215) && (y >= 280 && y <= 335)) {
            pos = "B2";
            button.setLocation((1 * a) + 165, 252);
        } else if ((x >= 215 && x <= 265) && (y >= 280 && y <= 335)) {
            pos = "B3";
            button.setLocation((2 * a) + 165, 252);
        } else if ((x >= 265 && x <= 315) && (y >= 280 && y <= 335)) {
            pos = "B4";
            button.setLocation((3 * a) + 165, 252);
        } else if ((x >= 315 && x <= 362) && (y >= 280 && y <= 335)) {
            pos = "B5";
            button.setLocation((4 * a) + 165, 252);
        } else if ((x >= 362 && x <= 409) && (y >= 280 && y <= 335)) {
            pos = "B6";
            button.setLocation((5 * a) + 165, 252);
        } else if ((x >= 410 && x <= 457) && (y >= 280 && y <= 335)) {
            pos = "B7";
            button.setLocation((6 * a) + 163, 252);
        } else if ((x >= 458 && x <= 503) && (y >= 280 && y <= 335)) {
            pos = "B8";
            button.setLocation((7 * a) + 163, 252);
        } else if ((x >= 505 && x <= 551) && (y >= 280 && y <= 335)) {
            pos = "B9";
            button.setLocation((8 * a) + 162, 252);
        } else if ((x >= 552 && x <= 598) && (y >= 280 && y <= 335)) {
            pos = "B10";
            button.setLocation((9 * a) + 162, 252);
        } else if ((x >= 599 && x <= 644) && (y >= 280 && y <= 335)) {
            pos = "B11";
            button.setLocation((10 * a) + 160, 252);
        } else if ((x >= 645 && x <= 692) && (y >= 280 && y <= 335)) {
            pos = "B12";
            button.setLocation((11 * a) + 160, 252);
        } else if ((x >= 693 && x <= 739) && (y >= 280 && y <= 335)) {
            pos = "B13";
            button.setLocation((12 * a) + 159, 252);
        } else if ((x >= 740 && x <= 786) && (y >= 280 && y <= 335)) {
            pos = "B14";
            button.setLocation((13 * a) + 159, 252);
        } else if ((x >= 787 && x <= 834) && (y >= 280 && y <= 335)) {
            pos = "B15";
            button.setLocation((14 * a) + 158, 252);
        } else if ((x >= 835 && x <= 881) && (y >= 280 && y <= 335)) {
            pos = "B16";
            button.setLocation((15 * a) + 158, 252);
        } else if ((x >= 882 && x <= 929) && (y >= 280 && y <= 335)) {
            pos = "B17";
            button.setLocation((16 * a) + 156, 252);
        } else if ((x >= 930 && x <= 977) && (y >= 280 && y <= 335)) {
            pos = "B18";
            button.setLocation((17 * a) + 156, 252);
        } else if ((x >= 978 && x <= 1024) && (y >= 280 && y <= 335)) {
            pos = "B19";
            button.setLocation((18 * a) + 155, 252);
        } else if ((x >= 1025 && x <= 1073) && (y >= 280 && y <= 335)) {
            pos = "B20";
            button.setLocation((19 * a) + 155, 252);
        } else if ((x >= 1075 && x <= 1121) && (y >= 280 && y <= 335)) {
            pos = "B21";
            button.setLocation((20 * a) + 154, 252);
        } else if ((x >= 1122) && (y >= 280 && y <= 335)) {
            pos = "B22";
           IMF.MoldeEnCarro1 = String.valueOf(IdBtn); 
          button.setLocation(Carro2X, Carro2Y);
        }
//----------------------------------------Fin B---------------------------------
//----------------------------------------Inicio C------------------------------
        if ((x >= 65 && x <= 115) && (y >= 370 && y <= 425)) {
            pos = "C0";
            IMF.MoldeEnCarro2 = String.valueOf(IdBtn);
            button.setLocation(CarroX, CarroY);
        } else if ((x >= 115 && x <= 165) && (y >= 370 && y <= 425)) {
            pos = "C1";
            button.setLocation((0 * a) + 165, 342);
        } else if ((x >= 165 && x <= 215) && (y >= 370 && y <= 425)) {
            pos = "C2";
            button.setLocation((1 * a) + 165, 342);
        } else if ((x >= 215 && x <= 265) && (y >= 370 && y <= 425)) {
            pos = "C3";
            button.setLocation((2 * a) + 165, 342);
        } else if ((x >= 265 && x <= 315) && (y >= 370 && y <= 425)) {
            pos = "C4";
            button.setLocation((3 * a) + 165, 342);
        } else if ((x >= 315 && x <= 362) && (y >= 370 && y <= 425)) {
            pos = "C5";
            button.setLocation((4 * a) + 165, 342);
        } else if ((x >= 362 && x <= 409) && (y >= 370 && y <= 425)) {
            pos = "C6";
            button.setLocation((5 * a) + 165, 342);
        } else if ((x >= 410 && x <= 457) && (y >= 370 && y <= 425)) {
            pos = "C7";
            button.setLocation((6 * a) + 163, 342);
        } else if ((x >= 458 && x <= 503) && (y >= 370 && y <= 425)) {
            pos = "C8";
            button.setLocation((7 * a) + 163, 342);
        } else if ((x >= 505 && x <= 551) && (y >= 370 && y <= 425)) {
            pos = "C9";
            button.setLocation((8 * a) + 162, 342);
        } else if ((x >= 552 && x <= 598) && (y >= 370 && y <= 425)) {
            pos = "C10";
            button.setLocation((9 * a) + 162, 342);
        } else if ((x >= 599 && x <= 644) && (y >= 370 && y <= 425)) {
            pos = "C11";
            button.setLocation((10 * a) + 160, 342);
        } else if ((x >= 645 && x <= 692) && (y >= 370 && y <= 425)) {
            pos = "C12";
            button.setLocation((11 * a) + 160, 342);
        } else if ((x >= 693 && x <= 739) && (y >= 370 && y <= 425)) {
            pos = "C13";
            button.setLocation((12 * a) + 159, 342);
        } else if ((x >= 740 && x <= 786) && (y >= 370 && y <= 425)) {
            pos = "C14";
            button.setLocation((13 * a) + 159, 342);
        } else if ((x >= 787 && x <= 834) && (y >= 370 && y <= 425)) {
            pos = "C15";
            button.setLocation((14 * a) + 158, 342);
        } else if ((x >= 835 && x <= 881) && (y >= 370 && y <= 425)) {
            pos = "C16";
            button.setLocation((15 * a) + 158, 342);
        } else if ((x >= 882 && x <= 929) && (y >= 370 && y <= 425)) {
            pos = "C17";
            button.setLocation((16 * a) + 156, 342);
        } else if ((x >= 930 && x <= 977) && (y >= 370 && y <= 425)) {
            pos = "C18";
            button.setLocation((17 * a) + 156, 342);
        } else if ((x >= 978 && x <= 1024) && (y >= 370 && y <= 425)) {
            pos = "C19";
            button.setLocation((18 * a) + 155, 342);
        } else if ((x >= 1025 && x <= 1073) && (y >= 370 && y <= 425)) {
            pos = "C20";
            button.setLocation((19 * a) + 155, 342);
        } else if ((x >= 1075 && x <= 1121) && (y >= 370 && y <= 425)) {
            pos = "C21";
            button.setLocation((20 * a) + 154, 342);
        } else if ((x >= 1122) && (y >= 370 && y <= 425)) {
            pos = "C22";
            IMF.MoldeEnCarro1 = String.valueOf(IdBtn); 
          button.setLocation(Carro2X, Carro2Y);
        }
//----------------------------------------Fin C---------------------------------
//----------------------------------------Inicio D------------------------------
        if ((x >= 65 && x <= 115) && (y >= 452 && y <= 507)) {
            pos = "D0";
            IMF.MoldeEnCarro2 = String.valueOf(IdBtn);
            button.setLocation(CarroX, CarroY);
        } else if ((x >= 115 && x <= 165) && (y >= 452 && y <= 507)) {
            pos = "D1";
            button.setLocation((0 * a) + 165, 430);
        } else if ((x >= 165 && x <= 215) && (y >= 452 && y <= 507)) {
            pos = "D2";
            button.setLocation((1 * a) + 165, 430);
        } else if ((x >= 215 && x <= 265) && (y >= 452 && y <= 507)) {
            pos = "D3";
            button.setLocation((2 * a) + 165, 430);
        } else if ((x >= 265 && x <= 315) && (y >= 452 && y <= 507)) {
            pos = "D4";
            button.setLocation((3 * a) + 165, 430);
        } else if ((x >= 315 && x <= 362) && (y >= 452 && y <= 507)) {
            pos = "D5";
            button.setLocation((4 * a) + 165, 430);
        } else if ((x >= 362 && x <= 409) && (y >= 452 && y <= 507)) {
            pos = "D6";
            button.setLocation((5 * a) + 165, 430);
        } else if ((x >= 410 && x <= 457) && (y >= 452 && y <= 507)) {
            pos = "D7";
            button.setLocation((6 * a) + 163, 430);
        } else if ((x >= 458 && x <= 503) && (y >= 452 && y <= 507)) {
            pos = "D8";
            button.setLocation((7 * a) + 163, 430);
        } else if ((x >= 505 && x <= 551) && (y >= 452 && y <= 507)) {
            pos = "D9";
            button.setLocation((8 * a) + 162, 430);
        } else if ((x >= 552 && x <= 598) && (y >= 452 && y <= 507)) {
            pos = "D10";
            button.setLocation((9 * a) + 162, 430);
        } else if ((x >= 599 && x <= 644) && (y >= 452 && y <= 507)) {
            pos = "D11";
            button.setLocation((10 * a) + 160, 430);
        } else if ((x >= 645 && x <= 692) && (y >= 452 && y <= 507)) {
            pos = "D12";
            button.setLocation((11 * a) + 160, 430);
        } else if ((x >= 693 && x <= 739) && (y >= 452 && y <= 507)) {
            pos = "D13";
            button.setLocation((12 * a) + 159, 430);
        } else if ((x >= 740 && x <= 786) && (y >= 452 && y <= 507)) {
            pos = "D14";
            button.setLocation((13 * a) + 159, 430);
        } else if ((x >= 787 && x <= 834) && (y >= 452 && y <= 507)) {
            pos = "D15";
            button.setLocation((14 * a) + 158, 430);
        } else if ((x >= 835 && x <= 881) && (y >= 452 && y <= 507)) {
            pos = "D16";
            button.setLocation((15 * a) + 158, 430);
        } else if ((x >= 882 && x <= 929) && (y >= 452 && y <= 507)) {
            pos = "D17";
            button.setLocation((16 * a) + 156, 430);
        } else if ((x >= 930 && x <= 977) && (y >= 452 && y <= 507)) {
            pos = "D18";
            button.setLocation((17 * a) + 156, 430);
        } else if ((x >= 978 && x <= 1024) && (y >= 452 && y <= 507)) {
            pos = "D19";
            button.setLocation((18 * a) + 155, 430);
        } else if ((x >= 1025 && x <= 1073) && (y >= 452 && y <= 507)) {
            pos = "D20";
            button.setLocation((19 * a) + 155, 430);
        } else if ((x >= 1075 && x <= 1121) && (y >= 452 && y <= 507)) {
            pos = "D21";
            button.setLocation((20 * a) + 154, 430);
        } else if ((x >= 1122) && (y >= 452 && y <= 507)) {
            pos = "D22";
            IMF.MoldeEnCarro1 = String.valueOf(IdBtn); 
          button.setLocation(Carro2X, Carro2Y);
        }
//----------------------------------------Fin D---------------------------------
//----------------------------------------Inicio E------------------------------
        if ((x >= 65 && x <= 115) && (y >= 542 && y <=597 )) {
            pos = "E0";
            IMF.MoldeEnCarro2 = String.valueOf(IdBtn);
            button.setLocation(CarroX, CarroY);
        } else if ((x >= 115 && x <= 165) && (y >= 542 && y <= 597)) {
            pos = "E1";
            button.setLocation((0 * a) + 165, 520);
        } else if ((x >= 165 && x <= 215) && (y >= 542 && y <= 597)) {
            pos = "E2";
            button.setLocation((1 * a) + 165, 520);
        } else if ((x >= 215 && x <= 265) && (y >= 542 && y <= 597)) {
            pos = "E3";
            button.setLocation((2 * a) + 165, 520);
        } else if ((x >= 265 && x <= 315) && (y >= 542 && y <= 597)) {
            pos = "E4";
            button.setLocation((3 * a) + 165, 520);
        } else if ((x >= 315 && x <= 362) && (y >= 542 && y <= 597)) {
            pos = "E5";
            button.setLocation((4 * a) + 165, 520);
        } else if ((x >= 362 && x <= 409) && (y >= 542 && y <= 597)) {
            pos = "E6";
            button.setLocation((5 * a) + 165, 520);
        } else if ((x >= 410 && x <= 457) && (y >= 542 && y <= 597)) {
            pos = "E7";
            button.setLocation((6 * a) + 163, 520);
        } else if ((x >= 458 && x <= 503) && (y >= 542 && y <= 597)) {
            pos = "E8";
            button.setLocation((7 * a) + 163, 520);
        } else if ((x >= 505 && x <= 551) && (y >= 542 && y <= 597)) {
            pos = "E9";
            button.setLocation((8 * a) + 162, 520);
        } else if ((x >= 552 && x <= 598) && (y >= 542 && y <= 597)) {
            pos = "E10";
            button.setLocation((9 * a) + 162, 520);
        } else if ((x >= 599 && x <= 644) && (y >= 542 && y <= 597)) {
            pos = "E11";
            button.setLocation((10 * a) + 160, 520);
        } else if ((x >= 645 && x <= 692) && (y >= 542 && y <= 597)) {
            pos = "E12";
            button.setLocation((11 * a) + 160, 520);
        } else if ((x >= 693 && x <= 739) && (y >= 542 && y <= 597)) {
            pos = "E13";
            button.setLocation((12 * a) + 159, 520);
        } else if ((x >= 740 && x <= 786) && (y >= 542 && y <= 597)) {
            pos = "E14";
            button.setLocation((13 * a) + 159, 520);
        } else if ((x >= 787 && x <= 834) && (y >= 542 && y <= 597)) {
            pos = "E15";
            button.setLocation((14 * a) + 158, 520);
        } else if ((x >= 835 && x <= 881) && (y >= 542 && y <= 597)) {
            pos = "E16";
            button.setLocation((15 * a) + 158, 520);
        } else if ((x >= 882 && x <= 929) && (y >= 542 && y <= 597)) {
            pos = "E17";
            button.setLocation((16 * a) + 156, 520);
        } else if ((x >= 930 && x <= 977) && (y >= 542 && y <= 597)) {
            pos = "E18";
            button.setLocation((17 * a) + 156, 520);
        } else if ((x >= 978 && x <= 1024) && (y >= 542 && y <= 597)) {
            pos = "E19";
            button.setLocation((18 * a) + 155, 520);
        } else if ((x >= 1025 && x <= 1073) && (y >= 542 && y <= 597)) {
            pos = "E20";
            button.setLocation((19 * a) + 155, 520);
        } else if ((x >= 1075 && x <= 1121) && (y >= 542 && y <= 597)) {
            pos = "E21";
            button.setLocation((20 * a) + 154, 520);
        } else if ((x >= 1122) && (y >= 542 && y <= 597)) {
            pos = "E22";
            IMF.MoldeEnCarro1 = String.valueOf(IdBtn); 
          button.setLocation(Carro2X, Carro2Y);
        }
//----------------------------------------Fin E---------------------------------
//----------------------------------------Inicio F------------------------------
        if ((x >= 65 && x <= 115) && (y >= 632 && y <= 687)) {
            pos = "F0";
            IMF.MoldeEnCarro2 = String.valueOf(IdBtn);
            button.setLocation(CarroX, CarroY);
        } if ((x >= 115 && x <= 165) && (y >= 632 && y <= 687)) {
            pos = "F1";
            button.setLocation((0 * a) + 164, 610);
        } else if ((x >= 165 && x <= 215) && (y >= 632 && y <= 687)) {
            pos = "F2";
            button.setLocation((1 * a) + 166, 610);
        } else if ((x >= 215 && x <= 265) && (y >= 632 && y <= 687)) {
            pos = "F3";
            button.setLocation((2 * a) + 165, 610);
        } else if ((x >= 265 && x <= 315) && (y >= 632 && y <= 687)) {
            pos = "F4";
            button.setLocation((3 * a) + 165, 610);
        } else if ((x >= 315 && x <= 362) && (y >= 632 && y <= 687)) {
            pos = "F5";
            button.setLocation((4 * a) + 165, 610);
        } else if ((x >= 362 && x <= 409) && (y >= 632 && y <= 687)) {
            pos = "F6";
            button.setLocation((5 * a) + 165, 610);
        } else if ((x >= 410 && x <= 457) && (y >= 632 && y <= 687)) {
            pos = "F7";
            button.setLocation((6 * a) + 163, 610);
        } else if ((x >= 458 && x <= 503) && (y >= 632 && y <= 687)) {
            pos = "F8";
            button.setLocation((7 * a) + 163, 610);
        } else if ((x >= 505 && x <= 551) && (y >= 632 && y <= 687)) {
            pos = "F9";
            button.setLocation((8 * a) + 162, 610);
        } else if ((x >= 552 && x <= 598) && (y >= 632 && y <= 687)) {
            pos = "F10";
            button.setLocation((9 * a) + 162, 610);
        } else if ((x >= 599 && x <= 644) && (y >= 632 && y <= 687)) {
            pos = "F11";
            button.setLocation((10 * a) + 160, 610);
        } else if ((x >= 645 && x <= 692) && (y >= 632 && y <= 687)) {
            pos = "F12";
            button.setLocation((11 * a) + 160, 610);
        } else if ((x >= 693 && x <= 739) && (y >= 632 && y <= 687)) {
            pos = "F13";
            button.setLocation((12 * a) + 159, 610);
        } else if ((x >= 740 && x <= 786) && (y >= 632 && y <= 687)) {
            pos = "F14";
            button.setLocation((13 * a) + 159, 610);
        } else if ((x >= 787 && x <= 834) && (y >= 632 && y <= 687)) {
            pos = "F15";
            button.setLocation((14 * a) + 158, 610);
        } else if ((x >= 835 && x <= 881) && (y >= 632 && y <= 687)) {
            pos = "F16";
            button.setLocation((15 * a) + 158, 610);
        } else if ((x >= 882 && x <= 929) && (y >= 632 && y <= 687)) {
            pos = "F17";
            button.setLocation((16 * a) + 156, 610);
        } else if ((x >= 930 && x <= 977) && (y >= 632 && y <= 687)) {
            pos = "F18";
            button.setLocation((17 * a) + 156, 610);
        } else if ((x >= 978 && x <= 1024) && (y >= 632 && y <= 687)) {
            pos = "F19";
            button.setLocation((18 * a) + 155, 610);
        } else if ((x >= 1025 && x <= 1073) && (y >= 632 && y <= 687)) {
            pos = "F20";
            button.setLocation((19 * a) + 155, 610);
        } else if ((x >= 1075 && x <= 1121) && (y >= 632 && y <= 687)) {
            pos = "F21";
            button.setLocation((20 * a) + 154, 610);
        } else if ((x >= 1122) && (y >= 632 && y <= 687)) {
            pos = "F22";
            IMF.MoldeEnCarro1 = String.valueOf(IdBtn); 
          button.setLocation(Carro2X, Carro2Y);      
        }
//----------------------------------------Fin F---------------------------------
        if (pos.contains("A")) {
            Linea = 6;
        } else if (pos.contains("B")) {
            Linea = 5;
        } else if (pos.contains("C")) {
            Linea = 4;
        } else if (pos.contains("D")) {
            Linea = 3;
        } else if (pos.contains("E")) {
            Linea = 2;
        } else if (pos.contains("F")) {
            Linea = 1;
        } else if (pos.contains("X")) {
            Linea = 0;
        }
        if (!pos.equals("0")) {
            // Actualizo las posiciones por la nueva pos
            System.out.println("Actualiza cn id btn" + Cn.IdBtn);
            String Consulta = "UPDATE Imf SET Posicion='" + pos + "' ,Linea=" + Linea + " where IdBtn=" + IdBtn;
            Cn.UpdateTabla(Consulta);
        }
    }
    
    
    
}
