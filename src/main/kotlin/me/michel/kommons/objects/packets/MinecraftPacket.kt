package me.michel.kommons.objects.packets

import net.minecraft.server.v1_12_R1.Packet
import net.minecraft.server.v1_12_R1.PacketListener
import org.bukkit.Bukkit
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer
import org.bukkit.entity.Player

data class MinecraftPacket(val mineraftPacket: Packet<PacketListener>, var listen: Boolean = true) {

    fun send(player: Player) {
        val cp = player as CraftPlayer
        cp.handle.playerConnection.sendPacket(mineraftPacket)
    }

    fun sendToOnline() {
        val players = Bukkit.getOnlinePlayers()
        players.forEach {
            send(it)
        }
    }

    /*
    If is listening, then send your packet in a PlayerJoinListener.
     */
    fun isListening(): Boolean {
        return this.listen
    }

}