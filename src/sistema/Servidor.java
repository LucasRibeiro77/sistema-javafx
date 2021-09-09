package sistema;

import java.io.*;
import java.util.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
       
        public static Properties config = new Properties();
        public static String arquivo = "C:\\documents\\NetBeansProjects\\Sistema\\dist\\ConfigBD.ini";//local do arquivo
        public static String servidor;
        
        public static void show(String msg, String title){    
            
                try {
                        config.load(new FileInputStream(arquivo));
                       
                        servidor = String.valueOf(config.getProperty("Servidor"));
                        
                        System.out.println("Iniciando processo de leitura de configurações: ");
                       
                        System.out.println();
                       
                        System.out.println(servidor);
                        System.out.println(config.getProperty("NomeBD"));
                        System.out.println(config.getProperty("Usuario"));
                        System.out.println(config.getProperty("Senha"));
                       
                        System.out.println();
                       
                        System.out.println("Finalizando leitura!");
                } catch (IOException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
}