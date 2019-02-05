package by.epam.dmitriysedin.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DishOfAssortment implements Serializable {

	private static final long serialVersionUID = 1L;
	private String dishID;
	private String dishPhoto;
	private String dishName;
	private String dishAnnotation;
	private String dishExtraDescription;
	private List<SpecificationOfDish> specificationOfDishes = new ArrayList<>();

	public DishOfAssortment() {
	}

	public String getDishID() {
		return dishID;
	}

	public void setDishID(String dishID) {
		this.dishID = dishID;
	}

	public String getDishPhoto() {
		return dishPhoto;
	}

	public void setDishPhoto(String dishPhoto) {
		this.dishPhoto = dishPhoto;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getDishAnnotation() {
		return dishAnnotation;
	}

	public void setDishAnnotation(String dishAnnotation) {
		this.dishAnnotation = dishAnnotation;
	}

	public String getDishExtraDescription() {
		return dishExtraDescription;
	}

	public void setDishExtraDescription(String dishExtraDescription) {
		this.dishExtraDescription = dishExtraDescription;
	}

	public List<SpecificationOfDish> getSpecificationOfDishes() {
		return specificationOfDishes;
	}

	public void setSpecificationOfDishes(List<SpecificationOfDish> specificationOfDishes) {
		this.specificationOfDishes = specificationOfDishes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dishAnnotation, dishExtraDescription, dishID, dishName, dishPhoto, specificationOfDishes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof DishOfAssortment)) {
			return false;
		}
		DishOfAssortment other = (DishOfAssortment) obj;
		return Objects.equals(dishAnnotation, other.dishAnnotation)
				&& Objects.equals(dishExtraDescription, other.dishExtraDescription)
				&& Objects.equals(dishID, other.dishID) && Objects.equals(dishName, other.dishName)
				&& Objects.equals(dishPhoto, other.dishPhoto)
				&& Objects.equals(specificationOfDishes, other.specificationOfDishes);
	}

	@Override
	public String toString() {
		return "DishOfAssortment [dishID=" + dishID + ", dishPhoto=" + dishPhoto + ", dishName=" + dishName
				+ ", dishAnnotation=" + dishAnnotation + ", dishExtraDescription=" + dishExtraDescription
				+ ", specificationOfDishes=" + specificationOfDishes + '\n' + "]";
	}

}
