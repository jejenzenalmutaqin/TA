/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao;

import java.util.List;
import jipi.model.ProposalModel;

/**
 *
 * @author hp
 */
public interface ProposalDao {
    public void saveDataProposal(ProposalModel proposalModel);
    public List<ProposalModel> getListDataProposal();
    public void deleteDataProposal(String kdproposal);
    public ProposalModel getProposalById(String kdproposal) throws Exception;
}
