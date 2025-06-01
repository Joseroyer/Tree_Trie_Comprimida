package org.example;

import org.example.Utils.Fila;
import org.example.Utils.TpFila;

public class Trie {
    private No raiz;

    public Trie() {
        this.raiz = null;
    }

    public No getRaiz() {
        return raiz;
    }

    public void insere(String palavra) {
        No aux;
        No novaCaixa;
        int pos = 0, indexFilho = 0;
        boolean flag = true;

        if (raiz == null) raiz = new No();
        aux = raiz;

        for (int i = 0; i < palavra.length() && flag; i++) {
            pos = palavra.charAt(i) - 'a';

            if (aux.getvLig(pos) == null) { //primeiro caso, seta o resto da palavra
                novaCaixa = new No(palavra.substring(i));
                novaCaixa.setFlag(true);
                aux.setvLig(pos, novaCaixa);

                flag = false;
            } else {
                //encontrou a palvra
                No filho = aux.getvLig(pos);
                String sFilho = filho.getPalavra();

                indexFilho = 1;
                while (indexFilho < sFilho.length() && i + 1 < palavra.length()
                        && palavra.charAt(i + 1) == sFilho.charAt(indexFilho)) {
                    indexFilho++;
                    i++;
                }

                if (indexFilho < sFilho.length()) {
                    // Novo no com prefixo
                    novaCaixa = new No(sFilho.substring(0, indexFilho));

                    // Novo no com sufixo antigo
                    No restoFilho = new No(sFilho.substring(indexFilho));
                    restoFilho.setFlag(filho.getFlag());

                    for (int k = 0; k < No.N; k++) {
                        restoFilho.setvLig(k, filho.getvLig(k));
                    }

                    // resto da palavra inserida
                    No novo = new No(palavra.substring(i + 1));
                    novo.setFlag(true);

                    // Ligacao dos filhos ao novo no intermediario
                    novaCaixa.setvLig(restoFilho.getPalavra().charAt(0) - 'a', restoFilho);
                    novaCaixa.setvLig(novo.getPalavra().charAt(0) - 'a', novo);

                    // Atualiza o pai
                    aux.setvLig(pos, novaCaixa);
                }

                //Caso do Bear e Bid - Não usado
//                No aux1 = aux.getvLig(pos);
//                novaCaixa = new No(sFilho.substring(0, indexFilho + 1));
//                resto = new No(aux1.getPalavra().substring(i + 1));
//                aux1.setPalavra(String.valueOf(palavra.charAt(i)));
//                aux1.setvLig(pos, resto);
            }

            aux = aux.getvLig(pos);
        }
        aux.setFlag(true);
    }

    public void percorrerPorNivel() {
        Fila fila = new Fila();
        int nivel = 0;
        No aux = raiz;
        fila.Enqueue(aux, nivel);
        while (!fila.isEmpty()) {
            nivel++;
            TpFila no = fila.Dequeue();
            System.out.println("\t" + no.getNo().getPalavra() + " nivel: " + no.getNivel());
            for (int i = 0; i < No.N; i++) {
                if (no.getNo().getvLig(i) != null) {
                    fila.Enqueue(no.getNo().getvLig(i), no.getNivel() + 1);
                }
            }
        }
    }

    public void inOrdem() {
        inOrdem(raiz);
    }

    private void inOrdem(No raiz) {
        if (raiz != null) {
            System.out.println(raiz.getPalavra());
            for (int i = 0; i < 26; i++)
                inOrdem(raiz.getvLig(i));
        }
    }

    public void exibirPalavrasInseridas(No raiz, String concatenar) {

        if (raiz != null) {
            concatenar += raiz.getPalavra();

            if (raiz.getFlag())
                System.out.println(concatenar);

            for (int i = 0; i < 26; i++)
                exibirPalavrasInseridas(raiz.getvLig(i), concatenar);

        }
    }
}
