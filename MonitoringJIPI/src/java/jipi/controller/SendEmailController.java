package jipi.controller;

import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import jipi.dto.ProposalDto;
import jipi.model.MahasiswaModel;
import jipi.model.ProposalModel;
import jipi.service.MahasiswaService;
import jipi.service.ProposalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sendEmail")
public class SendEmailController {

    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    ProposalService proposalService;
    
    @Autowired
    MahasiswaService mahasiswaService;

    @RequestMapping(method = RequestMethod.GET)
    public String doSendEmail(String kdproposal, ModelMap model) {
        System.out.println(kdproposal);
        ProposalModel pm = proposalService.getProposalById(kdproposal);
        MahasiswaModel mm = mahasiswaService.getMahasiswaById(pm.getNim());
        
        System.out.println("masuk doSendEmail");
        // takes input from e-mail form
        String recipientAddress = pm.getEmail();
        System.out.println("di bawah recipientAddress");
        String pesan="";
        if(pm.getStatusproposal().equals("belum")){
            System.out.println("masuk if");
            pesan="Dear "+mm.getNamamahasiswa()+"\nProposal yang anda ajukan belum diterima\nSilahkan coba lagi\nTerimakasih";
        }else{
            System.out.println("masuk else");
            pesan="Dear "+mm.getNamamahasiswa()+"\nSelamat, proposal anda diterima\nDosen Pembimbing: "+pm.getDosenpembimbing()+"\nTerimakasih";
        }
        String subject = "PEMBERITAHUAN HASIL PENGAJUAN PROPOSAL";
        String message = pesan;
        System.out.println("bawah ====================");
        // prints debug info
//        System.out.println("To: " + recipientAddress);
//        System.out.println("Subject: " + subject);
//        System.out.println("Message: " + message);
        System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
        // creates a simple e-mail object
//		SimpleMailMessage email = new SimpleMailMessage();
//                
//		email.setTo(recipientAddress);
//		email.setSubject(subject);
//		email.setText(message);
//		
//		// sends the e-mail
//		mailSender.send(email);
        mailSender.send(new MimeMessagePreparator() {

            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(
                        mimeMessage, true, "UTF-8");
                messageHelper.setTo(recipientAddress);
                messageHelper.setSubject(subject);
                messageHelper.setText(message);

            }
//            public void prepare(MimeMessage mimeMessage) throws MessagingException {
//                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
//                message.setTo(recipientAddress);
//                message.setSubject(subject);
//                message.setText("<b>See the attached</b>", true);
//                
//            }
        });

        // forwards to the view named "Result"
        List<ProposalDto> listDto = proposalService.getListDataProposal();
        model.addAttribute("listDto", listDto);
        return "akd_pengajuanproposal";
    }
}
