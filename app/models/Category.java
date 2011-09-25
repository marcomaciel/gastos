package models;

import siena.Generator;
import siena.Id;
import siena.Index;
import siena.Model;
import siena.Query;

public class Category extends Model {

	@Id(Generator.AUTO_INCREMENT)
	public Long id;
	public String name;

	public static Query<Category> all() {
		return Model.all(Category.class);
	}

	public String toString() {
		return name;
	}
}
