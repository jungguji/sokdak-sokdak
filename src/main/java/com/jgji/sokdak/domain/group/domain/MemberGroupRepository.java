package com.jgji.sokdak.domain.group.domain;

import com.jgji.sokdak.domain.member.domain.MemberGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberGroupRepository extends JpaRepository<MemberGroup, Long> {

}
