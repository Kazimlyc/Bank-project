/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database.transactions;

import database.DbConnection;
import database.IBilgiController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kazimkalayci
 */
public class SifreYenileme extends DbConnection implements IBilgiController {

    private String tcNo = null;
    private String telNo = null;
    private String guvenlikCevap = null;
    private String eskiSifre = null;
    private String yeniSifre = null;

    public boolean sifreYenilendiMi() {
        if (bilgilerGecerliMi()) {
            String query = " Update kullanicilar"
                    + "SET sifre = '" + this.yeniSifre + "'"
                    + "WHERE"
                    + "tc_no = '" + this.tcNo + "'"
                    + "AND"
                    + "tel_no = '" + this.telNo + "'"
                    + "AND"
                    + "gucenlik_cevap = '" + this.guvenlikCevap + "'";

            if (this.eskiSifre != null) {
                query += " AND sifre = '" + this.eskiSifre + "'";
            }

            try {
                super.statement = super.connection.createStatement();
                return statement.executeUpdate(query) == 1;
            } catch (SQLException ex) {
                Logger.getLogger(SifreYenileme.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean bilgilerGecerliMi() {
        return !(this.tcNo == null
                || this.telNo == null
                || this.guvenlikCevap == null
                || this.yeniSifre == null);
    }

    @Override
    public HesapBilgileri getHesapBilgileri() {
        return HesapBilgileri.getInstance();
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
     * @return the guvenlikCevap
     */
    public String getGuvenlikCevap() {
        return guvenlikCevap;
    }

    /**
     * @param guvenlikCevap the guvenlikCevap to set
     */
    public void setGuvenlikCevap(String guvenlikCevap) {
        this.guvenlikCevap = guvenlikCevap;
    }

    /**
     * @return the eskiSifre
     */
    public String getEskiSifre() {
        return eskiSifre;
    }

    /**
     * @param eskiSifre the eskiSifre to set
     */
    public void setEskiSifre(String eskiSifre) {
        this.eskiSifre = eskiSifre;
    }

    /**
     * @return the yeniSifre
     */
    public String getYeniSifre() {
        return yeniSifre;
    }

    /**
     * @param yeniSifre the yeniSifre to set
     */
    public void setYeniSifre(String yeniSifre) {
        this.yeniSifre = yeniSifre;
    }

}
