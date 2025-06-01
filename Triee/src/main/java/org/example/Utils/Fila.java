package org.example.Utils;

import org.example.No;

public class Fila {
    private TpFila fila;
    private int tamanho;

    public Fila() {
        this.fila = null;
        this.tamanho = 0;
    }

    public void Enqueue(No No, int nivel) {
        TpFila nc = new TpFila(No, nivel);

        if (fila == null) {
            fila = nc;
        } else {
            TpFila aux = fila;
            while (aux.getProx() != null) {
                aux = aux.getProx();
            }
            aux.setProx(nc);
        }


        tamanho++;
    }

    public TpFila Dequeue() {
        if (fila == null)
            throw new RuntimeException("Fila vazia");

        TpFila aux = fila;
        fila = fila.getProx();
        tamanho--;
        return aux;
    }

    public boolean isEmpty() {
        return fila == null;
    }

    public TpFila getFila() {
        return fila;
    }

    public void setFila(TpFila fila) {
        this.fila = fila;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}


