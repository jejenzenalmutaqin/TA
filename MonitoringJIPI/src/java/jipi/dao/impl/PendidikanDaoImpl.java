/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao.impl;

import java.util.List;
import jipi.dao.PendidikanDao;
import jipi.model.PendidikanModel;
import org.hibernate.Query;

/**
 *
 * @author hp
 */
public class PendidikanDaoImpl extends HibernateUtil implements PendidikanDao{

    @Override
    public List<PendidikanModel> getListDataPendidikan() {
        List<PendidikanModel> dataList = null;
        String sql = "select model from PendidikanModel model";
        Query query = createQuery(sql);        
        dataList = query.list();
        return dataList;
    }

    @Override
    public PendidikanModel getDataPendidikanById(String kdpendidikan) {
        Query query = null;
        try {
            String sql = "select model from PendidikanModel model where kdpendidikan=:kdpendidikan";
            query = createQuery(sql).setParameter("kdpendidikan", kdpendidikan);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (PendidikanModel) query.uniqueResult();
    }
    
}
