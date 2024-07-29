MATERIA:
ESTRUCTURA DE DATOS
INTEGRANTES:
•
Josue Abad jabada3@est.ups.edu.ec
•
Sebastián Ávila davilaq1@est.ups.edu.ec

1. Descripción del Problema
El objetivo del proyecto es desarrollar una aplicación gráfica que permita a los usuarios resolver laberintos utilizando diferentes algoritmos de búsqueda. La aplicación debe permitir a los usuarios:
•
Ingresar el tamaño del laberinto.
•
Marcar celdas como obstáculos.
•
Seleccionar y ejecutar distintos algoritmos de búsqueda para encontrar un camino desde el inicio hasta el final del laberinto.
•
Visualizar el resultado en la interfaz gráfica.
•
Reiniciar el laberinto para realizar nuevas pruebas.

2. Propuesta de Solución
2.1. Marco Teórico
•
Programación Dinámica: Es una técnica de diseño algorítmico que resuelve problemas dividiéndolos en subproblemas más pequeños, resolviendo cada subproblema solo una vez y almacenando sus soluciones en una tabla para evitar recomputaciones. Es útil para problemas de optimización como el de encontrar el camino más corto en un laberinto.
•
BFS (Breadth-First Search): Es un algoritmo de búsqueda en grafos que explora los nodos nivel por nivel, comenzando desde el nodo raíz. Es eficaz para encontrar el camino más corto en un laberinto porque garantiza que el primer camino encontrado es el más corto en términos de número de aristas.
•
DFS (Depth-First Search): Es un algoritmo de búsqueda en grafos que explora lo más profundo posible antes de retroceder. Aunque es útil para encontrar
caminos en grafos, no garantiza encontrar el camino más corto ya que puede
explorar rutas largas innecesariamente.
2.2. Descripción de la Propuesta de Solución
La solución se implementa utilizando los siguientes componentes:
•
Lenguaje de Programación: Java.
•
Herramientas y Tecnologías:
o
Swing: Para la creación de la interfaz gráfica de usuario (GUI).
o
Algoritmos de Búsqueda: Implementación de BFS, DFS, y algoritmos recursivos con y sin caché.
•
Descripción de la Implementación:
o
Clase App: Punto de entrada de la aplicación que solicita el tamaño del laberinto, crea la instancia del laberinto y la vista, y muestra la interfaz gráfica.
o
Clase Laberinto: Modela el laberinto como una matriz bidimensional, proporcionando métodos para manipular y acceder a los datos del laberinto.
o
Clase LaberintoVista: Gestiona la interfaz gráfica, permite marcar obstáculos, ejecutar algoritmos, y reiniciar el laberinto.
o
Algoritmos de Búsqueda (RecursivoSimple, BusquedaConCache, BFS, DFS): Implementan diferentes estrategias para encontrar un camino en el laberinto, cada uno con sus características y métodos de optimización.
2.3. Criterio por Integrante de la Propuesta
•
Desarrollo de Algoritmos: Implementación y optimización de algoritmos de búsqueda (BFS, DFS, Recursivo Simple, Búsqueda con Cache).
•
Interfaz Gráfica: Creación de una GUI interactiva usando Swing para permitir la manipulación del laberinto y visualización de resultados.
•
Integración y Testing: Integración de componentes, pruebas de funcionalidad, y ajustes según los resultados obtenidos.

3. Conclusiones
Entre los algoritmos implementados, el BFS (Breadth-First Search) es la mejor opción para encontrar el camino más corto en el laberinto. Esto se debe a que:
•
Garantiza la Optimalidad: BFS explora todos los caminos de manera uniforme, asegurando que el primer camino encontrado hacia el objetivo sea el más corto en términos de número de pasos.
•
Eficiencia: Aunque puede ser menos eficiente en términos de espacio en comparación con DFS, la ventaja de encontrar el camino más corto lo hace preferible para problemas donde se requiere la solución óptima.
En contraste, DFS puede encontrar un camino, pero no garantiza que sea el más corto, y el enfoque Recursivo Simple o con Cache puede ser útil, pero su rendimiento puede variar dependiendo de la estructura del laberinto y la presencia de ciclos.



