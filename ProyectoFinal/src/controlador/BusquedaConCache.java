package controlador;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class BusquedaConCache {
    private Map<String, Boolean> cache = new HashMap<>();

    public boolean findPath(int[][] laberinto, int x, int y, List<int[]> path) {
        String key = x + "," + y;
        
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        
        if (x < 0 || y < 0 || x >= laberinto.length || y >= laberinto[0].length || laberinto[x][y] == 1) {
            cache.put(key, false);
            return false;
        }
        
        path.add(new int[]{x, y});
        
        if (x == laberinto.length - 1 && y == laberinto[0].length - 1) {
            cache.put(key, true);
            return true;
        }
        
        laberinto[x][y] = 1;
        
        if (findPath(laberinto, x + 1, y, path) || findPath(laberinto, x, y + 1, path) || 
            findPath(laberinto, x - 1, y, path) || findPath(laberinto, x, y - 1, path)) {
            cache.put(key, true);
            return true;
        }
        
        path.remove(path.size() - 1);
        laberinto[x][y] = 0;
        cache.put(key, false);
        return false;
    }
}

