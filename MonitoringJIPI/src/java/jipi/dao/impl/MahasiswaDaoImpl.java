/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao.impl;

import java.util.List;
import jipi.dao.MahasiswaDao;
import jipi.model.MahasiswaModel;
import org.hibernate.Query;

/**
 *
 * @author hp
 */
public class MahasiswaDaoImpl extends HibernateUtil implements MahasiswaDao{

    @Override
    public List<MahasiswaModel> getListDataMahasiswa() {
        List<MahasiswaModel> dataList = null;
        String sql = "select model from MahasiswaModel model";
        Query query = createQuery(sql);        
        dataList = query.list();
        return dataList;
    }
    
}
