public class PhoneConverterLauncher {

    //What this does this prevent anyone (including you)
    // from accidentally creating a "launcher".
    // It's CashRegisters we want to create, not launchers.
    private PhoneConverterLauncher() {}

    public static void main(String[] args) {
    PhoneConverter  converter = new PhoneConverter();
    PhoneConverter.run(args);
}

}
