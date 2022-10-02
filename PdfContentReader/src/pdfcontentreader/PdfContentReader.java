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
        File file = new File("C:/invoice.pdf");
//        ApacheTika apacheTika = new ApacheTika();
//        apacheTika.run(file);

//        ITextReader iTextReader = new ITextReader();
//        iTextReader.run();

        PdfBox pdfBox = new PdfBox();
        pdfBox.run(file);
    }
    
}
