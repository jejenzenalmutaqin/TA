/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.service;

import java.util.List;
import jipi.dto.KelulusanDto;
import jipi.dto.ViewKelulusanDto;
import jipi.model.KelulusanModel;

/**
 *
 * @author hp
 */
public interface KelulusanService {
    public void saveDataKelulusan(KelulusanDto kelulusanDto) throws Exception;
    public List<KelulusanDto> getListDataKelulusan();
    public void deleteDataKelulusan(String kdkelulusan) throws Exception;
    public KelulusanModel getKelulusanById(String kdkelulusan);
    public KelulusanDto updateDataForm(String kdkelulusan) throws Exception;
    public void doUpdateDataForm(KelulusanDto kelulusanDto) throws Exception;
    public List<KelulusanDto> searchKelulusan(String cariBerdasarkan, String cariKey);
    public List<KelulusanDto> getListDataKelulusanByFilterForReport(String fakultas_filter, String jurusan_filter, String angkatan_filter);
    public List<ViewKelulusanDto> getListKelulusan(ViewKelulusanDto dataFilter);

}
