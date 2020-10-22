package utils.enums;

public enum TestingType {
    DIAG_TESTING("Диагностическое тестирование"),
    ENTRANCE_TESTING("Вступительное тестирование");

    private String name;
    public String getName() {
        return name;
    }

    private TestingType(String name) {
        this.name = name;
    }
}
