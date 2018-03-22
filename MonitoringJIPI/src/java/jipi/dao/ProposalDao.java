/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao;

import java.util.List;
import jipi.model.ProposalModel;
import jipi.model.viewDosenmodel;

/**
 *
 * @author hp
 */
public interface ProposalDao {
    public void saveDataProposal(ProposalModel proposalModel);
    public List<ProposalModel> getListDataProposal();
    public void deleteDataProposal(String kdproposal);
    public ProposalModel getProposalById(String kdproposal) throws Exception;
    public List<ProposalModel> getListProposalUpdate(String kdproposal);
    public void updateProposal(ProposalModel proposalModel);
    public List<Object[]> getListCariDataProposalNativeQuery(String cariBerdasarkan, String cariKey);
    public List<Object[]> getListDataProposalForReport(String fakultas_filter, String jurusan_filter, String jenis_filter, String angkatan_filter);
    public List<viewDosenmodel> getListViewDataProposal(String jenisPengajuan,String jurusan,Integer angkatan);
}
