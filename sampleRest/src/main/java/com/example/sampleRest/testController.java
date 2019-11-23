package com.example.sampleRest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "TestControllerAPI", produces=org.springframework.http.MediaType.ALL_VALUE)
public class testController {
	
	@RequestMapping("api/greeting")
	@ApiOperation("this is simple greeting API")
	@ApiResponse(code=200, message = "ok" , response = testController.class)
    public String greeting() {
        return new String ("testing greeting");
    }
	
	
	@GetMapping("api/cards/{PAN}/{QRData}")
	public String getOTP(@PathVariable(value = "PAN") Long PAN,@PathVariable(value = "QRData") String QRData) {
	
		String keyValue = CardsController.getKeyValue(PAN);
		int s; 
		
		/*JSONObject pythonInput = new JSONObject();
		try {
			pythonInput.put("-p", PAN);
			pythonInput.put("-q", QRData);
			pythonInput.put("-k", keyValue);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		// String[] cmd = {"python","C:/Demo/myscript.py", this.arg1,};
	   // Runtime.getRuntime().exec(cmd);
		return "1234567890" + PAN + QRData;
		
	}

}
