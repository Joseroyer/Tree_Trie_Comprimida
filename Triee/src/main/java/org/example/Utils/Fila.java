package org.example.Utils;

public class Fila {
    private TpFila fila;
    private int tamanho;

    public Fila() {
        this.fila = null;
        this.tamanho = 0;
    }

    public void Enqueue(String info) {
        TpFila nc = new TpFila(info);
        TpFila aux;

        if (fila == null)
            fila = nc;

        aux = this.fila;
        while (aux.getProx() != null) {
            aux = aux.getProx();
        }
        aux.setProx(nc);

        aux.setProx(nc);
        tamanho++;
    }

    public String Dequeue() {
        if (fila == null)
            throw new RuntimeException("Fila vazia");

        TpFila aux = fila;
        fila = fila.getProx();
        tamanho--;
        return aux.getInfo();
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


