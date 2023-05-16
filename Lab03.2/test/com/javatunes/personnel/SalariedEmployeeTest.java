package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;
import java.sql.Date;
import static org.junit.Assert.*;

public class SalariedEmployeeTest {
    // object under test, called a "fixture"
    private SalariedEmployee emp1;
    private SalariedEmployee emp2;

    @Before
    public void setUp() {
    emp1 = new SalariedEmployee("Rich", Date.valueOf("2022-9-1"), 5000.0 );
    emp2 = new SalariedEmployee("Rich", Date.valueOf("2022-9-1"), 5000.0);
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate_sameSalary(){
        emp2.setName("James");
        assertNotEquals(emp1,emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate_sameSalary(){
        emp2.setHireDate(Date.valueOf("2000-09-09"));
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame(){
        assertEquals(emp1, emp2);

    }

    @Test
    public void testPay() {
        assertEquals(5000.0, emp1.pay(), .001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(1500, emp1.payTaxes(), .001);  // tax is 30% of the salary
    }
}