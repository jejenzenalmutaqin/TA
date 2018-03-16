/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.service;

import java.util.List;
import jipi.dto.JurusanDto;
import jipi.model.JurusanModel;

/**
 *
 * @author hp
 */
public interface JurusanService {
    public List<JurusanDto> getListDataJurusan();
    public List<JurusanDto> getJurusanById(String param);
}
