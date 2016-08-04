package com.test.repo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.repo.EmployeeRepo;

//JUnit Suite Test
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
   EmployeeRepoTest.class,
   DistrictRepoTest.class
})
public class JUnitTestSuite {
}