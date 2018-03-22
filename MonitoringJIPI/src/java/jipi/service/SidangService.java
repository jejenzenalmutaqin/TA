/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.service;

import java.util.List;
import jipi.dto.SidangDto;
import jipi.model.SidangModel;

/**
 *
 * @author hp
 */
public interface SidangService {
    public void saveDataSidang(SidangDto sidangDto) throws Exception;
    public List<SidangDto> getListDataSidang();
    public void deleteDataSidang(String kdsidang) throws Exception;
    public SidangModel getSidangById(String kdsidang);
    public SidangDto updateDataForm(String kdsidang) throws Exception;
    public void doUpdateDataForm(SidangDto sidangDto) throws Exception;
    public List<SidangDto> searchSidang(String cariBerdasarkan, String cariKey);
    public List<SidangDto> getListDataSidangByFilterForReport(String fakultas_filter, String jurusan_filter, String jenis_filter, String angkatan_filter, String urut_filter);

}
