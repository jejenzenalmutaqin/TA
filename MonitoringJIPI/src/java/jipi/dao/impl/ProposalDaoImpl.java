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
    
}
