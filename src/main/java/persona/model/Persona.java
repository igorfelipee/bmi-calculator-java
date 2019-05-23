package persona.model;

import persona.enums.Sex;

public class Persona {

    private Double weight;
    private Double height;
    private Sex sex;
    private Integer age;

    public Persona(Double weight, Double height, Sex sex, Integer age) {
        this.weight = weight;
        this.height = height;
        this.sex = sex;
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
