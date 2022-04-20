import org.testng.annotations.Test;

import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;

import org.apache.http.auth.AUTH;
import org.testng.annotations.AfterClass;

public class RestAssuredProject {
	
	RequestSpecification requestSpec;
	String SSHkey;
	int id;
	String accessToken = "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";
	  @BeforeClass
	  public void beforeClass() {
		  
		  
		  requestSpec = new RequestSpecBuilder().setContentType(ContentType.JSON)
	
				  .setBaseUri("https://api.github.com").build();
	  }
  @Test
  public void POST() {
	  
	  String reqBody = "{\n"
	  		+ "    \"title\": \"TestAPIKey\",\n"
	  		+ "    \"key\": \"ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQC+2odmmvUvzSUlo4SJgWgH+j0wZ+9N8KBsYRmY7fMlkdVbNMiPFxwcIuziar7vz/fjSYl4nUyVdBscIHQu95dnw/syRKuBnhksaI/Si8nMfjwAk6xmBja/PCAJZS3s4nYtlfPq4e/ssTUljod0RvL8j6SwZZ2JCVJQ5mZEK5NJSqshY1X47XT/5ad1dc9cVs9C52+QbtzBdvL5NMtWI6/TUMi6khlB0ScAXkdZZLvB82vpifshtu9UlpYd4A/gXX9LZtVJlhbITh7XHJz8EhKkK3hRRuWPJnXHK2cfsklx74tAsztDtlzOOH5TUy10ntAn10RMoRGn5ghS12bB3Vk85kEoqUAyPg17RAUFcr4tQMb3Z2vpu1msaxLZMFFi5CHnCN4GZ7iGClQG3NcgiOUo+6wqtXYAf6Prq4fPk880KBhFIgqYHlgwJUIKEBrw835sBC7b93B+U8HMDpG1rnmFaAGsTJQuMPXslbuFiSwspo9XAhiCXUJpPHXKaveiVIM=\"\n"
	  		+ "}	";
	  System.out.println(accessToken);

	    Response response = given().spec(requestSpec)
	    		.auth().oauth2(accessToken)
	    		.body(reqBody).when()
	    		.post("/user/keys");
	    response.then().statusCode(201);
		System.out.println(response.asPrettyString());
	  
	    JsonPath jsonPathEvaluator = response.jsonPath();
id = jsonPathEvaluator.get("id");
	System.out.println(id);
 
	
  }

  
  @Test  (dependsOnMethods = { "POST" })
  public void DELETE() {
	 
	  System.out.println("id is:" + id);

	    Response response = given().spec(requestSpec)
	    		.auth().oauth2(accessToken)
	    		.pathParam("keyId", id).when()
	    		.delete("/user/keys/{keyId}");
	   
	   response.then().statusCode(204).log().all();
		System.out.println(response.asPrettyString());
		
	  
	   
	System.out.println(id);
 
	
  }
  
  
  @Test 
  public void GET() {
	 
	  
	    Response response = given().spec(requestSpec)
	    		.auth().oauth2(accessToken)
	    		.when()
	    		.get("/user/keys");
	   
	   response.then().statusCode(200).log().all();
		System.out.println(response.asPrettyString());
		
	  
	   

 
	
  }


}
