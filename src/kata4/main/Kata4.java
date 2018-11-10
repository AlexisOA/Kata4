/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata4.main;

import java.io.IOException;
import java.util.List;
import kata4.model.Histogram;
import kata4.model.Mail;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;
import static kata4.view.MailListReader.read;

/**
 *
 * @author Usuario
 */
public class Kata4 {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws Exception {
          execute();
    }
     
     public static void execute() throws Exception{
        List<Mail> mailList = input();
        Histogram<String> histogram = process(mailList);
        output(histogram);
    }
     
     public static List<Mail> input() throws Exception{
         String fileName = "email.txt";
         try{
             return new MailListReader().read(fileName);
         } catch (IOException ex) {
             
         }
         return null;
    }
     
     public static Histogram<String> process(List<Mail> mailList){
         return new MailHistogramBuilder().build(mailList);
    }
    
    public static void output(Histogram<String> histogram){
        new HistogramDisplay(histogram).execute();
    }
    
}
