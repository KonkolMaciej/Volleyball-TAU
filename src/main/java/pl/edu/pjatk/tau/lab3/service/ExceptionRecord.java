package pl.edu.pjatk.tau.lab3.service;

/**
 * Created by maciek on 15.10.17.
 */
public class ExceptionRecord extends Exception {


    public ExceptionRecord(String record) {
        super("Brak rekordu do zaktualizowania");
    }

    public static String ExceptionRecord() {
        return ("Brak rekordu do zaktualizowania");

    }
}
