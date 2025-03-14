package dev.twme.griefDefenderAxiomAddon.hook;

import com.moulberry.axiom.integration.Integration;
import com.moulberry.axiom.integration.SectionPermissionChecker;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class GriefDefenderIntegration implements Integration.CustomIntegration {
    @Override
    public boolean canBreakBlock(Player player, Block block) {
        return canPlaceBlock(player, block.getLocation());
    }

    @Override
    public boolean canPlaceBlock(Player player, Location location) {
        if (!Bukkit.getPluginManager().isPluginEnabled("GriefDefender")) {
            return true;
        }
        if (player.hasPermission("griefdefenderaxiomaddon.bypass")) {
            return true;
        }
        return GriefDefenderIntegrationImpl.isBuilder(player,location);
    }

    @Override
    public SectionPermissionChecker checkSection(Player player, World world, int i, int i1, int i2) {
        if (!Bukkit.getPluginManager().isPluginEnabled("GriefDefender")) {
            return SectionPermissionChecker.ALL_ALLOWED;
        }
        if (player.hasPermission("griefdefenderaxiomaddon.bypass")) {
            return SectionPermissionChecker.ALL_ALLOWED;
        }
        return GriefDefenderIntegrationImpl.checkSection(player, world, i, i1, i2);
    }
}
