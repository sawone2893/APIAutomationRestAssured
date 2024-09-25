package utililties;

import com.github.javafaker.Faker;

public class DataGenerator {
	private DataGenerator() {}
	
	public static Faker generateData() {
		return new Faker();
	}

}
