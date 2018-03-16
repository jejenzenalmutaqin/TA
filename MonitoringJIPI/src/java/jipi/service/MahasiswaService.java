/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.service;

import java.util.List;
import jipi.dto.MahasiswaDto;
import jipi.model.MahasiswaModel;
import jipi.model.ProposalModel;

/**
 *
 * @author hp
 */
public interface MahasiswaService {
    public List<MahasiswaDto> getListDataMahasiswa();
    public List<MahasiswaDto> getListDataMahasiswaDistinctAngkatan();
    public List<MahasiswaDto> getListAngkatan();
    public MahasiswaModel getMahasiswaById(String nim);
    
    public void saveDataMahasiswa(MahasiswaModel mahasiswaModel);
    public void deleteDataMahasiswa(String nim);
    public MahasiswaDto getDtoMahasiswa(String nim) throws Exception;
    public MahasiswaModel getMahasiswaByNim(String nim) throws Exception;
}
