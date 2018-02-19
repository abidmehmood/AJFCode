// Encryptable.java

package obssao.encryption;

public interface Encryptable {

}

    aspect EncryptableAspect {
// declaration of fields and methods into interface
public boolean Encryptable.encrypted=false;

public void Encryptable.encrypt(){
        state.encrypt();
        }

public void Encryptable.decrypt(){
        state.decrypt();
        }

public boolean Encryptable.isEncrypted(){
        return state.isEncrypted();
        }

static class EncryptableClass {
    public static EncryptableClass getInstance() {
        return new EncryptableClass();
    }
}

// aspect-specific interface implementations to provide access to intances
// of classes that correspond to interfaces
static class EncryptableStateClass {
    static EncryptableStateClass getInstance() {
        return new EncryptableStateClass();
    }
}

static class EncryptionRequiredClass {
    EncryptionRequiredClass(Encryptable e) {
        encryptable = (EncryptableClass) e;
    }

    static EncryptionRequiredClass getInstance(Encryptable e) {

        return new EncryptionRequiredClass(e);
    }
}

static class EncryptedClass {
    EncryptedClass(Encryptable e) {
        encryptable = (EncryptableClass) e;
    }

    static EncryptedClass getInstance(Encryptable e) {
        return new EncryptedClass(e);
    }
}

static class AnyClass {
    AnyClass(Encryptable e) {
        encryptable = (EncryptableClass) e;
    }

    static AnyClass getInstance(Encryptable e) {
        return new AnyClass(e);
    }
}

    // declare associations of classes to interfaces and other classes
    declare parents:EncryptableClass implements Encryptable;
        declare parents:EncryptableStateClass implements EncryptableState;
        declare parents:EncryptionRequiredClass implements EncryptionRequired;
        declare parents:EncryptedClass implements Encrypted;
        declare parents:AnyClass implements Any;

        declare parents:EncryptionRequiredClass extends EncryptableStateClass;
        declare parents:EncryptedClass extends EncryptableStateClass;
        declare parents:AnyClass extends EncryptableStateClass;

public EncryptableStateClass Encryptable.state; // reference to class that
// handles states

public EncryptionRequiredClass Encryptable.encryptionRequiredState;
// references to classes each representing a state
public EncryptedClass Encryptable.encryptedState;

// initialize the Encryptable

public void Encryptable.initialize(){
        System.out.println("Encryptable.initialize()...");
        state=EncryptableStateClass.getInstance();
        encryptionRequiredState=EncryptionRequiredClass.getInstance(this);
        encryptedState=EncryptedClass.getInstance(this);

        state.entry();
        }

public void Encryptable.setState(EncryptableState st){
        System.out.println("Encryptable.setState(): going to change the state to "
        +st.toString());
        state=(EncryptableStateClass)st;
        state.entry();
        }

        }