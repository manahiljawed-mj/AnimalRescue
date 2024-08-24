package com.animalRescue.AnimalRescue.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    protected long id;
    protected String name;
    protected String breed;
    protected int age;

    protected Cat() {
    }

    private Cat(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.breed = builder.breed;
        this.age = builder.age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat cat)) return false;
        return getAge() == cat.getAge() &&
                Objects.equals(getId(), cat.getId()) &&
                Objects.equals(getName(), cat.getName()) &&
                Objects.equals(getBreed(), cat.getBreed());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getBreed(), getAge());
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                '}';
    }

    public static class Builder {
        protected Long id;
        protected String name;
        protected String breed;
        protected int age;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder copy(Cat c) {
            this.id = c.getId();
            this.name = c.getName();
            this.breed = c.getBreed();
            this.age = c.getAge();
            return this;
        }

        public Cat build() {
            return new Cat(this);
        }
    }
}
