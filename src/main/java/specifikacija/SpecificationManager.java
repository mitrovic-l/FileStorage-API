package specifikacija;

public abstract class SpecificationManager {
    private static FileStorageSpecification implementation;

    public static void registerImplementation(FileStorageSpecification impl){
        implementation = impl;
    }

    public static FileStorageSpecification getImplementation(){
        return implementation;
    }
}
