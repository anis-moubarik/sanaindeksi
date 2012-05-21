package tira.fileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author moubarik
 */
public class TiedostonLuku {
    
    FileReader fr;
    BufferedReader br;
    
    /**
     * 
     * @param tiedostonimi
     * @return
     * @throws IOException
     */
    public String[] lueRivitTaulukkoon(String tiedostonimi) throws IOException{
        fr = new FileReader(tiedostonimi);
        br = new BufferedReader(fr);
        List<String> rivit = new ArrayList<String>();
        String rivi = null;
        
        while((rivi = br.readLine()) != null){
            rivit.add(rivi);
        }
        br.close();
        return rivit.toArray(new String[rivit.size()]);
    }
    public String lueTiedostoMuistiin(String tiedostonimi) throws IOException{
        fr = new FileReader(tiedostonimi);
        br = new BufferedReader(fr);
        String teksti = null, rivi;
        
        while((rivi = br.readLine()) != null){
            teksti += rivi;
        }
        
        return teksti;
    }
}
