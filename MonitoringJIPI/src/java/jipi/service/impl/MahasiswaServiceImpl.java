/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import jipi.dao.AgamaDao;
import jipi.dao.FakultasDao;
import jipi.dao.JenkelDao;
import jipi.dao.JurusanDao;
import jipi.dao.MahasiswaDao;
import jipi.dao.PendidikanDao;
import jipi.dto.MahasiswaDto;
import jipi.dto.UserDto;
import jipi.model.AgamaModel;
import jipi.model.JenkelModel;
import jipi.model.JurusanModel;
import jipi.model.MahasiswaModel;
import jipi.model.PendidikanModel;
import jipi.model.UserModel;
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
    
    @Autowired
    JenkelDao jenkelDao;
    
    @Autowired
    FakultasDao fakultasDao;
    
    @Autowired
    PendidikanDao pendidikanDao;
    
    @Autowired
    AgamaDao agamaDao;
    
    @Autowired
    JurusanDao jurusanDao;
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

    @Override
    public MahasiswaModel getMahasiswaById(String nim) {
        MahasiswaModel mahasiswaModel = null;
        try {
            mahasiswaModel = mahasiswaDao.getMahasiswaById(nim);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mahasiswaModel;
    }

    @Override
    public List<MahasiswaDto> getListAngkatan() {
        List<MahasiswaDto> listAngkatanDto = new ArrayList();
        List<Object[]> listDataObject = mahasiswaDao.getListAngkatanNativeQuery();
        if (listDataObject != null){
            for (Object[] object : listDataObject){
                MahasiswaDto dto = new MahasiswaDto();
                if (object[0] != null){
                    dto.setAngkatan(object[0].toString());
                }
                listAngkatanDto.add(dto);
            }
        }
        return listAngkatanDto;
    }

    @Override
    public List<MahasiswaDto> getListDataMahasiswaDistinctAngkatan() {
        List<MahasiswaDto> ListDto = new ArrayList<>();
        List<MahasiswaModel> data = mahasiswaDao.getListDataMahasiswaDistinctAngkatan();
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

    @Override
    public void saveDataMahasiswa(MahasiswaModel mahasiswaModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteDataMahasiswa(String nim) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MahasiswaDto getDtoMahasiswa(String nim) throws Exception {
        List<MahasiswaModel> dataList = mahasiswaDao.getListMahasiswa(nim); 
         MahasiswaDto dto = new MahasiswaDto();
         AgamaModel am = new AgamaModel();
        if(dataList != null){
            for (MahasiswaModel ddm : dataList) {       
                if(ddm.getNim() != null){
                    dto.setNim(ddm.getNim());
                }
                if(ddm.getNamamahasiswa()!=null){
                    dto.setNamamahasiswa(ddm.getNamamahasiswa());
                }
                if(ddm.getTempatlahir()!= null){
                    dto.setTempatlahir(ddm.getTempatlahir());
                }
                if(ddm.getTgllahir()!= null){
                    dto.setTgllahir(ddm.getTgllahir());
                }
                if(ddm.getKdjenkel() != null){
                    JenkelModel jenkelModel  = new JenkelModel();
                    try {
                        jenkelModel = jenkelDao.getListDataJenkelById(ddm.getKdjenkel());
                    } catch (Exception e) {
                    }
                    dto.setKdjenkel(jenkelModel.getNamajenkel());
//                    dto.setKdjenkel(ddm.getKdjenkel());
                }
                if(ddm.getKdagama()!= null){
                    try {
                        am = agamaDao.getDataAgamaById(ddm.getKdagama());
                    } catch (Exception e) {
                        
                    }
                    dto.setKdagama(am.getNamaagama());
//                    dto.setKdagama(ddm.getKdagama());
                }
                if(ddm.getAlamat()!= null){
                    dto.setAlamat(ddm.getAlamat());
                }
                if(ddm.getDaerahasal()!= null){
                    dto.setDaerahasal(ddm.getDaerahasal());
                }
                if(ddm.getAsalsekolah() != null){
                    dto.setAsalsekolah(ddm.getAsalsekolah());
                }
                if(ddm.getJurusanasalsekolah()!= null){
                    dto.setJurusanasalsekolah(ddm.getJurusanasalsekolah());
                }
                if(ddm.getNamaayah()!= null){
                    dto.setNamaayah(ddm.getNamaayah());
                }
                if(ddm.getNamaibu()!= null){
                    dto.setNamaibu(ddm.getNamaibu());
                }
                if(ddm.getPendidikanayah()!= null){
                    PendidikanModel pendidikanModel = new PendidikanModel();
                    try {
                        pendidikanModel = pendidikanDao.getDataPendidikanById(ddm.getPendidikanayah());
                    } catch (Exception e) {
                    }
                    dto.setPendidikanayah(pendidikanModel.getNamapendidikan());
//                    dto.setPendidikanayah(ddm.getPendidikanayah());
                }
                if(ddm.getPendidikanibu()!= null){
                    PendidikanModel pendidikanModel = new PendidikanModel();
                    try {
                        pendidikanModel = pendidikanDao.getDataPendidikanById(ddm.getPendidikanibu());
                    } catch (Exception e) {
                    }
                    dto.setPendidikanibu(pendidikanModel.getNamapendidikan());
//                    dto.setPendidikanibu(ddm.getPendidikanibu());
                }
                if(ddm.getAlamatortu()!= null){
                    dto.setAlamatortu(ddm.getAlamatortu());
                }
                if(ddm.getTlportu()!= null){
                    dto.setTlportu(ddm.getTlportu());
                }
                if(ddm.getAngkatan()!= null){
                    dto.setAngkatan(ddm.getAngkatan());
                }
                if(ddm.getKdjurusan() != null){
                    JurusanModel jurusan = new JurusanModel();
                    try {
                        jurusan = jurusanDao.getDataJurusanById(ddm.getKdjurusan());
                    } catch (Exception e) {
                    }
                    dto.setKdjurusan(jurusan.getNamajurusan());
                }
                if(ddm.getFoto()!= null){
                    dto.setFoto(ddm.getFoto());
                }
            }
        }
        return dto;
    }

    @Override
    public MahasiswaModel getMahasiswaByNim(String nim) throws Exception {
        MahasiswaModel mahasiswaModel = null;
        try {
            mahasiswaModel = mahasiswaDao.getMahasiswaByNim(nim);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mahasiswaModel;
    }

    @Override
    public UserDto getDataUserByNim(String nim) throws Exception {
       List<UserModel> dataList = mahasiswaDao.getDataUserByNim(nim);
        UserDto dto = new UserDto();
        if (dataList != null) {
            for (UserModel ddm : dataList) {
                if (ddm.getNim()!= null) {
                    dto.setNim(ddm.getNim());
                }
                if (ddm.getUsername()!= null) {
                    dto.setUsername(ddm.getUsername());
                }
                if (ddm.getPassword()!= null) {
                    dto.setPassword(ddm.getPassword());
                }
                if (ddm.getKduser()!= null) {
                    dto.setKduser(ddm.getKduser());
                }
                if (ddm.getKeterangan()!= null) {
                    dto.setKeterangan(ddm.getKeterangan());
                }
                if (ddm.getNip()!= null) {
                    dto.setNip(ddm.getNip());
                }
                if (ddm.getAkses()!= null) {
                    dto.setAkses(ddm.getAkses());
                }
            }
        }
        return dto; 
    }
    @Override
    public void doUpdateDataForm(UserDto userDto) throws Exception {
        System.out.println("MASUK FUNGSI DOUPDATEDATFORM"+userDto.getAkses());
        System.out.println("MASUK FUNGSI DOUPDATEDATFORM"+userDto.getNim());
        System.out.println("MASUK FUNGSI DOUPDATEDATFORM"+userDto.getNip());
        System.out.println("MASUK FUNGSI DOUPDATEDATFORM"+userDto.getUsername());
        System.out.println("MASUK FUNGSI DOUPDATEDATFORM"+userDto.getPassword());
        System.out.println("MASUK FUNGSI DOUPDATEDATFORM"+userDto.getKeterangan());
        
        UserModel ddm = new UserModel();
//        UserDto param = getDataUserByNim(userDto.getNim());
//        System.out.println("ISI PARAM : "+param.getKduser());
        try {
//            ddm.setKduser(param.getKduser());
            ddm.setUsername(userDto.getUsername());
            ddm.setPassword(userDto.getPassword());
            ddm.setAkses(userDto.getAkses());
            ddm.setNim(userDto.getNim());
            ddm.setKeterangan(userDto.getKeterangan());
            ddm.setAkses(userDto.getAkses());
            ddm.setNip(userDto.getNip());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mahasiswaDao.updateUser(ddm);
    }

    @Override
    public MahasiswaDto getDtoMahasiswaByDto(MahasiswaDto dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
