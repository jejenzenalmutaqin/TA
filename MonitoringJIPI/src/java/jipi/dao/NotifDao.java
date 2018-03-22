/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao;

import java.util.List;
import jipi.model.NotifModel;

/**
 *
 * @author hp
 */
public interface NotifDao {
    public List<Object[]> getListNotifNativeQuery(String nim);
    public List<Object[]> getListNotifByKodeNatifNativeQuery(String kdnotif);
    public void updateNotif(NotifModel notifModel);
    public void deleteNotif(String kdnotif);
    public List<Object[]> getListCariDataMahasiswaNativeQuery(String nim);
    public void saveDataNotif(NotifModel notifModel);
}
