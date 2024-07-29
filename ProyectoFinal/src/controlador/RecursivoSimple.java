package controlador;


import java.util.List;

public class RecursivoSimple {
    public boolean findPath(int[][] laberinto, int x, int y, List<int[]> path) {
        if (x < 0 || y < 0 || x >= laberinto.length || y >= laberinto[0].length || laberinto[x][y] == 1) {
            return false;
        }
        
        path.add(new int[]{x, y});
        
        if (x == laberinto.length - 1 && y == laberinto[0].length - 1) {
            return true;
        }
        
        laberinto[x][y] = 1;
        
        if (findPath(laberinto, x + 1, y, path) || findPath(laberinto, x, y + 1, path) || 
            findPath(laberinto, x - 1, y, path) || findPath(laberinto, x, y - 1, path)) {
            return true;
        }
        
        path.remove(path.size() - 1);
        laberinto[x][y] = 0;
        return false;
    }
}
