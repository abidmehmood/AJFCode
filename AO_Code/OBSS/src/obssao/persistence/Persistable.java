// Persistable.java 
package obssao.persistence;

public interface Persistable {

}

    aspect PersistableAspect {
// declaration of fields and methods into interface
public boolean Persistable.updated=false;
        // an instance of DBManager in result of aggregation relationship
        DBManager Persistable.persister=null;

public boolean Persistable.isUpdated(){

        return state.isUpdated();
        }

public void Persistable.update(){
        System.out.println("Persistable.update() called with state = "+state);
        state.update();
        }

public boolean Persistable.isUpdateRequired(){
        return state.isUpdateRequired();
        }

static class PersistableClass {
    public static PersistableClass getInstance() {
        return new PersistableClass();
    }
}

// aspect-specific interface implementations to provide access to intances
// of classes
// that correspond to interfaces
static class PersistableStateClass {
    static PersistableStateClass getInstance() {
        return new PersistableStateClass();
    }
}

static class UpdateRequiredClass {
    UpdateRequiredClass(Persistable p) {
        persistable = (PersistableClass) p;
    }

    static UpdateRequiredClass getInstance(Persistable p) {

        return new UpdateRequiredClass(p);
    }
}

static class UpdatedClass {
    UpdatedClass(Persistable p) {
        persistable = (PersistableClass) p;
    }

    static UpdatedClass getInstance(Persistable p) {
        return new UpdatedClass(p);
    }
}

static class AnyClass {
    AnyClass(Persistable p) {
        persistable = (PersistableClass) p;
    }

    static AnyClass getInstance(Persistable p) {
        return new AnyClass(p);
    }
}

    // declare associations of classes to interfaces and other classes
    declare parents:PersistableClass implements Persistable;
        declare parents:PersistableStateClass implements PersistableState;
        declare parents:UpdateRequiredClass implements UpdateRequired;
        declare parents:UpdatedClass implements Updated;
        declare parents:AnyClass implements Any;
        declare parents:UpdateRequiredClass extends PersistableStateClass;
        declare parents:UpdatedClass extends PersistableStateClass;
        declare parents:AnyClass extends PersistableStateClass;

public PersistableStateClass Persistable.state; // reference to class that
// handles states

public UpdateRequiredClass Persistable.updateRequiredState; // references to
// classes each
// representing
// a state
public UpdatedClass Persistable.updatedState;

// initialize the Persistable

public void Persistable.initialize(){
        System.out.println("Persistable.initialize()...");
        state=PersistableStateClass.getInstance();
        updateRequiredState=UpdateRequiredClass.getInstance(this);
        updatedState=UpdatedClass.getInstance(this);

        state.entry();
        }

public void Persistable.setState(PersistableState st){
        System.out
        .println("Persistable.setState(): going to change the state to "
        +st.toString());
        state=(PersistableStateClass)st;
        System.out.println("Persistable.setState(): stated changed to"+state);
        state.entry();
        }

        }