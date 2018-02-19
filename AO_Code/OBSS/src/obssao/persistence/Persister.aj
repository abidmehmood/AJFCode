//Persister.aj

package obssao.persistence;

public aspect Persister {
    pointcut updateRequiredUsed(UpdateRequired ur): execution (* *(..)) && target (ur);

    pointcut excludeInternalCalls(): !within (PersistableAspect) || !within (PersistableStateAspect) ||
            !within (UpdateRequiredAspect);
    pointcut toUse(UpdateRequired ur): updateRequiredUsed(ur) && excludeInternalCalls();

    before (UpdateRequired ur): toUse(ur) {

        System.out.println("Persister.JoinPoint detected: Going to execute advice");

        PersistableAspect.PersistableClass p = PersistableAspect.PersistableClass.getInstance();
        ur.persistable = p;
        ur.persistable.state = PersistableAspect.PersistableStateClass.getInstance();
        ur.persistable.updateRequiredState = PersistableAspect.UpdateRequiredClass.getInstance(p);
        ur.persistable.updatedState = PersistableAspect.UpdatedClass.getInstance(p);

        System.out.println("Persister.Finished executing advice");
    }
}
