package com.maple.originmapleapp.repository;

import com.maple.originmapleapp.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<MemberEntity, Integer> {
    Boolean existsBymemberEmail(String memberEmail);
    MemberEntity findBymemberName(String memberName);

    MemberEntity findBymemberEmail(String memberEmail);

}
