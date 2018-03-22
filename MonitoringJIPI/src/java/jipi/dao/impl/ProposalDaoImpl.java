/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao.impl;

import java.util.List;
import jipi.dao.ProposalDao;
import jipi.model.ProposalModel;
import org.hibernate.Query;

/**
 *
 * @author hp
 */
public class ProposalDaoImpl extends HibernateUtil implements ProposalDao{

    @Override
    public void saveDataProposal(ProposalModel proposalModel) {
        getSession().save(proposalModel);
    }

    @Override
    public List<ProposalModel> getListDataProposal() {
        List<ProposalModel> dataList = null;
        String sql = "select model from ProposalModel model";
        Query query = createQuery(sql);        
        dataList = query.list();
        return dataList;
    }

    @Override
    public void deleteDataProposal(String kdproposal) {
        ProposalModel ddm = new ProposalModel();
        ddm.setKdproposal(kdproposal);
        getSession().delete(ddm);
    }

    @Override
    public ProposalModel getProposalById(String kdproposal) throws Exception {
        ProposalModel proposal = new ProposalModel();
        Query query = null;
        try {
            String sql = "select model from ProposalModel model where kdproposal=:kdproposal";
            query = createQuery(sql).setParameter("kdproposal", kdproposal);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (ProposalModel) query.uniqueResult(); 
    }

    @Override
    public List<ProposalModel> getListProposalUpdate(String kdproposal) {
        List<ProposalModel> dataList = null;
        String sql = "select model from ProposalModel model where kdproposal=:kdproposaledit";
        Query query = createQuery(sql).setParameter("kdproposaledit", kdproposal);
        dataList = query.list();
        return dataList;
    }

    @Override
    public void updateProposal(ProposalModel proposalModel) {
        getSession().saveOrUpdate(proposalModel);
    }

    @Override
    public List<Object[]> getListCariDataProposalNativeQuery(String cariBerdasarkan, String cariKey) {
        List<Object[]> dataList = null;
        String sql = "select * from pengajuanproposal_tbl ";
        String where="";
        if(cariBerdasarkan.equals("1")){
            where = "where nim like '%"+cariKey+"%'";
        }else if(cariBerdasarkan.equals("2")){
            where = "where nim in (select nim from mst_mahasiswa where namamahasiswa like '%"+cariKey+"%')";
        }else if(cariBerdasarkan.equals("3")){
            where = "where kdjenisproposal = 1";
        }else if(cariBerdasarkan.equals("4")){
            where = "where kdjenisproposal = 2";
        }else if(cariBerdasarkan.equals("5")){
            where = "where kdjenisproposal = 3";
        }else if(cariBerdasarkan.equals("6")){
            where = "where tglpengajuanproposal like '%"+cariKey+"%'";
        }else if(cariBerdasarkan.equals("7")){
            where = "where dosenpembimbing like '%"+cariKey+"%'";
        }else if(cariBerdasarkan.equals("8")){
            where = " ";
        }
        sql = sql + where;
        Query query = createNativeQuery(sql);
        dataList = query.list();
        return dataList;
    }

    @Override
    public List<Object[]> getListDataProposalForReport(String fakultas_filter, String jurusan_filter, String jenis_filter, String angkatan_filter) {
        List<Object[]> dataList = null;
        String sql = "select p.* from pengajuanproposal_tbl p inner join mst_mahasiswa m inner join mst_jurusan j inner join mst_fakultas f \n" +
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
        if(jenis_filter.equals("seluruh")){
            where =" ";
        }else{
            where = " and p.kdjenisproposal='"+jenis_filter+"' ";
            sql = sql + where;
        }
        where = where + " order by p.tglpengajuanproposal asc ";
        sql = sql + where;
        Query query = createNativeQuery(sql);
        dataList = query.list();
        return dataList;
    }
    
}
