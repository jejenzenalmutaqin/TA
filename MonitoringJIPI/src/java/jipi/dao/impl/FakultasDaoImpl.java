/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao.impl;

import java.util.List;
import jipi.dao.FakultasDao;
import jipi.model.FakultasModel;
import org.hibernate.Query;

/**
 *
 * @author hp
 */
public class FakultasDaoImpl extends HibernateUtil implements FakultasDao{

    @Override
    public List<FakultasModel> getListDataFakultas() {
        List<FakultasModel> dataList = null;
        String sql = "select model from FakultasModel model";
        Query query = createQuery(sql);        
        dataList = query.list();
        return dataList;
    }
    
}
