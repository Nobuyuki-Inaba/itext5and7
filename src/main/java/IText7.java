import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfTextFormField;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;

public class IText7 {
    public static void main(String[] args) throws Exception {
        PdfDocument doc = new PdfDocument(new PdfWriter("itext7_flatten.pdf"));
//        PdfPage page = doc.addNewPage();

        PdfAcroForm form = PdfAcroForm.getAcroForm(doc, true);
        PdfTextFormField nameField = PdfTextFormField.createText(doc, new Rectangle(100, 100, 161, 31), "text", "TEST");
        nameField.setFontSize(0);
        form.addField(nameField);
        form.flattenFields();

        doc.close();
    }
}