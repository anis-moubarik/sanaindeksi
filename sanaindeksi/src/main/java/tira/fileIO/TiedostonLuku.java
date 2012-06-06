package tira.fileIO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import tira.dynaaminentaulu.DynaaminenTauluInterface;
import tira.dynaaminentaulu.DynaaminenTauluString;

/**
 *
 * @author moubarik
 */
public class TiedostonLuku {
    
    FileInputStream fr;
    InputStreamReader ir;
    BufferedReader br;
    
    /**
     * Luetaan tiedosto/Gutenberg URL String[] taulukkoon, käytetään UTF8 enkoodausta.
     * @param tiedostonimi
     * @return String[]
     * @throws IOException
     */
    public String[] lueRivitTaulukkoon(String tiedostonimi) throws IOException{
        HttpURLConnection httpcon;
        if(tiedostonimi.startsWith("http://") && tiedostonimi.contains("gutenberg")){
            String id = tiedostonimi.substring(tiedostonimi.lastIndexOf("/")+1);
            URL gutenberg = new URL("http://www.gutenberg.org/cache/epub/"+id+"/pg"+id+".txt");
            httpcon = (HttpURLConnection) gutenberg.openConnection();
            httpcon.addRequestProperty("User-Agent", "Mozilla/4.76");
            br = new BufferedReader(new InputStreamReader(httpcon.getInputStream(), "UTF8"));
        }else{        
            fr = new FileInputStream(tiedostonimi);
            ir = new InputStreamReader(fr, "UTF8");
            br = new BufferedReader(ir);
        }
        DynaaminenTauluInterface<String> rivit = new DynaaminenTauluString();
        String rivi;

        while((rivi = br.readLine()) != null){
            rivit.lisää(rivi);
        }
        br.close();
        return (String[]) rivit.toArray(new String[rivit.size()]);
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
