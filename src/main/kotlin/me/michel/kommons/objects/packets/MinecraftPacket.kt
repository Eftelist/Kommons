package me.michel.kommons.objects.packets

import com.comphenix.protocol.ProtocolLibrary
import com.comphenix.protocol.ProtocolManager
import com.comphenix.protocol.events.PacketContainer
import org.bukkit.Bukkit
import org.bukkit.entity.Player

data class MinecraftPacket(val mineraftPacket: PacketContainer, var listen: Boolean = true) {

    private var manager: ProtocolManager = ProtocolLibrary.getProtocolManager()

    fun send(player: Player) {
        manager.sendServerPacket(player, mineraftPacket)
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