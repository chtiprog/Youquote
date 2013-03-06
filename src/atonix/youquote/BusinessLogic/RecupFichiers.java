/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package atonix.youquote.BusinessLogic;

import atonix.youquote.UI.desktop.FrameYouQuote;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ankat
 */
public class RecupFichiers {
    static String url ;
    public static String quoteName ;
    
    public static void recupFichierYahoo(String name){
        quoteName = name ;
        url = "http://finance.yahoo.com/d/quotes.csv?s=" + quoteName + "&f=ohgl1";
        
        System.out.println(quoteName + "url : " + url) ; // DEBUG
        
         // Récupère et sauvegarde fichier csv de yahoo
        try {
            URL website = new URL(url);

          ReadableByteChannel rbc = Channels.newChannel(website.openStream());
          FileOutputStream fos = new FileOutputStream("/home/ankat/testTelechargement.csv");
          fos.getChannel().transferFrom(rbc, 0, 1 << 24);     
        } 
        catch (MalformedURLException ex) {
            Logger.getLogger(FrameYouQuote.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(FrameYouQuote.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
    }
    
    
} // fin classe RecupFichiers
