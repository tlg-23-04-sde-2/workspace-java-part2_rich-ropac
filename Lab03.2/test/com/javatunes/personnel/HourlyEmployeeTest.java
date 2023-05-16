package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    private HourlyEmployee emp;

    @Before
    public void setUp() {
        emp = new HourlyEmployee("James", Date.valueOf("2021-10-10"), 30.0, 40.0);
    }

    @Test
    public void testPay() {
        assertEquals(1200.0, emp.pay(), .001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(300.0, emp.payTaxes(),.001);

    }
}