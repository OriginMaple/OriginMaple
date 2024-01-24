package com.maple.originmapleapp.repository;

import com.maple.originmapleapp.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity,Long> {
}
