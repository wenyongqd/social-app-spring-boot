package com.lakehead.socialapp.adapter.repository.jpa;

import com.lakehead.socialapp.adapter.repository.jpa.entity.PostDo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListPostJpaRepository extends PagingAndSortingRepository<PostDo, Long> {
    Page<PostDo> findAll(Pageable pageable);
}
