//EncryptableState.java

package obssao.encryption;


public interface EncryptableState {

}

    aspect EncryptableStateAspect {
// constructor for this class
public EncryptableAspect.EncryptableClass EncryptableState.encryptable;

// abstract methods of this class

public void EncryptableState.entry(){
        }

public void EncryptableState.exit(){
        }

public boolean EncryptableState.isEncrypted(){

        // this method is to be overloaded in corresponding state class
        return false;
        }

public void EncryptableState.encrypt(){

        // method to be overloaded
        }

public void EncryptableState.decrypt(){

        // method to be overloaded.
        }

        }