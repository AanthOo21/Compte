package org.example.compte.exceptions;

public class SoldeInsuffisantException extends Exception{
    public SoldeInsuffisantException() {
        super("Solde insuffisant");
    }

    public SoldeInsuffisantException(String message) {
        super(message);
    }
}
