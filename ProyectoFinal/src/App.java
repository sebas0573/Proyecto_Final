import javax.swing.JOptionPane;

import modelo.Laberinto;
import vista.LaberintoVista;

public class App {
    public static void main(String[] args) throws Exception {
       int rows = 0, cols = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                String rowsInput = JOptionPane.showInputDialog("Ingrese el número de filas del laberinto:");
                String colsInput = JOptionPane.showInputDialog("Ingrese el número de columnas del laberinto:");
                
                rows = Integer.parseInt(rowsInput);
                cols = Integer.parseInt(colsInput);
                
                if (rows > 0 && cols > 0) {
                    validInput = true;
                } else {
                    JOptionPane.showMessageDialog(null, "El número de filas y columnas debe ser mayor que 0.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, ingrese números enteros.");
            }
        }

        
        Laberinto laberinto = new Laberinto(rows, cols);
        LaberintoVista view = new LaberintoVista(laberinto);
        view.setVisible(true);
    }
}
