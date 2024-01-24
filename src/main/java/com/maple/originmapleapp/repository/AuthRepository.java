package com.maple.originmapleapp.repository;

import com.maple.originmapleapp.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<MemberEntity, String> {
}
