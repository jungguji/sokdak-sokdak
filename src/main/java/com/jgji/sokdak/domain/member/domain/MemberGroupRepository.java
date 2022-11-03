package com.jgji.sokdak.domain.member.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberGroupRepository extends JpaRepository<MemberGroup, Long> {

    Optional<MemberGroup> findByMemberIdAndGroupId(long memberId, long groupId);
}
