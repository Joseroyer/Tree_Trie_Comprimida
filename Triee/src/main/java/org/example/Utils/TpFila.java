package org.example.Utils;

public class TpFila {
    private String info;
    private TpFila prox;

    public TpFila(String info) {
        this.info = info;
        this.prox = null;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public TpFila getProx() {
        return prox;
    }

    public void setProx(TpFila prox) {
        this.prox = prox;
    }
}
