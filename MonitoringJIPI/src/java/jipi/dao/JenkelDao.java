/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao;

import java.util.List;
import jipi.model.JenkelModel;

/**
 *
 * @author hp
 */
public interface JenkelDao {
    public List<JenkelModel> getListDataJenkel();
    public JenkelModel getListDataJenkelById(String kdjenkel);
}
