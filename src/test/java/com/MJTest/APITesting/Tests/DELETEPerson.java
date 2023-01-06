package com.MJTest.APITesting.Tests;

import com.MJTest.APITesting.Helpers.PersonServiceHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DELETEPerson {
    private PersonServiceHelper personServiceHelper;

    //Initializing the Person Service Helper
    @BeforeClass
    public void init(){
        this.personServiceHelper= new PersonServiceHelper();
    }

    @Test
    public void testDeletePerson(){
        String id= personServiceHelper.deletePerson(3).jsonPath().getString("id");
        Assert.assertNull(id,"Deleted");

    }

}
