/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao.impl;

import java.util.List;
import jipi.dao.AgamaDao;
import jipi.model.AgamaModel;
import org.hibernate.Query;

/**
 *
 * @author hp
 */
public class AgamaDaoImpl extends HibernateUtil implements AgamaDao{

    @Override
    public List<AgamaModel> getListDataAgama() {
        List<AgamaModel> dataList = null;
        String sql = "select model from AgamaModel model";
        Query query = createQuery(sql);        
        dataList = query.list();
        return dataList;
    }
    
}
