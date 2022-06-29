package com.lucasrb.batch.repository.criteria;

import com.lucasrb.batch.entity.Customer;
import com.lucasrb.batch.repository.criteria.params.CustomParams;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CustomerRepositoryCustomImpl implements CustomerRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Customer> getWithFilter(CustomParams params) {
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
//        Root<Customer> from = criteriaQuery.from(Customer.class);
//        CriteriaQuery<Customer> select = criteriaQuery.select(from)
//                .orderBy(criteriaBuilder.asc(from.get("id")));
//        TypedQuery<Customer> typedQuery = entityManager.createQuery(select);
//        typedQuery.setFirstResult(params.getPage() - 1);
//        typedQuery.setMaxResults(params.getPageSize());

//        return typedQuery.getResultList();
        Query query = entityManager.createQuery("select c from Customer c order by c.id asc");
        query.setFirstResult((params.getPage() - 1) * params.getPageSize());
        query.setMaxResults(params.getPageSize());
        return query.getResultList();
    }
}
