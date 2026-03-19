package org.calculator.engine;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Formatter {
    private final char DECIMAL_SEPARATOR = new DecimalFormatSymbols(Locale.getDefault()).getDecimalSeparator();

    public String format(BigDecimal value) {

        value = value.stripTrailingZeros();
        String plain = value.toPlainString();

        if (countDigits(plain) < 17) {
            return normalize(plain);
        }

        BigDecimal rounded = value.round(new MathContext(16, RoundingMode.HALF_UP));
        String roundedPlain = rounded.stripTrailingZeros().toPlainString();

        if (countDigits(roundedPlain) < 17) {
            return normalize(roundedPlain);
        }

        return toScientific(value);

    }

    private int countDigits(String s) {

        int count = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) count++;
        }

        return count;
    }

    private String normalize(String plain) {

        return plain.replace('.', DECIMAL_SEPARATOR);

    }

    private String toScientific(BigDecimal value) {

        int exponent = value.precision() - value.scale() - 1;
        BigDecimal mantissa = value.movePointLeft(exponent);

        mantissa = mantissa.round(new MathContext(16, RoundingMode.HALF_UP)).stripTrailingZeros();
        String m = mantissa.toPlainString();

        return m.replace('.', DECIMAL_SEPARATOR) + "E" + exponent;
    }
}
