// Any.java
package obssao.encryption;

public interface Any extends EncryptableState {

}

    aspect AnyAspect {
public void Any.entry(){
        System.out.println("Any.entry()");
        }

public void Any.exit(){
        System.out.println("Any.exit()");
        }

public String Any.toString(){
        return"Any";
        }

public boolean Any.isEncrypted(){
        return false;
        }

        }