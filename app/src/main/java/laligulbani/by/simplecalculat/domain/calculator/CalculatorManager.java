package laligulbani.by.simplecalculat.domain.calculator;

public class CalculatorManager implements CalculatorManagement {

    private Object name;

    public CalculatorManager() {
        this("Lali");
    }

    public CalculatorManager(Object name) {
        this.name = name;
    }

    @Override
    public Float add(float value1, float value2) {
        return value1 + value2;
    }

    @Override
    public Float subtract(float value1, float value2) {
        return value1 - value2;
    }

    @Override
    public Float multiply(float value1, float value2) {
        return value1 * value2;
    }

    @Override
    public Float divide(float value1, float value2) {
        if (value2 == 0) {
            throw new RuntimeException("Divide by zero impossible");
        }

        return value1 / value2;
    }

    @Override
    public String toString() {
        return "CalculatorManager{" +
                "name=" + name.toString()+
                '}';
    }
}

