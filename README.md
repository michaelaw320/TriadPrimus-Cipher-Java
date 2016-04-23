# TriadPrimus-Cipher-Java
TriadPrimus-Cipher Implementation in Java, mode ECB

To Use as Library:

public static void main(String[] args) {
        // TODO code application logic here
        
        TestAll();
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
