/**
 * 
 */
package com.sumit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sumit.models.Photo;
import com.sumit.models.User;

/**
 * @author Sumit
 *
 */
@Service
public interface PhotoService {

	Photo save(Photo photo);
	List<Photo> findAll();
	List<Photo> findByUser(User user);
	Photo findByPhotoId(Long photoId);
}
