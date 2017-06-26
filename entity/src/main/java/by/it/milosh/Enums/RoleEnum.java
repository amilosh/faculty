package by.it.milosh.Enums;

public enum RoleEnum {
    ADMIN("ROLE_ADMIN"),
    STUDENT("ROLE_STUDENT"),
    TEACHER("ROLE_TEACHER");

    String type;

    private RoleEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return this.name();
    }

}
