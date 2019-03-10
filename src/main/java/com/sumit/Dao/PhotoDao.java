/**
 * 
 */
package com.sumit.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sumit.models.Photo;
import com.sumit.models.User;

/**
 * @author Sumit
 *
 */
@Repository
public interface PhotoDao extends CrudRepository<Photo,Long >
{

	Photo save(Photo photo);
	List<Photo> findAll();
	List<Photo> findByUser(User user);
	Photo findByPhotoId(Long photoId);
}
