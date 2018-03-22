/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.service;

import java.util.List;
import jipi.dto.MahasiswaDto;
import jipi.dto.NotifDto;
import jipi.model.NotifModel;

/**
 *
 * @author hp
 */
public interface NotifService {
    public List<NotifDto> getNotifById(String nim);
    public List<NotifDto> getNotifByKodeNotif(String kdnotif);
    public void updateStatusBaca(String kdnotif) throws Exception;
    public void deleteNotif(String kdnotif) throws Exception;
    public List<MahasiswaDto> searchNotif(String nim);
    public void saveNotif(String nim, String isinotif, String subjeknotif, String judulnotif) throws Exception;
}
