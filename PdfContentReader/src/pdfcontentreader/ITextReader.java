/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdfcontentreader;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.io.IOException;

/**
 *
 * @author Reazul-System
 */
public class ITextReader {
    
    public void run(){
        try 
    {
        //Create a PdfReader instance.
        PdfReader pdf = new PdfReader("C:\\invoice.pdf");  
   
        //Get the number of pages in pdf.
        int nbrPages = pdf.getNumberOfPages(); 
   
        //Iterate the pdf through the pages.
        for(int i=1; i <= nbrPages; i++) 
        { 
            //Extract the content of the page using PdfTextExtractor.
            String content = PdfTextExtractor.getTextFromPage(pdf, i);
   
            //Display the content of the page on the console.
            System.out.println("Content of the page : " + content);
        }
   
        //Close the PdfReader.
        pdf.close();
    
    } catch (IOException ex) {
    }
    }
    
}
