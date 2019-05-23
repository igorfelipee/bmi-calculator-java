package persona.services;

import persona.enums.Sex;
import persona.model.Persona;

public class PersonaServices {


    public Boolean isPersonaSenior(Persona persona){
        return persona.getAge() > 65;
    }

    public Boolean isPersonaAdult(Persona persona){
        return persona.getAge() > 18;
    }

    public Boolean isPersonaMale(Persona persona){
        return persona.getSex() == Sex.MALE;
    }

    public Boolean isPersonaFemale(Persona persona){
        return persona.getSex() == Sex.FEMALE;
    }

}
