package specifikacija.izuzeci;

public class UnsupportedOperation extends Exception{
    String message = "Greska! Operacija nije podrzana.";

    @Override
    public String getMessage() {
        return message;
    }
}
