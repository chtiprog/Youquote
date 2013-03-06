/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package atonix.youquote.BusinessLogic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ankat
 */
public class Telecharger {

    URL url;
    URLConnection connection;
    InputStream entree = null;
    FileOutputStream fichierSortie = null;

    public Telecharger(String url) throws MalformedURLException, IOException {
        this.url = new URL(url);
        this.connection = this.url.openConnection();

    } // fin constructeur

    public void getFichier() {
        int longueurFichier = this.connection.getContentLength();
        if (longueurFichier == -1) {
            System.out.println("Invalide URL or file.");
            return;
        }

        try {
            entree = this.connection.getInputStream();
            String nomFichier = url.getFile().substring(url.getFile().lastIndexOf('/') + 1);
            //this.fichierSortie = new FileOutputStream(nomFichier);
            this.fichierSortie = new FileOutputStream("/home/ankat/test.csv");
            
            
            byte[] buffer = new byte[1024];
            int read;

            while ((read = entree.read(buffer)) > 0) {
                fichierSortie.write(buffer, 0, read);
            }
            
            fichierSortie.flush();

        }
        catch(IOException e){
            System.out.println("Error while trying to download the file.");
            e.printStackTrace();
        }
        finally{
            try {
                fichierSortie.close();
                entree.close();
            } catch (IOException ex) {
                Logger.getLogger(Telecharger.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
    } // fin methode getFichier
    
    
} // fin classe Telecharger
