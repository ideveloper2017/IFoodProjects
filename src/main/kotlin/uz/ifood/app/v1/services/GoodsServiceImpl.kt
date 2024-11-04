package uz.ifood.app.v1.services

import io.swagger.v3.oas.annotations.servers.Server
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import uz.ifood.app.v1.entity.Goods
import uz.ifood.app.v1.repository.GoodsRepository
import uz.ifood.app.v1.services.interfaces.GoodsServices

@Service
class GoodsServiceImpl (public var goodsRepository: GoodsRepository? = null) : GoodsServices {

    override fun getGoodList(): List<Goods> {
     return goodsRepository!!.findAll() as List<Goods>
    }
}