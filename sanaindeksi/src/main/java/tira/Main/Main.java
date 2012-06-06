package tira.Main;

import java.io.IOException;
import tira.UI.KomentoRiviUI;

/**
 *
 * @author moubarik
 */
public class Main {
    /**
     * Jos parametreja löytyy prosessoidaan ja ladataan ne Trieen suoraan.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        KomentoRiviUI ui = new KomentoRiviUI();
        if(args.length > 0){
            ui.lataaParametrit(args);
            ui.run();
        }else{
            ui.run();
        }
    }

}
