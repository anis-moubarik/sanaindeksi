package tira.trie;


public class Trie{
    
    private TrieSolmu juuri;
    
    public Trie(){
        juuri = new TrieSolmu('\0', false);
    }
    
    public void lisääSana(String sana){
        int l = sana.length();
        char[] kirjaimet = sana.toCharArray();
        TrieSolmu solmu = juuri;
        
        for(int i = 0; i < l; i++){
            if (solmu.lapset.hae(kirjaimet[i]) == null)
                solmu.lapset.lisää(new TrieSolmu(kirjaimet[i], i  == l-1 ? true : false));
            solmu = solmu.lapset.hae(kirjaimet[i]);
        }
    }
    
}