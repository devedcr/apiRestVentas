package com.solutioncode.apiRestVentas.validation;

import com.solutioncode.apiRestVentas.controller.RolController;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UniqueFieldValidator implements ConstraintValidator<Unique, Object> {
    private static final Logger logger = LoggerFactory.getLogger(UniqueFieldValidator.class);
    @PersistenceContext
    private EntityManager entityManager;
    private String fieldName;
    private String entityName;

    @Override
    public void initialize(Unique constraintAnnotation) {
        this.fieldName = constraintAnnotation.fieldName();
        this.entityName = constraintAnnotation.entityName();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        String jpql = "SELECT COUNT(e) FROM " + entityName + " e WHERE e." + fieldName + " = :value";
        logger.info(jpql);
        Query query = entityManager.createQuery(jpql).setParameter("value", value);
        Long count = (Long) query.getSingleResult();
        return (count == 0);
    }
}
