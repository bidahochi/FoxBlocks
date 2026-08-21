package com.bidahochi.BlockMod.customization.data;

/**
 * Parses player-authored customization numbers without using exceptions as
 * control flow. Malformed and overflowing input returns the caller's fallback,
 * allowing GUI, NBT, and tooltip boundaries to share identical behavior.
 */
public final class CustomizationNumberParser
{

    /** Prevents construction of this static utility class. */
    private CustomizationNumberParser()
    {
    }

    /**
     * Parses a signed base-ten integer.
     *
     * @param text candidate decimal text
     * @param fallback value returned for blank, malformed, or overflowing input
     * @return parsed integer or {@code fallback}
     */
    public static int parseInteger(String text, int fallback)
    {
        if (text == null)
        {
            return fallback;
        }
        String normalized = text.trim();
        if (normalized.length() == 0)
        {
            return fallback;
        }
        boolean negative = normalized.charAt(0) == '-';
        int digitStart = negative ? 1 : 0;
        if (digitStart == normalized.length())
        {
            return fallback;
        }
        long limit = negative ? 2147483648L : Integer.MAX_VALUE;
        long value = 0L;
        for (int index = digitStart; index < normalized.length(); index++)
        {
            char character = normalized.charAt(index);
            if (character < '0' || character > '9')
            {
                return fallback;
            }
            int digit = character - '0';
            if (value > (limit - digit) / 10L)
            {
                return fallback;
            }
            value = value * 10L + digit;
        }
        return negative ? (int) -value : (int) value;
    }

    /**
     * Parses a block-unit decimal into integer hundredths. Input with more than
     * two decimal places is rejected so the stored value is never silently rounded.
     *
     * @param text signed decimal block value such as {@code -0.25}
     * @param fallback hundredths returned when the text is invalid
     * @return exact integer hundredths or {@code fallback}
     */
    public static int parseHundredths(String text, int fallback)
    {
        if (text == null)
        {
            return fallback;
        }
        String normalized = text.trim();
        if (normalized.length() == 0)
        {
            return fallback;
        }
        boolean negative = normalized.charAt(0) == '-';
        int valueStart = negative ? 1 : 0;
        int decimalIndex = normalized.indexOf('.', valueStart);
        if (decimalIndex >= 0 && normalized.indexOf('.', decimalIndex + 1) >= 0)
        {
            return fallback;
        }
        int wholeEnd = decimalIndex >= 0 ? decimalIndex : normalized.length();
        String wholeText = normalized.substring(valueStart, wholeEnd);
        if (wholeText.length() == 0)
        {
            wholeText = "0";
        }
        int whole = parseInteger(wholeText, -1);
        if (whole < 0 || whole > Integer.MAX_VALUE / 100)
        {
            return fallback;
        }
        int fraction = 0;
        if (decimalIndex >= 0)
        {
            String fractionText = normalized.substring(decimalIndex + 1);
            if (fractionText.length() > 2)
            {
                return fallback;
            }
            if (fractionText.length() > 0)
            {
                fraction = parseInteger(fractionText, -1);
                if (fraction < 0)
                {
                    return fallback;
                }
                if (fractionText.length() == 1)
                {
                    fraction *= 10;
                }
            }
        }
        int hundredths = whole * 100 + fraction;
        return negative ? -hundredths : hundredths;
    }

    /**
     * Parses packed color text in signed decimal, {@code #RRGGBB},
     * {@code 0xRRGGBB}, or bare six-digit hexadecimal form.
     *
     * @param text candidate packed color text
     * @param fallback packed color returned for malformed or overflowing input
     * @return parsed packed color or {@code fallback}
     */
    public static int parseColor(String text, int fallback)
    {
        if (text == null)
        {
            return fallback;
        }
        String normalized = text.trim();
        if (normalized.length() == 0)
        {
            return fallback;
        }
        if (normalized.charAt(0) == '#')
        {
            return parseHex(normalized.substring(1), fallback);
        }
        if (normalized.startsWith("0x") || normalized.startsWith("0X"))
        {
            return parseHex(normalized.substring(2), fallback);
        }
        if (normalized.length() == 6 && isHex(normalized))
        {
            return parseHex(normalized, fallback);
        }
        return parseInteger(normalized, fallback);
    }

    /** Parses up to eight hexadecimal digits into a packed 32-bit value. */
    private static int parseHex(String text, int fallback)
    {
        if (text.length() == 0 || text.length() > 8 || isHex(text) == false)
        {
            return fallback;
        }
        long value = 0L;
        for (int index = 0; index < text.length(); index++)
        {
            value = value * 16L + Character.digit(text.charAt(index), 16);
        }
        return (int) value;
    }

    /** Returns whether every character is a hexadecimal digit. */
    private static boolean isHex(String value)
    {
        for (int index = 0; index < value.length(); index++)
        {
            if (Character.digit(value.charAt(index), 16) < 0)
            {
                return false;
            }
        }
        return true;
    }
}
