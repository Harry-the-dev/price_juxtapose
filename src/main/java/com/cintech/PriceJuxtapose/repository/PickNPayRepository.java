package com.cintech.PriceJuxtapose.repository;

import com.cintech.PriceJuxtapose.dto.PickNPayDTO;
import com.cintech.PriceJuxtapose.entity.PickNPay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface PickNPayRepository extends JpaRepository<PickNPay, Long> {

    PickNPay findPickNPayById(Long id);

    List<PickNPay> findPickNPayByTitle (String title) ;
    List<PickNPay> findPickNPayByTitleLike (String title) ;
    List<PickNPay> findPickNPayByTitleContainingIgnoreCase (String title) ;
    List<PickNPay> findPickNPayByUrl (String url);
    List<PickNPay> findPickNPayByUrlLike (String url);
    List<PickNPay> findPickNPayByUrlContainingIgnoreCase (String url);
    List<PickNPay> findPickNPayByPrice (double price );
    List<PickNPay> findPickNPayByPriceBetween (double min , double max);

    //@Query( value = "update PickNPay p set p.price = :price where p.id = :id  " , nativeQuery = true)
   // void updateById (@Param("id") Long id , @Param("price") double price);







    /*
    @Query( value = "select id from PickNPay p where p.url = :url" , nativeQuery = true)
    int findPickNPayIdByUrl (String url);

   // @Query( value = "select id from PickNPay p where p.url = :url" , nativeQuery = true)



    @Modifying
    @Transactional
    @Query( value = "update tbl_student  set first_name = :firstName where email_address = :emailId", nativeQuery = true)
    int updateStudentNameByEmailId (@Param("firstName") String firstName , @Param("emailId") String emailId );
    */


}