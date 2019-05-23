package persona.enums;

public enum Weigth {

    UNDER_WEIGTH_TOO_GRAVE("Baixo peso muito grave."),
    UNDER_WEIGTH_GRAVE("Baixo peso grave."),
    UNDER_WEIGTH("Baixo peso."),
    NORMAL_WEIGTH("Peso normal."),
    OVER_WEIGTH("Sobrepeso."),
    OBESE("Obesidade."),
    OBESE_FIRST_DEGREE("Obesidade grau I."),
    OBESE_SECOND_DEGREE("Obesidade grau II."),
    OBESE_THIRD_DEGREE("Obesidade grau III.");



    private String description;

    Weigth(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
