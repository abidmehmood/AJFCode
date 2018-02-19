//Encrypted.java

package obssao.encryption;

public interface Encrypted extends EncryptableState {

}

    aspect EncryptedAspect {

public void Encrypted.entry(){
        System.out.println("Encrypted.entry()");
        }

public void Encrypted.exit(){
        System.out.println("Encrypted.exit()");
        }

public void Encrypted.decrypt(){
        System.out.println("Encrypted.decrypt()");
        encryptable.setState(encryptable.encryptedState);

        }
public String Encrypted.toString(){
        return"Updated";
        }
        }