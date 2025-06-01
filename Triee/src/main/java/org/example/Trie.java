package org.example;

import org.example.Utils.Fila;
import org.w3c.dom.Node;

public class Trie {
    private No raiz;

    public Trie() {
        this.raiz = null;
    }

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    public void insere(String palavra) {
        No aux;
        No novaCaixa;
        No resto;
        int pos = 0;
        boolean flag = true;

        if (raiz == null) raiz = new No();
        aux = raiz;

        for (int i = 0; i < palavra.length() && flag; i++) {
            pos = palavra.charAt(i) - 'a';
            if (aux.getvLig(pos) == null) { //primeiro caso, seta o resto da palavra
                novaCaixa = new No(palavra.substring(i));
                aux.setvLig(pos, novaCaixa);
                aux.setFlag(true);

                flag = false;
            } else { //encontrou a palvra
                No aux1 = aux.getvLig(pos);

                resto = new No(aux1.getPalavra().substring(i + 1));
                aux1.setPalavra(String.valueOf(palavra.charAt(i)));

                aux1.setvLig(pos, resto);
            }

            aux = aux.getvLig(pos);
        }
    }

    public void percorrerPorNivel(){
        Fila fila = new Fila();
        No aux = raiz;
        fila.Enqueue(aux.getPalavra());
        while (!fila.isEmpty()) {
            String palavra = fila.Dequeue();
            System.out.println(aux.getPalavra());
            for(int i=0; i<No.N; i++){
                if(aux.getvLig(i) != null){
//                    fila.Enqueue(aux.getvLig(i));
                }
            }
        }
    }
}
