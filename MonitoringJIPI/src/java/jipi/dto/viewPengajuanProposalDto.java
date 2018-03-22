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
public class viewPengajuanProposalDto {
    String nim ;
    String nama;
    String judul;
    String jenisPengajuan;
    String perubahanJudul;
    Integer sks;
    String tglPengajuan;
    String pembimbing;
    String jurusan;
    String fakultas;
    String angkatan;

    public String getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
    }

    
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJenisPengajuan() {
        return jenisPengajuan;
    }

    public void setJenisPengajuan(String jenisPengajuan) {
        this.jenisPengajuan = jenisPengajuan;
    }

    public String getPerubahanJudul() {
        return perubahanJudul;
    }

    public void setPerubahanJudul(String perubahanJudul) {
        this.perubahanJudul = perubahanJudul;
    }

    public Integer getSks() {
        return sks;
    }

    public void setSks(Integer sks) {
        this.sks = sks;
    }

    public String getTglPengajuan() {
        return tglPengajuan;
    }

    public void setTglPengajuan(String tglPengajuan) {
        this.tglPengajuan = tglPengajuan;
    }

    public String getPembimbing() {
        return pembimbing;
    }

    public void setPembimbing(String pembimbing) {
        this.pembimbing = pembimbing;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }
    
    
}
