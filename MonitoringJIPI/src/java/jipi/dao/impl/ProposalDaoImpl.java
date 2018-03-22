/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao.impl;

import java.util.List;
import jipi.dao.ProposalDao;
import jipi.model.ProposalModel;
import jipi.model.viewDosenmodel;
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
    public List<viewDosenmodel> getListViewDataProposal(String jenispengajuan,String Jurusan,Integer angkatan) {
        List<viewDosenmodel> dataList = null;
        String sql = "select mhs.nim,mhs.namamahasiswa,proposal.judulproposal,jenis.namajenispengajuan, " +
            "proposal.perubahanjudul,proposal.skssudahtempuh,proposal.tglpengajuanproposal, " +
            "proposal.dosenpembimbing,jur.namajurusan,fak.namafakultas " +
            "from MahasiswaModel mhs , " +
            "ProposalModel as proposal, " +
            "JurusanModel as jur, " +
            "FakultasModel as fak, " +
            "JenisPengajuanModel as jenis " +
            "where mhs.nim= proposal.nim " +
            "and mhs.kdjurusan=jur.kdjurusan " +
            "and jur.kdfakultas=fak.kdfakultas " +
            "and jenis.kdjenispengajuan=proposal.kdjenisproposal"
                + "where mhs.angkatan= ? "
                + "and jenis.namajenispengajuan like '%?%'"
                + "and mhs.kdjurusan=?";
        Query query = createQuery(sql).setParameter(0, angkatan)
                .setString(1, jenispengajuan)
                .setString(2, Jurusan);        
        dataList = query.list();
        return dataList;
    }
}
