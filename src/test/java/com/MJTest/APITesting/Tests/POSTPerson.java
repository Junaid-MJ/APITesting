package com.MJTest.APITesting.Tests;

import com.MJTest.APITesting.Helpers.PersonServiceHelper;
import com.MJTest.APITesting.Model.Person;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class POSTPerson {

    private PersonServiceHelper personServiceHelper;

    //Initializing the Person Service Helper
    @BeforeClass
    public void init(){
        this.personServiceHelper= new PersonServiceHelper();
    }

    @Test
    public void testPostCreatePerson(){
        String id= personServiceHelper.createPerson().jsonPath().getString("id");
        Assert.assertNotNull(id,"Person ID is not null");

    }

}
