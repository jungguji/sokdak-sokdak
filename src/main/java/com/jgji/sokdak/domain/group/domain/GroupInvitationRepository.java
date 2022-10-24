package com.jgji.sokdak.domain.group.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupInvitationRepository extends JpaRepository<GroupInvitation, Long> {
}
