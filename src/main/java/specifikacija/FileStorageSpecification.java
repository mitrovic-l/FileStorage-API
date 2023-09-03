package specifikacija;

import specifikacija.izuzeci.*;

import java.util.List;

public interface FileStorageSpecification {

    void setFileName(String fileName);

    /**
     * Kreira fajl sa zadatim imenom na zadatoj putanji.
     * @param fileName ime fajla
     */
    void createFile(String fileName) throws InvalidExtension, DuplicateName;

    /**
     * Brise fajl na zadatoj putanji.
     * @param fileName putanja fajla
     */
    void deleteFile(String fileName) throws NoSuchFile;

    /**
     * Preimenovanje fajla na zadatoj putanji.
     * @param fileName ime fajla
     * @param newFileName novo ime fajla
     */
    void renameFile(String fileName, String newFileName) throws DuplicateName, NoSuchFile;

    /**
     * Premestanje fajla u zadati direktorijum.
     * @param fileName ime fajla
     * @param newDirPath putanja direktorijuma u koji ce fajl biti premesten
     */
    void moveFile(String fileName, String newDirPath) throws DuplicateName, NoSuchFile, OversizeException;

    /**
     * Vraca putanju za zadato ime fajla.
     * @param fileName ime fajla
     * @return putanja fajla
     */
    String getFilePath(String fileName);

    /**
     * Preuzima fajl sa prosledjenim imenom
     * @param fileName ime fajla
     * @return  true ako je preuzimanje uspesno
     * @throws NoSuchFile
     */
    boolean downloadFile(String fileName) throws NoSuchFile, UnsupportedOperation;

    /**
     * Postavlja fajl sa lokalnog storage-a na remote storage.
     * @param fileName ime fajla
     * @return  true ako je postavljanje uspesno
     * @throws UnsupportedOperation
     */
    boolean uploadFile(String fileName) throws UnsupportedOperation;

    /**
     * Kreira skladiste na datoj putanji sa zadatom velicinom i restrikcijama
     * @param path   putanja direktorijuma
     * @param storageSize   velicina skladista
     * @param restriction   restrikcije vezane za skladiste
     */
    void storageInit(String path,int storageSize,String restriction);


    /**
     * Kreira direktorijum sa zadatim imenom i brojem fajlova i foldera koje moze sadrzati
     * @param name  ime direktorijuma
     * @param numOfFiles  maksimalan broj fajlova koje direktorijum moze da sadrzi
     */
    void createDirectory(String name,Integer... numOfFiles) throws DuplicateName;


    /**
     * Brise direktorijum na zadatoj putanji
     * @param dirName  putanja direktorijuma
     */
    void deleteDirectory(String dirName) throws NoSuchFile, InvalidDelete;

    /**
     * Kreiranje ogranicenja na direktorijumu postavljanjem nedozvoljenih ekstenzija
     * @param unsupportedExtensions nedozvoljene ekstenzije
     */
    void setUnsupportedExtensions(String[] unsupportedExtensions);

    /**
     * Vraca putanju direktorijuma za prosledjeno ime
     * @param name ime direktorijuma
     * @return putanja direktorijuma
     */
    String getDirectoryPath(String name);

    /**
     * Preuzima direktorijum na prosledjenu putanju
     * @param sourcePath    putanja direktorijuma na skladistu
     * @param destinationPath   putanja za preuzimanje direktorijuma
     */
    void downoloadDirectory(String sourcePath, String destinationPath) throws UnsupportedOperation;

    /**
     * menja ime direktorijuma
     * @param dirName trenurno ime direktorijuma
     * @param novoIme novo ime direktorijuma
     */
    void renameDirectory(String dirName,String novoIme) throws UnsupportedOperation, DuplicateName;

    /**
     * Vraca sve fajlve iz direktorijuma
     * @param path putanja direktorijuma
     * @return lista fajlova
     */
    List<String> listAll(String...path);

    /**
     * Vraca sve fajlove iz svih direktorijuma u datom direktorijumu
     * @param path  putanja direktorijuma
     * @return lista fajlova
     */
    List<String> listFull(String... path);

    /**
     * Vraca sve fajlove sa odredjenom ekstenzijom
     * @param extname ime ekstenzije
     * @return lista fajlova
     */
    List<String> listExt(String ... extname);

    /**
     * Vraca sve fajlove koji pocinju,sadrze ili se zavrsavaju zadatim podstringom
     * @param substring podstring za pretragu
     * @return lista fajlova
     */
    List<String> listFilesWith(String substring);

    /**
     * Proverava da li direktorijum sadrzi fajlove sa zadatom listom imena
     * @param path putanja zadatog direktorijuma
     * @param fileNames lista imena
     * @return true ako direktorijum sadrzi prosledjene fajlove, false u suprotnom
     */
    boolean listContains(String path,String ...fileNames);

    /**
     * Vraca putanju direktorijuma u kom se nalazi dati fajl.
     * @param fileName ime fajla
     * @return ime direktorijuma
     */
    String findDirecotry(String fileName) throws NoSuchFile;

    /**
     * Sortira fajlove u direktorijumu po zadatim kriterijumima
     * @param order redosled sortiranja
     * @param criteria kriterijumi za soritranje
     */
    List<String> sort(String order, String ... criteria);

    /**
     * Vraca sve fajlove iz zadatog direktorijuma koji su kreirani u datom periodu
     * @param path putanja direktorijuma
     * @param time period
     */
    List<String> filesFromPeriod(String path,String time);

    /**
     * Filtrira podatke o trazenim fajlovima
     * @param modifications modifikacije
     */
    void fileInfoFilter(String... modifications);

    /**
     * Prelazak u sledeci direktorijum
     * @param path putanja direktorijuma
     * @return  true ako moze preci u sledeci direktorijum, false u suprotnom
     */
    boolean forward(String path);

    /**
     * Vracanje nazad u prethodni direktorijum.
     * @return  true ako se moze vratiti u prethodni, false u suprotnom
     */
    boolean backwards();

    /**
     * Vraca korensku putanju skladista.
     * @return putanja skladista
     */
    String getRoot();

}
