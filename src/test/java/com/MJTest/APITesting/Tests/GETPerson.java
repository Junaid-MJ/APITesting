package com.MJTest.APITesting.Tests;

import com.MJTest.APITesting.Model.Person;
import com.MJTest.APITesting.Helpers.PersonServiceHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class GETPerson {

    private PersonServiceHelper personServiceHelper;

    @BeforeClass
    public void init(){
        personServiceHelper= new PersonServiceHelper();
    }

    @Test
    public void testGetAllPerson(){
        List<Person> personList= personServiceHelper.getAllPerson();
        Assert.assertNotNull(personList,"Person List is not Empty");

    }

}
