package test.persona.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import persona.enums.Sex;
import persona.model.Persona;
import persona.services.PersonaServices;

public class PersonaServicesShould {

    private PersonaServices personaServices;


    @BeforeEach
    private void setUp(){
        personaServices = new PersonaServices();
    }


    @Test
    @DisplayName("Check if persona is male")
    private void checkIfPersonaIsMale(){
        Persona persona = new Persona(55.0, 1.65, Sex.MALE, 22);
        Assertions.assertTrue(personaServices.isPersonaMale(persona));
    }

    @Test
    @DisplayName("Check if persona is female")
    private void checkIfPersonaIsFemale(){
        Persona persona = new Persona(55.0, 1.65, Sex.FEMALE, 22);
        Assertions.assertTrue(personaServices.isPersonaMale(persona));
    }


    @Test
    @DisplayName("Check if persona is senior")
    private void checkIfPersonaIsSenior(){
        Persona persona = new Persona(55.0, 1.65, Sex.FEMALE, 80);
        Assertions.assertTrue(personaServices.isPersonaSenior(persona));
    }

    @Test
    @DisplayName("Check if persona is adult")
    private void checkIfPersonaIsAdult(){
        Persona persona = new Persona(55.0, 1.65, Sex.FEMALE, 22);
        Assertions.assertTrue(personaServices.isPersonaAdult(persona));
    }
}
