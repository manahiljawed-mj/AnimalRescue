package AnimalRescueFrontend;

import java.time.LocalDate;

public class ApplicantClass {
    private PetOwnerClass petOwner;
    private CatClass cat;
    private DogClass dog;
    private String applicationDate;
    private String status;

    public ApplicantClass(PetOwnerClass pet,String applicationDate,DogClass dog,CatClass cat,String status1) {
    	this.dog=dog;
    	this.cat=cat;
    	this.petOwner=pet;
    	this.applicationDate=applicationDate;
    	this.status=status1;
    }

    public PetOwnerClass getPetOwner() {
        return petOwner;
    }

    public void setPetOwner(PetOwnerClass petOwnerClass) {
        this.petOwner = petOwnerClass;
    }

    public CatClass getCat() {
        return cat;
    }

    public void setCat(CatClass catClass) {
        this.cat = catClass;
    }

    public DogClass getDog() {
        return dog;
    }

    public void setDog(DogClass dog) {
        this.dog = dog;
    }

    public String getapplicationDate() {
        return applicationDate;
    }

    public void setapplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getReturnDate() {
        return status;
    }

    public void setReturnDate(String status) {
        this.status = status;
    }

	public byte[] getBytes(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
