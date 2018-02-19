//PersistableState.java
package obssao.persistence;

public interface PersistableState {

}

    aspect PersistableStateAspect {
// constructor for this class
public PersistableAspect.PersistableClass PersistableState.persistable;

// abstract methods of this class
public void PersistableState.entry(){
        }

public void PersistableState.exit(){
        }

public boolean PersistableState.isUpdated(){
        // to be overloaded.
        return false;
        }

public void PersistableState.update(){

        // to be overloaded.
        }

public boolean PersistableState.isUpdateRequired(){

        // to be overloaded.

        return false;
        }

        }