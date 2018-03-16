/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import jipi.dao.AlumniDao;
import jipi.dto.AlumniDto;
import jipi.model.AlumniModel;
import jipi.model.MahasiswaModel;
import jipi.service.AlumniService;
import jipi.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@Transactional
public class AlumniServiceImpl implements AlumniService{
    @Autowired
    AlumniDao alumniDao;
    
    @Autowired
    MahasiswaService mahasiswaService;
    
    @Override
    public void saveDataAlumni(AlumniDto alumniDto) throws Exception {
        AlumniModel dataModel = new AlumniModel();
        
        dataModel.setKdalumni(alumniDto.getKdalumni());
        dataModel.setNim(alumniDto.getNim());
        dataModel.setKdkelulusan(alumniDto.getKdkelulusan());
        dataModel.setPerusahaan(alumniDto.getPerusahaan());
        dataModel.setAlamatperusahaan(alumniDto.getAlamatperusahaan());
        dataModel.setDaerahkerja(alumniDto.getDaerahkerja());
        dataModel.setSektor(alumniDto.getSektor());
        dataModel.setProfesi(alumniDto.getProfesi());
        dataModel.setTestimoni(alumniDto.getTestimoni());
        dataModel.setFoto(alumniDto.getFoto());
        alumniDao.saveDataAlumni(dataModel);
    }

    @Override
    public List<AlumniDto> getListDataAlumni() {
        List<AlumniDto> ListDto = new ArrayList<>();
        List<AlumniModel> data = alumniDao.getListDataAlumni();
        if(data != null){
            for (AlumniModel ddm : data) {
                AlumniDto dto = new AlumniDto();
                MahasiswaModel mm = new MahasiswaModel();
                if(ddm.getKdalumni() != null){
                    dto.setKdalumni(ddm.getKdalumni());
                }
                if(ddm.getNim() != null){
                    mm = mahasiswaService.getMahasiswaById(ddm.getNim());
                    dto.setNim(mm.getNamamahasiswa());
                }
                if(ddm.getKdkelulusan() != null){
                    dto.setKdkelulusan(ddm.getKdkelulusan());
                }
                if(ddm.getPerusahaan() != null){
                    dto.setPerusahaan(ddm.getPerusahaan());
                }
                if(ddm.getAlamatperusahaan() != null){
                    dto.setAlamatperusahaan(ddm.getAlamatperusahaan());
                }
                if(ddm.getDaerahkerja() != null){
                    dto.setDaerahkerja(ddm.getDaerahkerja());
                }
                if(ddm.getSektor() != null){
                    dto.setSektor(ddm.getSektor());
                }
                if(ddm.getProfesi() != null){
                    dto.setProfesi(ddm.getProfesi());
                }
                if(ddm.getTestimoni() != null){
                    dto.setTestimoni(ddm.getTestimoni());
                }
                if(ddm.getFoto() != null){
                    dto.setFoto(ddm.getFoto());
                }
                ListDto.add(dto);
            }
        }
        return ListDto;
    }

    @Override
    public void deleteDataAlumni(String kdalumni) throws Exception {
        try {
            alumniDao.deleteDataAlumni(kdalumni);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public AlumniModel getAlumniById(String kdalumni) {
        AlumniModel alumniModel = null;
        try {
            alumniModel = alumniDao.getAlumniById(kdalumni);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alumniModel;
    }

    @Override
    public AlumniDto updateDataForm(String kdalumni) throws Exception {
        List<AlumniModel> dataList = alumniDao.getListAlumniUpdate(kdalumni);
         AlumniDto dto = new AlumniDto();
        if(dataList != null){
            for (AlumniModel ddm : dataList) {       
                if(ddm.getKdalumni() != null){
                    dto.setKdalumni(ddm.getKdalumni());
                }
                if(ddm.getNim() != null){
                    dto.setNim(ddm.getNim());
                }
                if(ddm.getKdkelulusan() != null){
                    dto.setKdkelulusan(ddm.getKdkelulusan());
                }
                if(ddm.getPerusahaan() != null){
                    dto.setPerusahaan(ddm.getPerusahaan());
                }
                if(ddm.getAlamatperusahaan() != null){
                    dto.setAlamatperusahaan(ddm.getAlamatperusahaan());
                }
                if(ddm.getDaerahkerja() != null){
                    dto.setDaerahkerja(ddm.getDaerahkerja());
                }
                if(ddm.getSektor() != null){
                    dto.setSektor(ddm.getSektor());
                }
                if(ddm.getProfesi() != null){
                    dto.setProfesi(ddm.getProfesi());
                }
                if(ddm.getTestimoni() != null){
                    dto.setTestimoni(ddm.getTestimoni());
                }
                if(ddm.getFoto() != null){
                    dto.setFoto(ddm.getFoto());
                }
            }
        }
        return dto;
    }

    @Override
    public void doUpdateDataForm(AlumniDto alumniDto) throws Exception {
        AlumniModel ddm = new AlumniModel();
        try {
            ddm.setKdalumni(alumniDto.getKdalumni());
            ddm.setNim(alumniDto.getNim());
            ddm.setKdkelulusan(alumniDto.getKdkelulusan());
            ddm.setPerusahaan(alumniDto.getPerusahaan());
            ddm.setAlamatperusahaan(alumniDto.getAlamatperusahaan());
            ddm.setDaerahkerja(alumniDto.getDaerahkerja());
            ddm.setSektor(alumniDto.getSektor());
            ddm.setProfesi(alumniDto.getProfesi());
            ddm.setTestimoni(alumniDto.getTestimoni());
            ddm.setFoto(alumniDto.getFoto());
        } catch (Exception e) {
            e.printStackTrace();
        }
        alumniDao.updateAlumni(ddm);
    }

    @Override
    public List<AlumniDto> searchAlumni(String cariBerdasarkan, String cariKey) {
        List<AlumniDto> listAlumniDto = new ArrayList();
        List<Object[]> listDataObject = alumniDao.getListCariDataAlumniNativeQuery(cariBerdasarkan, cariKey);
        if (listDataObject != null){
            for (Object[] object : listDataObject){
                AlumniDto dto = new AlumniDto();
                MahasiswaModel mm = new MahasiswaModel();
                if (object[0] != null){
                    dto.setKdalumni(object[0].toString());
                }
                if (object[1] != null){
                    mm = mahasiswaService.getMahasiswaById(object[1].toString());
                    dto.setNim(mm.getNamamahasiswa());
                }
                if (object[2] != null){
                    dto.setKdkelulusan(object[2].toString());
                }
                if (object[3] != null){
                    dto.setPerusahaan(object[3].toString());
                }
                if (object[4] != null){
                    dto.setAlamatperusahaan(object[4].toString());
                }
                if (object[5] != null){
                    dto.setDaerahkerja(object[5].toString());
                }
                if (object[6] != null){
                    dto.setSektor(object[6].toString());
                }
                if (object[7] != null){
                    dto.setProfesi(object[7].toString());
                }
                if (object[8] != null){
                    dto.setTestimoni(object[8].toString());
                }
                if (object[9] != null){
                    dto.setFoto(object[9].toString());
                }
                listAlumniDto.add(dto);
            }
        }
        return listAlumniDto; 
    }
    
}
