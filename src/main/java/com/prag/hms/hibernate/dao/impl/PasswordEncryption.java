package com.prag.hms.hibernate.dao.impl;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordEncryption {

//    public static void main(String[] args) throws NoSuchAlgorithmException {
//        String passwordToHash = "password";
//        String salt = getSalt();
//
//        String securePassword = get_SHA_512_SecurePassword(passwordToHash);
//        System.out.println(securePassword);
//
////        securePassword = get_SHA_256_SecurePassword(passwordToHash, salt);
////        System.out.println(securePassword);
////
////        securePassword = get_SHA_384_SecurePassword(passwordToHash, salt);
////        System.out.println(securePassword);
////
////        securePassword = get_SHA_512_SecurePassword(passwordToHash, salt);
////        System.out.println(securePassword);
//    }

    public static String get_SHA_512_SecurePassword(String passwordToHash) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            //md.update(salt.getBytes());
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

////    private static String get_SHA_256_SecurePassword(String passwordToHash, String salt) {
////        //Use MessageDigest md = MessageDigest.getInstance("SHA-256");
////    }
////
////    private static String get_SHA_384_SecurePassword(String passwordToHash, String salt) {
////        //Use MessageDigest md = MessageDigest.getInstance("SHA-384");
////    }
//
//    private static String get_SHA_512_SecurePassword(String passwordToHash, String salt) {
//        //Use MessageDigest md = MessageDigest.getInstance("SHA-512");
//    }

    //Add salt
    private static String getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }
}
