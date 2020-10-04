package me.ispoopie.lootdrop;

import com.jojodmo.customitems.api.CustomItemsAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.ShulkerBox;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class DropCommand implements CommandExecutor {
    @SuppressWarnings("NullableProblems")
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        for (Player player : Bukkit.getOnlinePlayers()) {

            int x = new Random().nextInt(3) - 1;
            int z = new Random().nextInt(3) - 1;

            while (x == z && x == 0) {
                z = new Random().nextInt(3) - 1;
            }

            Location dropLocation = player.getLocation().add(x, 0, z);
            dropLocation.setY(dropLocation.getWorld().getHighestBlockYAt(dropLocation.getBlockX(), dropLocation.getBlockZ()) + 1);
            dropLocation.getBlock().setType(Material.BLUE_SHULKER_BOX);
            ShulkerBox box = (ShulkerBox) dropLocation.getBlock().getState();
            box.getInventory().setContents(new ItemStack[] { CustomItemsAPI.getCustomItem("poop"), new ItemStack(Material.ACACIA_DOOR) });
        }
        return false;
    }
}
