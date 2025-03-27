import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Vertice {
    private String nome;
    private List<Vertice> adjacencias = new ArrayList<>();
    private int grau; //direc = inDegree + outDegree
    private int inDegree;
    private int outDegree;

    public Vertice(String nome) {
        this.nome = nome;
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
        // Resolver o stackOverFlow
        // Como printar o in e outDegree apenas para quando for grafo direcionado?
        return nome + "(grau: + " + grau + ", adjacencias: " + adjacencias + ")";
    }
}
