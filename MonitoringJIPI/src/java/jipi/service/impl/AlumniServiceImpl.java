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
import jipi.dto.AlumniViewDto;
import jipi.dto.ViewAlumniDto;
import jipi.model.AlumniModel;
import jipi.model.MahasiswaModel;
import jipi.model.ViewAlumniModel;
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
        dataModel.setTglmulaikerja(alumniDto.getTglmulaikerja());
        dataModel.setPerusahaan(alumniDto.getPerusahaan());
        dataModel.setEmailperusahaan(alumniDto.getEmailperusahaan());
        dataModel.setAlamatperusahaan(alumniDto.getAlamatperusahaan());
        dataModel.setDaerahkerja(alumniDto.getDaerahkerja());
        dataModel.setSektor(alumniDto.getSektor());
        dataModel.setProfesi(alumniDto.getProfesi());
        dataModel.setTestimoni(alumniDto.getTestimoni());
        dataModel.setFoto(alumniDto.getFoto());
        dataModel.setIntegritas(alumniDto.getIntegritas());
        dataModel.setKeahlian(alumniDto.getKeahlian());
        dataModel.setInggris(alumniDto.getInggris());
        dataModel.setTeknologi(alumniDto.getTeknologi());
        dataModel.setKomunikasi(alumniDto.getKomunikasi());
        dataModel.setKerjasama(alumniDto.getKerjasama());
        dataModel.setPengembangan(alumniDto.getPengembangan());
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
                if(ddm.getTglmulaikerja()!= null){
                    dto.setTglmulaikerja(ddm.getTglmulaikerja());
                }
                if(ddm.getPerusahaan() != null){
                    dto.setPerusahaan(ddm.getPerusahaan());
                }
                if(ddm.getEmailperusahaan() != null){
                    dto.setEmailperusahaan(ddm.getEmailperusahaan());
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
                if(ddm.getIntegritas()!= null){
                    dto.setIntegritas(ddm.getIntegritas());
                }
                if(ddm.getKeahlian()!= null){
                    dto.setKeahlian(ddm.getKeahlian());
                }
                if(ddm.getInggris()!= null){
                    dto.setInggris(ddm.getInggris());
                }
                if(ddm.getTeknologi()!= null){
                    dto.setTeknologi(ddm.getTeknologi());
                }
                if(ddm.getKomunikasi()!= null){
                    dto.setKomunikasi(ddm.getKomunikasi());
                }
                if(ddm.getKerjasama()!= null){
                    dto.setKerjasama(ddm.getKerjasama());
                }
                if(ddm.getPengembangan()!= null){
                    dto.setPengembangan(ddm.getPengembangan());
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
                if(ddm.getTglmulaikerja()!= null){
                    dto.setTglmulaikerja(ddm.getTglmulaikerja());
                }
                if(ddm.getPerusahaan() != null){
                    dto.setPerusahaan(ddm.getPerusahaan());
                }
                if(ddm.getEmailperusahaan() != null){
                    dto.setEmailperusahaan(ddm.getEmailperusahaan());
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
                if(ddm.getIntegritas()!= null){
                    dto.setIntegritas(ddm.getIntegritas());
                }
                if(ddm.getKeahlian()!= null){
                    dto.setKeahlian(ddm.getKeahlian());
                }
                if(ddm.getInggris()!= null){
                    dto.setInggris(ddm.getInggris());
                }
                if(ddm.getTeknologi()!= null){
                    dto.setTeknologi(ddm.getTeknologi());
                }
                if(ddm.getKomunikasi()!= null){
                    dto.setKomunikasi(ddm.getKomunikasi());
                }
                if(ddm.getKerjasama()!= null){
                    dto.setKerjasama(ddm.getKerjasama());
                }
                if(ddm.getPengembangan()!= null){
                    dto.setPengembangan(ddm.getPengembangan());
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
            ddm.setTglmulaikerja(alumniDto.getTglmulaikerja());
            ddm.setPerusahaan(alumniDto.getPerusahaan());
            ddm.setEmailperusahaan(alumniDto.getEmailperusahaan());
            ddm.setAlamatperusahaan(alumniDto.getAlamatperusahaan());
            ddm.setDaerahkerja(alumniDto.getDaerahkerja());
            ddm.setSektor(alumniDto.getSektor());
            ddm.setProfesi(alumniDto.getProfesi());
            ddm.setTestimoni(alumniDto.getTestimoni());
            ddm.setFoto(alumniDto.getFoto());
            ddm.setIntegritas(alumniDto.getIntegritas());
            ddm.setKeahlian(alumniDto.getKeahlian());
            ddm.setInggris(alumniDto.getInggris());
            ddm.setTeknologi(alumniDto.getTeknologi());
            ddm.setKomunikasi(alumniDto.getKomunikasi());
            ddm.setKerjasama(alumniDto.getKerjasama());
            ddm.setPengembangan(alumniDto.getPengembangan());
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
                    dto.setTglmulaikerja(object[3].toString());
                }
                if (object[4] != null){
                    dto.setPerusahaan(object[4].toString());
                }
                if (object[5] != null){
                    dto.setEmailperusahaan(object[5].toString());
                }
                if (object[6] != null){
                    dto.setAlamatperusahaan(object[6].toString());
                }
                if (object[7] != null){
                    dto.setDaerahkerja(object[7].toString());
                }
                if (object[8] != null){
                    dto.setSektor(object[8].toString());
                }
                if (object[9] != null){
                    dto.setProfesi(object[9].toString());
                }
                if (object[10] != null){
                    dto.setTestimoni(object[10].toString());
                }
                if (object[11] != null){
                    dto.setFoto(object[11].toString());
                }
                if (object[12] != null){
                    dto.setIntegritas(object[12].toString());
                }
                if (object[13] != null){
                    dto.setKeahlian(object[13].toString());
                }
                if (object[14] != null){
                    dto.setInggris(object[14].toString());
                }
                if (object[15] != null){
                    dto.setTeknologi(object[15].toString());
                }
                if (object[16] != null){
                    dto.setKomunikasi(object[16].toString());
                }
                if (object[17] != null){
                    dto.setKerjasama(object[17].toString());
                }
                if (object[18] != null){
                    dto.setPengembangan(object[18].toString());
                }
                listAlumniDto.add(dto);
            }
        }
        return listAlumniDto; 
    }
    @Override
    public List<AlumniViewDto> viewDataAlumni(String kdalumni) throws Exception {
        List<AlumniViewDto> listAlumniViewDto = new ArrayList();
        List<Object[]> listDataObject = alumniDao.getListDataAlumniNativeQuery(kdalumni);
        System.out.println("HASIL QUERY : "+listDataObject.toString());
        int stat = 0;
        if (listDataObject != null) {
            for (Object[] object : listDataObject) {
                AlumniViewDto dto = new AlumniViewDto();
                if (object[0] != null) {
                    dto.setKdalumni(object[0].toString());
                } 
                if (object[1] != null) {
                    dto.setNim(object[1].toString());
                } 
                if (object[2] != null) {
                    dto.setKdkelulusan(object[2].toString());
                } 
                if (object[3] != null) {
                    dto.setPerusahaan(object[3].toString());
                } 
                if (object[4] != null) {
                    dto.setAlamatperusahaan(object[4].toString());
                } 
                if (object[5] != null) {
                    dto.setDaerahkerja(object[5].toString());
                } 
                if (object[6] != null) {
                    dto.setSektor(object[6].toString());
                } 
                if (object[7] != null) {
                    dto.setProfesi(object[7].toString());
                } 
                if (object[8] != null) {
                    dto.setTestimoni(object[8].toString());
                } 
                if (object[9] != null) {
                    dto.setFoto(object[9].toString());
                } 
                if (object[10] != null) {
                    dto.setKdfakultas(object[10].toString());
                } 
                if (object[11] != null) {
                    dto.setNamafakultas(object[11].toString());
                } 
                if (object[12] != null) {
                    dto.setKdjurusan(object[12].toString());
                } 
                if (object[13] != null) {
                    dto.setNamajurusan(object[13].toString());
                } 
                if (object[14] != null) {
                    dto.setNamamahasiswa(object[14].toString());
                } 
                if (object[15] != null) {
                    dto.setDaerahasal(object[15].toString());
                } 
                if (object[16] != null) {
                    dto.setTempatlahir(object[16].toString());
                } 
                if (object[17] != null) {
                    dto.setTgllahir(object[17].toString());
                } 

                if (stat == 0) {
                    dto.setStatus("Belum Lengkap");
                } else {
                    dto.setStatus("Sudah Lengkap");
                }

                listAlumniViewDto.add(dto);
            }
        }
        System.out.println("");
        return listAlumniViewDto;
    }
    @Override
    public List<AlumniDto> getListDataAlumniView() {
        List<AlumniDto> ListDto = new ArrayList<>();
        List<AlumniModel> data = alumniDao.getListDataAlumni();
        int stat = 0;
        if (data != null) {
            for (AlumniModel ddm : data) {
                AlumniDto dto = new AlumniDto();
                MahasiswaModel mm = new MahasiswaModel();
                if (ddm.getKdalumni() == null || ddm.getKdalumni().equals("")) {
                    stat = 1;
                } else {
                    dto.setKdalumni(ddm.getKdalumni());
                }
                if (ddm.getNim() == null || ddm.getNim().equals("")) {
                    stat = 1;
                } else {
                    mm = mahasiswaService.getMahasiswaById(ddm.getNim());
                    dto.setNim(mm.getNamamahasiswa());
                }
                if (ddm.getKdkelulusan() == null || ddm.getKdkelulusan().equals("")) {
                    stat = 1;
                } else {
                    dto.setKdkelulusan(ddm.getKdkelulusan());
                }
                if (ddm.getPerusahaan() == null || ddm.getPerusahaan().equals("")) {
                    stat = 1;
                } else {
                    dto.setPerusahaan(ddm.getPerusahaan());
                }
                if (ddm.getAlamatperusahaan() == null || ddm.getAlamatperusahaan().equals("")) {
                    stat = 1;
                } else {
                    dto.setAlamatperusahaan(ddm.getAlamatperusahaan());
                }
                if (ddm.getDaerahkerja() == null || ddm.getDaerahkerja().equals("")) {
                    stat = 1;
                } else {
                    dto.setDaerahkerja(ddm.getDaerahkerja());
                }
                if (ddm.getSektor() == null || ddm.getSektor().equals("")) {
                    stat = 1;
                } else {
                    dto.setSektor(ddm.getSektor());
                }
                if (ddm.getProfesi() == null || ddm.getProfesi().equals("")) {
                    stat = 1;
                } else {
                    dto.setProfesi(ddm.getProfesi());
                }
                if (ddm.getTestimoni() == null || ddm.getTestimoni().equals("")) {
                    stat = 1;
                } else {
                    dto.setTestimoni(ddm.getTestimoni());
                }
                if (ddm.getFoto() == null || ddm.getFoto().equals("")) {
                    stat = 1;
                } else {
                    dto.setFoto(ddm.getFoto());
                }
                
                if (stat == 1) {
                    dto.setStatus("Belum Lengkap");
                } else {
                    dto.setStatus("Sudah Lengkap");
                }
                ListDto.add(dto);
            }
        }
        return ListDto;
    }

    @Override
    public List<AlumniDto> searchAlumniByJurusan(String jurusan, String fakultas, String angkatan) {
        List<AlumniDto> listAlumniDto = new ArrayList();
        List<Object[]> listDataObject = alumniDao.getListCariDataAlumniByJurusan(fakultas, jurusan, angkatan);
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
                if (object[10] != null){
                    dto.setTglmulaikerja(object[10].toString());
                }
                if (object[11] != null){
                    dto.setEmailperusahaan(object[11].toString());
                }
                if (object[12] != null){
                    dto.setIntegritas(object[12].toString());
                }
                if (object[13] != null){
                    dto.setKeahlian(object[13].toString());
                }
                if (object[14] != null){
                    dto.setInggris(object[14].toString());
                }
                if (object[15] != null){
                    dto.setTeknologi(object[15].toString());
                }
                if (object[16] != null){
                    dto.setKomunikasi(object[16].toString());
                }
                if (object[17] != null){
                    dto.setKerjasama(object[17].toString());
                }
                if (object[18] != null){
                    dto.setPengembangan(object[18].toString());
                }
                listAlumniDto.add(dto);
            }
        }
        return listAlumniDto;
    }
    
    @Override
    public List<ViewAlumniDto> getListPengajuanSidang(ViewAlumniDto dataFilter) {
        
        Integer angkatan=dataFilter.getAngkatan();
        String jurusan=dataFilter.getKdjurusan();
        
        
        List<ViewAlumniModel> dataList = alumniDao.getListDataAlumni(jurusan,angkatan);
        List<ViewAlumniDto> ListData = new ArrayList<>();
        if(dataList != null){
            for (ViewAlumniModel ddm : dataList) { 
                ViewAlumniDto dto= new ViewAlumniDto();
                if(ddm.getNim()!= null){
                    dto.setNim((String) ddm.getNim());
                }
                if(ddm.getNamamahasiswa() !=null){
                    dto.setNamamahasiswa((String)ddm.getNamamahasiswa());
                }
                if(ddm.getNamafakultas() != null){
                    dto.setNamafakultas((String) ddm.getNamafakultas());
                }
                if(ddm.getTgllulus()!= null){
                    dto.setTgllulus((String) ddm.getTgllulus());
                }
                if(ddm.getAngkatan()!=null){
                    dto.setAngkatan((Integer) ddm.getAngkatan());
                }
                if(ddm.getPerusahaan()!=null){
                    dto.setPerusahaan((String) ddm.getPerusahaan());
                }
                if(ddm.getIpk()!= 0){
                    dto.setIpk((double) ddm.getIpk());
                }
                if(ddm.getProfesi()!=null){
                    dto.setProfesi((String) ddm.getProfesi());
                }
                if(ddm.getAlamatperusahaan()!= null){
                    dto.setAlamatperusahaan((String) ddm.getAlamatperusahaan());
                }
                if(ddm.getSektor()!=null){
                    dto.setSektor((String) ddm.getSektor());
                }
                if(ddm.getTgllulus()!= null){
                    dto.setTgllulus((String) ddm.getTgllulus());
                }
                ListData.add(dto);
            }
        }
        return ListData;

    }
    
}
