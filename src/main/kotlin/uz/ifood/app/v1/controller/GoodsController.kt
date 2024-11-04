package uz.ifood.app.v1.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import uz.ifood.app.v1.entity.Goods
import uz.ifood.app.v1.services.GoodsServiceImpl
import uz.ifood.app.v1.services.interfaces.GoodsServices


@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/api/v1/goods")
class GoodsController(private val goodsServices: GoodsServices) {


    @RequestMapping("/", produces = ["application/json"],method = [RequestMethod.GET])
    fun getGoodList(): ResponseEntity<*>{
        return ResponseEntity.ok(goodsServices.getGoodList());
    }
}