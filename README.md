# Detailed Events (Bukkit)

Bukkit development sometimes involves a lot of event handling and a lot of conditions inside them. For example, simply
to check if you step on a pressure plate you at least have to use 3 lines of condition checking that can result in a
loss of code motivation and ugly code.

This plugin aims to simplify the event handling process by providing a simple and easy-to-use API for handling events.
It also provides a way to handle events in a more readable way.

## Events

### Block based Events

- [PlayerFarmlandTrampleEvent](#playerfarmlandtrampleevent)
- [PlayerPressurePlateTriggerEvent](#playerpressureplatetriggerevent)

### Inventory based Events

- [InventoryItemClickEvent](#inventoryitemclickevent)

### Item based Events

- [PlayerLeftClickItemEvent](#playerleftclickitemevent--playerrightclickitemevent)
- [PlayerRightClickItemEvent](#playerleftclickitemevent--playerrightclickitemevent)

## Usage

### PlayerFarmlandTrampleEvent

Gets triggered when farmland gets trampled by a player.

| Value           | Description                      |
|-----------------|----------------------------------|
| `getPlayer()`   | Get the player that trampled.    |
| `getFarmland()` | Get the block that got trampled. |

### PlayerPressurePlateTriggerEvent

Gets triggered when a player steps on a pressure plate.

| Value                | Description                     |
|----------------------|---------------------------------|
| `getPlayer()`        | Get the player that stepped.    |
| `getPressurePlate()` | Get the block that got stepped. |

### InventoryItemClickEvent

Gets triggered when a player clicks on an item in an inventory.

| Value            | Description                                   |
|------------------|-----------------------------------------------|
| `getPlayer()`    | Get the player that clicked.                  |
| `getItemStack()` | Get the item that got clicked.                |
| `getInventory()` | Get the inventory that got clicked inside in. |
| `getAction()`    | Get the type of click.                        |

### PlayerLeftClickItemEvent / PlayerRightClickItemEvent

Gets triggered when a player left or right clicks (depends on the chosen event) clicks an item.

| Value            | Description                    |
|------------------|--------------------------------|
| `getPlayer()`    | Get the player that clicked.   |
| `getItemStack()` | Get the item that got clicked. |

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
