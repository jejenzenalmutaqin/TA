/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao;

import java.util.List;
import jipi.model.MahasiswaModel;

/**
 *
 * @author hp
 */
public interface MahasiswaDao {
    public List<MahasiswaModel> getListDataMahasiswa();
    public List<MahasiswaModel> getListDataMahasiswaDistinctAngkatan();
    public MahasiswaModel getMahasiswaById(String nim) throws Exception;
    public List<Object[]> getListAngkatanNativeQuery();
    public void saveDataMahasiswa(MahasiswaModel mahasiswaModel);
    public List<MahasiswaModel> getListMahasiswa(String nim);
    public void deleteDataMahasiswa(String nim);
    public MahasiswaModel getMahasiswaByNim(String nim) throws Exception;
}
