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

    @Override
    public MahasiswaModel getMahasiswaById(String nim) throws Exception {
        MahasiswaModel user = new MahasiswaModel();
        Query query = null;
        try {
            String sql = "select model from MahasiswaModel model where nim=:nim";
            query = createQuery(sql).setParameter("nim", nim);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (MahasiswaModel) query.uniqueResult();    
    }

    @Override
    public List<Object[]> getListAngkatanNativeQuery() {
        List<Object[]> dataList = null;
        String sql="select distinct angkatan from mst_mahasiswa order by angkatan asc";
        Query query = createNativeQuery(sql);
        dataList = query.list();
        return dataList;
    }

    @Override
    public List<MahasiswaModel> getListDataMahasiswaDistinctAngkatan() {
        List<MahasiswaModel> dataList = null;
        String sql = "select distinct angkatan from MahasiswaModel model";
        Query query = createQuery(sql);        
        dataList = query.list();
        return dataList;
    }

    @Override
    public void saveDataMahasiswa(MahasiswaModel mahasiswaModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MahasiswaModel> getListMahasiswa(String nim) {
        List<MahasiswaModel> dataList = null;
        String sql = "select model from MahasiswaModel model where nim=:nim";
        Query query = createQuery(sql).setParameter("nim", nim);
        dataList = query.list();
        return dataList;
    }

    @Override
    public void deleteDataMahasiswa(String nim) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MahasiswaModel getMahasiswaByNim(String nim) throws Exception {
        MahasiswaModel mhs = new MahasiswaModel();
        Query query = null;
        try {
            String sql = "select model from MahasiswaModel model where nim=:nim";
            query = createQuery(sql).setParameter("nim", nim);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (MahasiswaModel) query.uniqueResult();
    }
    
}
