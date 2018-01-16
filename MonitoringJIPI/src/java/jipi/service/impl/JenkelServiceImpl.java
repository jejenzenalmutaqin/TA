/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import jipi.dao.JenkelDao;
import jipi.dto.JenkelDto;
import jipi.model.JenkelModel;
import jipi.service.JenkelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@Transactional
public class JenkelServiceImpl implements JenkelService{
    @Autowired
    JenkelDao jenkelDao;
    
    @Override
    public List<JenkelDto> getListDataJenkel() {
        List<JenkelDto> ListDto = new ArrayList<>();
        List<JenkelModel> data = jenkelDao.getListDataJenkel();
        if(data != null){
            for (JenkelModel ddm : data) {
                JenkelDto dto = new JenkelDto();
                if(ddm.getKdjenkel() != null){
                    dto.setKdjenkel(ddm.getKdjenkel());
                }
                if(ddm.getNamajenkel() != null){
                    dto.setNamajenkel(ddm.getNamajenkel());
                }
                ListDto.add(dto);
            }
        }
        return ListDto;
    }
    
}
