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
public class FaturaOdemeleri extends DbConnection implements IBilgiController {

    private String faturaIsmi = null;
    private double faturaTutari = 0;

    public boolean faturaOdendiMi() {
        if (bilgilerGecerliMi()) {
            String query = "UPDATE kullanici_faturalar"
                    + "SET " + this.faturaIsmi + " = 0 "
                    + "WHERE kullanici_id = '" + getHesapBilgileri().getKullaniciId() + "'";
            try {
                super.statement = super.connection.createStatement();
                statement.executeUpdate(query);
                this.bakiyeAzalt();
                this.faturayiSifirla();
            } catch (SQLException ex) {
                Logger.getLogger(FaturaOdemeleri.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean bilgilerGecerliMi() {
        return !(this.faturaIsmi == null
                || this.faturaTutari == 0
                || getHesapBilgileri().getBakiye() < this.faturaTutari);
    }

    @Override
    public HesapBilgileri getHesapBilgileri() {
        return HesapBilgileri.getInstance();
    }
    
    
    private void bakiyeAzalt(){
        String query = "UPDATE kullanici_bakiye"
                + "SET bakiye = bakiye - '" + this.faturaTutari + "'"
                + "WHERE kullanici_id = '" + getHesapBilgileri().getKullaniciId() + "'";
        
        try {
            super.statement = super.connection.createStatement();
            statement.executeUpdate(query);
            getHesapBilgileri().setBakiye(getHesapBilgileri().getBakiye()- this.faturaTutari);
        } catch (SQLException ex) {
            Logger.getLogger(FaturaOdemeleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void faturayiSifirla(){
        if(bilgilerGecerliMi()){
            switch(this.faturaIsmi){
                case "elektrik":
                    getHesapBilgileri().setElektrikFaturasi(0);
                    break;
                case "su":
                    getHesapBilgileri().setSuFaturasi(0);
                    break;
                case "dogalgaz":
                    getHesapBilgileri().setDogalgazFaturasi(0);
                    break;
                case "internet":
                    getHesapBilgileri().setInternetFaturasi(0);
                    break;
            }
        }else{
        
        }
    }
    
    /**
     * @return the faturaIsmi
     */
    public String getFaturaIsmi() {
        return faturaIsmi;
    }

    /**
     * @param faturaIsmi the faturaIsmi to set
     */
    public void setFaturaIsmi(String faturaIsmi) {
        this.faturaIsmi = faturaIsmi;
    }

    /**
     * @return the faturaTutari
     */
    public double getFaturaTutari() {
        return faturaTutari;
    }

    /**
     * @param faturaTutari the faturaTutari to set
     */
    public void setFaturaTutari(double faturaTutari) {
        this.faturaTutari = faturaTutari;
    }

}
