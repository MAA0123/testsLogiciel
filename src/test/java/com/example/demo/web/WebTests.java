package com.example.demo.web;

import com.example.demo.data.Voiture;
import com.example.demo.service.Echantillon;
import com.example.demo.service.StatistiqueImpl;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class WebTests {

    @MockBean
    StatistiqueImpl statistiqueImpl;

    @Autowired
    MockMvc mockMvc;

    @Test
    void testGetStatistiques() throws Exception {
        // Configurer le mock pour retourner un échantillon
        when(statistiqueImpl.prixMoyen()).thenReturn(new Echantillon(2, 15000));

        // Effectuer la requête GET et vérifier le résultat
        mockMvc.perform(get("/statistique"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreDeVoitures").value(2))
                .andExpect(jsonPath("$.prixMoyen").value(15000));
    }

    @Test
    void testGetStatistiques_pasDeVoiture() throws Exception {
        // Configurer le mock pour lancer une ArithmeticException (pas de voiture)
        when(statistiqueImpl.prixMoyen()).thenThrow(new ArithmeticException());

        // Effectuer la requête GET et vérifier que le status est 400 (BAD_REQUEST)
        mockMvc.perform(get("/statistique"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void testCreerVoiture() throws Exception {
        // Effectuer la requête POST avec un JSON de voiture
        mockMvc.perform(post("/voiture")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"marque\":\"f\",\"prix\":100}"))
                .andDo(print())
                .andExpect(status().isOk());

        // Vérifier que la méthode ajouter a été appelée avec n'importe quelle voiture
        verify(statistiqueImpl).ajouter(any(Voiture.class));
    }

}
