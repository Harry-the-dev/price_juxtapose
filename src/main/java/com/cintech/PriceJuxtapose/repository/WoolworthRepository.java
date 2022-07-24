package com.cintech.PriceJuxtapose.repository;
import com.cintech.PriceJuxtapose.entity.Woolworth;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WoolworthRepository extends JpaRepository<Woolworth, Long> {

    Woolworth findWoolworthsById(Long id);

    List<Woolworth> findWoolworthsByTitle (String title) ;
    List<Woolworth> findWoolworthsByTitleLike (String title) ;
    List<Woolworth> findWoolworthsByTitleContainingIgnoreCase (String title) ;
    List<Woolworth> findWoolworthsByUrl (String url);
    List<Woolworth> findWoolworthsByUrlLike (String url);
    List<Woolworth> findWoolworthsByUrlContainingIgnoreCase (String url);
    List<Woolworth> findWoolworthsByPrice (double price );
    List<Woolworth> findWoolworthsByPriceBetween (double min , double max);
}