package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("bear", "bell", "bid", "bull", "buy", "sell", "stock", "stop");
        Trie trie = new Trie();

//        for (String palavra : palavras) {
//            trie.insere(palavra);
//        }
        trie.insere(palavras.get(0));
        trie.insere(palavras.get(2));

    }
}