/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao;

import java.util.List;
import jipi.model.JenisPengajuanModel;
import jipi.model.ViewPengajuanSidangModel;

/**
 *
 * @author hp
 */
public interface JenisPengajuanDao {
    public void saveDataJenisPengajuan(JenisPengajuanModel jenisPengajuanModel);
    public List<JenisPengajuanModel> getListDataJenisPengajuan();
    public void deleteDataJenisPengajuan(String kdjenispengajuan);
    public JenisPengajuanModel getJenisPengajuanById(String kdjenispengajuan) throws Exception;
    public List<ViewPengajuanSidangModel> getListDataPengajuanSidang(String kdJenisSidang,String kdjurusan,Integer Angkatan);
}
