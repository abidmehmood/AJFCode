//UpdateRequired.java
package obssao.persistence;


public interface UpdateRequired extends PersistableState {

}

    aspect UpdateRequiredAspect {

public void UpdateRequired.entry(){
        System.out.println("UpdateRequired.entry() with = "+this);

        this.update();
        }

public void UpdateRequired.exit(){
        System.out.println("UpdateRequired.exit()");
        }

public void UpdateRequired.update(){
        System.out.println("UpdateRequired.update() with persistable="+persistable.updatedState);
        persistable.setState(persistable.updatedState);
        }

public String UpdateRequired.toString(){
        return"UpdateRequired";
        }
        }