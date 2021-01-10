package br.edu.ifrn.laj.pdcorp.apisea.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import br.edu.ifrn.laj.pdcorp.apisea.dtos.UserDTO;
import br.edu.ifrn.laj.pdcorp.apisea.enums.ExceptionMessages;
import br.edu.ifrn.laj.pdcorp.apisea.exceptions.ApiException;
import br.edu.ifrn.laj.pdcorp.apisea.models.User;
import br.edu.ifrn.laj.pdcorp.apisea.repositories.UserRepository;
import br.edu.ifrn.laj.pdcorp.apisea.validators.AbstractValidationMediator;
import br.edu.ifrn.laj.pdcorp.apisea.validators.user.UserValidationMediator;

import javax.validation.ConstraintViolationException;
import java.sql.SQLException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	@Autowired
	private UserValidationMediator validator;
	
	public UserDTO save(User user) throws ApiException {
		try {
			return UserDTO.convertFromModel(repository.save(user));
		} catch (DataIntegrityViolationException ex){
			throw new ApiException(ExceptionMessages.DATA_VALIDATION.getDescription().concat(
					ex.getMostSpecificCause().getMessage()));
		}
	}
	
	public UserDTO findByUsername(String email) throws ApiException {
		User user = repository.findByEmail(email);
		if(ObjectUtils.isEmpty(user)) {
			throw new ApiException(ExceptionMessages.USER_DOESNT_EXISTS_DB);
		}
		return UserDTO.convertFromModel(user);
	}

	public User getByCredentials(String username, String password) throws ApiException {
		User user = repository.findByEmailAndPassword(username, password);
		if(ObjectUtils.isEmpty(user)) {
			throw new ApiException(ExceptionMessages.CREDENTIALS_IS_WORNG);
		}
		return user;
	}
	
	

}
