package com.co.portfolio_api.business.email;

import com.co.portfolio_api.db.entity.Email;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class EmailRepository {
//    private final JPAQueryFactory factory;
    private final EntityManager entityManager;


    @Transactional
    public void insertEmail(EmailDto.EmailCond cond) {

        try {
            Email email1 = new Email(cond.getName(), cond.getEmail(), cond.getSubject(), cond.getMessage());
            entityManager.persist(email1);
            entityManager.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
