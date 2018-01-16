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
import jipi.dto.AgamaDto;
import jipi.model.AgamaModel;
import jipi.service.AgamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@Transactional
public class AgamaServiceImpl implements AgamaService{
    @Autowired
    AgamaDao agamaDao;
    
    @Override
    public List<AgamaDto> getListDataAgama() {
        List<AgamaDto> ListDto = new ArrayList<>();
        List<AgamaModel> data = agamaDao.getListDataAgama();
        if(data != null){
            for (AgamaModel ddm : data) {
                AgamaDto dto = new AgamaDto();
                if(ddm.getKdagama() != null){
                    dto.setKdagama(ddm.getKdagama());
                }
                if(ddm.getNamaagama() != null){
                    dto.setNamaagama(ddm.getNamaagama());
                }
                
                ListDto.add(dto);
            }
        }
        return ListDto;
    }
    
}
