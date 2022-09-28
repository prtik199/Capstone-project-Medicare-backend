

package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Repository;
import com.example.demo.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

}