/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao;

import java.util.List;
import jipi.model.KelulusanModel;
import jipi.model.ViewKelulusanModel;

/**
 *
 * @author hp
 */
public interface KelulusanDao {
    public void saveDataKelulusan(KelulusanModel kelulusanModel);
    public List<KelulusanModel> getListDataKelulusan();
    public void deleteDataKelulusan(String kdkelulusan);
    public KelulusanModel getKelulusanById(String kdkelulusan) throws Exception;
    public List<KelulusanModel> getListKelulusanUpdate(String kdkelulusan);
    public void updateKelulusan(KelulusanModel kelulusanModel);
    public List<Object[]> getListCariDataKelulusanNativeQuery(String cariBerdasarkan, String cariKey);
    public List<ViewKelulusanModel> getListDataKelulusan(String fJurusan,Integer fAngkatan);
}
