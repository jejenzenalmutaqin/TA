/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao;

import java.util.List;
import jipi.model.JurusanModel;

/**
 *
 * @author hp
 */
public interface JurusanDao {
    public List<JurusanModel> getListDataJurusan();
    public List<JurusanModel> getJurusanById(String param) throws Exception;
    public JurusanModel getDataJurusanById(String kdjurusan);
}
