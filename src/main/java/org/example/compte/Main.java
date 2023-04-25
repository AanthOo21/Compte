package org.example.compte;

import org.example.compte.exceptions.MontantNegatifException;
import org.example.compte.exceptions.SoldeInsuffisantException;
import org.example.compte.models.Compte;

public class Main {
    public static void main(String[] args) {

        Compte c = new Compte("1", 100);
        c.addPassageEnNegatifSubscriber((compte) -> System.out.println("Le compte numéro " + compte.getNumero() + " est passé en négatif."));
        c.addPassageEnNegatifSubscriber((compte) -> System.out.println("Nouveau Solde " + compte.getSolde()));
        c.addPassageEnNegatifSubscriber((compte) -> System.out.println("c'est quand même pas mal..."));
        c.addPassageEnNegatifSubscriber((compte) -> compte.disCoucou());

        try {
            c.depot(100);
            c.retrait(150);
            System.out.println("OK");
        }
        catch (MontantNegatifException e) {
            System.out.println("T'es con ou quoi ?");
            System.out.println(e.getMessage());
        }
        catch (SoldeInsuffisantException e){
            System.out.println("Va travailler ou faire une formation pour devenir un super dev");
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("----Finis----");
    }
}
