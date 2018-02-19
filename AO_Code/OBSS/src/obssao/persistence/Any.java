//Any.java
package obssao.persistence;

public interface Any extends PersistableState {

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

public boolean Any.isUpdateRequired(){
        return false;
        }

public boolean Any.isUpdated(){
        return false;
        }
        }
