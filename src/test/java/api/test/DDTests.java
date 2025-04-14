package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;


public class DDTests {
	
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostuser(String userId,String userName, String fname, 
			String lname, String useremail, String pws, String ph)
	{
		//System.out.println("@@@@@@@@@@@@@@@@@@@@@@"+userId);
		User userPayload = new User();
		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pws);
		userPayload.setPhone(ph);
		
		System.out.println(userPayload.getPhone());
		
		Response response = UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);		
	}
	
	@Test(priority=2, dataProvider="UserName", dataProviderClass=DataProviders.class)
	public void testDeleteUserName(String userName)
	{
		Response response = UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
