package ca.nscc;

public class CarDriver extends Operator{

    public String provincialMasterNumber;

    @Override
    public void renewLicense() {
        System.out.println("Applied to renew provincial driver's license.");
    }
}
