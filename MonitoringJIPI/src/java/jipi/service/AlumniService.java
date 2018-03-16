/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.service;

import java.util.List;
import jipi.dto.AlumniDto;
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
}
