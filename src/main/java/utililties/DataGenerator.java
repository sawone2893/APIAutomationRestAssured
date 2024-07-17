package utililties;

import com.github.javafaker.Faker;

public class DataGenerator {

	private static Faker faker;

	public static Faker generateData() {
		faker = new Faker();
		return faker;
	}

}
