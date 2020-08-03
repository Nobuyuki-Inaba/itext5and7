import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.TextField;

public class IText5 {
    public static void main(String[] args) throws Exception {
        Document doc = new Document(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("itext5.pdf"));
        writer.setPdfVersion(PdfWriter.VERSION_1_7);
        writer.setTagged();
        doc.open();
        doc.addTitle("itext5 sample");

        TextField tf = new TextField(writer, new Rectangle(100, 100, 261, 131), "text");
        tf.setTextColor(BaseColor.BLACK);
        tf.setFontSize(0);
        tf.setText("TEST");

        writer.addAnnotation(tf.getTextField());
        doc.close();

        PdfReader reader = new PdfReader("itext5.pdf");
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("itext5_flatten.pdf"));
        stamper.setFormFlattening(true);
        stamper.close();
    }
}