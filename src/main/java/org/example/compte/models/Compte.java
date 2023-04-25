package org.example.compte.models;

import org.example.compte.exceptions.MontantNegatifException;
import org.example.compte.exceptions.SoldeInsuffisantException;
import org.example.compte.interfaces.PasseageEnNegatifSubscriber;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Compte {
    private final List<PasseageEnNegatifSubscriber> passeageEnNegatifEvent = new ArrayList<>();
    private String numero;

    private double solde;

    private double ligneDeCredit;
    public Compte(String numero, double ligneDeCredit) {
        this.numero = numero;
        this.ligneDeCredit = ligneDeCredit;
        this.solde = 0;
    }

    public String getNumero() {
        return numero;
    }

    private void setLigneDeCredit(double ligneDeCredit) throws MontantNegatifException {
        if (ligneDeCredit < 0)
            throw new MontantNegatifException("Ligne de crédit doit être positive");
        this.ligneDeCredit = ligneDeCredit;
    }

    public double getLigneDeCredit() {
        return ligneDeCredit;
    }

    private void setSolde(double solde){
        this.solde = solde;
    }

    public double getSolde() {
        return solde;
    }

    public void retrait(double montant) throws Exception {
        double ancientSolde = getSolde();

        if (montant < 0)
            throw new MontantNegatifException("Le montant doit être positif");
        if (solde - montant < -getLigneDeCredit())
            throw new SoldeInsuffisantException();

        setSolde(getSolde() - montant);

        if (ancientSolde > 0 && getSolde() < 0)
            raisePassageEnNegatifEvent();
    }

    public void depot(double montant) throws Exception {
        if (montant < 0)
            throw new MontantNegatifException();

        setSolde(getSolde() + montant);
    }

    public void addPassageEnNegatifSubscriber(PasseageEnNegatifSubscriber subscriber){
        passeageEnNegatifEvent.add(subscriber);
    }
    public void removePassageEnNegatifSubscriber(PasseageEnNegatifSubscriber subscriber){
        passeageEnNegatifEvent.remove(subscriber);
    }
    public void raisePassageEnNegatifEvent(){
        for (PasseageEnNegatifSubscriber subscriber : passeageEnNegatifEvent) {
            subscriber.execute(this);
        }
    }

    public void disCoucou(){
        System.out.println("Coucou");
    }

}
