package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import modelo.Laberinto;
import controlador.BFS;
import controlador.BusquedaConCache;
import controlador.DFS;
import controlador.RecursivoSimple;

public class LaberintoVista extends JFrame {
    private Laberinto laberinto;
    private JPanel mazePanel;
    private JButton resolverButton;
    private JButton reiniciarButton;
    private JComboBox<String> selector;
    private List<JButton> buttons; // Lista para manejar los botones del laberinto

    public LaberintoVista(Laberinto laberinto) {
        this.laberinto = laberinto;
        setTitle("LABERINTO JOSUE ABAD Y SEBASTIAN AVILA");
        setSize(800, 800); // Tamaño inicial de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        buttons = new ArrayList<>();

        // Crear el panel del laberinto con el tamaño especificado
        mazePanel = new JPanel(new GridLayout(laberinto.getLaberinto().length, laberinto.getLaberinto()[0].length));
        for (int i = 0; i < laberinto.getLaberinto().length; i++) {
            for (int j = 0; j < laberinto.getLaberinto()[0].length; j++) {
                JButton button = new JButton();
                button.setBackground(Color.WHITE); // Color por defecto para las celdas
                button.setOpaque(true);
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borde para distinguir las celdas
                button.addActionListener(new CellButtonListener(i, j)); // Maneja el clic en cada celda
                mazePanel.add(button);
                buttons.add(button);
            }
        }

        resolverButton = new JButton("Resolver");
        resolverButton.addActionListener(new SolveButtonListener());

        reiniciarButton = new JButton("Reiniciar");
        reiniciarButton.addActionListener(new RestartButtonListener());

        selector = new JComboBox<>(new String[]{"Recursivo Simple", "Busqueda con cache", "BFS", "DFS"});

        add(mazePanel, BorderLayout.CENTER);
        add(resolverButton, BorderLayout.SOUTH);
        add(reiniciarButton, BorderLayout.EAST); // Botón de reinicio en el lado derecho
        add(selector, BorderLayout.NORTH);
    }

    private class SolveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int[][] maze = laberinto.getLaberinto();
            List<int[]> path = new ArrayList<>();
            boolean foundPath = false;

            switch (selector.getSelectedItem().toString()) {
                case "Recursivo Simple":
                    RecursivoSimple recursivo = new RecursivoSimple();
                    foundPath = recursivo.findPath(maze, 0, 0, path);
                    break;
                case "Busqueda con cache":
                    BusquedaConCache cache = new BusquedaConCache();
                    foundPath = cache.findPath(maze, 0, 0, path);
                    break;
                case "BFS":
                    BFS bfs = new BFS();
                    foundPath = bfs.findPath(maze, 0, 0, path);
                    break;
                case "DFS":
                    DFS dfs = new DFS();
                    foundPath = dfs.findPath(maze, 0, 0, path);
                    break;
            }

            if (foundPath) {
                for (int[] cell : path) {
                    int row = cell[0];
                    int col = cell[1];
                    buttons.get(row * laberinto.getLaberinto()[0].length + col).setBackground(Color.GREEN);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No path found!");
            }
        }
    }

    private class RestartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Reiniciar el laberinto a su estado inicial
            int[][] initialMaze = new int[laberinto.getLaberinto().length][laberinto.getLaberinto()[0].length];
            for (int i = 0; i < initialMaze.length; i++) {
                for (int j = 0; j < initialMaze[0].length; j++) {
                    initialMaze[i][j] = 0; // Suponiendo que 0 es la celda libre
                }
            }
            laberinto = new Laberinto(laberinto.getLaberinto().length, laberinto.getLaberinto()[0].length);
            for (int i = 0; i < initialMaze.length; i++) {
                for (int j = 0; j < initialMaze[0].length; j++) {
                    laberinto.setCelda(i, j, initialMaze[i][j]);
                }
            }

            // Restaurar el color de los botones
            for (JButton button : buttons) {
                button.setBackground(Color.WHITE);
            }
        }
    }

    private class CellButtonListener implements ActionListener {
        private int row;
        private int col;

        public CellButtonListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            if (button.getBackground() == Color.WHITE) {
                button.setBackground(Color.BLACK);
                laberinto.setCelda(row, col, 1); // Marca la celda como obstáculo
            } else {
                button.setBackground(Color.WHITE);
                laberinto.setCelda(row, col, 0); // Restaura la celda
            }
        }
    }
}
