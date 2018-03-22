package jipi.excelpdfbuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jipi.dto.AlumniDto;
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
public class ExcelCetakLaporanAlumni extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// get data model which is passed by the Spring container
		List<AlumniDto> listDtoAlumni = (List<AlumniDto>) model.get("listDtoAlumni");
		
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
		
		header.createCell(0).setCellValue("Kode Alumni");header.getCell(0).setCellStyle(style);
		header.createCell(1).setCellValue("NIM");header.getCell(1).setCellStyle(style);
		header.createCell(2).setCellValue("Nama Mahasiswa");header.getCell(2).setCellStyle(style);
		header.createCell(3).setCellValue("Tanggal Mulai Bekerja");header.getCell(3).setCellStyle(style);
		header.createCell(4).setCellValue("Perusahaan");header.getCell(4).setCellStyle(style);
                header.createCell(5).setCellValue("Alamat Perusahaan");header.getCell(5).setCellStyle(style);
                header.createCell(6).setCellValue("Email Perusahaan");header.getCell(6).setCellStyle(style);
                header.createCell(7).setCellValue("Daerah Kerja");header.getCell(7).setCellStyle(style);
                header.createCell(8).setCellValue("Sektor");header.getCell(8).setCellStyle(style);
                
                header.createCell(9).setCellValue("Profesi");header.getCell(9).setCellStyle(style);
                header.createCell(10).setCellValue("Testimoni");header.getCell(10).setCellStyle(style);
                header.createCell(11).setCellValue("Integritas");header.getCell(11).setCellStyle(style);
                header.createCell(12).setCellValue("Keahlian");header.getCell(12).setCellStyle(style);
                header.createCell(13).setCellValue("Inggris");header.getCell(13).setCellStyle(style);
                header.createCell(14).setCellValue("Teknologi");header.getCell(14).setCellStyle(style);
                header.createCell(15).setCellValue("Komunikasi");header.getCell(15).setCellStyle(style);
                header.createCell(16).setCellValue("Kerjasama");header.getCell(16).setCellStyle(style);
                header.createCell(17).setCellValue("Pengembangan");header.getCell(17).setCellStyle(style);
		// create data rows
		int rowCount = 4;
		
		for (AlumniDto alumni : listDtoAlumni) {
			HSSFRow aRow = sheet.createRow(rowCount++);
			aRow.createCell(0).setCellValue(alumni.getKdalumni());
			aRow.createCell(1).setCellValue(alumni.getNim());
			aRow.createCell(2).setCellValue(alumni.getKdkelulusan());
			aRow.createCell(3).setCellValue(alumni.getTglmulaikerja());
                        aRow.createCell(4).setCellValue(alumni.getPerusahaan());
                        aRow.createCell(5).setCellValue(alumni.getAlamatperusahaan());
                        aRow.createCell(6).setCellValue(alumni.getEmailperusahaan());
                        aRow.createCell(7).setCellValue(alumni.getDaerahkerja());
                        aRow.createCell(8).setCellValue(alumni.getSektor());
                        
                        aRow.createCell(9).setCellValue(alumni.getProfesi());
                        aRow.createCell(10).setCellValue(alumni.getTestimoni());
                        aRow.createCell(11).setCellValue(alumni.getIntegritas());
                        aRow.createCell(12).setCellValue(alumni.getKeahlian());
                        aRow.createCell(13).setCellValue(alumni.getInggris());
                        aRow.createCell(14).setCellValue(alumni.getTeknologi());
                        aRow.createCell(15).setCellValue(alumni.getKomunikasi());
                        aRow.createCell(16).setCellValue(alumni.getKerjasama());
                        aRow.createCell(17).setCellValue(alumni.getPengembangan());
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