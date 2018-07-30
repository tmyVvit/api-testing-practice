package exercises;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.Argument;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


public class RestAssuredExercises2Test {

	private static RequestSpecification requestSpec;

	@BeforeAll
	public static void createRequestSpecification() {

		requestSpec = new RequestSpecBuilder().
			setBaseUri("http://localhost").
			setPort(9876).
			setBasePath("/api/f1").
			build();
	}
	
	/*******************************************************
	 * Use junit-jupiter-params for @ParameterizedTest that
	 * specifies in which country
	 * a specific circuit can be found (specify that Monza 
	 * is in Italy, for example) 
	 ******************************************************/

	static Stream<Arguments> CircuitDataProvider(){
		return Stream.of(
				Arguments.of("monza", "Italy")
		);
	}

	@ParameterizedTest
	@MethodSource("CircuitDataProvider")
	public void check_coutry_for_specific_circuit(String circuitName, String country){
		given()
				.spec(requestSpec)
				.pathParam("circuit", circuitName)
				.when()
				.get("/circuits/{circuit}.json")
				.then().log().all()
				.body("MRData.CircuitTable.Circuits[0].Location.country", is(country));
	}

	//todo

	/*******************************************************
	 * Use junit-jupiter-params for @ParameterizedTest that specifies for all races
	 * (adding the first four suffices) in 2015 how many  
	 * pit stops Max Verstappen made
	 * (race 1 = 1 pitstop, 2 = 3, 3 = 2, 4 = 2)
	 ******************************************************/

	//todo

	/*******************************************************
	 * Request data for a specific circuit (for Monza this 
	 * is /circuits/monza.json)
	 * and check the country this circuit can be found in
	 ******************************************************/
	
	@Test
	public void checkCountryForCircuit() {
		
		given().
			spec(requestSpec).
		when().
		then();
	}
	
	/*******************************************************
	 * Request the pitstop data for the first four races in
	 * 2015 for Max Verstappen (for race 1 this is
	 * /2015/1/drivers/max_verstappen/pitstops.json)
	 * and verify the number of pit stops made
	 ******************************************************/
	
	@Test
	public void checkNumberOfPitstopsForMaxVerstappenIn2015() {
		
		given().
			spec(requestSpec).
		when().
		then();
	}
}