/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database.transactions;

import database.DbConnection;
import database.IBilgiController;
import gui.ayarlar.TextAyarlari;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kazimkalayci
 */
public class KullaniciBasvuru extends DbConnection implements IBilgiController {

    //basvuru bilgileri
    private String adSoyad = null, tcNo = null, telNo = null;
    private String guvenlikSorusu = null, guvenlikCevap = null;

    //sistem tarafından verilecek bilgiler
    private String musteriNo = null;
    private String sifre = null;

    @Override
    public boolean bilgilerGecerliMi() {
        return !(this.adSoyad == null
                || this.tcNo == null
                || this.telNo == null
                || this.guvenlikSorusu == null
                || this.guvenlikCevap == null
                || this.musteriNo == null
                || this.sifre == null
                || TextAyarlari.uzunlukSundanKucukMu(11, this.tcNo)
                || TextAyarlari.uzunlukSundanKucukMu(11, this.telNo));

    }

    public boolean basvuruOnaylandiMi() {
        if (this.bilgilerGecerliMi()) {
            if (this.tcNoTablodaVarMi()) {
                return false;
            } else {
                this.basvuruyuOnayla();
                return true;
            }
        } else {
            return false;
        }
    }

    private boolean tcNoTablodaVarMi() {
        String query = "SELECT tc_no FROM kullanicilar WHERE tc_no ='" + this.tcNo + "'";
        try {
            super.statement = super.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                return true; // eger tabloda veri bulunmussa true donecek
            }
        } catch (SQLException ex) {
            Logger.getLogger(KullaniciBasvuru.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    private void basvuruyuOnayla() {
        String query = "INSERT INTO kullanicilar(musteri_no,sifre,"
                + "ad_soyad,tc_no,tel_no,guvenlik_sorusu,guvenlik_cevap)"
                + "VALUES ("
                + "'" + this.musteriNo + "',"
                + "'" + this.sifre + "',"
                + "'" + this.adSoyad + "',"
                + "'" + this.tcNo + "',"
                + "'" + this.telNo + "',"
                + "'" + this.guvenlikSorusu + "',"
                + "'" + this.guvenlikCevap + "'"
                + ")";

        try {
            super.statement = super.connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(KullaniciBasvuru.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean musteriNoTablodaVarMi() {
        String query = "SELECT musteri_no FROM kullanicilar WHERE musteri_no = '" + this.musteriNo + "'";
        try {
            super.statement = super.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KullaniciBasvuru.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public HesapBilgileri getHesapBilgileri() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
     * @return the guvenlikSorusu
     */
    public String getGuvenlikSorusu() {
        return guvenlikSorusu;
    }

    /**
     * @param guvenlikSorusu the guvenlikSorusu to set
     */
    public void setGuvenlikSorusu(String guvenlikSorusu) {
        this.guvenlikSorusu = guvenlikSorusu;
    }

    /**
     * @return the guvenliCevap
     */
    public String getGuvenlikCevap() {
        return guvenlikCevap;
    }

    /**
     * @param guvenliCevap the guvenliCevap to set
     */
    public void setGuvenlikCevap(String guvenliCevap) {
        this.guvenlikCevap = guvenliCevap;
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
     * @return the sifre
     */
    public String getSifre() {
        return sifre;
    }

    /**
     * @param sifre the sifre to set
     */
    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

}
