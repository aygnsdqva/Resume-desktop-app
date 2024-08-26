package az.resume.util.color;

public class ColorUtil {
    private static final String ANSI_RESET = "\u001B[0m";

    private static String showFormatted(String text, ColorEnum color, FormatEnum... formatEnums) {
        StringBuilder sb = new StringBuilder();
        sb.append(color != null ? color.getCode() : "");
        for (FormatEnum format : formatEnums) {
            sb.append(format != null ? format.getCode() : "");
        }
        sb.append(text).append(ANSI_RESET);
        return String.valueOf(sb);
    }


    //GREEN COLOR//
    public  static String greenColor(Object text){
        return ColorUtil.showFormatted(String.valueOf(text), ColorEnum.ANSI_GREEN);
    }
    public  static String greenColorBold(Object text){
        return  ColorUtil.showFormatted(String.valueOf(text),ColorEnum.ANSI_GREEN,FormatEnum.ANSI_BOLD);
    }
    public  static String greenColorUnderline(Object text){
        return ColorUtil.showFormatted(String.valueOf(text),ColorEnum.ANSI_GREEN,FormatEnum.ANSI_UNDERLINE);
    }

    public  static String greenColorBlink(Object text){
        return ColorUtil.showFormatted(String.valueOf(text),ColorEnum.ANSI_GREEN,FormatEnum.ANSI_BLINK);
    }
    public  static String greenColorReversed(Object text){
        return ColorUtil.showFormatted(String.valueOf(text),ColorEnum.ANSI_GREEN,FormatEnum.ANSI_REVERSED);
    }

    //RED COLOR//
    public static String redColor(Object text) {
        return ColorUtil.showFormatted(String.valueOf(text), ColorEnum.ANSI_RED);
    }

    public static String redColorBold(Object text) {
        return ColorUtil.showFormatted(String.valueOf(text), ColorEnum.ANSI_RED, FormatEnum.ANSI_BOLD);
    }

    public static String redColorUnderline(Object text) {
        return ColorUtil.showFormatted(String.valueOf(text), ColorEnum.ANSI_RED, FormatEnum.ANSI_UNDERLINE);
    }

    public static String redColorBlink(Object text) {
        return ColorUtil.showFormatted(String.valueOf(text), ColorEnum.ANSI_RED, FormatEnum.ANSI_BLINK);
    }

    public static String redColorReversed(Object text) {
        return ColorUtil.showFormatted(String.valueOf(text), ColorEnum.ANSI_RED, FormatEnum.ANSI_REVERSED);
    }



   //YELLOW COLOR//
   public static String yellowColor(Object text) {
       return ColorUtil.showFormatted(String.valueOf(text), ColorEnum.ANSI_YELLOW);
   }

    public static String yellowColorBold(Object text) {
        return ColorUtil.showFormatted(String.valueOf(text), ColorEnum.ANSI_YELLOW, FormatEnum.ANSI_BOLD);
    }

    public static String yellowColorUnderline(Object text) {
        return ColorUtil.showFormatted(String.valueOf(text), ColorEnum.ANSI_YELLOW, FormatEnum.ANSI_UNDERLINE);
    }

    public static String yellowColorBlink(Object text) {
        return ColorUtil.showFormatted(String.valueOf(text), ColorEnum.ANSI_YELLOW, FormatEnum.ANSI_BLINK);
    }

    public static String yellowColorReversed(Object text) {
        return ColorUtil.showFormatted(String.valueOf(text), ColorEnum.ANSI_YELLOW, FormatEnum.ANSI_REVERSED);
    }


    //BLUE COLOR//
    public static String blueColor(Object text) {
        return ColorUtil.showFormatted(String.valueOf(text), ColorEnum.ANSI_BLUE);
    }

    public static String blueColorBold(Object text) {
        return ColorUtil.showFormatted(String.valueOf(text), ColorEnum.ANSI_BLUE, FormatEnum.ANSI_BOLD);
    }

    public static String blueColorUnderline(Object text) {
        return ColorUtil.showFormatted(String.valueOf(text), ColorEnum.ANSI_BLUE, FormatEnum.ANSI_UNDERLINE);
    }

    public static String blueColorBlink(Object text) {
        return ColorUtil.showFormatted(String.valueOf(text), ColorEnum.ANSI_BLUE, FormatEnum.ANSI_BLINK);
    }

    public static String blueColorReversed(Object text) {
        return ColorUtil.showFormatted(String.valueOf(text), ColorEnum.ANSI_BLUE, FormatEnum.ANSI_REVERSED);
    }


    //PURPLE COLOR//

    public static String purpleColor(Object text) {
        return ColorUtil.showFormatted(String.valueOf(text), ColorEnum.ANSI_PURPLE);
    }

    public static String purpleColorBold(Object text) {
        return ColorUtil.showFormatted(String.valueOf(text), ColorEnum.ANSI_PURPLE, FormatEnum.ANSI_BOLD);
    }

    public static String purpleColorUnderline(Object text) {
        return ColorUtil.showFormatted(String.valueOf(text), ColorEnum.ANSI_PURPLE, FormatEnum.ANSI_UNDERLINE);
    }

    public static String purpleColorBlink(Object text) {
        return ColorUtil.showFormatted(String.valueOf(text), ColorEnum.ANSI_PURPLE, FormatEnum.ANSI_BLINK);
    }

    public static String purpleColorReversed(Object text) {
        return ColorUtil.showFormatted(String.valueOf(text), ColorEnum.ANSI_PURPLE, FormatEnum.ANSI_REVERSED);
    }

    //CYAN COLOR//
    public static String cyanColor(Object text) {
        return ColorUtil.showFormatted(String.valueOf(text), ColorEnum.ANSI_CYAN);
    }

    public static String cyanColorBold(Object text) {
        return ColorUtil.showFormatted(String.valueOf(text), ColorEnum.ANSI_CYAN, FormatEnum.ANSI_BOLD);
    }

    public static String cyanColorUnderline(Object text) {
        return ColorUtil.showFormatted(String.valueOf(text), ColorEnum.ANSI_CYAN, FormatEnum.ANSI_UNDERLINE);
    }

    public static String cyanColorBlink(Object text) {
        return ColorUtil.showFormatted(String.valueOf(text), ColorEnum.ANSI_CYAN, FormatEnum.ANSI_BLINK);
    }

    public static String cyanColorReversed(Object text) {
        return ColorUtil.showFormatted(String.valueOf(text), ColorEnum.ANSI_CYAN, FormatEnum.ANSI_REVERSED);
    }


}
