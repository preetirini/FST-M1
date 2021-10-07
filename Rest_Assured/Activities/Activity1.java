import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class Activity1 {
	
  @Test (priority=0)
  public void POST_TC01() {
	  String ROOT_URI = "https://petstore.swagger.io/v2/pet" ;
	 String req = "{\"id\":77232,\"name\": \"Riley\",\"status\": \"alive\"}";
	  Response response = 
		        given().contentType(ContentType.JSON) // Set headers
		        .body(req).when().post(ROOT_URI);
	  String responsebody = response.getBody().asPrettyString();
	  System.out.println(responsebody);
	  response.then().statusCode(200);
	  response.then().body("id",equalTo(77232));
	  response.then().body("name",equalTo("Riley"));
	  response.then().body("status",equalTo("alive"));
			       
  }
  

  @Test (priority=1)
  public void GET_TC02() {
	  String get_URI = "https://petstore.swagger.io/v2/pet/{petId}" ;
	
	  Response response =   given().contentType(ContentType.JSON)
			                .when().pathParam("petId",77232)
			                .get(get_URI);
	  String res = response.getBody().asPrettyString() ;
	  System.out.println(res);
	  response.then().statusCode(200);
	  response.then().body("id",equalTo(77232));
	  response.then().body("name", equalTo("Riley"));
	  response.then().body("status",equalTo("alive"));
	  
  }
  
  
  @Test (priority=2)
  public void DELETE_TC03() {
	  String ROOT_URI = "https://petstore.swagger.io/v2/pet/{petId}" ;
	  Response response = given().contentType(ContentType.JSON)
			                .when().pathParam("petId",77232)
			                .delete(ROOT_URI);
	  String delres = response.getBody().asPrettyString();
	  System.out.println(delres);
	  response.then().statusCode(200);
	  response.then().body("message", equalTo("77232"));
	  
  }
}
