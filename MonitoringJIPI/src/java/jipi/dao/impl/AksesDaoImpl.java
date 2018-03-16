/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao.impl;

import java.util.List;
import jipi.dao.AksesDao;
import jipi.model.AksesModel;
import org.hibernate.Query;

/**
 *
 * @author hp
 */
public class AksesDaoImpl extends HibernateUtil implements AksesDao{

    @Override
    public List<AksesModel> getListDataAkses() {
        List<AksesModel> dataList = null;
        String sql = "select model from AksesModel model";
        Query query = createQuery(sql);        
        dataList = query.list();
        return dataList;
    }

    @Override
    public AksesModel getAksesById(String kdakses) throws Exception {
        AksesModel akses = new AksesModel();
        Query query = null;
        try {
            String sql = "select model from AksesModel model where kdakses=:kdakses";
            query = createQuery(sql).setParameter("kdakses", kdakses);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (AksesModel) query.uniqueResult();    
    }
    
}
