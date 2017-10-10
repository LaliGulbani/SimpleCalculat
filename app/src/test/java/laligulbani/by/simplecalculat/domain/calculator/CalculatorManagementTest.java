package laligulbani.by.simplecalculat.domain.calculator;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import laligulbani.by.simplecalculat.domain.calculator.CalculatorManagement;
import laligulbani.by.simplecalculat.domain.calculator.CalculatorManager;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorManagementTest {

    private CalculatorManagement calculatorMock;
    private CalculatorManagement spyCalculator;

    private Object name;

    @Before
    public void setup() {
        name = mock(Object.class);
        calculatorMock = new CalculatorManager(name);
        spyCalculator = spy(CalculatorManager.class);
    }

    @Test
    public void test_add_with_mockito() {
        when(name.toString()).thenReturn("Grisha");
        Assert.assertEquals("CalculatorManager{name=Grisha}", calculatorMock.toString());
    }

    @Test
    public void test_add_with_mockito_real() {
        Assert.assertEquals("CalculatorManager{name=Lali}", new CalculatorManager().toString());
    }

    @Test
    public void test_add_expect_Ok() {
        final Float expected = 2f;
        final Float actual = spyCalculator.add(1, 1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_sub_expect_Ok() {
        final Float expected = 1f;
        final Float actual = spyCalculator.subtract(5, 4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_add_mult_Ok() {
        final Float expected = 10f;
        final Float actual = spyCalculator.multiply(2, 5);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_div_expect_Ok() {
        final Float expected = 5f;
        final Float actual = spyCalculator.divide(25, 5);
        Assert.assertEquals(expected, actual);
    }

}
