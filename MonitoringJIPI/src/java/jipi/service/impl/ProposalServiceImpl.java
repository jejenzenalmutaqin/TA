/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import jipi.dao.ProposalDao;
import jipi.dto.ProposalDto;
import jipi.model.ProposalModel;
import jipi.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@Transactional
public class ProposalServiceImpl implements ProposalService{
    @Autowired
    ProposalDao proposalDao;
    
    @Override
    public void saveDataProposal(ProposalDto proposalDto) throws Exception {
        ProposalModel dataModel = new ProposalModel();
        dataModel.setKdproposal(proposalDto.getKdproposal());
        dataModel.setKdjenisproposal(proposalDto.getKdjenisproposal());
        dataModel.setNim(proposalDto.getNim());
        dataModel.setJudulproposal(proposalDto.getJudulproposal());
        dataModel.setPerubahanjudul(proposalDto.getPerubahanjudul());
        dataModel.setSkssudahtempuh(proposalDto.getSkssudahtempuh());
        dataModel.setSksproposal(proposalDto.getSksproposal());
        dataModel.setTglpengajuanproposal(proposalDto.getTglpengajuanproposal());
        dataModel.setIpk(proposalDto.getIpk());
        dataModel.setStatusproposal(proposalDto.getStatusproposal());
        dataModel.setDosenpembimbing(proposalDto.getDosenpembimbing());
        dataModel.setEmail(proposalDto.getEmail());
        proposalDao.saveDataProposal(dataModel);
    }

    @Override
    public List<ProposalDto> getListDataProposal() {
        List<ProposalDto> ListDto = new ArrayList<>();
        List<ProposalModel> data = proposalDao.getListDataProposal();
        if(data != null){
            for (ProposalModel ddm : data) {
                ProposalDto dto = new ProposalDto();
                if(ddm.getKdproposal() != null){
                    dto.setKdproposal(ddm.getKdproposal());
                }
                if(ddm.getKdjenisproposal() !=null){
                    dto.setKdjenisproposal(ddm.getKdjenisproposal());
                }
                if(ddm.getNim() != null){
                    dto.setNim(ddm.getNim());
                }
                if(ddm.getJudulproposal() != null){
                    dto.setJudulproposal(ddm.getJudulproposal());
                }
                if(ddm.getPerubahanjudul() != null){
                    dto.setPerubahanjudul(ddm.getPerubahanjudul());
                }
                if(ddm.getSkssudahtempuh() != null){
                    dto.setSkssudahtempuh(ddm.getSkssudahtempuh());
                }
                if(ddm.getSksproposal() != null){
                    dto.setSksproposal(ddm.getSksproposal());
                }
                if(ddm.getTglpengajuanproposal() != null){
                    dto.setTglpengajuanproposal(ddm.getTglpengajuanproposal());
                }
//                if(ddm.getIpk() != null){
                    dto.setIpk(ddm.getIpk());
//                }
                if(ddm.getSksproposal() != null){
                    dto.setStatusproposal(ddm.getStatusproposal());
                }
                if(ddm.getDosenpembimbing() != null){
                    dto.setEmail(ddm.getEmail());
                }
                ListDto.add(dto);
            }
        }
        return ListDto;
    }

    @Override
    public void deleteDataProposal(String kdproposal) throws Exception {
        try {
            proposalDao.deleteDataProposal(kdproposal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ProposalModel getProposalById(String kdproposal) {
        ProposalModel proposalModel = null;
        try {
            proposalModel = proposalDao.getProposalById(kdproposal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proposalModel;
    }
    
}
