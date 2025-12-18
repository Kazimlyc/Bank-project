/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author kazimkalayci
 */
public class DbVeriMerkezi extends DbConnection {

    protected int kullaniciId = 0;
    protected String adSoyad, telNo, tcNo, musteriNo;
    protected double bakiye;
    protected double elektrikFaturasi, suFaturasi, dogalgazFaturasi, internetFaturasi;
    
    public int getKullaniciId(){
    return kullaniciId;
    }

    public int setKullaniciId(int kullaniciId){
    return kullaniciId;
    }
    
    /**
     * @return the adSoyad
     */
    public String getAdSoyad() {
        return adSoyad;
    }

    /**
     * @param adSoyad the adSoyad to set
     */
    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    /**
     * @return the telNo
     */
    public String getTelNo() {
        return telNo;
    }

    /**
     * @param telNo the telNo to set
     */
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    /**
     * @return the tcNo
     */
    public String getTcNo() {
        return tcNo;
    }

    /**
     * @param tcNo the tcNo to set
     */
    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    /**
     * @return the musteriNo
     */
    public String getMusteriNo() {
        return musteriNo;
    }

    /**
     * @param musteriNo the musteriNo to set
     */
    public void setMusteriNo(String musteriNo) {
        this.musteriNo = musteriNo;
    }

    /**
     * @return the bakiye
     */
    public double getBakiye() {
        return bakiye;
    }

    /**
     * @param bakiye the bakiye to set
     */
    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }

    /**
     * @return the elektrikFaturasi
     */
    public double getElektrikFaturasi() {
        return elektrikFaturasi;
    }

    /**
     * @param elektrikFaturasi the elektrikFaturasi to set
     */
    public void setElektrikFaturasi(double elektrikFaturasi) {
        this.elektrikFaturasi = elektrikFaturasi;
    }

    /**
     * @return the suFaturasi
     */
    public double getSuFaturasi() {
        return suFaturasi;
    }

    /**
     * @param suFaturasi the suFaturasi to set
     */
    public void setSuFaturasi(double suFaturasi) {
        this.suFaturasi = suFaturasi;
    }

    /**
     * @return the dogalgazFaturasi
     */
    public double getDogalgazFaturasi() {
        return dogalgazFaturasi;
    }

    /**
     * @param dogalgazFaturasi the dogalgazFaturasi to set
     */
    public void setDogalgazFaturasi(double dogalgazFaturasi) {
        this.dogalgazFaturasi = dogalgazFaturasi;
    }

    /**
     * @return the internetFaturasi
     */
    public double getInternetFaturasi() {
        return internetFaturasi;
    }

    /**
     * @param internetFaturasi the internetFaturasi to set
     */
    public void setInternetFaturasi(double internetFaturasi) {
        this.internetFaturasi = internetFaturasi;
    }

}
