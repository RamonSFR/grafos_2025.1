import lombok.*;

import java.util.List;

@Getter
@Setter
public class Vertice {
    private String nome;
    private List<Vertice> adjacencias;
    private int grau; //direc = inDegree + outDegree
    private int inDegree;
    private int outDegree;

    public Vertice(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return nome;
    }
}
