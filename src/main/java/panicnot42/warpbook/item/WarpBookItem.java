package panicnot42.warpbook.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import panicnot42.warpbook.WarpBookMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WarpBookItem extends Item
{
  public WarpBookItem()
  {
    this.setMaxStackSize(1).setCreativeTab(CreativeTabs.tabTransport).setUnlocalizedName("warpbook").setTextureName("warpbook:warpbook");
  }

  @Override
  public int getMaxItemUseDuration(ItemStack itemStack)
  {
    return 1;
  }

  @Override
  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
  {
    if (player.isSneaking())
      player.openGui(WarpBookMod.instance, WarpBookMod.WarpBookInventoryGuiIndex, world, (int)player.posX, (int)player.posY, (int)player.posZ);
    else
      player.openGui(WarpBookMod.instance, WarpBookMod.WarpBookWarpGuiIndex, world, (int)player.posX, (int)player.posY, (int)player.posZ);
    return itemStack;
  }

  @SuppressWarnings("unchecked")
  @Override
  @SideOnly(Side.CLIENT)
  public void addInformation(ItemStack item, EntityPlayer player, @SuppressWarnings("rawtypes") List list, boolean thing)
  {
    try
    {
      list.add(String.format("%d/54 pages", item.getTagCompound().getTagList("WarpPages", new NBTTagCompound().getId()).tagCount()));
    }
    catch (Exception e)
    {
      // no pages
    }
  }
}
