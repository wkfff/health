package com.vaizn.utils;

import java.util.ArrayList;
import java.util.List;

public class LotteryUtils {

	class Person {
		
		private String personCode;
		private double probability;
		
		public Person() {
			
		}

		public Person(String personCode, double probability) {
			this.personCode = personCode;
			this.probability = probability;
		}

		public String getPersonCode() {
			return personCode;
		}

		public void setPersonCode(String personCode) {
			this.personCode = personCode;
		}

		public double getProbability() {
			return probability;
		}

		public void setProbability(double probability) {
			this.probability = probability;
		}
	}
	
	public static void main(String[] args) {
		LotteryUtils lottery = new LotteryUtils();
		List<Person> persons = new ArrayList<Person>();
		Person p1 = lottery.new Person("p1", 0.5);
		Person p2 = lottery.new Person("p2", 0.1);
		Person p3 = lottery.new Person("p3", 0.1);
		Person p4 = lottery.new Person("p4", 0.1);
		Person p5 = lottery.new Person("p5", 0.1);
		Person p6 = lottery.new Person("p6", 0.1);
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		persons.add(p5);
		persons.add(p6);
		
		List<Double> sortOrignalRates = new ArrayList<Double>(6);
		double sumRate = 0d;
		for (Person person : persons) {
			sumRate += person.probability;
			sortOrignalRates.add(sumRate / 1.0);
			System.out.println("sumRate:"+sumRate+" rate:"+(sumRate / 1.0));
		}
	}
}
