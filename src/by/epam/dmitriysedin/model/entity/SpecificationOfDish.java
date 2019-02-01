package by.epam.dmitriysedin.model.entity;

import java.io.Serializable;
import java.util.Objects;

public class SpecificationOfDish implements Serializable{

	private String dishDescription;
    private String dishPortion;
    private String dishPrice;

    public SpecificationOfDish() {
    }

    public String getDishDescription() {
        return dishDescription;
    }

    public void setDishDescription(String dishDescription) {
        this.dishDescription = dishDescription;
    }

    public String getDishPortion() {
        return dishPortion;
    }

    public void setDishPortion(String dishPortion) {
        this.dishPortion = dishPortion;
    }

    public String getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(String dishPrice) {
        this.dishPrice = dishPrice;
    }

    @Override
	public int hashCode() {
		return Objects.hash(dishDescription, dishPortion, dishPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof SpecificationOfDish)) {
			return false;
		}
		SpecificationOfDish other = (SpecificationOfDish) obj;
		return Objects.equals(dishDescription, other.dishDescription) && Objects.equals(dishPortion, other.dishPortion)
				&& Objects.equals(dishPrice, other.dishPrice);
	}

	@Override
    public String toString() {
        return "SpecificationOfDish{" +
                "dishDescription='" + dishDescription + '\'' +
                ", dishPortion='" + dishPortion + '\'' +
                ", dishPrice='" + dishPrice + '\'' +
                '}' + '\n';
    }
}
