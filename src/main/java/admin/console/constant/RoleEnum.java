package admin.console.constant;

public enum RoleEnum {
    ROLE_ADMIN(1),
    ROLE_MANAGER(2),
    ROLE_USER(3);

    private int level;

    RoleEnum(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public boolean isWeakerThan(RoleEnum r) {
        return r.getLevel() < level;
    }
}
