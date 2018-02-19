//Encrypter.aj

package obssao.encryption;

public aspect Encrypter {

    pointcut encryptionRequiredUsed(EncryptionRequired ur): execution (* *(..)) && target (ur);

    pointcut excludeInternalCalls(): !within (EncryptableAspect) || !within (EncryptableStateAspect) ||
            !within (EncryptionRequiredAspect);
    pointcut toUse(EncryptionRequired ur): encryptionRequiredUsed(ur) && excludeInternalCalls();

    before (EncryptionRequired ur): toUse(ur) {

        System.out.println("Encrypter.JoinPoint detected: Going to execute advice");

        EncryptableAspect.EncryptableClass p = EncryptableAspect.EncryptableClass.getInstance();
        ur.encryptable = p;
        ur.encryptable.state = EncryptableAspect.EncryptableStateClass.getInstance();
        ur.encryptable.encryptionRequiredState = EncryptableAspect.EncryptionRequiredClass.getInstance(p);

        System.out.println("Encrypter.Finished executing advice");
    }

}
