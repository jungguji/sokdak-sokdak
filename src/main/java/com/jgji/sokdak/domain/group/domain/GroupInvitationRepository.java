package com.jgji.sokdak.domain.group.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface GroupInvitationRepository extends JpaRepository<GroupInvitation, Long> {

    List<GroupInvitation> findByMemberIdAndGroupIdAndExpirationTimeGreaterThanEqualAndUsedFalse(long memberId, long groupId, LocalDateTime now);
    List<GroupInvitation> findByExpirationTimeGreaterThanEqualAndUsedFalse(LocalDateTime now);
    GroupInvitation findByCodeAndExpirationTimeGreaterThanEqualAndUsedFalse(String code, LocalDateTime now);
}
