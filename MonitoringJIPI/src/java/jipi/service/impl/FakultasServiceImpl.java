/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import jipi.dao.FakultasDao;
import jipi.dto.FakultasDto;
import jipi.model.FakultasModel;
import jipi.service.FakultasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@Transactional
public class FakultasServiceImpl implements FakultasService{
    @Autowired
    FakultasDao fakultasDao;
    
    @Override
    public List<FakultasDto> getListDataFakultas() {
        List<FakultasDto> ListDto = new ArrayList<>();
        List<FakultasModel> data = fakultasDao.getListDataFakultas();
        if(data != null){
            for (FakultasModel ddm : data) {
                FakultasDto dto = new FakultasDto();
                if(ddm.getKdfakultas() != null){
                    dto.setKdfakultas(ddm.getKdfakultas());
                }
                if(ddm.getNamafakultas() != null){
                    dto.setNamafakultas(ddm.getNamafakultas());
                }
                ListDto.add(dto);
            }
        }
        return ListDto;
    }
    
}
