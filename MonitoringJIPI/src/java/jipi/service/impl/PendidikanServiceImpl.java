/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import jipi.dao.PendidikanDao;
import jipi.dto.PendidikanDto;
import jipi.model.PendidikanModel;
import jipi.service.PendidikanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@Transactional
public class PendidikanServiceImpl implements PendidikanService{
    @Autowired
    PendidikanDao pendidikanDao;
    
    @Override
    public List<PendidikanDto> getListDataPendidikan() {
        List<PendidikanDto> ListDto = new ArrayList<>();
        List<PendidikanModel> data = pendidikanDao.getListDataPendidikan();
        if(data != null){
            for (PendidikanModel ddm : data) {
                PendidikanDto dto = new PendidikanDto();
                if(ddm.getKdpendidikan() != null){
                    dto.setKdpendidikan(ddm.getKdpendidikan());
                }
                if(ddm.getNamapendidikan() != null){
                    dto.setNamapendidikan(ddm.getNamapendidikan());
                }
                ListDto.add(dto);
            }
        }
        return ListDto;
    }
    
}
