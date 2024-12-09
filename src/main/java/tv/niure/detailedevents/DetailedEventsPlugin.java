package tv.niure.detailedevents;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import tv.niure.detailedevents.listeners.PlayerInteractEventListener;

public class DetailedEventsPlugin extends JavaPlugin {
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private static DetailedEventsPlugin instance;

    @Override
    public void onEnable() {
        super.onEnable();
        setInstance(this);

        Bukkit.getPluginManager().registerEvents(new PlayerInteractEventListener(), this);
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

}
