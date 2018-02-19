//EncryptionRequired.java

package obssao.encryption;

public interface EncryptionRequired extends EncryptableState {

}

    aspect EncryptionRequiredAspect {


public void EncryptionRequired.entry(){
        System.out.println("EncryptionRequired.entry()");
        }

public void EncryptionRequired.exit(){
        System.out.println("EncryptionRequired.exit()");
        }

public void EncryptionRequired.encrypt(){
        System.out.println("EncryptionRequired.update()");
        encryptable.setState(encryptable.encryptedState);
        }

public String EncryptionRequired.toString(){
        return"EncryptionRequired";
        }
        }