/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao;

import java.util.List;
import jipi.model.AgamaModel;

/**
 *
 * @author hp
 */
public interface AgamaDao {
    public List<AgamaModel> getListDataAgama();
    public AgamaModel getDataAgamaById(String id);
}
