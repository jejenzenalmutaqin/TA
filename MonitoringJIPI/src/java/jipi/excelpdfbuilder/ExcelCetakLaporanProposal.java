package jipi.excelpdfbuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jipi.dto.ProposalDto;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FontFormatting;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.springframework.web.servlet.view.document.AbstractExcelView;

/**
 * This class builds an Excel spreadsheet document using Apache POI library.
 * @author www.codejava.net
 *
 */
public class ExcelCetakLaporanProposal extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// get data model which is passed by the Spring container
		List<ProposalDto> listDtoProposal = (List<ProposalDto>) model.get("listDtoProposal");
		
		// create a new Excel sheet
		HSSFSheet sheet = workbook.createSheet("Daftar Pengajuan Proposal");
		sheet.setDefaultColumnWidth(30);
		CellRangeAddress mergedCell;
                mergedCell = new CellRangeAddress(0, 0, 0, 0);
                Map<String, Object> properties = new HashMap<>();
                properties.put(CellUtil.ALIGNMENT, HorizontalAlignment.LEFT);
                properties = setStylePropertiesCenter();
                String header0[]={"DAFTAR MAHASISWA PENGAJUAN PROPOSAL"};
                String header1[]={"UNIVERSITAS NASIONAL PASIM"};
                
                String header3[]={"Filter Berdasarkan: "};
                String header4[]={"Fakultas",""};
                String header5[]={"Jurusan",""};
                String header6[]={"Angkatan",""};
                String header7[]={"Pengajuan",""};
                properties=setStylePropertiesCenter();
		mergedCell = new CellRangeAddress(0, 0 , 0, 11);
		sheet.addMergedRegion(mergedCell);
                setValueRowHeader(sheet, 0, 0, header0, properties);
                mergedCell = new CellRangeAddress(1, 1 , 0, 11);
		sheet.addMergedRegion(mergedCell);
                setValueRowHeader(sheet, 1, 0, header1, properties);
                setValueRowHeader(sheet, 3, 0, header3, properties);
                setValueRowHeader(sheet, 4, 0, header4, properties);
                setValueRowHeader(sheet, 5, 0, header5, properties);
                setValueRowHeader(sheet, 6, 0, header6, properties);
                setValueRowHeader(sheet, 7, 0, header7, properties);
                
		// create style for header cells
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.GREEN.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);	
		// create header row
		HSSFRow header = sheet.createRow(9);
		
		header.createCell(0).setCellValue("Kode Proposal");header.getCell(0).setCellStyle(style);
		header.createCell(1).setCellValue("Jenis Proposal");header.getCell(1).setCellStyle(style);
		header.createCell(2).setCellValue("NIM");header.getCell(2).setCellStyle(style);
		header.createCell(3).setCellValue("Nama Mahasiswa");header.getCell(3).setCellStyle(style);
		header.createCell(4).setCellValue("Judul Proposal");header.getCell(4).setCellStyle(style);
                header.createCell(5).setCellValue("SKS Sudah Tempuh");header.getCell(5).setCellStyle(style);
                header.createCell(6).setCellValue("SKS Proposal");header.getCell(6).setCellStyle(style);
                header.createCell(7).setCellValue("Tanggal Pengajuan Proposal");header.getCell(7).setCellStyle(style);
                header.createCell(8).setCellValue("IPK");header.getCell(8).setCellStyle(style);
                header.createCell(9).setCellValue("Status Penyusunan");header.getCell(9).setCellStyle(style);
                header.createCell(10).setCellValue("Dosen Pembimbing");header.getCell(10).setCellStyle(style);
                header.createCell(11).setCellValue("Email");header.getCell(11).setCellStyle(style);
		// create data rows
		int rowCount = 10;
		
		for (ProposalDto proposal : listDtoProposal) {
			HSSFRow aRow = sheet.createRow(rowCount++);
			aRow.createCell(0).setCellValue(proposal.getKdproposal());
			aRow.createCell(1).setCellValue(proposal.getKdjenisproposal());
			aRow.createCell(2).setCellValue(proposal.getNim());
			aRow.createCell(3).setCellValue(proposal.getPerubahanjudul());
                        aRow.createCell(4).setCellValue(proposal.getJudulproposal());
                        aRow.createCell(5).setCellValue(proposal.getSkssudahtempuh());
                        aRow.createCell(6).setCellValue(proposal.getSksproposal());
                        aRow.createCell(7).setCellValue(proposal.getTglpengajuanproposal());
                        aRow.createCell(8).setCellValue(proposal.getIpk());
                        aRow.createCell(9).setCellValue(proposal.getStatusproposal());
                        aRow.createCell(10).setCellValue(proposal.getDosenpembimbing());
                        aRow.createCell(11).setCellValue(proposal.getEmail());
		}
                

	}
        
        public void setValueRowHeader(HSSFSheet sheet, int row, int column, String items[], Map<String, Object> properties){
		Row rowHeader = sheet.createRow(row);
		rowHeader.setHeight((short)+400);
		Cell cellHeader;
		int cellIndx = column;
		for (String value : items) {
			cellHeader = rowHeader.createCell(cellIndx++);
			cellHeader.setCellValue(value);	
			//CellUtil.setCellStyleProperties(cellHeader, properties);
		}			
	}
        
        public Map<String, Object> setStylePropertiesCenter(){
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put(CellUtil.FONT, FontFormatting.U_DOUBLE);
		properties.put(CellUtil.ALIGNMENT, HorizontalAlignment.CENTER);
		properties.put(CellUtil.VERTICAL_ALIGNMENT, VerticalAlignment.CENTER);
		return properties;		
	}
        public Map<String, Object> setStylePropertiesLeft(){
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put(CellUtil.FONT, FontFormatting.U_DOUBLE);
		properties.put(CellUtil.ALIGNMENT, HorizontalAlignment.LEFT);
		properties.put(CellUtil.VERTICAL_ALIGNMENT, VerticalAlignment.CENTER);
		return properties;		
	}

}