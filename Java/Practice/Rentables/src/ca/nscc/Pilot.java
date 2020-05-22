package ca.nscc;

public class Pilot extends Operator{

    public int loggedHours;

    @Override
    public void renewLicense() {
        System.out.println("Applied to renew pilot's license.");
    }
}
