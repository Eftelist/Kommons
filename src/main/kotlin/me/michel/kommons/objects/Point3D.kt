package me.michel.kommons.objects

import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.World
import org.bukkit.block.Block
import org.bukkit.util.Vector

data class Point3D(var x:Double,var y:Double, var z:Double){

    constructor(loc: Location): this(x = loc.x,y = loc.y, z = loc.z)

    fun toLocation(world: World): Location {
        return Location(world,x,y,z)
    }

    fun toVector(): Vector {
        return Vector(x,y,z)
    }

    fun toBlock(world: World): Block {
        return world.getBlockAt(x.toInt(),y.toInt(),z.toInt())
    }

    fun toBlockMaterial(world: World): Material {
        return this.toBlock(world).type
    }

    fun toDetailedString(world: World): String {
        return "Point3D(world=${world.name},x=$x,y=$y,z=$z,material=${toBlockMaterial(world).name}"
    }

    fun toVectorString(): String {
        return "-v $x $y $z"
    }

    override fun toString(): String {
        return "Point3D($x,$y,$z)"
    }

}