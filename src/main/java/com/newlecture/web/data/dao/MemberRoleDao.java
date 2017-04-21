package com.newlecture.web.data.dao;

import java.util.List;

import com.newlecture.web.data.entity.MemberRole;

public interface MemberRoleDao {
   String getDefaultRoleById(String memberId);
   List<MemberRole> getRolesOfMember(String memberId);
   List<MemberRole> getList(String memberId);
   List<MemberRole> getList();
   int add(MemberRole memberRole);
   int delete(MemberRole memberRole);
   int update(MemberRole memberRole);

}