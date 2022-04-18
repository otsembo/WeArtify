package com.example.data.repository

import com.example.model.objects.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.transactions.transaction

class CartRepository {


    private lateinit var userCart: ArrayList<Cart>

    private fun initCart(){
        userCart = ArrayList()
    }

    fun getUserActiveCart(id:Long) : List<Cart>{
        initCart()
        transaction {

            CartEntity.find { (Carts.user eq UserEntity[id].id) and (Carts.status eq CartStatusEntity[1].id) }
                .forEach {
                    userCart.add(
                        with(it){
                            Cart(
                                id = this.id.value, status = CartStatusEntity[status].getStatus(),
                                item = ArtEntity[art].getArt(), date = date.toLocalDate().toString(),
                                qty = qty, user = UserEntity[user].getUser(), totalPrice = totalPrice
                            )
                        }

                    )
                }

        }

        return userCart
    }

    fun getUserActiveCartCount(id:Long) = getUserActiveCart(id).size


}