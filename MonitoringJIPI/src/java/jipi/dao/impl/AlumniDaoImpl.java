/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao.impl;

import java.util.List;
import jipi.dao.AlumniDao;
import jipi.model.AlumniModel;
import org.hibernate.Query;

/**
 *
 * @author hp
 */
public class AlumniDaoImpl extends HibernateUtil implements AlumniDao{

    @Override
    public void saveDataAlumni(AlumniModel alumniModel) {
        getSession().save(alumniModel);
    }

    @Override
    public List<AlumniModel> getListDataAlumni() {
        List<AlumniModel> dataList = null;
        String sql = "select model from AlumniModel model";
        Query query = createQuery(sql);        
        dataList = query.list();
        return dataList;
    }

    @Override
    public void deleteDataAlumni(String kdalumni) {
        AlumniModel ddm = new AlumniModel();
        ddm.setKdalumni(kdalumni);
        getSession().delete(ddm);
    }

    @Override
    public AlumniModel getAlumniById(String kdalumni) throws Exception {
        AlumniModel alumni = new AlumniModel();
        Query query = null;
        try {
            String sql = "select model from AlumniModel model where kdalumni=:kdalumni";
            query = createQuery(sql).setParameter("kdalumni", kdalumni);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (AlumniModel) query.uniqueResult();
    }

    @Override
    public List<AlumniModel> getListAlumniUpdate(String kdalumni) {
        List<AlumniModel> dataList = null;
        String sql = "select model from AlumniModel model where kdalumni=:kdalumniedit";
        Query query = createQuery(sql).setParameter("kdalumniedit", kdalumni);
        dataList = query.list();
        return dataList;
    }

    @Override
    public void updateAlumni(AlumniModel alumniModel) {
        getSession().saveOrUpdate(alumniModel);
    }

    @Override
    public List<Object[]> getListCariDataAlumniNativeQuery(String cariBerdasarkan, String cariKey) {
        List<Object[]> dataList = null;
        String sql = "select * from alumni_tbl ";
        String where="";
        if(cariBerdasarkan.equals("1")){
            where = "where kdalumni like '%"+cariKey+"%'";
        }else if(cariBerdasarkan.equals("2")){
            where = "where nim like '%"+cariKey+"%'";
        }else if(cariBerdasarkan.equals("3")){
            where = "where nim in (select nim from mst_mahasiswa where namamahasiswa like '%"+cariKey+"%')";
        }else if(cariBerdasarkan.equals("4")){
            where = "where kdkelulusan like '%"+cariKey+"%'";
        }else if(cariBerdasarkan.equals("5")){
            where = "where daerahkerja like '%"+cariKey+"%'";
        }else if(cariBerdasarkan.equals("6")){
            where = "where sektor like '%"+cariKey+"%'";
        }else if(cariBerdasarkan.equals("7")){
            where = "where profesi like '%"+cariKey+"%'";
        }else if(cariBerdasarkan.equals("8")){
            where = " ";
        }
        sql = sql + where;
        Query query = createNativeQuery(sql);
        dataList = query.list();
        return dataList;
    }
    
}
