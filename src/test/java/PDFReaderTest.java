import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import junit.framework.Assert;

public class PDFReaderTest {

	public static void main(String[] args) throws IOException {
		
		
		URL url= new URL("https://www.medibuddy.in/assets/claimForms/reimbursement-claim-form.pdf");
		InputStream is = url.openStream();
		BufferedInputStream buf= new BufferedInputStream(is);
		
		PDDocument doc= null;
		doc= PDDocument.load(buf);
		
		String pdfContent= new PDFTextStripper().getText(doc);
		System.out.println(pdfContent);
		
		Assert.assertTrue(pdfContent.contains("GUIDANCE FOR FILLING CLAIM FORM"));
		
		

	}

}
