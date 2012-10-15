package haveric.stackableItems;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.entity.Player;

public final class Perms {

    private static Permission perm = null;

    // TODO: make dynamic?
    private static String stack = "stackableitems.stack";

    private static String adjust = "stackableitems.adjust";

    // Vanish nopickup
    private static String vanishNoPickup = "vanish.nopickup";

    private Perms() { } // Private constructor for utility class

    public static void setPerm(Permission p) {
        perm = p;
    }

    private static boolean permEnabled() {
        return (perm != null);
    }

    public static boolean groupExists(String group) {
        boolean groupExists = false;

        if (permEnabled()) {
            for (String g : perm.getGroups()) {
                if (g.equals(group)) {
                    groupExists = true;
                    break;
                }
            }
        }
        return groupExists;
    }

    public static boolean canStackInGroup(Player player) {
        boolean canStack = false;

        if (permEnabled()) {
            canStack = perm.has(player, stack);
        } else {
            canStack = player.hasPermission(stack);
        }
        return canStack;
    }

    public static boolean canAdjust(Player player) {
        boolean canAdjust = false;

        if (permEnabled()) {
            canAdjust = perm.has(player, adjust);
        } else {
            canAdjust = player.hasPermission(adjust);
        }
        return canAdjust;
    }

    public static String getPrimaryGroup(Player player) {
        String primaryGroup = null;

        if (permEnabled()) {
            primaryGroup = perm.getPrimaryGroup(player);
        }
        return primaryGroup;
    }

    public static String[] getGroups() {
        String[] groups = null;

        if (permEnabled()) {
            groups = perm.getGroups();
        }
        return groups;
    }

    public static boolean canVanishPickup(Player player) {
        boolean vanishPickup = true;

        if (permEnabled()) {
            vanishPickup = perm.has(player, vanishNoPickup);
        } else {
            vanishPickup = player.hasPermission(vanishNoPickup);
        }
        return vanishPickup;
    }

}
