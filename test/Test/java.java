/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import TriadPrimus.TriadPrimus;
import TriadPrimusCipher.Block;
import TriadPrimusCipher.PrimusKey;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael
 */
public class java {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //TestBlock();
        //TestBits();
        //TestKeygen();
        TestAll();
    }
    
    public static void TestBlock() {
        try {
            Block blk = new Block("TSTINGWITHLONGERSTRINFOFC");
            ArrayList<Long> blklng = blk.getDataBlock();
            for(Long lng : blklng) {
                System.out.printf("%x",lng.longValue());
            }
            System.out.println("--");
            System.out.println(blk.OutputToString());
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(java.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void TestBits() {
        long lng = 0xc511654621546546L;
        long lngsh = Block.CircularShiftLeft(lng);
        long lngbk = Block.CircularShiftRight(lngsh);
        System.out.printf("%x", lngsh);System.out.println();
        System.out.printf("%x", lngbk);System.out.println();
        if (lngbk == lng) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
    
    public static void TestKeygen() {
        String key = "KEYVISUALARTS";
        PrimusKey primkey = new PrimusKey(key,7);
    }
    
    public static void TestAll() {
        String data = "TESTDATATESTDATATESTDATATESTDATATESTDATATESTDATATESTDATATESTDATATESTDATATESTDATATESTDATA";
        String cipher, plain;
        String key = "KEYAKEYAA";
        System.out.println("Original: "+data);
        try {
            //Untuk encrypt
            TriadPrimus tpe = new TriadPrimus(data, key);
            cipher = tpe.Encrypt();
            System.out.println("Cipher: "+cipher);
            
            //Untuk decrypt
            TriadPrimus tpd = new TriadPrimus(cipher, key);
            plain = tpd.Decrypt();
            System.out.println("Plaintext: "+plain);
            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(java.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
