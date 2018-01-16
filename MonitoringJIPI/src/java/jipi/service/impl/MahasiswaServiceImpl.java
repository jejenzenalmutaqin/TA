/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import jipi.dao.MahasiswaDao;
import jipi.dto.MahasiswaDto;
import jipi.model.MahasiswaModel;
import jipi.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@Transactional
public class MahasiswaServiceImpl implements MahasiswaService{
    @Autowired
    MahasiswaDao mahasiswaDao;
    @Override
    public List<MahasiswaDto> getListDataMahasiswa() {
        List<MahasiswaDto> ListDto = new ArrayList<>();
        List<MahasiswaModel> data = mahasiswaDao.getListDataMahasiswa();
        if(data != null){
            for (MahasiswaModel ddm : data) {
                MahasiswaDto dto = new MahasiswaDto();
                if(ddm.getNim() != null){
                    dto.setNim(ddm.getNim());
                }
                if(ddm.getNamamahasiswa() != null){
                    dto.setNamamahasiswa(ddm.getNamamahasiswa());
                }
                if(ddm.getTempatlahir() != null){
                    dto.setTempatlahir(ddm.getTempatlahir());
                }
                if(ddm.getTgllahir() != null){
                    dto.setTgllahir(ddm.getTgllahir());
                }
                if(ddm.getKdjenkel() != null){
                    dto.setKdjenkel(ddm.getKdjenkel());
                }
                if(ddm.getKdagama() != null){
                    dto.setKdagama(ddm.getKdagama());
                }
                if(ddm.getAlamat() != null){
                    dto.setAlamat(ddm.getAlamat());
                }
                if(ddm.getDaerahasal() != null){
                    dto.setDaerahasal(ddm.getDaerahasal());
                }
                if(ddm.getAsalsekolah() != null){
                    dto.setAsalsekolah(ddm.getAsalsekolah());
                }
                if(ddm.getJurusanasalsekolah() != null){
                    dto.setJurusanasalsekolah(ddm.getJurusanasalsekolah());
                }
                if(ddm.getNamaayah() != null){
                    dto.setNamaayah(ddm.getNamaayah());
                }
                if(ddm.getNamaibu() != null){
                    dto.setNamaibu(ddm.getNamaibu());
                }
                if(ddm.getPendidikanayah() != null){
                    dto.setPendidikanayah(ddm.getPendidikanayah());
                }
                if(ddm.getPendidikanibu() != null){
                    dto.setPendidikanibu(ddm.getPendidikanibu());
                }
                if(ddm.getAlamatortu() != null){
                    dto.setAlamatortu(ddm.getAlamatortu());
                }
                if(ddm.getTlportu() != null){
                    dto.setTlportu(ddm.getTlportu());
                }
                if(ddm.getAngkatan()!= null){
                    dto.setAngkatan(ddm.getAngkatan());
                }
                if(ddm.getKdjurusan() != null){
                    dto.setKdjurusan(ddm.getKdjurusan());
                }
                
                ListDto.add(dto);
            }
        }
        return ListDto;
    }
    
}
