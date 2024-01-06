package com.product.chair.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.product.chair.business.bean.ChairBean;

public interface ChairRepository extends JpaRepository<ChairBean,Long>
{

}