## Descripción del Proyecto
Este proyecto es una aplicación en Java diseñada para resolver laberintos utilizando diversos algoritmos de búsqueda. La aplicación proporciona una interfaz gráfica de usuario (GUI) que permite al usuario definir el tamaño del laberinto, marcar celdas como obstáculos, seleccionar un algoritmo de búsqueda y visualizar el resultado. El proyecto incluye la implementación de algoritmos como BFS, DFS, y métodos recursivos, así como una interfaz gráfica para interactuar con el laberinto.

## Funcionalidades
Definir Tamaño del Laberinto: Permite a los usuarios ingresar el número de filas y columnas para crear un laberinto de tamaño personalizado.
Marcar Obstáculos: Los usuarios pueden seleccionar celdas en el laberinto para marcarlas como obstáculos, las cuales no se pueden atravesar.
Seleccionar Algoritmo de Búsqueda: Ofrece varios algoritmos para encontrar un camino desde el inicio hasta el final del laberinto:
Recursivo Simple
Busqueda con Cache
BFS (Breadth-First Search)
DFS (Depth-First Search)
Resolver Laberinto: Ejecuta el algoritmo de búsqueda seleccionado y visualiza el camino encontrado en verde.
Reiniciar Laberinto: Restaura el laberinto a su estado inicial, permitiendo nuevas interacciones sin necesidad de reiniciar la aplicación.
Estructura del Proyecto
Clases y Funcionalidades
## 1. App.java
Descripción: Clase principal que inicia la aplicación. Solicita al usuario el tamaño del laberinto, crea una instancia del laberinto y de la vista, y muestra la interfaz gráfica.
Responsabilidades:
Configurar el tamaño del laberinto.
Inicializar la vista del laberinto.
## 2. Laberinto.java
Descripción: Clase que modela el laberinto como una matriz bidimensional.
Responsabilidades:
setCelda(int row, int col, int value): Establece el valor de una celda en la matriz.
getCelda(int row, int col): Obtiene el valor de una celda en la matriz.
getLaberinto(): Devuelve la matriz completa del laberinto.
## 3. LaberintoVista.java
Descripción: Clase que gestiona la interfaz gráfica de usuario utilizando Swing.
Responsabilidades:
Crear y mostrar la cuadrícula del laberinto.
Permitir la interacción del usuario para marcar obstáculos y ejecutar algoritmos.
Implementar el botón "Resolver" para ejecutar el algoritmo seleccionado y mostrar el resultado.
Implementar el botón "Reiniciar" para limpiar el laberinto.
## 4. RecursivoSimple.java
Descripción: Implementa un algoritmo de búsqueda recursiva simple para encontrar un camino en el laberinto.
Responsabilidades:
findPath(int[][] laberinto, int x, int y, List<int[]> path): Busca un camino desde la posición (x, y) hasta el final del laberinto utilizando recursión.
## 5. BusquedaConCache.java
Descripción: Implementa un algoritmo de búsqueda recursiva con cache para mejorar la eficiencia.
Responsabilidades:
findPath(int[][] laberinto, int x, int y, List<int[]> path): Busca un camino desde la posición (x, y) utilizando memoización para evitar recomputaciones.
## 6. BFS.java
Descripción: Implementa el algoritmo de búsqueda en amplitud (BFS) para encontrar el camino más corto en el laberinto.
Responsabilidades:
findPath(int[][] laberinto, int startX, int startY, List<int[]> path): Busca el camino más corto desde la posición (startX, startY) hasta el final utilizando BFS.
## 7. DFS.java
Descripción: Implementa el algoritmo de búsqueda en profundidad (DFS) para encontrar un camino en el laberinto.
Responsabilidades:
findPath(int[][] laberinto, int startX, int startY, List<int[]> path): Busca un camino desde la posición (startX, startY) hasta el final utilizando DFS.