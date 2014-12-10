package com.example.mortgageandroid;


import java.text.DecimalFormat;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		 final EditText Gross_Income = (EditText)findViewById(R.id.editText1);
		final EditText Monthly_debt = (EditText)findViewById(R.id.editText2);
		final  EditText Interest_rate = (EditText)findViewById(R.id.editText3);
		final EditText Down_payment = (EditText)findViewById(R.id.editText4);
		final EditText Affordableamount = (EditText)findViewById(R.id.editText5);
		 final View spinner1;
		spinner1.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {}
					
					public void onClick(Spinner trmSpin){
				    	String GROSS_INCOME = Gross_Income.getText().toString();
				    	String MONTHLY_DEBT= Monthly_debt.getText().toString();
				    	String INTEREST_RATE= Interest_rate.getText().toString();
				    	String DOWN_PAYMENT= Down_payment.getText().toString();
				    	
				    	// converting string into integers to be used in the calculations
				    	Double GROSS_income = Double.parseDouble(GROSS_INCOME);
				    	Double MONTHLY_debt = Double.parseDouble(MONTHLY_DEBT);
				    	Double INTEREST_rate= Double.parseDouble(INTEREST_RATE);
				    	Double DOWN_payment= Double.parseDouble(DOWN_PAYMENT);
				    	
				    	// getting affordable value from the high and low amounts
				    	double HOUSE_payment = Engine.House_Payment(GROSS_income);
				    	double HOUSE_Debt_Payment = Engine.House_Debt_Payment(GROSS_income, MONTHLY_debt);
				    	double CAN_afford = Engine.can_afford(HOUSE_Debt_Payment, HOUSE_payment);
						Integer term =  (Integer) ((AdapterView<SpinnerAdapter>) spinner1).getSelectedItem();

				    	// calculating and rounding the present value which is the amount of money you can't afford for the house
				    	Double MORTAGE = Engine.present_value(CAN_afford,term ,INTEREST_rate,DOWN_payment );
				    	DecimalFormat format = new DecimalFormat("#0.000");
				    	String PV = format.format(MORTAGE);
				    	Affordableamount.setText("$"+PV);
				    	
				    	
				    	
						
						}
				}
						);}
						

	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
