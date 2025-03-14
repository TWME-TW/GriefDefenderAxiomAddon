package dev.twme.griefDefenderAxiomAddon;

import com.moulberry.axiom.integration.Integration;
import dev.twme.griefDefenderAxiomAddon.hook.GriefDefenderIntegration;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class GriefDefenderAxiomAddon extends JavaPlugin {

    @Override
    public void onEnable() {
        if (!Bukkit.getPluginManager().isPluginEnabled("GriefDefender") && !Bukkit.getPluginManager().isPluginEnabled("AxiomPaper")) {
            getLogger().warning("GriefDefender or AxiomPaper is not enabled, disabling plugin.");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        getLogger().info("GriefDefender Axiom Addon is enabled");

        Integration.CustomIntegration customIntegration = new GriefDefenderIntegration();
        Integration.registerCustomIntegration(this, customIntegration);
    }

    @Override
    public void onDisable() {
        getLogger().info("GriefDefender Axiom Addon is disabled");
    }
}
