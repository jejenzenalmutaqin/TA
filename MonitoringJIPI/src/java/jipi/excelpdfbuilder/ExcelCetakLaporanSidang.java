package jipi.excelpdfbuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class ExcelCetakLaporanSidang extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// get data model which is passed by the Spring container
		List<SidangDto> listDtoSidang = (List<SidangDto>) model.get("listDtoSidang");
		
		// create a new Excel sheet
		HSSFSheet sheet = workbook.createSheet("Daftar Pengajuan Sidang");
		sheet.setDefaultColumnWidth(30);
		CellRangeAddress mergedCell;
                mergedCell = new CellRangeAddress(0, 0, 0, 0);
                Map<String, Object> properties = new HashMap<>();
                properties.put(CellUtil.ALIGNMENT, HorizontalAlignment.LEFT);
                properties = setStylePropertiesCenter();
                String header0[]={"DAFTAR MAHASISWA PENGAJUAN SIDANG"};
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
		
		header.createCell(0).setCellValue("Kode Sidang");header.getCell(0).setCellStyle(style);
		header.createCell(1).setCellValue("Jenis Sidang");header.getCell(1).setCellStyle(style);
		header.createCell(2).setCellValue("NIM");header.getCell(2).setCellStyle(style);
		header.createCell(3).setCellValue("Nama Mahasiswa");header.getCell(3).setCellStyle(style);
		header.createCell(4).setCellValue("Tanggal Pengajuan Sidang");header.getCell(4).setCellStyle(style);
                header.createCell(5).setCellValue("Penalaah 1");header.getCell(5).setCellStyle(style);
                header.createCell(6).setCellValue("Penalaah 2");header.getCell(6).setCellStyle(style);
                header.createCell(7).setCellValue("Wakil Fakultas");header.getCell(7).setCellStyle(style);
                header.createCell(8).setCellValue("Jam Sidang");header.getCell(8).setCellStyle(style);
                header.createCell(9).setCellValue("Tanggal Sidang");header.getCell(9).setCellStyle(style);
                header.createCell(10).setCellValue("Ruangan Sidang");header.getCell(10).setCellStyle(style);
		// create data rows
		int rowCount = 4;
		
		for (SidangDto sidang : listDtoSidang) {
			HSSFRow aRow = sheet.createRow(rowCount++);
			aRow.createCell(0).setCellValue(sidang.getKdsidang());
			aRow.createCell(1).setCellValue(sidang.getKdjenissidang());
			aRow.createCell(2).setCellValue(sidang.getNim());
			aRow.createCell(3).setCellValue(sidang.getKdproposal());
                        aRow.createCell(4).setCellValue(sidang.getTglpengajuansidang());
                        aRow.createCell(5).setCellValue(sidang.getPenelaah1());
                        aRow.createCell(6).setCellValue(sidang.getPenelaah2());
                        aRow.createCell(7).setCellValue(sidang.getWakilfakultas());
                        aRow.createCell(8).setCellValue(sidang.getJamsidang());
                        aRow.createCell(9).setCellValue(sidang.getTglsidang());
                        aRow.createCell(10).setCellValue(sidang.getRuangansidang());
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