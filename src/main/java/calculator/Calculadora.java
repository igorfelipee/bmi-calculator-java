package calculator;

import calculator.services.CalculatorServices;
import persona.enums.Sex;
import persona.model.Persona;

import java.util.Scanner;

public class Calculadora {
    
    private static CalculatorServices calculatorServices = new CalculatorServices();

    public static void main(String[] args) {
        System.out.println("##################################");
        System.out.println("#                                #");
        System.out.println("#        Calculadora IMC         #");
        System.out.println("#                                #");
        System.out.println("#                                #");
        System.out.println("#                                #");
        System.out.println("#        Autor: Igor F           #");
        System.out.println("#                                #");
        System.out.println("##################################");


        String sex;
        Double heigth;
        Double weigth;
        Integer age;
        Boolean isPregnant = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a sua altura em metros (Ex.: 1.63)");
        heigth = scanner.nextDouble();
        System.out.println("Digite o seu peso kg (Ex.: 55)");
        weigth = scanner.nextDouble();
        System.out.println("Digite a sua idade (Ex.: 20)");
        age = scanner.nextInt();
        System.out.println("Digite o seu sexo (M/F)");
        sex = scanner.next();
        
        Sex personaSex = sex.toUpperCase() == "F" ? Sex.FEMALE : Sex.MALE;

        if(sex.equals("F")){
            System.out.println("Você está grávida no momento? (S/N)");
            String result = scanner.next();
            isPregnant = result.toUpperCase() == "S" ? Boolean.TRUE : Boolean.FALSE;
        }

        Persona persona = new Persona(weigth, heigth, personaSex, age);

        String result = calculatorServices.getBMIResult(persona, isPregnant);


        System.out.println(result);

    }

}
