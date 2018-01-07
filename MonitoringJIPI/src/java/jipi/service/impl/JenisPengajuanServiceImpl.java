/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import jipi.dao.JenisPengajuanDao;
import jipi.dto.JenisPengajuanDto;
import jipi.model.JenisPengajuanModel;
import jipi.service.JenisPengajuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@Transactional
public class JenisPengajuanServiceImpl implements JenisPengajuanService{
    @Autowired
    JenisPengajuanDao jenisPengajuanDao;
    @Override
    public void saveDataJenisPengajuan(JenisPengajuanDto jenisPengajuanDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<JenisPengajuanDto> getListDataJenisPengajuan() {
        List<JenisPengajuanDto> ListDto = new ArrayList<>();
        List<JenisPengajuanModel> data = jenisPengajuanDao.getListDataJenisPengajuan();
        if(data != null){
            for (JenisPengajuanModel ddm : data) {
                JenisPengajuanDto dto = new JenisPengajuanDto();
                if(ddm.getKdjenispengajuan()!= null){
                    dto.setKdjenispengajuan(ddm.getKdjenispengajuan());
                }
                if(ddm.getNamajenispengajuan() != null){
                    dto.setNamajenispengajuan(ddm.getNamajenispengajuan());
                }
                ListDto.add(dto);
            }
        }
        return ListDto;
    }

    @Override
    public void deleteDataJenisPengajuan(String kdjenispengajuan) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JenisPengajuanModel getJenisPengajuanById(String kdjenispengajuan) {
        JenisPengajuanModel jenisPengajuanModel = null;
        try {
            jenisPengajuanModel = jenisPengajuanDao.getJenisPengajuanById(kdjenispengajuan);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jenisPengajuanModel;
    }
    
}
