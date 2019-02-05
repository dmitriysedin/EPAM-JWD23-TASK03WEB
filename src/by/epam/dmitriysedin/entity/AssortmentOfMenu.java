package by.epam.dmitriysedin.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AssortmentOfMenu implements Serializable {

	private static final long serialVersionUID = 1L;
	private String assortmentID;
	private String assortmentName;
	private String assortmentAnnotation;
	private List<DishOfAssortment> dishes = new ArrayList<>();

	public AssortmentOfMenu() {
	}

	public String getAssortmentID() {
		return assortmentID;
	}

	public void setAssortmentID(String assortmentID) {
		this.assortmentID = assortmentID;
	}

	public String getAssortmentName() {
		return assortmentName;
	}

	public void setAssortmentName(String assortmentName) {
		this.assortmentName = assortmentName;
	}

	public String getAssortmentAnnotation() {
		return assortmentAnnotation;
	}

	public void setAssortmentAnnotation(String assortmentAnnotation) {
		this.assortmentAnnotation = assortmentAnnotation;
	}

	public List<DishOfAssortment> getDishes() {
		return dishes;
	}

	public void setDishes(List<DishOfAssortment> dishes) {
		this.dishes = dishes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(assortmentAnnotation, assortmentID, assortmentName, dishes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AssortmentOfMenu)) {
			return false;
		}
		AssortmentOfMenu other = (AssortmentOfMenu) obj;
		return Objects.equals(assortmentAnnotation, other.assortmentAnnotation)
				&& Objects.equals(assortmentID, other.assortmentID)
				&& Objects.equals(assortmentName, other.assortmentName) && Objects.equals(dishes, other.dishes);
	}

	@Override
	public String toString() {
		return "AssortmentOfMenu{" + "assortmentID='" + assortmentID + '\'' + ", assortmentName='" + assortmentName
				+ '\'' + ", assortmentAnnotation='" + assortmentAnnotation + '\'' + '\n' + ", dishes=" + dishes + '}'
				+ '\n';
	}
}
