// package com.yu.experience.pltp.pay.rsa;
//
// import java.io.FileInputStream;
// import java.io.FileOutputStream;
// import java.io.ObjectInputStream;
// import java.io.ObjectOutputStream;
// import java.security.Key;
// import java.security.KeyPair;
// import java.security.KeyPairGenerator;
// import java.security.SecureRandom;
//
// import javax.crypto.Cipher;
//
// // import org.springframework.util.Base64Utils;
//
// public class RSA_Encrypt {
//
// private static String ALGORITHM = "RSA";
//
// private static int KEYSIZE = 1024;
//
// private static String PUBLIC_KEY_FILE = "PublicKey";
//
// private static String PRIVATE_KEY_FILE = "PrivateKey";
//
// private static void generateKeyPair() throws Exception {
// SecureRandom sr = new SecureRandom();
//
// KeyPairGenerator kpg = KeyPairGenerator.getInstance(ALGORITHM);
//
// kpg.initialize(KEYSIZE, sr);
//
// KeyPair kp = kpg.generateKeyPair();
//
// Key publicKey = kp.getPublic();
// System.out.println("publicKey: " + publicKey);
//
// Key privateKey = kp.getPrivate();
// System.out.println("privateKey: " + privateKey);
//
// ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(PUBLIC_KEY_FILE));
//
// ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(PRIVATE_KEY_FILE));
//
// oos1.writeObject(publicKey);
// oos2.writeObject(privateKey);
//
// oos1.close();
// oos2.close();
// }
//
// public static String encrypt(String source) throws Exception {
// generateKeyPair();
//
// ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PUBLIC_KEY_FILE));
//
// Key key = (Key)ois.readObject();
// ois.close();
//
// Cipher cipher = Cipher.getInstance(ALGORITHM);
// cipher.init(Cipher.ENCRYPT_MODE, key);
//
// byte[] b = source.getBytes();
//
// byte[] b1 = cipher.doFinal(b);
//
// return Base64Utils.encodeToString(b1) ;
// }
//
// public static String encryptUsePrivateKey(String source) throws Exception {
// generateKeyPair();
//
// ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PRIVATE_KEY_FILE));
//
// Key key = (Key)ois.readObject();
// ois.close();
//
// Cipher cipher = Cipher.getInstance(ALGORITHM);
// cipher.init(Cipher.ENCRYPT_MODE, key);
//
// byte[] b = source.getBytes();
//
// byte[] b1 = cipher.doFinal(b);
//
// return Base64Utils.encodeToString(b1) ;
// }
//
// public static String decrypt(String cryptgraph) throws Exception {
// ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PRIVATE_KEY_FILE));
// Key key = (Key)ois.readObject();
// Cipher cipher = Cipher.getInstance(ALGORITHM);
// cipher.init(Cipher.DECRYPT_MODE, key);
//
// byte[] b = Base64Utils.decodeFromString(cryptgraph);
//
// byte[] b1 = cipher.doFinal(b);
//
// return new String(b1);
// }
//
//
// public static String decryptUsePublicKey(String cryptgraph) throws Exception {
// ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PUBLIC_KEY_FILE));
// Key key = (Key)ois.readObject();
// Cipher cipher = Cipher.getInstance(ALGORITHM);
// cipher.init(Cipher.DECRYPT_MODE, key);
//
// byte[] b = Base64Utils.decodeFromString(cryptgraph);
//
// byte[] b1 = cipher.doFinal(b);
//
// return new String(b1);
// }
//
// public static void main(String[] args) throws Exception {
// // ��Կ���ܣ� ˽Կ����
// String source = "RSA TEST";
//
// String cryptgraph = encrypt(source);
// System.out.println("cryptgraph: " + cryptgraph);
//
// String target = decrypt(cryptgraph);
// System.out.println("target: " + target);
//
// //------------------------------------------
//
// // //˽Կ���ܣ� ��Կ����
// // String reverseSource = "RSA REVERSE TEST";
// // String reversecryptgraph = encryptUsePrivateKey(reverseSource);
// // System.out.println(reversecryptgraph);
// //
// // String reversetarget = decryptUsePublicKey(reversecryptgraph);
// // System.out.println(reversetarget);
//
// }
// }
