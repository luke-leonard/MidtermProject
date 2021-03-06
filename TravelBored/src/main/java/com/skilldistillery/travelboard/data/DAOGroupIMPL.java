package com.skilldistillery.travelboard.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skilldistillery.travelboard.entities.Group;
import com.skilldistillery.travelboard.entities.GroupComment;

@Service
@Transactional
public class DAOGroupIMPL implements DAOGroup {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Group create(Group group) {
		System.out.println(em);
		em.persist(group);
		em.flush();
		
		
		return group;
	}

	@Override
	public boolean delete(int groupId) {
		Group group = em.find(Group.class, groupId);
		em.remove(group);
		em.flush();
		
		if (group == null) {
			return true;
		} 
		
		
		return false;
	}

	@Override
	public Group update(Group group, int groupId) {
		Group oldGroup = em.find(Group.class, groupId);
		oldGroup.setTitle(group.getTitle());
		oldGroup.setHook(group.getHook());
		oldGroup.setUser(group.getUser());
		oldGroup.setActive(group.getActive());
		oldGroup.setGroupComments(group.getGroupComments());
		
		em.flush();
		
		return oldGroup;
	}

	
	@Override
	public GroupComment submitComment(GroupComment gComment) {
		em.persist(gComment);
		em.flush();
		
		return gComment;
	}
	@Override
	public boolean deleteComment(int gId) {
		GroupComment gComment = em.find(GroupComment.class, gId);

		em.remove(gComment);
		em.flush();

		if (gComment == null) {
			return true;
		}

		return false;
	}
	@Override
	public Group getGroupById(int gId) {
		
		return em.find(Group.class, gId);
	}
	@Override
	public List<GroupComment> getGroupCommentsByGroupId(int gId) {
		String query = "SELECT gComment FROM GroupComment gComment WHERE gComment.group.id = :gId";
		
		List <GroupComment> gComments = em.createQuery(query, GroupComment.class).setParameter("gId", gId).getResultList();
		
		return gComments;
	}

}
