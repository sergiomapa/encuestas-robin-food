package  com.robinfood.encuestas.service;


import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.robinfood.encuestas.exception.*;
import com.robinfood.encuestas.repository.*;

import com.robinfood.encuestas.domain.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import lombok.extern.slf4j.Slf4j;

@Scope("singleton")
@Service
@Slf4j
public class EncuestasServiceImpl implements EncuestasService{

	@Autowired
	private EncuestasRepository tbEncuestasRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(Encuestas tbEncuestas)throws ConstraintViolationException{		
		
		Set<ConstraintViolation<Encuestas>> constraintViolations =validator.validate(tbEncuestas);
		 if (!constraintViolations.isEmpty()) {			
			throw new ConstraintViolationException(constraintViolations);
		}
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Encuestas> findAll(){
		log.debug("finding all TbEncuestas instances");
       	return tbEncuestasRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)			
    public Encuestas save(Encuestas entity) throws Exception {
		log.debug("saving TbEncuestas instance");
	   
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("TbEncuestas");
		}
		
		validate(entity);	
	
		if(tbEncuestasRepository.existsById(entity.getIdencuesta())){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return tbEncuestasRepository.save(entity);
	   }		
			
			
			@Override
			@Transactional(readOnly=true)
            public Optional<Encuestas> findById(Integer idEncuesta) {            
            	log.debug("getting TbEncuestas instance");
            	return tbEncuestasRepository.findById(idEncuesta);
            }
			
}
