package bin.javaproject.librarysystemtest.enums;

public enum BookStatus {
    AVAILABLE("在庫"),
    BORROWED("出借中"),
    IN_PROCESS("整理中"),
    LOST("遺失");

    private final String description;

    BookStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}