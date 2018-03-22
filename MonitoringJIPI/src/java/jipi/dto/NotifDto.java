/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dto;

/**
 *
 * @author hp
 */
public class NotifDto {
    String kdnotif;
    String kdakses;
    String nim;
    String tglnotif;
    String subjeknotif;
    String judulnotif;
    String isinotif;
    String statusbaca;

    public String getSubjeknotif() {
        return subjeknotif;
    }

    public void setSubjeknotif(String subjeknotif) {
        this.subjeknotif = subjeknotif;
    }

    public String getStatusbaca() {
        return statusbaca;
    }

    public void setStatusbaca(String statusbaca) {
        this.statusbaca = statusbaca;
    }

    public String getKdnotif() {
        return kdnotif;
    }

    public void setKdnotif(String kdnotif) {
        this.kdnotif = kdnotif;
    }

    public String getKdakses() {
        return kdakses;
    }

    public void setKdakses(String kdakses) {
        this.kdakses = kdakses;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getTglnotif() {
        return tglnotif;
    }

    public void setTglnotif(String tglnotif) {
        this.tglnotif = tglnotif;
    }
    

    public String getJudulnotif() {
        return judulnotif;
    }

    public void setJudulnotif(String judulnotif) {
        this.judulnotif = judulnotif;
    }
    
    public String getIsinotif() {
        return isinotif;
    }

    public void setIsinotif(String isinotif) {
        this.isinotif = isinotif;
    }
}
