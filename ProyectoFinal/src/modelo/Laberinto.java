package modelo;

public class Laberinto {
    private int[][] laberinto;
    private int rows;
    private int cols;

    public Laberinto(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.laberinto = new int[rows][cols];
    }

    public void setCelda(int row, int col, int value) {
        this.laberinto[row][col] = value;
    }

    public int getCelda(int row, int col) {
        return this.laberinto[row][col];
    }

    public int[][] getLaberinto() {
        return this.laberinto;
    }
}

