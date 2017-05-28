package dietbisabesok.com.bukanitip.helper;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */

public class CurrencyHelper {

    public static String CurrencyHelper(long a){
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator(',');
        DecimalFormat decimalFormat = new DecimalFormat("Rp #,###.00", symbols);
        decimalFormat.setMaximumFractionDigits(0);
        return decimalFormat.format(a);
    }

    public static String CurrencyHelperFromDouble(double a){
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator(',');
        DecimalFormat decimalFormat = new DecimalFormat("Rp #,###.00", symbols);
        decimalFormat.setMaximumFractionDigits(0);
        return decimalFormat.format(a);
    }

    public static String CurrencyHelperWhitOutRP(long a){
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator(',');
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00", symbols);
        decimalFormat.setMaximumFractionDigits(0);
        return decimalFormat.format(a);
    }
}
