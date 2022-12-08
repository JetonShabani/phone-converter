import java.util.Scanner;
public class PhoneConverter {
    public static final void run(String[] args) throws IndexOutOfBoundsException {
        System.out.println("Enter phone number:");
        Scanner scanInput = new Scanner(System.in);
        String telephoneNumberWithText;
        telephoneNumberWithText = scanInput.nextLine();
        telephoneNumberWithText = telephoneNumberWithText.toUpperCase();
        String convertedPhoneNumber = String.valueOf(phoneNumber(telephoneNumberWithText));

        try {
            if (convertedPhoneNumber.length() >= 10 && convertedPhoneNumber.length() <= 13) {

                System.out.println("Enter country code:");
                Scanner scanInput2 = new Scanner(System.in);
                String countryCode;
                countryCode = scanInput2.nextLine();
                //countryCode = countryCode.toUpperCase();
                String country = countryCode;

                //converting to US phone number
                //String phoneNumber = String.valueOf(convertedPhoneNumber).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
                StringBuilder sb = new StringBuilder(new StringBuilder("(").append(convertedPhoneNumber.substring(0, 3))
                        .append(") ").append(convertedPhoneNumber.substring(3, 6))
                        .append("-").append(convertedPhoneNumber.substring(6))
                        .toString());

                //converting to DE phone number
                StringBuilder sb2 = new StringBuilder(new StringBuilder("+49 ").append(convertedPhoneNumber.substring(0, 3))
                        .append(" ").append(convertedPhoneNumber.substring(3, 6))
                        .append(" ").append(convertedPhoneNumber.substring(6))
                        .toString());

                //to check if the countryCode is us or de in lower and uppercase
                if (country.equals("us") || country.equals("US")) {
                    System.out.println("US number " + sb);
                } else if (country.equals("DE") || country.equals("de")) {
                    System.out.println("DE " + sb2);
                } else {
                    System.out.println("enter DE or US");

                }
                //System.out.println("DE number " + sb2 );

            } else {
                throw new IndexOutOfBoundsException();

            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("'" + convertedPhoneNumber + "'number or text is lower than 10 or longer than 13");
        }


    }

    public static long phoneNumber(String telephoneNumberWithText) {
        long number = 0;
        int stringLength = telephoneNumberWithText.length();


        for (int digitNum = 0; digitNum < stringLength; digitNum++) {
            char ch = telephoneNumberWithText.charAt(digitNum);

            if (Character.isLetter(ch)) {
                switch (ch) {
                    case 'A':
                    case 'B':
                    case 'C':
                        number *= 10;
                        number += 2;
                        break;
                    case 'D':
                    case 'E':
                    case 'F':
                        number *= 10;
                        number += 3;
                        break;
                    case 'G':
                    case 'H':
                    case 'I':
                        number *= 10;
                        number += 4;
                        break;
                    case 'J':
                    case 'K':
                    case 'L':
                        number *= 10;
                        number += 5;
                        break;
                    case 'M':
                    case 'N':
                    case 'O':
                        number *= 10;
                        number += 6;
                        break;
                    case 'P':
                    case 'Q':
                    case 'R':
                    case 'S':
                        number *= 10;
                        number += 7;
                        break;
                    case 'T':
                    case 'U':
                    case 'V':
                        number *= 10;
                        number += 8;
                        break;
                    case 'W':
                    case 'X':
                    case 'Y':
                    case 'Z':
                        number *= 10;
                        number += 9;
                        break;
                }
            } else if (Character.isDigit(ch)) {
                number *= 10;
                number += Character.getNumericValue(ch);
            }
        }
        return number;
    }
}