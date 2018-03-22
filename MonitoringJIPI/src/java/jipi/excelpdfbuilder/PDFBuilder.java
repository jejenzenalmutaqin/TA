package jipi.excelpdfbuilder;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import jipi.excelpdfbuilder.AbstractITextPdfView;
import jipi.dto.ProposalDto;

/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 * @author www.codejava.net
 *
 */
public class PDFBuilder extends AbstractITextPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc,
			PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// get data model which is passed by the Spring container
		List<ProposalDto> listDtoProposal = (List<ProposalDto>) model.get("listDtoProposal");
		
		doc.add(new Paragraph("Laporan Pengajuan Proposal Bentuk PDF"));
		
		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] {3.0f, 3.0f, 3.0f, 3.0f});
		table.setSpacingBefore(10);
		
		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);
		
		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(5);
		
		// write table header 
		cell.setPhrase(new Phrase("Kode Proposal", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Kode Jenis Proposal", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("NIM", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Judul Proposal", font));
		table.addCell(cell);
		
		// write table row data
		for (ProposalDto proposal : listDtoProposal) {
			table.addCell(proposal.getKdproposal());
			table.addCell(proposal.getKdjenisproposal());
			table.addCell(proposal.getNim());
			table.addCell(proposal.getJudulproposal());
		}
		
		doc.add(table);
		
	}

}