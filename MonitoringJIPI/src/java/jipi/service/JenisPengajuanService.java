/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.service;

import java.util.List;
import jipi.dto.JenisPengajuanDto;
import jipi.model.JenisPengajuanModel;

/**
 *
 * @author hp
 */
public interface JenisPengajuanService {
    public void saveDataJenisPengajuan(JenisPengajuanDto jenisPengajuanDto) throws Exception;
    public List<JenisPengajuanDto> getListDataJenisPengajuan();
    public void deleteDataJenisPengajuan(String kdjenispengajuan) throws Exception;
    public JenisPengajuanModel getJenisPengajuanById(String kdjenispengajuan);
    public String getNamaJenisPengajuan(String kdjenispengajuan);
}
