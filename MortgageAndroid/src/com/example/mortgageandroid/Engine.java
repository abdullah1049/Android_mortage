package com.example.mortgageandroid;

	public class Engine {
		static double house_payment;
		static double house_debt_payment;
		static double Monthly_rate;
		static double Present_Value;
			public static double House_Debt_Payment(double gross_income, double monthly_debt){
				house_debt_payment = (((gross_income/12)*0.36)- monthly_debt);
				return house_debt_payment;
			}
			
			public static double House_Payment(double gross_income){
				house_payment = ((gross_income/12)*0.18);
				return house_payment;	
			}
			
			public static double can_afford(double house_debt_payment, double house_payment){
				if (house_debt_payment<house_payment){
					return house_debt_payment;
				}
				else{
					return house_payment;}
				}
			
			
			public static double present_value(double payment_used, double Term , double rate, double down_payment ){
				double Rate= rate/100;
				Monthly_rate = Math.pow(1+(Rate/12),Term*12);
				Present_Value= (payment_used)*(((1-(1/Monthly_rate))/(Rate/12))+down_payment);
				return Present_Value; 
			}
			}


