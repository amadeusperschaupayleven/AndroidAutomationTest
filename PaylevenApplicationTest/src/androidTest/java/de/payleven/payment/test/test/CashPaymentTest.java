package de.payleven.payment.test.test;

import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


@SuppressWarnings("rawtypes")
public class CashPaymentTest extends ActivityInstrumentationTestCase2 {
  	private Solo solo;
  	
  	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "de.evopay.payment.ui.login.StartUpActivity";

    private static Class<?> launcherActivityClass;
    static{
        try {
            launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
        } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
        }
    }
  	
  	@SuppressWarnings("unchecked")
    public CashPaymentTest() throws ClassNotFoundException {
        super(launcherActivityClass);
    }

  	public void setUp() throws Exception {
        super.setUp();
		solo = new Solo(getInstrumentation());
		getActivity();
  	}
  
   	@Override
   	public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
  	}
  
	public void testRun() {
        //Wait for activity: 'de.evopay.payment.ui.login.StartUpActivity'
		solo.waitForActivity("StartUpActivity", 2000);
        //Wait for activity: 'de.evopay.payment.ui.login.LoginActivity'
		assertTrue("LoginActivity is not found!", solo.waitForActivity("LoginActivity"));
        //Click on Sign in
		solo.clickOnView(solo.getView("sign_in_button"));
        //Wait for dialog
		solo.waitForDialogToOpen(5000);
        //Wait for activity: 'de.evopay.payment.ui.payment.PaymentActivity'
		assertTrue("PaymentActivity is not found!", solo.waitForActivity("PaymentActivity"));
        //Click on number_pad_button_one
		solo.clickOnView(solo.getView("number_pad_button_one"));
        //Click on number_pad_button_zero
		solo.clickOnView(solo.getView("number_pad_button_zero"));
        //Click on number_pad_button_zero
		solo.clickOnView(solo.getView("number_pad_button_zero"));
        //Click on Continue
		solo.clickOnView(solo.getView("continue_button"));
        //Wait for dialog
		solo.waitForDialogToOpen(5000);
        //Click on Cash
		solo.clickOnView(solo.getView("payment_method_view", 4));
        //Click on number_pad_button_two
		solo.clickOnView(solo.getView("number_pad_button_two"));
        //Enter the text: '0,02  '
		solo.clearEditText((android.widget.EditText) solo.getView("received_amount_field"));
		solo.enterText((android.widget.EditText) solo.getView("received_amount_field"), "0,02 €");
        //Click on number_pad_button_zero
		solo.clickOnView(solo.getView("number_pad_button_zero"));
        //Enter the text: '0,20  '
		solo.clearEditText((android.widget.EditText) solo.getView("received_amount_field"));
		solo.enterText((android.widget.EditText) solo.getView("received_amount_field"), "0,20 €");
        //Click on number_pad_button_zero
		solo.clickOnView(solo.getView("number_pad_button_zero"));
        //Enter the text: '2,00  '
		solo.clearEditText((android.widget.EditText) solo.getView("received_amount_field"));
		solo.enterText((android.widget.EditText) solo.getView("received_amount_field"), "2,00 €");
        //Click on Next
		solo.clickOnView(solo.getView("number_pad_button_custom_right"));
        //Click on Skip receipt
		solo.clickOnView(solo.getView("skip_button"));
        //Click on New Payment
		solo.clickOnView(solo.getView("new_payment_button"));
        //Click on LinearLayout Payment
		solo.clickOnView(solo.getView("action_bar_spinner"));
        //Click on LinearLayout Account
		solo.clickInList(2, 0);
        //Wait for activity: 'de.evopay.payment.ui.account.AccountActivity'
		assertTrue("AccountActivity is not found!", solo.waitForActivity("AccountActivity"));
        //Click on Log out
		solo.clickOnText(java.util.regex.Pattern.quote("Log out"));
        //Wait for activity: 'de.evopay.payment.ui.login.LoginActivity'
		assertTrue("LoginActivity is not found!", solo.waitForActivity("LoginActivity"));
	}
}
