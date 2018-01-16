/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.service;

import java.util.List;
import jipi.dto.ProposalDto;
import jipi.model.ProposalModel;

/**
 *
 * @author hp
 */
public interface ProposalService {
    public void saveDataProposal(ProposalDto proposalDto) throws Exception;
    public List<ProposalDto> getListDataProposal();
    public void deleteDataProposal(String kdproposal) throws Exception;
    public ProposalModel getProposalById(String kdproposal);
    public ProposalDto updateDataForm(String kdproposal) throws Exception;
    public void doUpdateDataForm(ProposalDto proposalDto) throws Exception;
}
