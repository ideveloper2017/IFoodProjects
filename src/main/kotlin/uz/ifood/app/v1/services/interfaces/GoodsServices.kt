package uz.ifood.app.v1.services.interfaces

import org.springframework.stereotype.Service
import uz.ifood.app.v1.entity.Goods


interface GoodsServices {

    fun getGoodList():List<Goods>

}