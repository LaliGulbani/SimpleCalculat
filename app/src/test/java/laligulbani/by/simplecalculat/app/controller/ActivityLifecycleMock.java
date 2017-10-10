package laligulbani.by.simplecalculat.app.controller;


import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import laligulbani.by.simplecalculat.BuildConfig;
import laligulbani.by.simplecalculat.R;
import laligulbani.by.simplecalculat.app.controller.CalculatorActivity;
import laligulbani.by.simplecalculat.domain.calculator.CalculatorManagement;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static laligulbani.by.simplecalculat.app.controller.Constants.SDK_VERSION;
import static org.mockito.Matchers.anyFloat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = SDK_VERSION)
public class ActivityLifecycleMock {

    private CalculatorActivity Activity;
    private CalculatorActivity activityController;

    @Before
    public void setup() {
        Activity = Robolectric.setupActivity(CalculatorActivity.class);
        assertNotNull(Activity);
    }


    @Test
    public void test_calculator() {
        activityController = Robolectric.buildActivity(CalculatorActivity.class)
                .create()
                .start()
                .resume()
                .visible()
                .get();
        EditText FirstEditText = (EditText) Activity.findViewById(R.id.etNum1);
        assertNotNull("", FirstEditText);

        EditText SecondEditText = (EditText) Activity.findViewById(R.id.etNum2);
        assertNotNull("", SecondEditText);

        boolean BtnAddEnabled = Activity.findViewById(R.id.btnAdd).isEnabled();
        assertEquals(BtnAddEnabled, true);
        assertTrue(BtnAddEnabled);

        boolean BtnSubEnabled = Activity.findViewById(R.id.btnSub).isEnabled();
        assertEquals(BtnSubEnabled, true);
        assertTrue(BtnSubEnabled);

        boolean BtnMulEnabled = Activity.findViewById(R.id.btnMult).isEnabled();
        assertEquals(BtnMulEnabled, true);
        assertTrue(BtnMulEnabled);

        boolean BtnDivEnabled = Activity.findViewById(R.id.btnDiv).isEnabled();
        assertEquals(BtnDivEnabled, true);
        assertTrue(BtnDivEnabled);
    }

    @Test
    public void test_mock_add() {

        EditText FirstEditText = (EditText) Activity.findViewById(R.id.etNum1);
        EditText SecondEditText = (EditText) Activity.findViewById(R.id.etNum2);
        Button BtnAdd = (Button) Activity.findViewById(R.id.btnAdd);
        TextView ResultTextView = (TextView) Activity.findViewById(R.id.tvResult);

        final CalculatorManagement mock1 = mock(CalculatorManagement.class);
        when(mock1.add(anyFloat(), anyFloat())).thenReturn(4f);

        Activity.setCalculatorManager(mock1);
        FirstEditText.setText(Float.toString(3f));
        SecondEditText.setText(Float.toString(1f));

        BtnAdd.performClick();

        Assert.assertEquals(ResultTextView.getText(), Float.toString(4));


    }
    @After
    public void onDestroy() {
    }
}


