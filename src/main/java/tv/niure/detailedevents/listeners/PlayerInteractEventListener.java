package tv.niure.detailedevents.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import tv.niure.detailedevents.events.block.PlayerFarmlandTrampleEvent;
import tv.niure.detailedevents.events.block.PlayerPressurePlateTriggerEvent;
import tv.niure.detailedevents.events.item.PlayerLeftClickItemEvent;
import tv.niure.detailedevents.events.item.PlayerRightClickItemEvent;

import java.util.Optional;

public class PlayerInteractEventListener implements Listener {

    @EventHandler
    public void onEntityInteract(PlayerInteractEvent event) {
        // Blocks
        handlePressurePlateTriggerEvent(event).ifPresent(event::setCancelled);
        handleFarmlandDestroyEvent(event).ifPresent(event::setCancelled);

        // Items
        handlePlayerRightClickItemEvent(event).ifPresent(event::setCancelled);
        handlePlayerLeftClickItemEvent(event).ifPresent(event::setCancelled);
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

        PlayerPressurePlateTriggerEvent newEvent = new PlayerPressurePlateTriggerEvent(event.getPlayer(), event.getClickedBlock());
        Bukkit.getPluginManager().callEvent(newEvent);

        return Optional.of(newEvent.isCancelled());
    }

    /**
     * Handle the farmland destroy event
     *
     * @param event The event
     * @return Whether the event should be cancelled
     */
    private Optional<Boolean> handleFarmlandDestroyEvent(PlayerInteractEvent event) {
        if (event.getAction() != Action.PHYSICAL) return Optional.empty();
        if (event.getClickedBlock() == null) return Optional.empty();
        if (event.getClickedBlock().getType() != Material.FARMLAND) return Optional.empty();

        PlayerFarmlandTrampleEvent newEvent = new PlayerFarmlandTrampleEvent(event.getPlayer(), event.getClickedBlock());
        Bukkit.getPluginManager().callEvent(newEvent);

        return Optional.of(newEvent.isCancelled());
    }

    /**
     * Handle the player right click item event
     *
     * @param event The event
     * @return Whether the event should be cancelled
     */
    private Optional<Boolean> handlePlayerRightClickItemEvent(PlayerInteractEvent event) {
        if (!event.getAction().isRightClick()) return Optional.empty();
        if (event.getItem() == null) return Optional.empty();

        PlayerRightClickItemEvent newEvent = new PlayerRightClickItemEvent(event.getPlayer(), event.getItem());
        Bukkit.getPluginManager().callEvent(newEvent);

        return Optional.of(newEvent.isCancelled());
    }

    /**
     * Handle the player left click item event
     *
     * @param event The event
     * @return Whether the event should be cancelled
     */
    private Optional<Boolean> handlePlayerLeftClickItemEvent(PlayerInteractEvent event) {
        if (!event.getAction().isLeftClick()) return Optional.empty();
        if (event.getItem() == null) return Optional.empty();

        PlayerLeftClickItemEvent newEvent = new PlayerLeftClickItemEvent(event.getPlayer(), event.getItem());
        Bukkit.getPluginManager().callEvent(newEvent);

        return Optional.of(newEvent.isCancelled());
    }
}
