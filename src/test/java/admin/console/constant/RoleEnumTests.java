package admin.console.constant;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RoleEnumTests {
    @Test
    public void compare() {
        assertTrue(RoleEnum.ROLE_MANAGER.isWeakerThan(RoleEnum.ROLE_ADMIN));
        assertTrue(RoleEnum.ROLE_USER.isWeakerThan(RoleEnum.ROLE_MANAGER));
        assertTrue(RoleEnum.ROLE_USER.isWeakerThan(RoleEnum.ROLE_ADMIN));
    }
}
