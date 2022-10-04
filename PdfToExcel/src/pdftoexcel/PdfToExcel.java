/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdftoexcel;

/**
 *
 * @author reazulhaque
 */
import com.spire.pdf.*;
public class PdfToExcel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Create a PdfDocument object
        PdfDocument pdf = new PdfDocument();
        //Load a sample PDF file
        pdf.loadFromFile("Order-AD-226271811_202210024809.pdf");
        //Save to Excel
        pdf.saveToFile("PdfToExcel.xlsx", FileFormat.XLSX);
    }
    
}
