/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao;

import java.util.List;
import jipi.model.AksesModel;

/**
 *
 * @author hp
 */
public interface AksesDao {
    public List<AksesModel> getListDataAkses();
    public AksesModel getAksesById(String kdakses) throws Exception;
}
