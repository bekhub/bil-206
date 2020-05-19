package mvc.models;

import mvc.utils.Function;

public class ThirdModel extends Model {

    @Override
    public void setUp() {
        notifyObserver();
    }

    @Override
    public Function getFunction() {
        return x -> x;
    }
}
