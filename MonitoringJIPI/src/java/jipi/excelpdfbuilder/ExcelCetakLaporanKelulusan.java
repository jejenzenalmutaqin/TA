package jipi.excelpdfbuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jipi.dto.KelulusanDto;
import jipi.dto.ProposalDto;
import jipi.dto.SidangDto;

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
public class ExcelCetakLaporanKelulusan extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// get data model which is passed by the Spring container
		List<KelulusanDto> listDtoKelulusan = (List<KelulusanDto>) model.get("listDtoKelulusan");
		
		// create a new Excel sheet
		HSSFSheet sheet = workbook.createSheet("Daftar Data Kelulusan");
		sheet.setDefaultColumnWidth(30);
		CellRangeAddress mergedCell;
                mergedCell = new CellRangeAddress(0, 0, 0, 0);
                Map<String, Object> properties = new HashMap<>();
                properties.put(CellUtil.ALIGNMENT, HorizontalAlignment.LEFT);
                properties = setStylePropertiesCenter();
                String header0[]={"DAFTAR DATA KELULUSAN"};
                String header1[]={"UNIVERSITAS NASIONAL PASIM"};
                
                properties=setStylePropertiesCenter();
		mergedCell = new CellRangeAddress(0, 0 , 0, 11);
		sheet.addMergedRegion(mergedCell);
                setValueRowHeader(sheet, 0, 0, header0, properties);
                mergedCell = new CellRangeAddress(1, 1 , 0, 11);
		sheet.addMergedRegion(mergedCell);
                setValueRowHeader(sheet, 1, 0, header1, properties);
                
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
		HSSFRow header = sheet.createRow(3);
		
		header.createCell(0).setCellValue("Kode Kelulusan");header.getCell(0).setCellStyle(style);
		header.createCell(1).setCellValue("NIM");header.getCell(1).setCellStyle(style);
		header.createCell(2).setCellValue("Nama Mahasiswa");header.getCell(2).setCellStyle(style);
		header.createCell(3).setCellValue("Tanggal Lulus");header.getCell(3).setCellStyle(style);
		header.createCell(4).setCellValue("IPK");header.getCell(4).setCellStyle(style);
                header.createCell(5).setCellValue("Revisi");header.getCell(5).setCellStyle(style);
                header.createCell(6).setCellValue("Mulai Revisi");header.getCell(6).setCellStyle(style);
                header.createCell(7).setCellValue("Akhir Revisi");header.getCell(7).setCellStyle(style);
                header.createCell(8).setCellValue("Penyelesaian Revisi");header.getCell(8).setCellStyle(style);
		// create data rows
		int rowCount = 4;
		
		for (KelulusanDto lulus : listDtoKelulusan) {
			HSSFRow aRow = sheet.createRow(rowCount++);
			aRow.createCell(0).setCellValue(lulus.getKdkelulusan());
			aRow.createCell(1).setCellValue(lulus.getNim());
			aRow.createCell(2).setCellValue(lulus.getKdsidang());
			aRow.createCell(3).setCellValue(lulus.getTgllulus());
                        aRow.createCell(4).setCellValue(lulus.getIpk());
                        aRow.createCell(5).setCellValue(lulus.getRevisi());
                        aRow.createCell(6).setCellValue(lulus.getMulairevisi());
                        aRow.createCell(7).setCellValue(lulus.getAkhirrevisi());
                        aRow.createCell(8).setCellValue(lulus.getPenyerahanrevisi());
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