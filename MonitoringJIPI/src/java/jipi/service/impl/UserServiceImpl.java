/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.Transactional;
import jipi.dao.AksesDao;
import jipi.dao.UserDao;
import jipi.dto.UserDto;
import jipi.model.AksesModel;
import jipi.model.UserModel;
import jipi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    AksesDao aksesDao;

    @Override
    public void saveDataUser(UserDto userDto) throws Exception {
        UserModel dataModel = new UserModel();
        dataModel.setKduser("U" + generateKode());
        dataModel.setUsername(userDto.getUsername());
        dataModel.setPassword(userDto.getPassword());
        dataModel.setAkses(userDto.getAkses());
        if (userDto.getAkses().equals("5") || userDto.getAkses().equals("6")) {
            dataModel.setNim(userDto.getNim());
            dataModel.setNip("");
        } else {
            dataModel.setNim("");
            dataModel.setNip(userDto.getNim());
        }
        dataModel.setKeterangan(userDto.getKeterangan());
        userDao.saveDataUser(dataModel);
    }

    @Override
    public List<UserDto> getListDataUser() {
        List<UserDto> ListDto = new ArrayList<>();
        List<UserModel> data = userDao.getListDataUser();
        AksesModel am = new AksesModel();
        if (data != null) {
            for (UserModel ddm : data) {
                UserDto dto = new UserDto();
                if (ddm.getKduser() != null) {
                    dto.setKduser(ddm.getKduser());
                }
                if (ddm.getUsername() != null) {
                    dto.setUsername(ddm.getUsername());
                }
                if (ddm.getPassword() != null) {
                    dto.setPassword(ddm.getPassword());
                }
                if (ddm.getAkses() != null) {
                    try {
                        am = aksesDao.getAksesById(ddm.getAkses());
                    } catch (Exception ex) {

                    }
                    dto.setAkses(am.getNamaakses());
                }
                if (ddm.getNim() != null) {
                    dto.setNim(ddm.getNim());
                }
                if (ddm.getNip() != null) {
                    dto.setNip(ddm.getNip());
                }
                if (ddm.getKeterangan() != null) {
                    dto.setKeterangan(ddm.getKeterangan());
                }
                ListDto.add(dto);
            }
        }
        return ListDto;
    }

    @Override
    public void deleteDataUser(String kduser) throws Exception {
        try {
            userDao.deleteDataUser(kduser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserModel getUserById(String kduser) {
        UserModel userModel = null;
        try {
            userModel = userDao.getUserById(kduser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userModel;
    }

    @Override
    public UserDto updateDataForm(String kduser) throws Exception {
        List<UserModel> dataList = userDao.getListUserUpdate(kduser);
        UserDto dto = new UserDto();
        if (dataList != null) {
            for (UserModel ddm : dataList) {
                if (ddm.getKduser() != null) {
                    dto.setKduser(ddm.getKduser());
                }
                if (ddm.getUsername() != null) {
                    dto.setUsername(ddm.getUsername());
                }
                if (ddm.getPassword() != null) {
                    dto.setPassword(ddm.getPassword());
                }
                if (ddm.getAkses() != null) {
                    dto.setAkses(ddm.getAkses());
                }
                if (ddm.getAkses().equals("5") || ddm.getAkses().equals("6")) {
                    dto.setNim(ddm.getNim() != null ? ddm.getNim() : "");
                    dto.setNip(ddm.getNip() != null ? ddm.getNip() : "");
                } else {
                    dto.setNim(ddm.getNip() != null ? ddm.getNip() : "");
                    dto.setNip(ddm.getNip() != null ? ddm.getNip() : "");
                }
                if (ddm.getKeterangan() != null) {
                    dto.setKeterangan(ddm.getKeterangan());
                }

            }
        }
        return dto;
    }

    @Override
    public void doUpdateDataForm(UserDto userDto) throws Exception {
        UserModel ddm = new UserModel();
        try {
            ddm.setKduser(userDto.getKduser());
            ddm.setUsername(userDto.getUsername());
            ddm.setPassword(userDto.getPassword());
            ddm.setAkses(userDto.getAkses());
            if (userDto.getAkses().equals("5") || userDto.getAkses().equals("6")) {
                ddm.setNim(userDto.getNim());
                ddm.setNip("");
            } else {
                ddm.setNim("");
                ddm.setNip(userDto.getNim());
            }
            ddm.setKeterangan(userDto.getKeterangan());

        } catch (Exception e) {
            e.printStackTrace();
        }
        userDao.updateUser(ddm);
    }

    public String generateKodeUser() {
        return null;
    }

    @Override
    public List<UserDto> searchUser(String cariBerdasarkan, String cariKey) {
        List<UserDto> listUserDto = new ArrayList();
        List<Object[]> listDataObject = userDao.getListCariDataUserNativeQuery(cariBerdasarkan, cariKey);
        List<UserModel> data = userDao.getListDataUser();
        AksesModel am = new AksesModel();
        if (listDataObject != null) {
            for (Object[] object : listDataObject) {
                UserDto dto = new UserDto();
                if (object[0] != null) {
                    dto.setKduser(object[0].toString());
                }
                if (object[1] != null) {
                    dto.setUsername(object[1].toString());
                }
                if (object[2] != null) {
                    dto.setPassword(object[2].toString());
                }
                if (object[3] != null) {
//                    dto.setAkses(object[3].toString());
                    try {
                        am = aksesDao.getAksesById(object[3].toString());
                    } catch (Exception ex) {

                    }
                    dto.setAkses(am.getNamaakses());
                }
                if (object[4] != null) {
                    dto.setNim(object[4].toString());
                }
                if (object[5] != null) {
                    dto.setNip(object[5].toString());
                }
                if (object[6] != null) {
                    dto.setKeterangan(object[6].toString());
                }
                listUserDto.add(dto);
            }
        }
        return listUserDto;
    }

    @Override
    public List<Object[]> getCountUsernameService(String username) {
        List<Object[]> listDataObject = userDao.getCountUsername(username);
        return listDataObject;
    }

    @Override
    public List<Object[]> getCountUsernameAndPasswordService(String username, String password) {
        List<Object[]> listDataObject = userDao.getCountUsernameAndPassword(username, password);
        return listDataObject;
    }

    @Override
    public List<Object[]> getCountUsernameAndPasswordAndAksesService(String username, String password, String akses) {
        List<Object[]> listDataObject = userDao.getCountUsernameAndPasswordAndAkses(username, password, akses);
        return listDataObject;
    }

    @Override
    public List<UserDto> getListDataUserByLogin(String username, String password, String akses) {
        List<UserDto> listUserDto = new ArrayList();
        List<Object[]> listDataObject = userDao.getListDataUserByLogin(username, password, akses);
        List<UserModel> data = userDao.getListDataUser();
        AksesModel am = new AksesModel();
        if (listDataObject != null) {
            for (Object[] object : listDataObject) {
                UserDto dto = new UserDto();
                if (object[0] != null) {
                    dto.setKduser(object[0].toString());
                }
                if (object[1] != null) {
                    dto.setUsername(object[1].toString());
                }
                if (object[2] != null) {
                    dto.setPassword(object[2].toString());
                }
                if (object[3] != null) {
                    dto.setAkses(object[3].toString());
                }
                if (object[4] != null) {
                    dto.setNim(object[4].toString());
                }
                if (object[5] != null) {
                    dto.setNip(object[5].toString());
                }
                if (object[6] != null) {
                    dto.setKeterangan(object[6].toString());
                }
                listUserDto.add(dto);
            }
        }
        return listUserDto;
    }

    public String generateKode() {
        Random random = new Random();
        char[] kode = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        String tamp = "";
        for (int lenght = 0; lenght < 7; lenght++) {
            tamp += kode[random.nextInt(kode.length)];
        }
        return tamp;
    }

    @Override
    public List<UserDto> saveDataUserOtomatis(String nim, String nama) throws Exception {
        UserModel dataModel = new UserModel();
        dataModel.setKduser("U" + generateKode());
        dataModel.setUsername(nama.replaceAll("\\s+", "") + nim);
        dataModel.setPassword(generateKode());
        dataModel.setAkses("5");
        dataModel.setNim(nim);
        dataModel.setNip("");
        dataModel.setKeterangan("mahasiswa");
        userDao.saveDataUser(dataModel);
        
        UserDto user = new UserDto();
        user.setUsername(dataModel.getUsername());
        user.setPassword(dataModel.getPassword());
        List<UserDto> result = new ArrayList<>();
        result.add(user);
        return result;
    }

    @Override
    public UserDto updateDataFormMhs(String nim) throws Exception {
        List<UserModel> dataList = userDao.getListUserUpdateMhs(nim);
        UserDto dto = new UserDto();
        if (dataList != null) {
            for (UserModel ddm : dataList) {
                if (ddm.getKduser() != null) {
                    dto.setKduser(ddm.getKduser());
                }
                if (ddm.getUsername() != null) {
                    dto.setUsername(ddm.getUsername());
                }
                if (ddm.getPassword() != null) {
                    dto.setPassword(ddm.getPassword());
                }
                if (ddm.getAkses() != null) {
                    dto.setAkses(ddm.getAkses());
                }
                if (ddm.getAkses().equals("5") || ddm.getAkses().equals("6")) {
                    dto.setNim(ddm.getNim() != null ? ddm.getNim() : "");
                    dto.setNip(ddm.getNip() != null ? ddm.getNip() : "");
                } else {
                    dto.setNim(ddm.getNip() != null ? ddm.getNip() : "");
                    dto.setNip(ddm.getNip() != null ? ddm.getNip() : "");
                }
                if (ddm.getKeterangan() != null) {
                    dto.setKeterangan(ddm.getKeterangan());
                }

            }
        }
        return dto;
    }

    @Override
    public void doUpdateDataFormMhs(UserDto userDto) throws Exception {
        UserModel ddm = new UserModel();
        try {
            ddm.setKduser(userDto.getKduser());
            ddm.setUsername(userDto.getUsername());
            ddm.setPassword(userDto.getPassword());
            ddm.setAkses(userDto.getAkses());
            if (userDto.getAkses().equals("5") || userDto.getAkses().equals("6")) {
                ddm.setNim(userDto.getNim());
                ddm.setNip("");
            } else {
                ddm.setNim("");
                ddm.setNip(userDto.getNim());
            }
            ddm.setKeterangan(userDto.getKeterangan());

        } catch (Exception e) {
            e.printStackTrace();
        }
        userDao.updateUserMhs(ddm);
    }

}
