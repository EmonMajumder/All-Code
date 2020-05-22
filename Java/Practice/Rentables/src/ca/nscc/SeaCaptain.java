package ca.nscc;

public class SeaCaptain extends Operator {

    public int yearsAtSea;

    @Override
    public void renewLicense() {
        System.out.println("Applied to renew captain's nautical license.");
    }
}
