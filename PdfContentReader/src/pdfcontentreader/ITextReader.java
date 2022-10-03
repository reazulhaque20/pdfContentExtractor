/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdfcontentreader;

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.FilteredTextRenderListener;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.RegionTextRenderFilter;
import com.itextpdf.text.pdf.parser.RenderFilter;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import java.io.IOException;

/**
 *
 * @author Reazul-System
 */
public class ITextReader {

    public void run() {
        try {
            PdfReader pdf = new PdfReader("C:\\invoice.pdf");
            int nbrPages = pdf.getNumberOfPages();
            for (int i = 1; i <= nbrPages; i++) {
                String content = PdfTextExtractor.getTextFromPage(pdf, i);
                System.out.println("Content of the page : " + content);
            }
            pdf.close();

        } catch (IOException ex) {
        }
    }
    public void run2(){
        final float x=479.991f;
        final float y=70.80975f; 
        final float width=6; 
        final float height=5; 
        final String pdfFilePath="C:\\invoice.pdf";
        String text = null;
        try {
            final PdfReader pdfReader = new PdfReader(pdfFilePath);
            final int pageNumber = 1;//pdfViewer.getCurrentPageNumber() + 1;
            System.out.println("Page number: " + pageNumber);
            final Rectangle selection = new Rectangle(x, y, width, height);
            final RenderFilter renderFilter = new RegionTextRenderFilter(selection);
            final LocationTextExtractionStrategy delegate 
                    = new LocationTextExtractionStrategy();
            final TextExtractionStrategy extractionStrategy 
                    = new FilteredTextRenderListener(delegate, renderFilter);
            text = PdfTextExtractor.getTextFromPage(pdfReader, pageNumber, 
                                                    extractionStrategy);
            pdfReader.close();
            System.out.println(text);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
