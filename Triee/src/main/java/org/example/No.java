package org.example;

public class No {
    private String palavra;
    private No[] vLig;
    private boolean flag;
    public final static int N = 26;

    public No() {
        this.palavra = "";
        this.vLig = new No[N];
        this.flag = false;
    }

    public No(String palavra) {
        this();
        this.palavra = palavra;
    }

    public No getvLig(int p) {
        return vLig[p];
    }

    public void setvLig(int p, No vLig) {
        this.vLig[p] = vLig;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
