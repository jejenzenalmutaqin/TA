/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.Transactional;
import jipi.dao.JurusanDao;
import jipi.dto.JurusanDto;
import jipi.model.JurusanModel;
import jipi.service.JurusanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@Transactional
public class JurusanServiceImpl implements JurusanService{
    @Autowired
    JurusanDao jurusanDao;
    @Override
    public List<JurusanDto> getListDataJurusan() {
        List<JurusanDto> ListDto = new ArrayList<>();
        List<JurusanModel> data = jurusanDao.getListDataJurusan();
        if(data != null){
            for (JurusanModel ddm : data) {
                JurusanDto dto = new JurusanDto();
                if(ddm.getKdjurusan() != null){
                    dto.setKdjurusan(ddm.getKdjurusan());
                }
                if(ddm.getNamajurusan() != null){
                    dto.setNamajurusan(ddm.getNamajurusan());
                }
                if(ddm.getKdfakultas() != null){
                    dto.setKdfakultas(ddm.getKdfakultas());
                }
                ListDto.add(dto);
            }
        }
        return ListDto;
    }

    @Override
    public List<JurusanDto> getJurusanById(String param) {
        List<JurusanDto> ListDto = new ArrayList<>();
        List<JurusanModel> data = null;
        try {
            data = jurusanDao.getJurusanById(param);
        } catch (Exception ex) {
            Logger.getLogger(JurusanServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(data != null){
            for (JurusanModel ddm : data) {
                JurusanDto dto = new JurusanDto();
                if(ddm.getKdjurusan() != null){
                    dto.setKdjurusan(ddm.getKdjurusan());
                }
                if(ddm.getNamajurusan() != null){
                    dto.setNamajurusan(ddm.getNamajurusan());
                }
                if(ddm.getKdfakultas() != null){
                    dto.setKdfakultas(ddm.getKdfakultas());
                }
                ListDto.add(dto);
            }
        }
        return ListDto;
    }
    
}
