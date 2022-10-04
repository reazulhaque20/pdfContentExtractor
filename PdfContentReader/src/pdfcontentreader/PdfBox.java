/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdfcontentreader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

/**
 *
 * @author Reazul-System
 */
public class PdfBox extends PDFTextStripper{
    public PdfBox() throws IOException{
        
    }
    
    static List<String> lines = new ArrayList<String>();

    public void run(File file) throws IOException {
//      File file = file;
      PDDocument document = PDDocument.load(file);

      //Instantiate PDFTextStripper class
      PDFTextStripper pdfStripper = new PDFTextStripper();

      //Retrieving text from PDF document
      String text = pdfStripper.getText(document);
      System.out.println(text);
      System.out.println(text.subSequence(9, 19));

      //Closing the document
      document.close();
    }
    
    public void run2() throws IOException{
        PDDocument document = null;
        String fileName = "Order-AD-226271811_202210024809.pdf";
        try {
            document = PDDocument.load( new File(fileName) );
            PDFTextStripper stripper = new PdfBox();
            stripper.setSortByPosition( true );
            stripper.setStartPage( 0 );
            stripper.setEndPage( document.getNumberOfPages() );
  
            Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
            stripper.writeText(document, dummy);
             
            // print lines
            for(String line:lines){
                System.out.println(line); 
            }
        }
        finally {
            if( document != null ) {
                document.close();
            }
        }
    }
    
    public void getCoordinate() throws IOException{
            PDDocument document = null;
        String fileName = "apache.pdf";
        try {
            document = PDDocument.load( new File(fileName) );
            PDFTextStripper stripper = new PdfBox();
            stripper.setSortByPosition( true );
            stripper.setStartPage( 0 );
            stripper.setEndPage( document.getNumberOfPages() );
  
            Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
            stripper.writeText(document, dummy);
        }
        finally {
            if( document != null ) {
                document.close();
            }
        }
    }
    
    /**
     * Override the default functionality of PDFTextStripper.writeString()
     */
    @Override
     protected void writeString(String string, List<TextPosition> textPositions) throws IOException {
        for (TextPosition text : textPositions) {
            System.out.println(text.getUnicode()+ " [(X=" + text.getXDirAdj() + ",Y=" +
                    text.getYDirAdj() + ") height=" + text.getHeightDir() + " width=" +
                    text.getWidthDirAdj() + "]");
        }
    }
}
