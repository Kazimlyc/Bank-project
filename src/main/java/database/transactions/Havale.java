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
public class Havale extends DbConnection implements IBilgiController {

    private int gonderilecekMiktar = 0;
    private String havaleAlacakKisi = null; //musteri no

    public boolean havaleYapildiMi() {
        if (bilgilerGecerliMi()) {
            String query = "UPDATE kullanci_bakiye"
                    + "SET bakiye = - '" + this.gonderilecekMiktar + "'"
                    + "WHERE kullanici_id = '" + getHesapBilgileri().getKullaniciId() + "'";
            String query2 = "UPDATE kullanici_bakiye"
                    + "SET bakiye = bakiye + '" + this.gonderilecekMiktar + "'"
                    + "WHERE musteri_no = '" + this.havaleAlacakKisi + "'";
            try {
                super.statement = super.connection.createStatement();
                if (statement.executeUpdate(query2) == 1) {
                        statement.executeUpdate(query);
                        getHesapBilgileri().setBakiye(getHesapBilgileri().getBakiye() - this.gonderilecekMiktar);
                        return true;
                }else {
                    return false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Havale.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }

        } else {
            return false;
        }
    }

    @Override
    public boolean bilgilerGecerliMi() {
        return !(this.gonderilecekMiktar == 0
                || this.havaleAlacakKisi == null
                || this.gonderilecekMiktar > getHesapBilgileri().getBakiye()
                || this.havaleAlacakKisi.equals(getHesapBilgileri().getMusteriNo()));
    }

    @Override
    public HesapBilgileri getHesapBilgileri() {
        return HesapBilgileri.getInstance();
    }

    /**
     * @return the gonderilecekMiktar
     */
    public int getGonderilecekMiktar() {
        return gonderilecekMiktar;
    }

    /**
     * @param gonderilecekMiktar the gonderilecekMiktar to set
     */
    public void setGonderilecekMiktar(int gonderilecekMiktar) {
        this.gonderilecekMiktar = gonderilecekMiktar;
    }

    /**
     * @return the havaleAlacakKisi
     */
    public String getHavaleAlacakKisi() {
        return havaleAlacakKisi;
    }

    /**
     * @param havaleAlacakKisi the havaleAlacakKisi to set
     */
    public void setHavaleAlacakKisi(String havaleAlacakKisi) {
        this.havaleAlacakKisi = havaleAlacakKisi;
    }

}
