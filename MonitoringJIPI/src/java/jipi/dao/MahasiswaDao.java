/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao;

import java.util.List;
import jipi.dto.MahasiswaDto;
import jipi.dto.UserDto;
import jipi.model.MahasiswaModel;
import jipi.model.UserModel;

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
    public List<UserModel> getDataUserByNim(String nim) throws Exception;
    public void updateUser(UserModel userModel);
    public List<MahasiswaModel> getDataMhsByDto(MahasiswaDto nim) throws Exception;
}
