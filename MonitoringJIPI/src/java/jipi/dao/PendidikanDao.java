/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao;

import java.util.List;
import jipi.model.PendidikanModel;

/**
 *
 * @author hp
 */
public interface PendidikanDao {
    public List<PendidikanModel> getListDataPendidikan();
    public PendidikanModel getDataPendidikanById(String kdpendidikan);
}
