import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Setter
@ToString
public class Grafo {
    private boolean isDirecionado;
    private List<Vertice> vertices;
    private List<Aresta> arestas;
    private int ordem;
    private int tamanho;

    public Grafo(boolean isDirecionado){
        this.isDirecionado = isDirecionado;
    }

    public void setVertices(List<Vertice> vertices) {
        this.vertices = vertices;
        ordem = vertices.size();
    }

    public void setArestas(List<Aresta> arestas) {
        this.arestas = arestas;
        tamanho = arestas.size();
    }
}
