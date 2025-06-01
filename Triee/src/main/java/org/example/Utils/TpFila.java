package org.example.Utils;

import org.example.No;

public class TpFila {
    private No no;
    private int nivel;
    private TpFila prox;

    public TpFila(No no, int nivel) {
        this.no = no;
        this.nivel = nivel;
        this.prox = null;
    }

    public TpFila getProx() {
        return prox;
    }

    public void setProx(TpFila prox) {
        this.prox = prox;
    }

    public No getNo() {
        return no;
    }

    public void setNo(No no) {
        this.no = no;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
