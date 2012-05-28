package tira.fileIO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author moubarik
 */
public class TiedostonLuku {
    
    FileInputStream fr;
    InputStreamReader ir;
    BufferedReader br;
    
    /**
     * Luetaan tiedosto String[] taulukkoon, käytetään UTF8 enkoodausta.
     * @param tiedostonimi
     * @return String[]
     * @throws IOException
     */
    public String[] lueRivitTaulukkoon(String tiedostonimi) throws IOException{
        fr = new FileInputStream(tiedostonimi);
        ir = new InputStreamReader(fr, "UTF8");
        br = new BufferedReader(ir);
        List<String> rivit = new ArrayList<String>();
        String rivi = null;
        
        
        while((rivi = br.readLine()) != null){
            rivit.add(rivi);
        }
        ir.close();
        return rivit.toArray(new String[rivit.size()]);
    }
    /**
     * @param tiedostonimi
     * @return
     * @throws IOException
     */
    public String lueTiedostoMuistiin(String tiedostonimi) throws IOException{
        fr = new FileInputStream(tiedostonimi);
        ir = new InputStreamReader(fr, "UTF8");
        br = new BufferedReader(ir);
        String teksti = null, rivi;
        
        while((rivi = br.readLine()) != null){
            teksti += rivi;
        }
        
        return teksti;
    }
}
