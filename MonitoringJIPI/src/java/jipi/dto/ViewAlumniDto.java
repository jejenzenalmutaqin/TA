package jipi.dto;

/**
 *
 * @author Barne's
 */
public class ViewAlumniDto {
    String nim,namamahasiswa,alamatperusahaan,
	sektor,profesi,tgllulus,namafakultas,kdfakultas,kdjurusan,grouping,perusahaan;
    double ipk;
    Integer angkatan;

    public String getPerusahaan() {
        return perusahaan;
    }

    public void setPerusahaan(String perusahaan) {
        this.perusahaan = perusahaan;
    }
    
    public String getGrouping() {
        return grouping;
    }

    public void setGrouping(String grouping) {
        this.grouping = grouping;
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

    public String getAlamatperusahaan() {
        return alamatperusahaan;
    }

    public void setAlamatperusahaan(String perusahaanlamatperusahaan) {
        this.alamatperusahaan = perusahaanlamatperusahaan;
    }

    public String getSektor() {
        return sektor;
    }

    public void setSektor(String sektor) {
        this.sektor = sektor;
    }

    public String getProfesi() {
        return profesi;
    }

    public void setProfesi(String profesi) {
        this.profesi = profesi;
    }

    public String getTgllulus() {
        return tgllulus;
    }

    public void setTgllulus(String tgllulus) {
        this.tgllulus = tgllulus;
    }

    public String getNamafakultas() {
        return namafakultas;
    }

    public void setNamafakultas(String namafakultas) {
        this.namafakultas = namafakultas;
    }

    public String getKdfakultas() {
        return kdfakultas;
    }

    public void setKdfakultas(String kdfakultas) {
        this.kdfakultas = kdfakultas;
    }

    public String getKdjurusan() {
        return kdjurusan;
    }

    public void setKdjurusan(String kdjurusan) {
        this.kdjurusan = kdjurusan;
    }

    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

    public Integer getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(Integer angkatan) {
        this.angkatan = angkatan;
    }
    
    
}
