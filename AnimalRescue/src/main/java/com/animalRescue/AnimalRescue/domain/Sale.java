package com.animalRescue.AnimalRescue.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "dog_id")
    protected Dog dog;

    @ManyToOne
    @JoinColumn(name = "cat_id")
    protected Cat cat;

    @ManyToOne
    @JoinColumn(name = "petOwner_id", nullable = false)
    protected PetOwner petOwner;

    protected LocalDate saleDate;
    protected double price;

    protected Sale() {
    }

    private Sale(Builder builder) {
        this.id = builder.id;
        this.dog = builder.dog;
        this.cat = builder.cat;
        this.petOwner = builder.petOwner;
        this.saleDate = builder.saleDate;
        this.price = builder.price;
    }

    public Long getId() {
        return id;
    }

    public Dog getDog() {
        return dog;
    }

    public Cat getCat() {
        return cat;
    }

    public PetOwner getPetOwner() {
        return petOwner;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sale sale)) return false;
        return Double.compare(sale.getPrice(), getPrice()) == 0 &&
                Objects.equals(getId(), sale.getId()) &&
                Objects.equals(getDog(), sale.getDog()) &&
                Objects.equals(getCat(), sale.getCat()) &&
                Objects.equals(getPetOwner(), sale.getPetOwner()) &&
                Objects.equals(getSaleDate(), sale.getSaleDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDog(), getCat(), getPetOwner(), getSaleDate(), getPrice());
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", dog=" + dog +
                ", cat=" + cat +
                ", petOwner=" + petOwner +
                ", saleDate=" + saleDate +
                ", price=" + price +
                '}';
    }

    public static class Builder {
        private Long id;
        private Dog dog;
        private Cat cat;
        private PetOwner petOwner;
        private LocalDate saleDate;
        private double price;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setDog(Dog dog) {
            this.dog = dog;
            return this;
        }

        public Builder setCat(Cat cat) {
            this.cat = cat;
            return this;
        }

        public Builder setPetOwner(PetOwner petOwner) {
            this.petOwner = petOwner;
            return this;
        }

        public Builder setSaleDate(LocalDate saleDate) {
            this.saleDate = saleDate;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder copy(Sale s) {
            this.id = s.getId();
            this.dog = s.getDog();
            this.cat = s.getCat();
            this.petOwner = s.getPetOwner();
            this.saleDate = s.getSaleDate();
            this.price = s.getPrice();
            return this;
        }

        public Sale build() {
            return new Sale(this);
        }
    }
}
