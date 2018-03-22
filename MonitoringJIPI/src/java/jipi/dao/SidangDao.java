/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao;

import java.util.List;
import jipi.model.SidangModel;

/**
 *
 * @author hp
 */
public interface SidangDao {
    public void saveDataSidang(SidangModel sidangModel);
    public List<SidangModel> getListDataSidang();
    public void deleteDataSidang(String kdsidang);
    public SidangModel getSidangById(String kdsidang) throws Exception;
    public List<SidangModel> getListSidangUpdate(String kdsidang);
    public void updateSidang(SidangModel sidangModel);
    public List<Object[]> getListCariDataSidangNativeQuery(String cariBerdasarkan, String cariKey);
    public List<Object[]> getListDataSidangForReport(String fakultas_filter, String jurusan_filter, String jenis_filter, String angkatan_filter, String urut_filter);

}
