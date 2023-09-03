package specifikacija.izuzeci;

public class OversizeException extends Exception{
    String message="Greska! Direktorijum je popunjen.";

    @Override
    public String getMessage() {
        return message;
    }
}
