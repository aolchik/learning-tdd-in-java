package com.aolchik.tdd.integration;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Ignore;
import org.junit.Test;

public class ConfigurationFileTest {

	@Test
	public void readPropertiesAndSetupCalculator() {
		// This kind of integration test can be used
		// for outside in development (scenario to code mapping)
		
		Properties properties = generateValidProperties();

		String filename = createTestPropertyFile(properties);
		
		PersistedPropertiesCalculator calc = new PersistedPropertiesCalculator(filename);
		
		validatePropertiesApplied(calc, properties);
		
		changeConfiguration(calc);

		calc.saveProperties();
		
		checkPropertiesWereSaved(filename, calc.getProperties());
		
	}
	
	private Properties generateValidProperties() {
		fail("Not yet implemented!");
		return null;
	}
	
	private String createTestPropertyFile(Properties properties) {
		fail("Not yet implemented!");
		return null;
	}
	
	private void validatePropertiesApplied(PersistedPropertiesCalculator calc, Properties props) {
		fail("Not yet implemented!");
	}
	
	private void changeConfiguration(PersistedPropertiesCalculator calc) {
		fail("Not yet implemented!");
	}
	
	private void checkPropertiesWereSaved(String filename, Properties props) {
		fail("Not yet implemented!");
	}

}
