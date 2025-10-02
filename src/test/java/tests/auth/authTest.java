package tests.auth;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import Services.authProcess;
import models.authResponse;

public class authTest{

    private authResponse response;
    @Test(groups="smoke")
    public void authenticationTest_withValidCreds(){
        authProcess authentication = new authProcess();
        response = authentication.requestAuth("admin", "password123");
        assertFalse(response.getToken().equals(null), "Unexpected Response");
    }
    @Test(groups="regression")
    public void authenticationTest_withInvalidCreds(){
        authProcess authentication = new authProcess();
        response = authentication.requestAuth("Johnathan", "Williams");
        assertTrue(response.getFailureReason().equals("Bad credentials"), "Unexpected Response");
    }
    @Test(groups="regression")
    public void authenticationTest_withBlankCreds(){
        authProcess authentication = new authProcess();
        response = authentication.requestAuth("", "");
        assertTrue(response.getFailureReason().equals("Bad credentials"), "Unexpected Response");
    }
}
