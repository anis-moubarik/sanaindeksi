package tira.sanaindeksi;

import tira.trie.Trie;

public class main {
    public static void main(String[] args) {
        Trie tr = new Trie();
    
        String[] sanat = {"sana", "ananas", "kana", "puhelin"};
        for (String sana : sanat){
            tr.lisääSana(sana);
        }
    }
}
