package by.epam.dmitriysedin.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;
	private String menuID;
	private String menuCurrency;
	private String menuName;
	private String menuAnnotation;
	private List<AssortmentOfMenu> assortments = new ArrayList<>();

	public Menu() {
	}

	public String getMenuID() {
		return menuID;
	}

	public void setMenuID(String menuID) {
		this.menuID = menuID;
	}

	public String getMenuCurrency() {
		return menuCurrency;
	}

	public void setMenuCurrency(String menuCurrency) {
		this.menuCurrency = menuCurrency;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuAnnotation() {
		return menuAnnotation;
	}

	public void setMenuAnnotation(String menuAnnotation) {
		this.menuAnnotation = menuAnnotation;
	}

	public List<AssortmentOfMenu> getAssortments() {
		return assortments;
	}

	public void setAssortments(List<AssortmentOfMenu> assortments) {
		this.assortments = assortments;
	}

	@Override
	public int hashCode() {
		return Objects.hash(assortments, menuAnnotation, menuCurrency, menuID, menuName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Menu)) {
			return false;
		}
		Menu other = (Menu) obj;
		return Objects.equals(assortments, other.assortments) && Objects.equals(menuAnnotation, other.menuAnnotation)
				&& Objects.equals(menuCurrency, other.menuCurrency) && Objects.equals(menuID, other.menuID)
				&& Objects.equals(menuName, other.menuName);
	}

	@Override
	public String toString() {
		return "Menu{" + "menuID='" + menuID + '\'' + ", menuCurrency='" + menuCurrency + '\'' + ", menuName='"
				+ menuName + '\'' + ", menuAnnotation='" + menuAnnotation + '\'' + '\n' + ", assortments=" + assortments
				+ '}' + '\n';
	}
}
