import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
public class Grafo {
    public boolean isDirecionado;
    private List<Vertice> vertices;
    private List<Aresta> arestas;
    private int ordem;
    private int tamanho;

    public Grafo(boolean isDirecionado) {
        this.isDirecionado = isDirecionado;
    }

    public void setVertices(List<Vertice> vertices) {
        this.vertices = vertices;
        ordem = vertices.size();
    }

    public void setArestas(List<Aresta> arestas) {
        this.arestas = arestas;
        tamanho = arestas.size();
        if (!isDirecionado) {
            verificaDirecionado();
        }
        preencherAdjancencias();
    }

    public void preencherAdjancencias() {
        for (Aresta aresta : arestas) {
            Vertice origem = aresta.getOrigem();
            Vertice destino = aresta.getDestino();
            avaliarGrausDosVertices(origem, destino);

            destino.addAdjacencia(origem);
            if (!isDirecionado) {
                origem.addAdjacencia(destino);
            }
        }
    }

    private void avaliarGrausDosVertices(Vertice origem, Vertice destino) {
        if (isDirecionado) {
            origem.incrementaOutDegree();
            destino.incrementaInDegree();
        }
        destino.incrementaGrau();
        origem.incrementaGrau();
    }

    public void verificaDirecionado() {
        for (int i = 0; i < arestas.size();i++) {
            if (isSelfLoop(arestas.get(i))) {
                defineComoDirecionado();
                return;
            }
            for (int j = 0; j < arestas.size(); j++) {
                if (naoEaMesmaAresta(i, j)) {
                    if (isViaMaoDupla(arestas.get(i), arestas.get(j))) {
                        defineComoDirecionado();
                        return;
                    } else if (isMesmoSentido(arestas.get(i), arestas.get(j))) {
                        defineComoDirecionado();
                        return;
                    }
                }

            }
        }
    }

    private static boolean naoEaMesmaAresta(int i, int j) {
        return i != j;
    }

    private boolean isMesmoSentido(Aresta i, Aresta j) {
        return i.getOrigem() == j.getOrigem() && i.getDestino() == j.getDestino();
    }

    private void defineComoDirecionado() {
        isDirecionado = true;
    }

    private static boolean isViaMaoDupla(Aresta arestaAlvo, Aresta arestaInterna) {
        return arestaAlvo.getOrigem() == arestaInterna.getDestino()
                && arestaAlvo.getDestino() == arestaInterna.getOrigem();
    }

    private static boolean isSelfLoop(Aresta arestaAlvo) {
        return arestaAlvo.getOrigem() == arestaAlvo.getDestino();
    }

    @Override
    public String toString() {
        return
                "\nisDirecionado: " + isDirecionado +
                        "\nvertices: " + vertices +
                        "\narestas: " + arestas +
                        "\nordem: " + ordem +
                        "\ntamanho: " + tamanho;
    }
}
