/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao.impl;

import java.util.List;
import jipi.dao.JenkelDao;
import jipi.model.JenkelModel;
import org.hibernate.Query;

/**
 *
 * @author hp
 */
public class JenkelDaoImpl extends HibernateUtil implements JenkelDao{

    @Override
    public List<JenkelModel> getListDataJenkel() {
        List<JenkelModel> dataList = null;
        String sql = "select model from JenkelModel model";
        Query query = createQuery(sql);        
        dataList = query.list();
        return dataList;
    }

    @Override
    public JenkelModel getListDataJenkelById(String kdjenkel) {
        Query query = null;
        try {
            String sql = "select model from JenkelModel model where kdjenkel=:kdjenkel";
            query = createQuery(sql).setParameter("kdjenkel", kdjenkel);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (JenkelModel) query.uniqueResult(); 
    }
    
}
