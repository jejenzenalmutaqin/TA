/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dto;

/**
 *
 * @author Barne's
 */
public class ViewKelulusanDto {
    String nim,namamahasiswa,judulproposal,namajurusan,kdkelulusan,tgllulus,revisi,mulairevisi,
            akhirrevisi,penyerahanrevisi,kdsidang,kdjurusan;
    Integer angkatan;
    Double ipk;

    public Integer getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(Integer angkatan) {
        this.angkatan = angkatan;
    }
    
    public String getKdjurusan() {
        return kdjurusan;
    }

    public void setKdjurusan(String kdjurusan) {
        this.kdjurusan = kdjurusan;
    }
    
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNamamahasiswa() {
        return namamahasiswa;
    }

    public void setNamamahasiswa(String namamahasiswa) {
        this.namamahasiswa = namamahasiswa;
    }

    public String getJudulproposal() {
        return judulproposal;
    }

    public void setJudulproposal(String judulproposal) {
        this.judulproposal = judulproposal;
    }

    public String getNamajurusan() {
        return namajurusan;
    }

    public void setNamajurusan(String namajurusan) {
        this.namajurusan = namajurusan;
    }

    public String getKdkelulusan() {
        return kdkelulusan;
    }

    public void setKdkelulusan(String kdkelulusan) {
        this.kdkelulusan = kdkelulusan;
    }

    public String getTgllulus() {
        return tgllulus;
    }

    public void setTgllulus(String tgllulus) {
        this.tgllulus = tgllulus;
    }

    public String getRevisi() {
        return revisi;
    }

    public void setRevisi(String revisi) {
        this.revisi = revisi;
    }

    public String getMulairevisi() {
        return mulairevisi;
    }

    public void setMulairevisi(String mulairevisi) {
        this.mulairevisi = mulairevisi;
    }

    public String getAkhirrevisi() {
        return akhirrevisi;
    }

    public void setAkhirrevisi(String akhirrevisi) {
        this.akhirrevisi = akhirrevisi;
    }

    public String getPenyerahanrevisi() {
        return penyerahanrevisi;
    }

    public void setPenyerahanrevisi(String penyerahanrevisi) {
        this.penyerahanrevisi = penyerahanrevisi;
    }

    public String getKdsidang() {
        return kdsidang;
    }

    public void setKdsidang(String kdsidang) {
        this.kdsidang = kdsidang;
    }

    public Double getIpk() {
        return ipk;
    }

    public void setIpk(Double ipk) {
        this.ipk = ipk;
    }
    
    
}
