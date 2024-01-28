package com.maple.originmapleapp.repository;

import com.maple.originmapleapp.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<MemberEntity, String> {
    Optional<MemberEntity> findBymemberEmail(String memberEmail);
}
