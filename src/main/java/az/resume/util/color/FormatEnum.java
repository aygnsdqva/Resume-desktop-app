package az.resume.util.color;

public enum FormatEnum {
    ANSI_BOLD("\u001B[1m"), ANSI_UNDERLINE("\u001B[4m"), ANSI_BLINK("\u001B[5m"), ANSI_REVERSED("\u001B[7m");

    private final String code;

    FormatEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
