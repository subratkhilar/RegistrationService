package com.org.ms.registerService.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.org.ms.registerService.bean.UserBean;

@Transactional
@Repository("userregdDao")
public class UserRegdDaoImpl implements UserRegdDao {
	String sql = "";
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void createUser(UserBean userBean) {
		entityManager.persist(userBean);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserBean> listofAlluser() {
		sql = "from UserBean";
		// Criteria criteria = entityManager.getCriteriaBuilder().
		return (List<UserBean>) entityManager.createQuery(sql).getResultList();
	}

	@Override
	public void deleteuser(UserBean userBean) {
		entityManager.remove(userBean);
	}

	@Override
	public UserBean getuseById(int id) {
		return entityManager.find(UserBean.class, id);
	}

	@Override
	public void updateUser(UserBean userBean) {
		entityManager.flush();
		//entityManager.persist(userBean);
		
	}

}
