/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.service;

import java.util.List;
import jipi.dto.AlumniDto;
import jipi.dto.AlumniViewDto;
import jipi.dto.ViewAlumniDto;
import jipi.model.AlumniModel;

/**
 *
 * @author hp
 */
public interface AlumniService {
    public void saveDataAlumni(AlumniDto alumniDto) throws Exception;
    public List<AlumniDto> getListDataAlumni();
    public void deleteDataAlumni(String kdalumni) throws Exception;
    public AlumniModel getAlumniById(String kdalumni);
    public AlumniDto updateDataForm(String kdalumni) throws Exception;
    public void doUpdateDataForm(AlumniDto alumniDto) throws Exception;
    public List<AlumniDto> searchAlumni(String cariBerdasarkan, String cariKey);
    public List<AlumniViewDto> viewDataAlumni(String kdalumni) throws Exception;
    public List<AlumniDto> getListDataAlumniView();
    public List<AlumniDto> searchAlumniByJurusan(String jurusan, String fakultas, String angkatan);
    public List<AlumniDto> getListDataAlumniByFilterForReport(String fakultas_filter, String jurusan_filter, String angkatan_filter);
    public List<ViewAlumniDto> getListPengajuanSidang(ViewAlumniDto dataFilter);
}
