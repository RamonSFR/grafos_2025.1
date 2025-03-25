import java.util.List;

public class Main {
    public static void main(String[] args) {
        Grafo g = new Grafo(true);
        Vertice v1 = new Vertice("A");
        Vertice v2 = new Vertice("B");
        Aresta a1 = new Aresta(v2, v1);
        //v1.getAdjacencias.add(v2);
        //v2.getAdjacencias.add(v1); -- ñ dir
        Aresta a2 = new Aresta(v2, v1);
        g.setVertices(List.of(v1, v2));
        g.setArestas(List.of(a1, a2));
        System.out.println(g);
    }
}