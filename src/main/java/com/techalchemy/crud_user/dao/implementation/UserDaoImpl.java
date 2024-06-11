package com.techalchemy.crud_user.dao.implementation;

import com.techalchemy.crud_user.dao.interfaces.UserDAO;
import com.techalchemy.crud_user.entity.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<UserEntity> findAll() {
        return this.em.createQuery("SELECT u FROM UserEntity u").getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserEntity> findById(Long id) {
        return Optional.ofNullable(this.em.find(UserEntity.class, id));
    }

    @Override
    @Transactional
    public void save(UserEntity userEntity) {
        this.em.persist(userEntity);
        this.em.flush();
    }

    @Override
    @Transactional
    public void update(UserEntity userEntity) {
         this.em.merge(userEntity);
    }

    @Override
    @Transactional
    public void delete(UserEntity userEntity) {
       this.em.remove(userEntity);
    }
}
