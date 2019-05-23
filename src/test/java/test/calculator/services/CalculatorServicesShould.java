package test.calculator.services;

import calculator.services.CalculatorServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import persona.enums.Sex;
import persona.enums.Weigth;
import persona.model.Persona;

public class CalculatorServicesShould {

    private CalculatorServices calculatorServices;


    @BeforeEach
    private void setUp(){
        calculatorServices = new CalculatorServices();
    }

    @Test
    @DisplayName(value="Return BMI value as Double type")
    public void returnBMIValueAsDouble(){
        Persona persona = new Persona(55.0, 1.65, Sex.MALE, 22);
        Assertions.assertTrue(calculatorServices.calculateBMI(persona) instanceof Double);
    }

    @Test
    @DisplayName(value="Return the right BMI value")
    public void returnTheRightBMIValue(){
        Persona persona = new Persona(55.0, 1.65, Sex.MALE, 22);
        Assertions.assertEquals(Double.valueOf(20.202020202020204), calculatorServices.calculateBMI(persona));
    }

    @Test
    @DisplayName(value="Return UNDER_WEIGTH_TOO_GRAVE if Adult BMI is under 16")
    public void returnUnderWeigthTooGraveAdult(){
        Double bmi = 15.0;
        Assertions.assertEquals(Weigth.UNDER_WEIGTH_TOO_GRAVE,calculatorServices.getAdultBMIDescription(bmi));
    }

    @Test
    @DisplayName(value="Return UNDER_WEIGTH_GRAVE if Adult BMI is equal or higher 16 and equal or under 16.9")
    public void returnUnderWeigthGraveAdult(){
        Double bmi = 16.0;
        Assertions.assertEquals(Weigth.UNDER_WEIGTH_GRAVE,calculatorServices.getAdultBMIDescription(bmi));
    }

    @Test
    @DisplayName(value="Return UNDER_WEIGTH if Adult BMI is equal or higher 17 and equal or under 18.4")
    public void returnUnderWeigthAdult(){
        Double bmi = 17.0;
        Assertions.assertEquals(Weigth.UNDER_WEIGTH,calculatorServices.getAdultBMIDescription(bmi));
    }

    @Test
    @DisplayName(value="Return NORMAL_WEIGTH if Adult BMI is equal or higher 18.5 and equal or under 24.9")
    public void returnNormalWeigthAdult(){
        Double bmi = 18.5;
        Assertions.assertEquals(Weigth.NORMAL_WEIGTH,calculatorServices.getAdultBMIDescription(bmi));
    }

    @Test
    @DisplayName(value="Return OVER_WEIGTH if Adult BMI is equal or higher 25 and equal or under 29.9")
    public void returnOverWeigthAdult(){
        Double bmi = 25.0;
        Assertions.assertEquals(Weigth.OVER_WEIGTH,calculatorServices.getAdultBMIDescription(bmi));
    }

    @Test
    @DisplayName(value="Return OBESE_FIRST_DEGREE if Adult BMI is equal or higher 30 and equal or under 34.9")
    public void returnObeseOneAdult(){
        Double bmi = 30.0;
        Assertions.assertEquals(Weigth.OBESE_FIRST_DEGREE,calculatorServices.getAdultBMIDescription(bmi));
    }

    @Test
    @DisplayName(value="Return OBESE_SECOND_DEGREE if Adult BMI is equal or higher 35 and equal or under 39.9")
    public void returnObeseTwoAdult(){
        Double bmi = 35.0;
        Assertions.assertEquals(Weigth.OBESE_SECOND_DEGREE,calculatorServices.getAdultBMIDescription(bmi));
    }

    @Test
    @DisplayName(value="Return OBESE_THIRD_DEGREE if Adult BMI is equal or higher 40")
    public void returnObeseThreeAdult(){
        Double bmi = 40.0;
        Assertions.assertEquals(Weigth.OBESE_THIRD_DEGREE,calculatorServices.getAdultBMIDescription(bmi));
    }

    @Test
    @DisplayName(value="Return UNDER_WEIGTH if Pregnant BMI is under 18.5")
    public void returnUnderWeigthPregnant(){
        Double bmi = 18.4;
        Assertions.assertEquals(Weigth.UNDER_WEIGTH,calculatorServices.getPregnantBMIDescription(bmi));
    }

    @Test
    @DisplayName(value="Return NORMAL_WEIGTH if Pregnant BMI is equal or higher 18.5 and equal or under 24.9")
    public void returnNormalWeigthPregnant(){
        Double bmi = 18.5;
        Assertions.assertEquals(Weigth.NORMAL_WEIGTH,calculatorServices.getPregnantBMIDescription(bmi));
    }

    @Test
    @DisplayName(value="Return OVER_WEIGTH if Pregnant BMI is equal or higher 25 and equal or under 29.9")
    public void returnOverWeigthPregnant(){
        Double bmi = 25.0;
        Assertions.assertEquals(Weigth.OVER_WEIGTH,calculatorServices.getPregnantBMIDescription(bmi));
    }

    @Test
    @DisplayName(value="Return OVER_WEIGTH if Pregnant BMI is equal or higher 30.0")
    public void returnObesePregnant(){
        Double bmi = 30.0;
        Assertions.assertEquals(Weigth.OBESE,calculatorServices.getPregnantBMIDescription(bmi));
    }

    @Test
    @DisplayName(value="Return UNDER_WEIGTH if Female Senior BMI is under 21.9 kg/m2")
    public void returnUnderWeigthFemaleSenior(){
        Persona persona = new Persona(55.0, 1.80, Sex.FEMALE, 66);
        Double bmi = calculatorServices.calculateBMI(persona);
        Assertions.assertEquals(Weigth.UNDER_WEIGTH,calculatorServices.getFemaleSeniorBMIDescription(bmi));
    }

