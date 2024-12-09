package tv.niure.detailedevents.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import tv.niure.detailedevents.events.inventory.InventoryItemClickEvent;

import java.util.Optional;

public class InventoryClickEventListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        handleInventoryItemClickEvent(event).ifPresent(event::setCancelled);
    }

    /**
     * Handle the InventoryItemClickEvent
     *
     * @param event the InventoryClickEvent
     * @return an Optional containing a boolean indicating if the event was cancelled
     */
    private Optional<Boolean> handleInventoryItemClickEvent(InventoryClickEvent event) {
        if (event.getCurrentItem() == null) return Optional.empty();
        if (!(event.getWhoClicked() instanceof Player)) return Optional.empty();

        InventoryItemClickEvent newEvent = new InventoryItemClickEvent((Player) event.getWhoClicked(), event.getCurrentItem(), event.getClickedInventory(), event.getAction());
        Bukkit.getPluginManager().callEvent(newEvent);

        return Optional.of(newEvent.isCancelled());
    }
}
