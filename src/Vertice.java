import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Vertice {
    private String nome;
    private List<Vertice> adjacencias = new ArrayList<>();
    private int grau;
    private int inDegree;
    private int outDegree;
    private Grafo grafo;

    public Vertice(String nome, Grafo grafo) {
        this.nome = nome;
        this.grafo = grafo;
    }

    public void addAdjacencia(Vertice vertice) {
        adjacencias.add(vertice);
    }
    public void incrementaGrau(){
        grau++;
    }
    public void incrementaInDegree(){
        inDegree++;
    }
    public void incrementaOutDegree(){
        outDegree++;
    }

    @Override
    public String toString() {
        List<String> listaNomesAdjacencias = adjacencias.stream().map(Vertice::getNome).toList();

        if (grafo.isDirecionado) {
            return nome + "(grau: + " + grau + ", inDegree: " + inDegree + ", outDegree" + outDegree + ", adjacencias: " + listaNomesAdjacencias + ")";
        }

        return nome + "(grau: + " + grau + ", adjacencias: " + listaNomesAdjacencias + ")";
    }
}
