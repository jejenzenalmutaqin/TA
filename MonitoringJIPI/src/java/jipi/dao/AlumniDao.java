/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao;

import java.util.List;
import jipi.model.AlumniModel;

/**
 *
 * @author hp
 */
public interface AlumniDao {
    public void saveDataAlumni(AlumniModel alumniModel);
    public List<AlumniModel> getListDataAlumni();
    public void deleteDataAlumni(String kdalumni);
    public AlumniModel getAlumniById(String kdalumni) throws Exception;
    public List<AlumniModel> getListAlumniUpdate(String kdalumni);
    public void updateAlumni(AlumniModel alumniModel);
    public List<Object[]> getListCariDataAlumniNativeQuery(String cariBerdasarkan, String cariKey);
}
