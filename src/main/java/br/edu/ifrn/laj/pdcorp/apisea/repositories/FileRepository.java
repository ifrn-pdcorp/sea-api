package br.edu.ifrn.laj.pdcorp.apisea.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrn.laj.pdcorp.apisea.models.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

	List<File> findByIdActivity(Long idActivity);

}