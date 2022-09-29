/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pdfcontentreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

/**
 *
 * @author Reazul-System
 */
public class PdfContentReader {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, SAXException, TikaException {
        // TODO code application logic here
        // Create a content handler
        BodyContentHandler contenthandler
            = new BodyContentHandler();
 
        // Create a file in local directory
        File f = new File("C:/sample.pdf");
 
        // Create a file input stream
        // on specified path with the created file
        FileInputStream fstream = new FileInputStream(f);
 
        // Create an object of type Metadata to use
        Metadata data = new Metadata();
 
        // Create a context parser for the pdf document
        ParseContext context = new ParseContext();
 
        // PDF document can be parsed using the PDFparser
        // class
        PDFParser pdfparser = new PDFParser();
 
        // Method parse invoked on PDFParser class
        pdfparser.parse(fstream, contenthandler, data,
                        context);
 
        // Printing the contents of the pdf document
        // using toString() method in java
        System.out.println("Extracting contents :"
                           + contenthandler.toString());
    }
    
}
