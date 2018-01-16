/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao.impl;

import java.util.List;
import jipi.dao.JurusanDao;
import jipi.model.JurusanModel;
import org.hibernate.Query;

/**
 *
 * @author hp
 */
public class JurusanDaoImpl extends HibernateUtil implements JurusanDao{

    @Override
    public List<JurusanModel> getListDataJurusan() {
        List<JurusanModel> dataList = null;
        String sql = "select model from JurusanModel model";
        Query query = createQuery(sql);        
        dataList = query.list();
        return dataList;
    }
    
}
