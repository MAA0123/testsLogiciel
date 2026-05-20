package com.example.demo.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VoitureTest {

    @Test
    void constructeurParDefaut_initialiseValeursParDefaut() {
        Voiture v = new Voiture();
        assertNull(v.getMarque(), "La marque doit être null après le constructeur par défaut");
        assertEquals(0, v.getPrix(), "Le prix doit être 0 après le constructeur par défaut");
        assertEquals(0, v.getId(), "L'id doit être 0 après le constructeur par défaut");
    }

    @Test
    void constructeurAvecArguments_initialiseChamps() {
        Voiture v = new Voiture("Renault", 15000);
        assertEquals("Renault", v.getMarque(), "La marque doit être initialisée");
        assertEquals(15000, v.getPrix(), "Le prix doit être initialisé");
        assertEquals(0, v.getId(), "L'id doit rester 0 si non défini par le constructeur");
    }

    @Test
    void settersEtGetters_fonctionnentCorrectement() {
        Voiture v = new Voiture();
        v.setMarque("Peugeot");
        v.setPrix(20000);
        v.setId(42);
        assertEquals("Peugeot", v.getMarque(), "Marque incorrecte");
        assertEquals(20000, v.getPrix(), "Prix incorrect");
        assertEquals(42, v.getId(), "Id incorrect");
    }

    @Test
    void toString_contientChampsImportants() {
        Voiture v = new Voiture("Tesla", 50000);
        v.setId(7);
        String s = v.toString();
        assertTrue(s.contains("Tesla"), "toString doit contenir la marque");
        assertTrue(s.contains("50000"), "toString doit contenir le prix");
        assertTrue(s.contains("7"), "toString doit contenir l'id");
    }
}
