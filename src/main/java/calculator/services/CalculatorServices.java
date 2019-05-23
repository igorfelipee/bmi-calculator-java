package calculator.services;

import persona.enums.Weigth;
import persona.model.Persona;
import persona.services.PersonaServices;

public class CalculatorServices {

    private PersonaServices personaServices = new PersonaServices();

    public Double calculateBMI(Persona persona){
        return persona.getWeight() / Math.pow(persona.getHeight(), 2);
    }


    public String getBMIResult(Persona persona, Boolean isPregnant){

        if(personaServices.isPersonaSenior(persona)){
            return getSeniorBMI(persona);
        }else if(personaServices.isPersonaAdult(persona)){
            if(isPregnant){
                return getPregnantBMI(persona);
            }
            return getAdultBMI(persona);
        }else {
            return getChildBMI(persona);
        }
    }


    private String getSeniorBMI(Persona persona){
        Double BMIResult = calculateBMI(persona);
        if(personaServices.isPersonaMale(persona)){
          return getMaleSeniorBMIDescription(BMIResult).getDescription();
        }
        return getFemaleSeniorBMIDescription(BMIResult).getDescription();
    }

    public Weigth getMaleSeniorBMIDescription(Double bmiResult){
        if(bmiResult <= 21.9){
            return Weigth.UNDER_WEIGTH;
        }else if(bmiResult >= 22 && bmiResult <= 27){
            return Weigth.NORMAL_WEIGTH;
        }else if(bmiResult >= 27.1 && bmiResult <= 30){
            return Weigth.OVER_WEIGTH;
        }else if(bmiResult >= 30.1 && bmiResult <= 35){
            return Weigth.OBESE_FIRST_DEGREE;
        }else if(bmiResult >= 35.1 && bmiResult <= 39.9){
            return Weigth.OBESE_SECOND_DEGREE;
        }else{
            return Weigth.OBESE_THIRD_DEGREE;
        }
    }

    public Weigth getFemaleSeniorBMIDescription(Double bmiResult){
        if(bmiResult <= 21.9){
            return Weigth.UNDER_WEIGTH;
        }else if(bmiResult >= 22 && bmiResult <= 27){
            return Weigth.NORMAL_WEIGTH;
        }else if(bmiResult >= 27.1 && bmiResult <= 32){
            return Weigth.OVER_WEIGTH;
        }else if(bmiResult >= 32.1 && bmiResult <= 37){
            return Weigth.OBESE_FIRST_DEGREE;
        }else if(bmiResult >= 37.1 && bmiResult <= 41.9){
            return Weigth.OBESE_SECOND_DEGREE;
        }else{
            return Weigth.OBESE_THIRD_DEGREE;
        }
    }

    private String getAdultBMI(Persona persona){
        Double BMIResult = calculateBMI(persona);
        return getAdultBMIDescription(BMIResult).getDescription();
    }


    public Weigth getAdultBMIDescription(Double bmiResult) {
            if (bmiResult < 16) {
                return Weigth.UNDER_WEIGTH_TOO_GRAVE;
            } else if (bmiResult >= 16 && bmiResult <= 16.99) {
                return Weigth.UNDER_WEIGTH_GRAVE;
            } else if (bmiResult >= 17 && bmiResult <= 18.49) {
                return Weigth.UNDER_WEIGTH;
            } else if (bmiResult >= 18.50 && bmiResult <= 24.99) {
                return Weigth.NORMAL_WEIGTH;
            } else if (bmiResult >= 25 && bmiResult <= 29.99) {
                return Weigth.OVER_WEIGTH;
            } else if (bmiResult >= 30 && bmiResult <= 34.99) {
                return Weigth.OBESE_FIRST_DEGREE;
            } else if (bmiResult >= 35 && bmiResult <= 39.99) {
                return Weigth.OBESE_SECOND_DEGREE;
            } else{
                return Weigth.OBESE_THIRD_DEGREE;
            }
    }

