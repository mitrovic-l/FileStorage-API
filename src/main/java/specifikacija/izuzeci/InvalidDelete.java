package specifikacija.izuzeci;

public class InvalidDelete extends Exception{
    String message = "Greska! Nije moguce obrisati korenski direktorijum.";

    @Override
    public String getMessage() {
        return message;
    }
}
