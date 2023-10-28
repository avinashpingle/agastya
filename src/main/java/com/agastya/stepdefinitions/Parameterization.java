package com.agastya.stepdefinitions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.agastya.utilities.FileUtil;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Parameterization {

	int result = 0;
	int x, y;
	String pincode; 

	@Given("I have {int} and {int}")
	public void i_have_and(int int1, int int2) {
		x = int1;
		y = int2;
	}
	
	@Given("I have {string} and {string}")
	public void i_have_and(String s1, String s2) {
		System.out.println(s1);
		System.out.println(s2);
	}
	
	@Given("I have {int}")
	public void getPincode(int rowNum) {
		FileUtil excel = new FileUtil();
		String[] data = excel.getRowFromExcel("/Users/avinashpingale/Documents/Carnation23A/Pincodes.xlsx", "pincodes", rowNum);
		this.pincode = data[1];
	}
	
	@Then("print the pincode")
	public void printPincode() {
		System.out.println("Pincode: "+pincode);
	}

	@When("I add them")
	public void i_add_them() {
		result = x+y;
	}

	@Then("check if the result is prime")
	public void check_if_the_result_is_prime() {
		int count = 1;
		
		for (int i = 1; i < result/2; i++) {
			if(result%i==0) {
				count++;
			}
		}
		
		if(count>2) {
			System.out.println(result+" is not prime");
		}else {
			System.out.println(result+" is prime");
		}
	}
	
	@Given("I have following pair of numbers:")
	public void dataTableExample(DataTable table) {
		Map<String, String> map = table.asMap();
		Set<Entry<String,String>> entries = map.entrySet();
		for (Entry entry : entries) {
			System.out.println(entry.getKey()+"\t"+entry.getValue());
		}
	}
}