    private String getPregnantBMI(Persona persona){
        Double BMIResult = calculateBMI(persona);
        return getPregnantBMIDescription(BMIResult).getDescription();
    }


    public Weigth getPregnantBMIDescription(Double bmiResult) {
        if (bmiResult < 18.5) {
            return Weigth.UNDER_WEIGTH;
        } else if (bmiResult >= 18.5 && bmiResult <= 24.9) {
            return Weigth.NORMAL_WEIGTH;
        } else if (bmiResult >= 25.0 && bmiResult <= 29.9) {
            return Weigth.OVER_WEIGTH;
        } else {
            return Weigth.OBESE;
        }
    }


    private String getChildBMI(Persona persona){
        Double BMIResult = calculateBMI(persona);
        if(personaServices.isPersonaMale(persona)){
            return getMaleChildBMIDescription(persona.getAge(), BMIResult).getDescription();
        }
        return getFemaleChildBMIDescription(persona.getAge(), BMIResult).getDescription();
    }


    private Weigth getMaleChildBMIDescription(Integer age, Double bmi) {
        if (age <= 2) {
            if (bmi <= 15) return Weigth.UNDER_WEIGTH;
            if (bmi <= 18) return Weigth.NORMAL_WEIGTH;
            if (bmi <= 21) return Weigth.OVER_WEIGTH;
            return Weigth.OBESE_FIRST_DEGREE;
        }

        if (age <= 4) {
            if (bmi <= 14) return Weigth.UNDER_WEIGTH;
            if (bmi <= 17) return Weigth.NORMAL_WEIGTH;
            if (bmi <= 18) return Weigth.OVER_WEIGTH;
            return Weigth.OBESE_FIRST_DEGREE;
        }

        if (age <= 6) {
            if (bmi <= 14) return Weigth.UNDER_WEIGTH;
            if (bmi <= 17) return Weigth.NORMAL_WEIGTH;
            if (bmi <= 18.3) return Weigth.OVER_WEIGTH;
            return Weigth.OBESE_FIRST_DEGREE;
        }

        if (age <= 8) {
            if (bmi <= 14) return Weigth.UNDER_WEIGTH;
            if (bmi <= 18) return Weigth.NORMAL_WEIGTH;
            if (bmi <= 20) return Weigth.OVER_WEIGTH;
            return Weigth.OBESE_FIRST_DEGREE;
        }

        if (age <= 10) {
            if (bmi <= 14.5) return Weigth.UNDER_WEIGTH;
            if (bmi <= 19) return Weigth.NORMAL_WEIGTH;
            if (bmi <= 22) return Weigth.OVER_WEIGTH;
            return Weigth.OBESE_FIRST_DEGREE;
        }

        if (age <= 12) {
            if (bmi <= 15.2) return Weigth.UNDER_WEIGTH;
            if (bmi <= 21) return Weigth.NORMAL_WEIGTH;
            if (bmi <= 23) return Weigth.OVER_WEIGTH;
            return Weigth.OBESE_FIRST_DEGREE;
        }

        if (age <= 14) {
            if (bmi <= 16.3) return Weigth.UNDER_WEIGTH;
            if (bmi <= 22.5) return Weigth.NORMAL_WEIGTH;
            if (bmi <= 26) return Weigth.OVER_WEIGTH;
            return Weigth.OBESE_FIRST_DEGREE;
        }

        if (age <= 16) {
            if (bmi <= 16.8) return Weigth.UNDER_WEIGTH;
            if (bmi <= 24) return Weigth.NORMAL_WEIGTH;
            if (bmi <= 26.5) return Weigth.OVER_WEIGTH;
            return Weigth.OBESE_FIRST_DEGREE;
        }

        if (age <= 18) {
            if (bmi <= 18.9) return Weigth.UNDER_WEIGTH;
            if (bmi <= 25.7) return Weigth.NORMAL_WEIGTH;
            if (bmi <= 27.9) return Weigth.OVER_WEIGTH;
            return Weigth.OBESE_FIRST_DEGREE;
        }

        if (bmi <= 19.9) return Weigth.UNDER_WEIGTH;
        if (bmi <= 26) return Weigth.NORMAL_WEIGTH;
        if (bmi <= 30.5) return Weigth.OVER_WEIGTH;
        return Weigth.OBESE_FIRST_DEGREE;
    }

