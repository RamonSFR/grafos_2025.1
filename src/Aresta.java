import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class Aresta {
    private String nome;
    private Vertice origem;
    private Vertice destino;

    public Aresta(Vertice origem,
                  Vertice destino){
        this.origem = origem;
        this.destino = destino;
    }

    @Override
    public String toString(){
        String nomeASerPrintado = nome == null ? "" : nome;
        return nomeASerPrintado + "(" + origem + ", " + destino + ")";
    }
}
