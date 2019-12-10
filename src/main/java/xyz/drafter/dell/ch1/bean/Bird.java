package xyz.drafter.dell.ch1.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author wangmeng
 * @date 2019/12/4
 * @desciption
 */
public class Bird {

    @Value("drafter")
    private String name;

    @Value("#{20-2}")
    private Integer age;

    @Value("${bird.color}")
    private String color;


    public Bird() {
    }

    public Bird(String name, Integer age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
