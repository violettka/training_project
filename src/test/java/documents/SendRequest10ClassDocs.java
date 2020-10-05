package documents;

public enum SendRequest10ClassDocs {

    SCHOOL_APLICATION("Заявление на поступление в школу (с подписью)","Не требуется"),
    BIRTHDAY_CERTIFIKATE("Св-во о рождении", "Скан"),
    BIRTHDAY_CERTIFIKATE_TRANSLATION ("Св-во о рождении (перевод)", "Скан"),
    STUDENT_PASSPORT("Паспорт учащегося (фото)","Скан"),
    STUDENT_PASSPORT_REGISTRATION("Паспорт учащегося (регистрация)","Скан"),
    STUDENT_PASSPORT_TRANSLATION("Паспорт учащегося (перевод)","Скан"),
    SNILS("СНИЛС","Скан"),
    HOME_BOOK("Выписка из домовой книги","Скан"),
    SCORE_BOARD("Табель текущих оценок","Скан"),
    STUDENT_PERSONAL_FILE("Личное дело учащегося","Нет"),
    CERTIFICATE_OF_GENERAL_EDUCATION("Аттестат об основном общем образовании","Скан"),
    PARENT_PASSPORT("Паспорт родителя (фото)","Скан"),
    PARENT_PASSPORT_REGISTRATION("Паспорт родителя (регистрация)","Скан"),
    PARENT_PASSPORT_TRANSLATION("Паспорт родителя (перевод)","Скан"),
    CERTIFICATE_LARGE_FAMILY("Св-во многодетной семьи","Не требуется"),
    REPRESENTATION_DOCUMENTS("Документы о законном представительстве","Не требуется");

    private String name;
    private String status;

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    private SendRequest10ClassDocs(String name, String status) {
        this.name = name;
        this.status = status;
    }
}
