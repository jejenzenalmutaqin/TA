/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao.impl;

import java.util.List;
import jipi.dao.SidangDao;
import jipi.model.ProposalModel;
import jipi.model.SidangModel;
import org.hibernate.Query;

/**
 *
 * @author hp
 */
public class SidangDaoImpl extends HibernateUtil implements SidangDao{

    @Override
    public void saveDataSidang(SidangModel sidangModel) {
        getSession().save(sidangModel);
    }

    @Override
    public List<SidangModel> getListDataSidang() {
        List<SidangModel> dataList = null;
        String sql = "select model from SidangModel model";
        Query query = createQuery(sql);        
        dataList = query.list();
        return dataList;
    }

    @Override
    public void deleteDataSidang(String kdsidang) {
        SidangModel ddm = new SidangModel();
        ddm.setKdsidang(kdsidang);
        getSession().delete(ddm);
    }

    @Override
    public SidangModel getSidangById(String kdsidang) throws Exception {
        SidangModel sidang = new SidangModel();
        Query query = null;
        try {
            String sql = "select model from SidangModel model where kdsidang=:kdsidang";
            query = createQuery(sql).setParameter("kdsidang", kdsidang);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (SidangModel) query.uniqueResult(); 
    }

    @Override
    public List<SidangModel> getListSidangUpdate(String kdsidang) {
        List<SidangModel> dataList = null;
        String sql = "select model from SidangModel model where kdsidang=:kdsidangedit";
        Query query = createQuery(sql).setParameter("kdsidangedit", kdsidang);
        dataList = query.list();
        return dataList;
    }

    @Override
    public void updateSidang(SidangModel sidangModel) {
        getSession().saveOrUpdate(sidangModel);
    }

    @Override
    public List<Object[]> getListCariDataSidangNativeQuery(String cariBerdasarkan, String cariKey) {
        List<Object[]> dataList = null;
        String sql = "select * from pengajuansidang_tbl ";
        String where="";
        if(cariBerdasarkan.equals("1")){
            where = "where nim like '%"+cariKey+"%'";
        }else if(cariBerdasarkan.equals("2")){
            where = "where nim in (select nim from mst_mahasiswa where namamahasiswa like '%"+cariKey+"%')";
        }else if(cariBerdasarkan.equals("3")){
            where = "where kdjenissidang = 1";
        }else if(cariBerdasarkan.equals("4")){
            where = "where kdjenissidang = 2";
        }else if(cariBerdasarkan.equals("5")){
            where = "where kdjenissidang = 3";
        }else if(cariBerdasarkan.equals("6")){
            where = "where tglpengajuansidang like '%"+cariKey+"%'";
        }else if(cariBerdasarkan.equals("7")){
            where = "where penelaah1 like '%"+cariKey+"%'";
        }else if(cariBerdasarkan.equals("8")){
            where = "where penelaah2 like '%"+cariKey+"%'";
        }else if(cariBerdasarkan.equals("9")){
            where = "where wakilfakultas like '%"+cariKey+"%'";
        }else if(cariBerdasarkan.equals("10")){
            where = "where tglsidang like '%"+cariKey+"%'";
        }else if(cariBerdasarkan.equals("11")){
            where = "where ruangansidang like '%"+cariKey+"%'";
        }else if(cariBerdasarkan.equals("12")){
            where = " ";
        }
        sql = sql + where;
        Query query = createNativeQuery(sql);
        dataList = query.list();
        return dataList;
    }
    
}
