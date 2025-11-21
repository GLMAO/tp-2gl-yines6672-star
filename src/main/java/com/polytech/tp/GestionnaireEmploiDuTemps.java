package com.polytech.tp;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireEmploiDuTemps implements Subject {
    private List<ICours> listeCours = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer o) {
        if (o != null && !observers.contains(o)) {
            observers.add(o);
        }
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer o : new ArrayList<>(observers)) {
            o.update(message);
        }
    }

    public void ajouterCours(ICours cours) {
        this.listeCours.add(cours);
        String msg = "Nouveau cours ajouté : " + cours.getDescription();
        System.out.println(msg);
        notifyObservers(msg);
    }

    public void modifierCours(ICours cours, String message) {
        // Logique de modification...
        System.out.println("Cours modifié : " + message);
        notifyObservers(message);
    }

    /**
     * Méthode utilitaire appelée par les tests pour simuler un changement.
     */
    public void setChangement(String message) {
        System.out.println("Changement : " + message);
        notifyObservers(message);
    }
}