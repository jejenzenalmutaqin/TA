/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import jipi.dao.AksesDao;
import jipi.dto.AksesDto;
import jipi.model.AksesModel;
import jipi.service.AksesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@Transactional
public class AksesServiceImpl implements AksesService{
    @Autowired
    AksesDao aksesDao;
    
    @Override
    public List<AksesDto> getListDataAkses() {
        List<AksesDto> ListDto = new ArrayList<>();
        List<AksesModel> data = aksesDao.getListDataAkses();
        if(data != null){
            for (AksesModel ddm : data) {
                AksesDto dto = new AksesDto();
                if(ddm.getKdakses() != null){
                    dto.setKdakses(ddm.getKdakses());
                }
                if(ddm.getNamaakses() != null){
                    dto.setNamaakses(ddm.getNamaakses());
                }
                ListDto.add(dto);
            }
        }
        return ListDto;
    }
    
}
