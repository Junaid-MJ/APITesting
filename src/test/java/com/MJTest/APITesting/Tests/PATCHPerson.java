package com.MJTest.APITesting.Tests;

import com.MJTest.APITesting.Helpers.PersonServiceHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PATCHPerson {

    private PersonServiceHelper personServiceHelper;

    //Initializing the Person Service Helper
    @BeforeClass
    public void init(){
        this.personServiceHelper= new PersonServiceHelper();
    }

    @Test
    public void testPatchUpdatePerson(){
        String id= personServiceHelper.updatePerson(2).jsonPath().getString("id");
        System.out.println(id);
        Assert.assertNotNull(id,"updated");

    }


}
