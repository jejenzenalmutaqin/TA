/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import jipi.dao.KelulusanDao;
import jipi.dto.KelulusanDto;
import jipi.model.KelulusanModel;
import jipi.model.MahasiswaModel;
import jipi.model.SidangModel;
import jipi.service.KelulusanService;
import jipi.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@Transactional
public class KelulusanServiceImpl implements KelulusanService{

    @Autowired
    KelulusanDao kelulusanDao;
    
    @Autowired
    MahasiswaService mahasiswaService;
    
    @Override
    public void saveDataKelulusan(KelulusanDto kelulusanDto) throws Exception {
        KelulusanModel dataModel = new KelulusanModel();
        dataModel.setKdkelulusan(kelulusanDto.getKdkelulusan());
        dataModel.setNim(kelulusanDto.getNim());
        dataModel.setKdsidang(kelulusanDto.getKdsidang());
        dataModel.setTgllulus(kelulusanDto.getTgllulus());
        dataModel.setIpk(kelulusanDto.getIpk());
        dataModel.setRevisi(kelulusanDto.getRevisi());
        dataModel.setMulairevisi(kelulusanDto.getMulairevisi());
        dataModel.setAkhirrevisi(kelulusanDto.getAkhirrevisi());
        dataModel.setPenyerahanrevisi(kelulusanDto.getPenyerahanrevisi());
        kelulusanDao.saveDataKelulusan(dataModel);
    }

    @Override
    public List<KelulusanDto> getListDataKelulusan() {
        List<KelulusanDto> ListDto = new ArrayList<>();
        List<KelulusanModel> data = kelulusanDao.getListDataKelulusan();
        MahasiswaModel mm = new MahasiswaModel();
        if(data != null){
            for (KelulusanModel ddm : data) {
                KelulusanDto dto = new KelulusanDto();
                if(ddm.getKdkelulusan() != null){
                    dto.setKdkelulusan(ddm.getKdkelulusan());
                }
                if(ddm.getNim() != null){
                    mm = mahasiswaService.getMahasiswaById(ddm.getNim());
                    dto.setNim(mm.getNamamahasiswa());
                }
                if(ddm.getKdsidang() != null){
                    dto.setKdsidang(ddm.getKdsidang());
                }
                if(ddm.getTgllulus() != null){
                    dto.setTgllulus(ddm.getTgllulus());
                }
//                if(ddm.getIpk() != null){
                    dto.setIpk(ddm.getIpk());
//                }
                if(ddm.getRevisi() != null){
                    dto.setRevisi(ddm.getRevisi());
                }
                if(ddm.getMulairevisi() != null){
                    dto.setMulairevisi(ddm.getMulairevisi());
                }
                if(ddm.getAkhirrevisi() != null){
                    dto.setAkhirrevisi(ddm.getAkhirrevisi());
                }
                if(ddm.getPenyerahanrevisi() != null){
                    dto.setPenyerahanrevisi(ddm.getPenyerahanrevisi());
                }
                ListDto.add(dto);
            }
        }
        return ListDto;
    }

    @Override
    public void deleteDataKelulusan(String kdkelulusan) throws Exception {
        try {
            kelulusanDao.deleteDataKelulusan(kdkelulusan);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public KelulusanModel getKelulusanById(String kdkelulusan) {
        KelulusanModel kelulusanModel = null;
        try {
            kelulusanModel = kelulusanDao.getKelulusanById(kdkelulusan);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kelulusanModel;
    }

    @Override
    public KelulusanDto updateDataForm(String kdkelulusan) throws Exception {
        KelulusanDto dto = new KelulusanDto();
        List<KelulusanModel> data = kelulusanDao.getListKelulusanUpdate(kdkelulusan);
        if(data != null){
            for (KelulusanModel ddm : data) {
                if(ddm.getKdkelulusan() != null){
                    dto.setKdkelulusan(ddm.getKdkelulusan());
                }
                if(ddm.getNim() != null){
                    dto.setNim(ddm.getNim());
                }
                if(ddm.getKdsidang() != null){
                    dto.setKdsidang(ddm.getKdsidang());
                }
                if(ddm.getTgllulus() != null){
                    dto.setTgllulus(ddm.getTgllulus());
                }
//                if(ddm.getIpk() != null){
                    dto.setIpk(ddm.getIpk());
//                }
                if(ddm.getRevisi() != null){
                    dto.setRevisi(ddm.getRevisi());
                }
                if(ddm.getMulairevisi() != null){
                    dto.setMulairevisi(ddm.getMulairevisi());
                }
                if(ddm.getAkhirrevisi() != null){
                    dto.setAkhirrevisi(ddm.getAkhirrevisi());
                }
                if(ddm.getPenyerahanrevisi() != null){
                    dto.setPenyerahanrevisi(ddm.getPenyerahanrevisi());
                }
            }
        }
        return dto;
    }

    @Override
    public void doUpdateDataForm(KelulusanDto kelulusanDto) throws Exception {
        KelulusanModel dataModel = new KelulusanModel();
        try {
            dataModel.setKdkelulusan(kelulusanDto.getKdkelulusan());
            dataModel.setNim(kelulusanDto.getNim());
            dataModel.setKdsidang(kelulusanDto.getKdsidang());
            dataModel.setTgllulus(kelulusanDto.getTgllulus());
            dataModel.setIpk(kelulusanDto.getIpk());
            dataModel.setRevisi(kelulusanDto.getRevisi());
            dataModel.setMulairevisi(kelulusanDto.getMulairevisi());
            dataModel.setAkhirrevisi(kelulusanDto.getAkhirrevisi());
            dataModel.setPenyerahanrevisi(kelulusanDto.getPenyerahanrevisi());
        } catch (Exception e) {
            e.printStackTrace();
        }
        kelulusanDao.updateKelulusan(dataModel);
    }

    @Override
    public List<KelulusanDto> searchKelulusan(String cariBerdasarkan, String cariKey) {
        List<KelulusanDto> listKelulusanDto = new ArrayList();
        List<Object[]> listDataObject = kelulusanDao.getListCariDataKelulusanNativeQuery(cariBerdasarkan, cariKey);
        if (listDataObject != null){
            for (Object[] object : listDataObject){
                KelulusanDto dto = new KelulusanDto();
                MahasiswaModel mm = new MahasiswaModel();
                if (object[0] != null){
                    dto.setKdkelulusan(object[0].toString());
                }
                if (object[1] != null){
                    mm = mahasiswaService.getMahasiswaById(object[1].toString());
                    dto.setNim(mm.getNamamahasiswa());
                }
                if (object[2] != null){
                    dto.setKdsidang(object[2].toString());
                }
                if (object[3] != null){
                    dto.setTgllulus(object[3].toString());
                }
                if (object[4] != null){
                    dto.setIpk(Double.parseDouble(object[4].toString()));
                }
                if (object[5] != null){
                    dto.setRevisi(object[5].toString());
                }
                if (object[6] != null){
                    dto.setMulairevisi(object[6].toString());
                }
                if (object[7] != null){
                    dto.setAkhirrevisi(object[7].toString());
                }
                if (object[8] != null){
                    dto.setPenyerahanrevisi(object[8].toString());
                }
                listKelulusanDto.add(dto);
            }
        }
        return listKelulusanDto; 
    }
    
}
