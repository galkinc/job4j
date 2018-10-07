package tracker.view;

public class StartUITemplate {
    /**
     * Variables for the graphic menu.
     */
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String TEXT_COLOR = "\u001B[32m";
    private static final String MENU_ACTIVE_COLOR = "\u001B[35m";
    private static final String ATTENTION_COLOR = "\u001B[31m";

    /**
     * Use for drawing a row of the items list.
     *
     * @param id   Id
     * @param name Name
     * @param desc Desc
     * @return Row of the items list.
     */
    public static String tableRowUI(String id, String name, String desc) {
        return String.format("%sID: %s %s; \t \t %sName: %s %s; \t \t \t %sDescription: %s %s;",
                TEXT_COLOR, ANSI_RESET, id, TEXT_COLOR, ANSI_RESET, name, TEXT_COLOR, ANSI_RESET, desc);
    }

    /**
     * Draw a header
     *
     * @param name Text for header
     * @return Header
     */
    public static String headerUI(String name) {
        return String.format("%n%s* %s * %s", TEXT_COLOR, name.toUpperCase(), ANSI_RESET);
    }

    public static String menuLine(String button, String text) {
        return String.format("%s%s%s %s%s%s %n",
                MENU_ACTIVE_COLOR, button, ANSI_RESET, TEXT_COLOR, text, ANSI_RESET);
    }

    /**
     * Error message drawing
     *
     * @param message text for the error message
     * @return Error message
     */
    public static String errorUI(String message) {
        return String.format("%n%sError: %s %s", ATTENTION_COLOR, message, ANSI_RESET);
    }

    public static String id(String id) {
        return String.format("%s%s%s", TEXT_COLOR, id, ANSI_RESET);
    }

    public static String menuHeader() {
        return String.format("%n %s******  MENU  ******%s %n", TEXT_COLOR, ANSI_RESET);
    }

    public static String menufooter() {
        return String.format("%s********************%s %n%n", TEXT_COLOR, ANSI_RESET);
    }

}
