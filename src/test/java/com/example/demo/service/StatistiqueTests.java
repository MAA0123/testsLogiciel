package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StatistiqueTests{

    private StatistiqueImpl stats;

    @BeforeEach
    void setUp() {
        stats = new StatistiqueImpl();
    }

    @Test
    void prixMoyen_surEchantillonVide_lanceArithmeticException() {
        assertThrows(ArithmeticException.class, () -> stats.prixMoyen());
    }

    @Test
    void ajouterEtPrixMoyen_unSeulElement_retourneCorrect() {
        Voiture v = new Voiture("Renault", 15000);
        stats.ajouter(v);

        Echantillon e = stats.prixMoyen();
        assertEquals(1, e.getNombreDeVoitures(), "Le nombre de voitures doit être 1");
        assertEquals(15000, e.getPrixMoyen(), "Le prix moyen doit être égal au prix de la voiture");
    }

    @Test
    void ajouterEtPrixMoyen_plusieursElements_calculCorrect() {
        stats.ajouter(new Voiture("Peugeot", 10000));
        stats.ajouter(new Voiture("Citroen", 20000));
        stats.ajouter(new Voiture("Fiat", 15000));

        Echantillon e = stats.prixMoyen();
        assertEquals(3, e.getNombreDeVoitures(), "Le nombre de voitures doit être 3");
        assertEquals(15000, e.getPrixMoyen(), "Le prix moyen doit être 15000");
    }

    @Test
    void ajouter_plusieursAppels_incrementeNombre() {
        stats.ajouter(new Voiture("A", 1));
        stats.ajouter(new Voiture("B", 2));

        Echantillon e = stats.prixMoyen();
        assertEquals(2, e.getNombreDeVoitures());
    }
}
