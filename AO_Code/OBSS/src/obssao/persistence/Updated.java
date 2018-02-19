//Updated.java
package obssao.persistence;

public interface Updated extends PersistableState {

}

    aspect UpdatedAspect {
public void Updated.entry(){
        System.out.println("Updated.entry()");
        }

public void Updated.exit(){
        System.out.println("Updated.exit()");
        }

public String Updated.toString(){
        return"Updated";
        }
        }
