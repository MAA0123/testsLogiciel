package com.example.demo.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EchantillonTest {

    @Test
    void constructeurParDefaut_initialiseValeursParDefaut() {
        Echantillon e = new Echantillon();
        assertEquals(0, e.getNombreDeVoitures(), "Le nombre de voitures doit être 0 par défaut");
        assertEquals(0, e.getPrixMoyen(), "Le prix moyen doit être 0 par défaut");
    }

    @Test
    void constructeurAvecArguments_initialiseChamps() {
        Echantillon e = new Echantillon(5, 20000);
        assertEquals(5, e.getNombreDeVoitures(), "Le nombre de voitures doit être initialisé");
        assertEquals(20000, e.getPrixMoyen(), "Le prix moyen doit être initialisé");
    }

    @Test
    void setNombreDeVoitures_modifieLaValeur() {
        Echantillon e = new Echantillon();
        e.setNombreDeVoitures(10);
        assertEquals(10, e.getNombreDeVoitures(), "Le setter doit modifier le nombre de voitures");
    }

    @Test
    void setPrixMoyen_modifieLaValeur() {
        Echantillon e = new Echantillon();
        e.setPrixMoyen(25000);
        assertEquals(25000, e.getPrixMoyen(), "Le setter doit modifier le prix moyen");
    }
}
