import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class validateIC {
    public static boolean validateICDate(String ic) {
        String normalizedIC = ic.replaceAll("-", "");
        // Check if the IC is null or empty
        if (normalizedIC.isEmpty()) {
            return false;
        }
        // Check if the IC contains only digits
        if (!normalizedIC.matches("\\d+")) {
            return false;
        }
        // Check if the IC is exactly 12 characters long
        if (normalizedIC.length() != 12) {
            return false;
        }
        // Check if the first 6 characters are digits (representing the date)
        String datePart = normalizedIC.substring(0, 6);
        String year = datePart.substring(0, 2);
        String month = datePart.substring(2, 4);
        String day = datePart.substring(4, 6);
        // Validate the date part
        // Try both 19xx and 20xx for year
        for (String century : new String[]{"19", "20"}) {
            String fullDate = century + year + "-" + month + "-" + day;
            try {
                LocalDate.parse(fullDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                System.out.println("Valid IC Date: " + fullDate);
                return true;
            } catch (DateTimeParseException e) {
                // Try next century
            }
        }
        return false;
    }

    public static void main(String[] args){
        String ic1 = "880101-01-1234a"; // Valid IC
        System.out.println("IC 1 is valid: " + validateICDate(ic1));
    }
}
