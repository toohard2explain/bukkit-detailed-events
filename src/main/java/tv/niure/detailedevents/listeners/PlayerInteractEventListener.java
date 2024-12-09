package tv.niure.detailedevents.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import tv.niure.detailedevents.events.PressurePlateTriggerEvent;

import java.util.Optional;

public class PlayerInteractEventListener implements Listener {

    @EventHandler
    public void onEntityInteract(PlayerInteractEvent event) {
        handlePressurePlateTriggerEvent(event).ifPresent(event::setCancelled);
    }

    /**
     * Handle the pressure plate trigger event
     *
     * @param event The event
     * @return Whether the event should be cancelled
     */
    private Optional<Boolean> handlePressurePlateTriggerEvent(PlayerInteractEvent event) {
        if (event.getAction() != Action.PHYSICAL) return Optional.empty();
        if (event.getClickedBlock() == null) return Optional.empty();
        if (!event.getClickedBlock().getType().name().contains("PRESSURE_PLATE")) return Optional.empty();

        PressurePlateTriggerEvent newEvent = new PressurePlateTriggerEvent(event.getPlayer(), event.getClickedBlock());
        Bukkit.getPluginManager().callEvent(newEvent);

        return Optional.of(newEvent.isCancelled());
    }
}
