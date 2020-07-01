package com.bpnsolution.jubo.admin.service.serviceimpl;

import com.bpnsolution.jubo.admin.service.TemplateService;
import com.bpnsolution.jubo.model.Object;
import com.bpnsolution.jubo.model.Template;
import com.bpnsolution.jubo.repository.ObjectRepository;
import com.bpnsolution.jubo.repository.TemplateRepository;

import lombok.RequiredArgsConstructor;
import org.graalvm.compiler.lir.LIRInstruction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.swing.border.EmptyBorder;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TemplateServiceImpl implements TemplateService {

    private final EntityManager em;
    private final TemplateRepository templateRepository;
    private final ObjectRepository objectRepository;

    @Override
    public Template[] saveTemp(Template[] template) throws Exception {
        Object object = template[0].getObject().get(0);
        System.out.println("object = " + object);
        Object object2 = template[0].getObject().get(1);
        System.out.println("object2 = " + object2);

        em.persist(template[0]);
        Template template1 = em.find(Template.class, template[0].getTemplate_idx());

        System.out.println("template1 = " + template1);

        template1.getObject().add(object);
        template1.getObject().add(object2);

        em.persist(template1);

        return template;
    }

    @Override
    @Transactional(readOnly = true)
    public Template findTempInfo(Template temp) throws Exception {
        temp = em.find(Template.class, temp.getTemplate_idx());
        return temp;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Template> findAllTempInfo() throws Exception {
        return templateRepository.findAllTemplate();
    }

    @Override
    public Template updTempInfo(String church_id) throws Exception {
        return null;
    }

    @Override
    public boolean removeTemp(String church_id) throws Exception {
        return false;
    }
}
