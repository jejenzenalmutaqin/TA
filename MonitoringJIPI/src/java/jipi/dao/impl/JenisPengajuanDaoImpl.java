/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao.impl;

import java.util.List;
import jipi.dao.JenisPengajuanDao;
import jipi.model.JenisPengajuanModel;
import org.hibernate.Query;

/**
 *
 * @author hp
 */
public class JenisPengajuanDaoImpl extends HibernateUtil implements JenisPengajuanDao{

    @Override
    public void saveDataJenisPengajuan(JenisPengajuanModel jenisPengajuanModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<JenisPengajuanModel> getListDataJenisPengajuan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteDataJenisPengajuan(String kdjenispengajuan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JenisPengajuanModel getJenisPengajuanById(String kdjenispengajuan) throws Exception {
        JenisPengajuanModel jenispengajuan = new JenisPengajuanModel();
        Query query = null;
        try {
            String sql = "select model from JenisPengajuanModel model where kdjenispengajuan=:kdjenispengajuan";
            query = createQuery(sql).setParameter("kdjenispengajuan", kdjenispengajuan);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (JenisPengajuanModel) query.uniqueResult(); 
    }
    
}