    private Weigth getFemaleChildBMIDescription(Integer age, Double bmi) {
        if (age <= 2) {
            if (bmi <= 15) return Weigth.UNDER_WEIGTH;
            if (bmi <= 18) return Weigth.NORMAL_WEIGTH;
            if (bmi <= 20) return Weigth.OVER_WEIGTH;
            return Weigth.OBESE_FIRST_DEGREE;
        }

        if (age <= 4) {
            if (bmi <= 14) return Weigth.UNDER_WEIGTH;
            if (bmi <= 17) return Weigth.NORMAL_WEIGTH;
            if (bmi <= 18) return Weigth.OVER_WEIGTH;
            return Weigth.OBESE_FIRST_DEGREE;
        }

        if (age <= 6) {
            if (bmi <= 14) return Weigth.UNDER_WEIGTH;
            if (bmi <= 17) return Weigth.NORMAL_WEIGTH;
            if (bmi <= 19) return Weigth.OVER_WEIGTH;
            return Weigth.OBESE_FIRST_DEGREE;
        }

        if (age <= 8) {
            if (bmi <= 14) return Weigth.UNDER_WEIGTH;
            if (bmi <= 18) return Weigth.NORMAL_WEIGTH;
            if (bmi <= 20.7) return Weigth.OVER_WEIGTH;
            return Weigth.OBESE_FIRST_DEGREE;
        }

        if (age <= 10) {
            if (bmi <= 14.5) return Weigth.UNDER_WEIGTH;
            if (bmi <= 20) return Weigth.NORMAL_WEIGTH;
            if (bmi <= 23) return Weigth.OVER_WEIGTH;
            return Weigth.OBESE_FIRST_DEGREE;
        }

        if (age <= 12) {
            if (bmi <= 15.2) return Weigth.UNDER_WEIGTH;
            if (bmi <= 21.8) return Weigth.NORMAL_WEIGTH;
            if (bmi <= 25) return Weigth.OVER_WEIGTH;
            return Weigth.OBESE_FIRST_DEGREE;
        }

        if (age <= 14) {
            if (bmi <= 16.3) return Weigth.UNDER_WEIGTH;
            if (bmi <= 23.2) return Weigth.NORMAL_WEIGTH;
            if (bmi <= 27) return Weigth.OVER_WEIGTH;
            return Weigth.OBESE_FIRST_DEGREE;
        }

        if (age <= 16) {
            if (bmi <= 17.2) return Weigth.UNDER_WEIGTH;
            if (bmi <= 24.7) return Weigth.NORMAL_WEIGTH;
            if (bmi <= 29) return Weigth.OVER_WEIGTH;
            return Weigth.OBESE_FIRST_DEGREE;
        }

        if (age <= 18) {
            if (bmi <= 18.2) return Weigth.UNDER_WEIGTH;
            if (bmi <= 25.7) return Weigth.NORMAL_WEIGTH;
            if (bmi <= 30.2) return Weigth.OVER_WEIGTH;
            return Weigth.OBESE_FIRST_DEGREE;
        }

        if (bmi <= 18.5) return Weigth.UNDER_WEIGTH;
        if (bmi <= 25.7) return Weigth.NORMAL_WEIGTH;
        if (bmi <= 32.7) return Weigth.OVER_WEIGTH;
        return Weigth.OBESE_FIRST_DEGREE;
    }

}