    @Test
    @DisplayName(value="Return UNDER_WEIGTH if Male Senior BMI is under 21.9 kg/m2")
    public void returnUnderWeigthMaleSenior(){
        Persona persona = new Persona(55.0, 1.80, Sex.MALE, 66);
        Double bmi = calculatorServices.calculateBMI(persona);
        Assertions.assertEquals(Weigth.UNDER_WEIGTH,calculatorServices.getMaleSeniorBMIDescription(bmi));
    }

    @Test
    @DisplayName(value = "Return NORMAL_WEIGTH if Female Senior BMI is between 22 kg/m2 and 27 kg/m2")
    public void returnNormalWeigthFemaleSenior(){
        Persona persona = new Persona(65.0, 1.70, Sex.FEMALE, 66);
        Double bmi = calculatorServices.calculateBMI(persona);
        Assertions.assertEquals(Weigth.NORMAL_WEIGTH,calculatorServices.getFemaleSeniorBMIDescription(bmi));
    }

    @Test
    @DisplayName(value = "Return NORMAL_WEIGTH if Male Senior BMI is between 22 kg/m2 and 27 kg/m2")
    public void returnNormalWeigthMaleSenior(){
        Persona persona = new Persona(65.0, 1.70, Sex.MALE, 66);
        Double bmi = calculatorServices.calculateBMI(persona);
        Assertions.assertEquals(Weigth.NORMAL_WEIGTH,calculatorServices.getMaleSeniorBMIDescription(bmi));
    }

    @Test
    @DisplayName(value = "Return OVER_WEIGTH if Female Senior BMI is between 27.1 kg/m2 and 32 kg/m2")
    public void returnOverWeigthFemaleSenior(){
        Persona persona = new Persona(80.0, 1.70, Sex.FEMALE, 66);
        Double bmi = calculatorServices.calculateBMI(persona);
        Assertions.assertEquals(Weigth.OVER_WEIGTH,calculatorServices.getFemaleSeniorBMIDescription(bmi));
    }

    @Test
    @DisplayName(value = "Return OVER_WEIGTH if Male Senior BMI is between 27.1 kg/m2 and 30 kg/m2")
    public void returnOverWeigthMaleSenior(){
        Persona persona = new Persona(80.0, 1.70, Sex.MALE, 66);
        Double bmi = calculatorServices.calculateBMI(persona);
        Assertions.assertEquals(Weigth.OVER_WEIGTH,calculatorServices.getMaleSeniorBMIDescription(bmi));
    }

    @Test
    @DisplayName(value = "Return OBESE_FIRST_DEGREE if Female Senior BMI is between 32.1 kg/m2 and 37 kg/m2")
    public void returnObeseOneFemaleSenior(){
        Persona persona = new Persona(93.0, 1.70, Sex.FEMALE, 66);
        Double bmi = calculatorServices.calculateBMI(persona);
        Assertions.assertEquals(Weigth.OBESE_FIRST_DEGREE,calculatorServices.getFemaleSeniorBMIDescription(bmi));
    }

    @Test
    @DisplayName(value = "Return OBESE_FIRST_DEGREE if Male Senior BMI is between 30.1 kg/m2 and 35 kg/m2")
    public void returnObeseOneMaleSenior(){
        Persona persona = new Persona(87.0, 1.70, Sex.MALE, 66);
        Double bmi = calculatorServices.calculateBMI(persona);
        Assertions.assertEquals(Weigth.OBESE_FIRST_DEGREE,calculatorServices.getMaleSeniorBMIDescription(bmi));
    }

    @Test
    @DisplayName(value = "Return OBESE_SECOND_DEGREE if Female Senior BMI is between 37.1 kg/m2 and 41.9 lg/m2")
    public void returnObeseTwoFemaleSenior(){
        Persona persona = new Persona(108.0, 1.70, Sex.FEMALE, 66);
        Double bmi = calculatorServices.calculateBMI(persona);
        Assertions.assertEquals(Weigth.OBESE_SECOND_DEGREE,calculatorServices.getFemaleSeniorBMIDescription(bmi));
    }

    @Test
    @DisplayName(value = "Return OBESE_SECOND_DEGREE if Male Senior BMI is between 35.1 kg/m2 and 39.9 lg/m2")
    public void returnObeseTwoMaleSenior(){
        Persona persona = new Persona(102.0, 1.70, Sex.MALE, 66);
        Double bmi = calculatorServices.calculateBMI(persona);
        Assertions.assertEquals(Weigth.OBESE_SECOND_DEGREE,calculatorServices.getMaleSeniorBMIDescription(bmi));
    }

    @Test
    @DisplayName(value = "Return OBESE_THIRD_DEGREE if Female Senior BMI is equal or higher than 40 kg/m2")
    public void returnObeseThreeFemaleSenior(){
        Persona persona = new Persona(116.0, 1.70, Sex.FEMALE, 66);
        Double bmi = calculatorServices.calculateBMI(persona);
        Assertions.assertEquals(Weigth.OBESE_SECOND_DEGREE,calculatorServices.getFemaleSeniorBMIDescription(bmi));
    }

    @Test
    @DisplayName(value = "Return OBESE_THIRD_DEGREE if Male Senior BMI is equal or higher than 39.9 kg/m2")
    public void returnObeseThreeMaleSenior(){
        Persona persona = new Persona(118.0, 1.70, Sex.MALE, 66);
        Double bmi = calculatorServices.calculateBMI(persona);
        Assertions.assertEquals(Weigth.OBESE_THIRD_DEGREE,calculatorServices.getMaleSeniorBMIDescription(bmi));
    }

}
