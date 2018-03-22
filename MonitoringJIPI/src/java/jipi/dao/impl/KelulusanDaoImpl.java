/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao.impl;

import java.util.List;
import jipi.dao.KelulusanDao;
import jipi.model.KelulusanModel;
import org.hibernate.Query;

/**
 *
 * @author hp
 */
public class KelulusanDaoImpl extends HibernateUtil implements KelulusanDao{

    @Override
    public void saveDataKelulusan(KelulusanModel kelulusanModel) {
        getSession().save(kelulusanModel);
    }

    @Override
    public List<KelulusanModel> getListDataKelulusan() {
        List<KelulusanModel> dataList = null;
        String sql = "select model from KelulusanModel model";
        Query query = createQuery(sql);        
        dataList = query.list();
        return dataList;
    }

    @Override
    public void deleteDataKelulusan(String kdkelulusan) {
        KelulusanModel ddm = new KelulusanModel();
        ddm.setKdkelulusan(kdkelulusan);
        getSession().delete(ddm);
    }

    @Override
    public KelulusanModel getKelulusanById(String kdkelulusan) throws Exception {
        KelulusanModel user = new KelulusanModel();
        Query query = null;
        try {
            String sql = "select model from KelulusanModel model where kdkelulusan=:kdkelulusan";
            query = createQuery(sql).setParameter("kdkelulusan", kdkelulusan);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (KelulusanModel) query.uniqueResult();
    }

    @Override
    public List<KelulusanModel> getListKelulusanUpdate(String kdkelulusan) {
        List<KelulusanModel> dataList = null;
        String sql = "select model from KelulusanModel model where kdkelulusan=:kdkelulusanedit";
        Query query = createQuery(sql).setParameter("kdkelulusanedit", kdkelulusan);
        dataList = query.list();
        return dataList;
    }

    @Override
    public void updateKelulusan(KelulusanModel kelulusanModel) {
        getSession().saveOrUpdate(kelulusanModel);
    }

    @Override
    public List<Object[]> getListCariDataKelulusanNativeQuery(String cariBerdasarkan, String cariKey) {
        List<Object[]> dataList = null;
        String sql = "select * from kelulusan_tbl ";
        String where="";
        if(cariBerdasarkan.equals("1")){
            where = "where nim like '%"+cariKey+"%'";
        }else if(cariBerdasarkan.equals("2")){
            where = "where nim in (select nim from mst_mahasiswa where namamahasiswa like '%"+cariKey+"%')";
        }else if(cariBerdasarkan.equals("3")){
            where = "where kdkelulusan like '%"+cariKey+"%'";
        }else if(cariBerdasarkan.equals("4")){
            where = "where tgllulus like '%"+cariKey+"%'";
        }else if(cariBerdasarkan.equals("5")){
            where = "where revisi like '%"+cariKey+"%'";
        }else if(cariBerdasarkan.equals("6")){
            where = "where mulairevisi like '%"+cariKey+"%'";
        }else if(cariBerdasarkan.equals("7")){
            where = "where akhirrevisi like '%"+cariKey+"%'";
        }else if(cariBerdasarkan.equals("8")){
            where = "where penyerahanrevisi like '%"+cariKey+"%'";
        }else if(cariBerdasarkan.equals("9")){
            where = "";
        }
        sql = sql + where;
        Query query = createNativeQuery(sql);
        dataList = query.list();
        return dataList;
    }

    @Override
    public List<Object[]> getListDataKelulusanForReport(String fakultas_filter, String jurusan_filter, String angkatan_filter) {
        List<Object[]> dataList = null;
        String sql = "select p.* from kelulusan_tbl p inner join mst_mahasiswa m inner join mst_jurusan j inner join mst_fakultas f \n" +
                     "on p.nim = m.nim and m.kdjurusan = j.kdjurusan and j.kdfakultas = f.kdfakultas ";
        String where="";
        if(fakultas_filter.equals("seluruh")){
            where =" ";
        }else{
            where = " and j.kdfakultas='"+fakultas_filter+"' ";
            sql = sql + where;
        }
        if(jurusan_filter.equals("seluruh")){
            where =" ";
        }else{
            where = " and m.kdjurusan='"+jurusan_filter+"' ";
            sql = sql + where;
        }
        if(angkatan_filter.equals("seluruh")){
            where =" ";
        }else{
            where = " and m.angkatan='"+angkatan_filter+"' ";
            sql = sql + where;
        }
        where = where + " order by p.tgllulus asc ";
        sql = sql + where;
        Query query = createNativeQuery(sql);
        dataList = query.list();
        return dataList;
    }
    
}
